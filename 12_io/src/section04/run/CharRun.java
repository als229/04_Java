package section04.run;

import section04.service.CharService;

public class CharRun {
	public static void main(String[] args) {

		CharService service = new CharService();
		
//		service.fileOutput1(); // 문자기반 출력
//		service.fileOutput2(); // 문자기반 보조스트림 출력
//		service.fileInput(); // 문자 기반 입력 스트림 + 보조 스트림 이용해서 파일 읽어오기
		service.keyboardInput(); // BufferedReader를 이용한 키보드 입력
		
	}
}
