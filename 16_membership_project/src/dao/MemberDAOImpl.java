package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import dto.Member;

// MemberDao 인터페이스를 상속 받아 구현
public class MemberDAOImpl implements MemberDAO{

    // 회원 데이터가 저장될 폴더, 파일경로를 상수로 지정
    private final String FILE_NAME = "MemberList.bin";

    // 회원 목록을 저장해둘 List 객체
    private List<Member> memberList = null;

    // 스트림 객체 참조 변수
    private ObjectInputStream  ois = null;
    private ObjectOutputStream oos = null;


    // 기본 생성자
    // - 회원 다수를 관리할 회원 목록(List)이 필요한데
    //   이미 파일로 저장된 회원 목록이 있으면 읽어오고 없으면 새로 만들기
    public MemberDAOImpl() throws FileNotFoundException, IOException, ClassNotFoundException {

        // membership.bin 파일이 존재하는지 검사
        File file = new File(FILE_NAME);

        if( file.exists() ) { // 존재하는 경우
            try {
                // 스트림 생성
                ois = new ObjectInputStream(new FileInputStream(FILE_NAME));

                // 저장된 객체를 파일에서 읽어와 다운 캐스팅하여 memberList가 참조하게함
                memberList = (ArrayList<Member>)ois.readObject();

            } finally {
                // try에서 발생하는 예외를
                // 메서드 선언부에서 throws 처리하면
                // catch() 구문을 작성하지 않아도 된다!!
                if(ois != null) ois.close();
            }
        }

        // 파일이 존재하지 않는 경우
        else {
            // 새로운 ArrayList를 만들어서 참조
            memberList = new ArrayList<Member>();
        }
    }


    // memberList 반환
    @Override
    public List<Member> getMemberList() {
    	// 위에 생성자에서 만들어져 있는 memberList 반환
    	// membermList는 view생성자 -> service 생성자 -> dao 생성자 순으로 프로그램 실행 되면 자동으로 MemberList.bin 읽고 생성됨.
    	return memberList;
    }

    
    //********************************
    // 추가, 수정 삭제 기능이 수행되면
    // 무조건 saveFile() 수행!
    //********************************

    
    // 회원 추가
    @Override
    public boolean addMember(Member member) throws IOException {
    	boolean flag = true; // 성공, 실패 확인용 flag
    	
    	
    	if(memberList.stream().filter(m -> member.getPhone().equals(m.getPhone())).findFirst().isPresent()) {
    		// stream의 filter 이용해서 파라미터의 phone이랑 리스트에 phone 같은거에서 findFirst에 isPresnt로 값 있냐 없냐 확인 후 값이 있으면 false(중복 전화번호)
    		flag = false;
    	}else {// 중복값이 없으면 추가
    		memberList.add(member);
    	}
    	
    	saveFile(); // 추가 수정 후 저장.
    	
        return flag;
    }


    // 파일 저장
    @Override
    public void saveFile() throws IOException {
    	
    	//  memberList를 MemberList.bin 파일로 출력
    	oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
    	oos.writeObject(memberList);
    
    }






}