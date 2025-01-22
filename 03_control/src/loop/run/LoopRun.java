package loop.run;

import loop.service.LoopService1;
import loop.service.LoopService2;

public class LoopRun {
	
	public static void main(String[] args) {
		
		// LoopService1 객체 생성
		LoopService1 service1 = new LoopService1();
		
//		service1.displayMenu(); // 메뉴 제공 메서드 실행
		
		LoopService2 service2 = new LoopService2();
		
		service2.displayMenu();
		
	}
	
}
