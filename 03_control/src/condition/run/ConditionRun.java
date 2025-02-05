package condition.run;

import condition.service.ConditionService;

/**
 * 실행용 클래스
 * */
public class ConditionRun {
	
	// main method : 자바 실행 메서드
	public static void main(String[] args) {

		//ConditionService 객체 생성
		ConditionService service = new ConditionService();
		
//		service.method1();
//		service.method2();
//		service.method3();
//		service.displayMenu();
		service.gradeMethode();
		
	}
}
