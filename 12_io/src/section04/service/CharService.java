package section04.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharService {

	/* [문자 기반 스트림]
	 * 
	 * - 2byte 문자(char) 단위로 입/출력하는 스트림
	 * 
	 * - 문자만 작성된 파일(txt, bin 등), 채팅, JSON, 웹 요청(주소)/응답(HTML 코드)
	 * 
	 * - 문자 기반 스트림 최상위 인터페이스 : Reader(입력용), Writer(출력용)
	 */
	

	/** 문자 기반 스트림을 이용한 파일 출력 */
	public void fileOutput1() {
		
		FileWriter fw = null;
		
		try {
			String content = """
One! Two! Q! W! E! R!

어떤 인사가 괜찮을까 천 번쯤 상상해 봤어
근데 오늘도 천 번 하고 한 번 더 고민 중

막상 네 앞에 서니 꽁꽁 얼어버렸다
숨겨왔던 나의 맘 절반의 반도 주지를 못했어

아, 아, 아직은
준비가 안됐다구요
소용돌이쳐 어지럽다구

쏟아지는 맘을 멈출 수가 없을까?
너의 작은 인사 한마디에 요란해져서
네 맘의 비밀번호 눌러 열고 싶지만
너를 고민고민해도 좋은 걸 어쩌니

거울 앞에서 새벽까지 연습한 인사가
손을 들고 웃는 얼굴을 하고서 고개를 숙였다

아, 아, 아직도 준비가 안됐나 봐요
소용돌이쳐 어지럽다구

쏟아지는 맘을 멈출 수가 없을까?
너의 작은 인사 한마디에 요란해져서
네 맘의 비밀번호 눌러 열고 싶지만
너를 고민고민해도 좋은 걸

이러지도 저러지도 못하는데
속이 왈칵 뒤집히고
이쯤 왔으면 눈치 챙겨야지
날 봐달라구요!

좋아한다 너를 좋아한다 좋아해

너를 많이 많이 좋아한단 말이야
벅차오르다 못해 내 맘이 쿡쿡 아려와
두 번은 말 못 해 너 지금 잘 들어봐
매일 고민하고 연습했던 말
좋아해					
""";
			
			String path = "io_test/char";
			
			File folder = new File(path);
			
			// 폴더가 없을 경우 생성
			if(!folder.exists()) {
				folder.mkdirs();
			}
			
			// 문자 기반 파일 출력 스트림 객체 생성
			fw = new FileWriter(folder + "/" + "고민중독.txt");
			
			// 문자 기반 스트림을 이용해서 출력하기
			fw.write(content); // String, char[] 출력을 위한 기능이 제공됨
			
			// 스트림에 남은 데이터를 밀어냄.
			fw.flush(); // close() 시 자동 수행됨. 그래서 굳이 안써도 됨.

			System.out.println("출력 완료");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(fw != null) fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/** 문자 기반 스트림 + 보조스트림을 이용한 파일 출력 */
	public void fileOutput2() {
		
		FileWriter fw = null;
		BufferedWriter bw = null; // 버퍼를 이용한 보조 스트림
		
		try {
			String content = """
					One! Two! Q! W! E! R!
					
					어떤 인사가 괜찮을까 천 번쯤 상상해 봤어
					근데 오늘도 천 번 하고 한 번 더 고민 중
					
					막상 네 앞에 서니 꽁꽁 얼어버렸다
					숨겨왔던 나의 맘 절반의 반도 주지를 못했어
					
					아, 아, 아직은
					준비가 안됐다구요
					소용돌이쳐 어지럽다구
					
					쏟아지는 맘을 멈출 수가 없을까?
					너의 작은 인사 한마디에 요란해져서
					네 맘의 비밀번호 눌러 열고 싶지만
					너를 고민고민해도 좋은 걸 어쩌니
					
					거울 앞에서 새벽까지 연습한 인사가
					손을 들고 웃는 얼굴을 하고서 고개를 숙였다
					
					아, 아, 아직도 준비가 안됐나 봐요
					소용돌이쳐 어지럽다구
					
					쏟아지는 맘을 멈출 수가 없을까?
					너의 작은 인사 한마디에 요란해져서
					네 맘의 비밀번호 눌러 열고 싶지만
					너를 고민고민해도 좋은 걸
					
					이러지도 저러지도 못하는데
					속이 왈칵 뒤집히고
					이쯤 왔으면 눈치 챙겨야지
					날 봐달라구요!
					
					좋아한다 너를 좋아한다 좋아해
					
					너를 많이 많이 좋아한단 말이야
					벅차오르다 못해 내 맘이 쿡쿡 아려와
					두 번은 말 못 해 너 지금 잘 들어봐
					매일 고민하고 연습했던 말
					좋아해					
					""";
			
			String path = "io_test/char";
			
			File folder = new File(path);
			
			// 폴더가 없을 경우 생성
			if(!folder.exists()) {
				folder.mkdirs();
			}
			
			// 문자 기반 파일 출력 스트림 객체 생성
			fw = new FileWriter(folder + "/" + "고민중독_buffer.txt");
			
			// 보조 스트림 객체 생성
			bw = new BufferedWriter(fw);
			
			// 문자 기반 보조 스트림을 이용해서 출력하기
			bw.write(content); // String, char[] 출력을 위한 기능이 제공됨
			
			// 스트림에 남은 데이터를 밀어냄.
			bw.flush(); // close() 시 자동 수행됨. 그래서 굳이 안써도 됨.
			
			System.out.println("출력 완료");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(bw != null) bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 문자 기반 입력 스트림 + 보조 스트림 이용해서 파일 읽어오기
	 */
	public void fileInput() {
		
		BufferedReader bis = null;
		
		/* [try - with - resource]
		 * - 자바 7버전(2011)에서 추가된 기능
		 * - finally에서 작성하던 close 처리 구문을 자동으로 수행하도록 만드는 구문
		 */
		
		String path = "io_test/char/고민중독.txt";
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			// 보조 스트림을 이용해서 파일 내용 읽어오기

			StringBuilder sb = new StringBuilder(); // 읽어온 내용 누적
			String temp = null; // 임시 변수
			
			while(true) {
				
				temp = br.readLine(); // 한 줄씩 읽어오기
				
				if(temp == null) break; // 읽어온 내용이 없으면 반복 종료
				
				sb.append(temp); // 읽어온 내용 누적(엔터 미포함)
				sb.append("\n"); // 엔터 추가
			}
			
			System.out.println("읽어오기 성공!");
			System.out.println("=======================================================");
			System.out.println(sb.toString());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		// finally 에서 close 하던 구문 생략 가능
	}
	
	// Scanner 대신 스트림을 이용한 문자열 입력 받기
	// => Scanner가 편리하긴 한데 매우 느림!!
	// 키보드 입력 => 바이트(2진수) 코드 입력 => 문자 변화
	
	public void keyboardInput() {
		
		//  문자 기반
		// System.in : 기본 장치(키보드)와 연결된 InputStream 반환
		// InputStreamReader : 바이트 스트림 => 문자 스트림으로 변환 시켜주는 객체
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			// BufferedReader :문자기반								System.in : 바이트 기반
			
			System.out.println("문자열 입력 : ");
			String input1 = br.readLine(); // 입력된 한 줄 읽어오기
			
			System.out.println("문자열 입력 : ");
			String input2 = br.readLine(); // 입력된 한 줄 읽어오기
			
			System.out.println("input1 : " + input1);
			System.out.println("input2 : " + input2);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
