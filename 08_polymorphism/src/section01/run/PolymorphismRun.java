package section01.run;

import section01.dto.Child;
import section01.dto.Parent;
import section01.service.PolymorphismService;

public class PolymorphismRun {

	public static void main(String[] args) {
		
		PolymorphismService service = new PolymorphismService();
		
		/* [매개 변수의 다형성]
		 * 
		 * - 매개 변수의 타입을 부모 타입으로 설정하여 모든 자식 객체 참조 주소를 전달 받을 수 있도록 함
		 * (다형성 - 업캐스팅 적용)
		 * 
		 * 
		 * * 매개 변수(Parameter) : 메서드 호출 시 전달된 값을 저장하는 변수
		 */
//		service.test1();
//		service.test2();
//		service.test3();
//		service.test4();
		service.test5();
//		service.test6();
		
	}
}
