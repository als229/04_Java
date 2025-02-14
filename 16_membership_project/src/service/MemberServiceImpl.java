package service;

import dao.MemberDAO;
import dao.MemberDAOImpl;
import dto.Member;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 왜 Service, Dao 인터페이스를 만들어서 구현했을까?
 * - 인터페이스를 상속 받아 구현하면
 *   모든 자식 클래스가 똑같은 기능을 가지게되어
 *   비슷하게 생김!
 *
 *  -> 언제든지 서로 다른 자식 클래스로 대체 가능!!
 *    ==> 유지보수성 증가
 */

// MemberService를 상속 받아 구현
public class MemberServiceImpl implements MemberService{

    // dao 객체 부모 참조 변수 선언
    private MemberDAO dao = null;
    private String[] gradeArr = {"일반", "골드", "다이아"};


    // 기본 생성자
    // - MemberServiceImpl 객체 생성 시
    //   MemberDAOImpl 객체도 생성
    public MemberServiceImpl() 
    		throws FileNotFoundException, ClassNotFoundException, IOException {
        dao = new MemberDAOImpl();
    }

    
    //********************************
    // 추가, 수정 삭제 기능이 수행되면
    // 무조건 dao.saveFile() 수행!
    //********************************

    // 회원 추가
    @Override
    public boolean addMember(String name, String phone) throws IOException {
    	
    	// view에서 고객이 입력한 name, phone 으로 Member 인스턴스 생성(amount, grade는 0으로 생성)
    	boolean flag = dao.addMember(new Member(name, phone, 0, 0));

        return flag;
    }


    // DAO에서 조회한 memberList를 그대로 반환
    @Override
    public List<Member> getMemberList() {
    	
    	// getMemberList 에서 memberList 요청
    	List <Member> memberList = dao.getMemberList();
    	
        return memberList;
    }


    // 이름 검색
    @Override
    public List<Member> selectName(String searchName) {

    	// 기존 memberList
    	List<Member> memberList = dao.getMemberList();
    	
    	// 검색할 이름이 같은 Member들을 담을 List
    	List<Member> searchedMemberList = new ArrayList<Member>(); 
    	
    	memberList.stream().filter(m -> m.getName().equals(searchName)).forEach(a -> {
    		// filter 에서 memberList의 이름과 검색할 이름(searchName)이 같은 Member를 searchedMemberList에 담는다.
    		searchedMemberList.add(a);
    	});
    	
        return searchedMemberList;
    }


    // 금액 누적
    @Override
    public String updateAmount(Member target, int acc) throws IOException {

    	String grade = "";
    	int beforeAmount = 0;
    	int beforeGrade = target.getGrade();
    	
    	int amount = target.getAmount() + acc;
    	int nowGrade = 0;
    	
    	target.setAmount(amount);
    	
    	if(amount < 100_000) {
    		grade = gradeArr[0];
    		nowGrade = Member.COMMON;
    	}else if(amount < 1_000_000) {
    		grade = gradeArr[1];
    		nowGrade = Member.GOLD;
    	}else {
    		grade = gradeArr[2];
    		nowGrade = Member.DIAMOND;
    	}
    	target.setGrade(nowGrade);
    	
    	String result = target.getName() + " 회원님의 누적 금액 \n"
    			+ beforeAmount + " -> " + amount + "\n";
    	if(beforeGrade != target.getGrade()) {
    		result += "* " + grade + " * " + "등급으로 변경되셨습니다.";
    	}

    	dao.saveFile();
        return result; // 결과 문자열 반환
        
        //ex)
        // 2000 -> 100000
        // * 골드 * 등급으로 변경 되셨습니다
    }


    //회원 정보(전화번호) 수정
    @Override
    public String updateMember(Member target, String phone) throws IOException {

    	String beforePhone = target.getPhone();
    	
    	target.setPhone(phone);
    	
        return target.getName() + "님의 전화번호가 변경되었습니다.\n"
        		+ beforePhone + " -> " + target.getPhone()
        		; // 결과 문자열 반환
        // ex)
        // 홍길동님의 전화번호가 변경 되었습니다
        // 01012341234 -> 01044445555
    }


    // 회원 탈퇴
    @Override
    public String deleteMember(Member target) throws IOException {

    	List <Member> memberList = dao.getMemberList();
    	String userName = target.getName();
    	
    	for(int i = 0; i < memberList.size(); i++) {
    		if(target.getPhone().equals(memberList.get(i).getPhone())) {
    			memberList.remove(i);
    		}
    	}
    	
        return userName+" 회원이 탈퇴 처리 되었습니다"; // 결과 문자열 반환
        // ex)
        // "홍길동 회원이 탈퇴 처리 되었습니다"
    }

}