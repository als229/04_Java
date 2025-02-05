package section01.service;

import section01.dto.Child;
import section01.dto.Parent;

public class PolymorphismService {
	/* 객체 지향 프로그래밍
	 * - 현실은 객체와 객체의 상호 작용으로 사건이 발생한다는 개념을 컴퓨터로 옮겨놓은 것
	 * 
	 * - 객체는 속성/기능으로 이루어짐
	 * 
	 * class : 객체의 속성과 기능을 정의한 것(문서, 설계도)
	 * 
	 * instance : class에 작성된 내용을 토대로 메모리에 생성된 객체
	 */

	/* * 참조변수 instanceof 클래스명
	 *  
	 * - "참조변수"가 참조하는 객체가 "클래스명"으로 만들어진 객체가 맞을 경우
	 * 
	 * - 상속 관계도 파악이 가능
	 * (자식 객체 내부의 부모 객체도 인식)
	 */

	/** 객체 타입, 필드 정보를 출력하는 메서드
	 * 
	 * @param obj : Object 또는 Object를 상속 받은 객체 참조 변수
	 * (Object는 모든 클래스/객체의 최상위 부모)
	 * 
	 */
	
	/*
	 * [다형성, Polymorphism]
	 * - 다양한 형태를 지니는 성질
	 * - 부모클래스 참조 변수로 자손 클래스 참조하는 기술
	 * 
	 * [객체에 대한 다형성]
	 * 
	 * 1. 업 캐스팅
	 * - 자식 객체가 부모 객체로 변하는 것
	 *   (자식 내 부모 부분만 참조)
	 * 
	 * - 참조 변수의 타입 	        : 부모 타입
	 * - 참조하는 객체의 타입    : 자식 타입
	 * 
	 * - 매개 변수의 다형성
	 * - 반환형의 다형성
	 * - 객체 배열의 다형성
	 * 
	 * 2. 다운 캐스팅
	 * - 업 캐스팅 되어 있는 객체의 참조 변수를 자식 타입으로 강제 형변한
	 *   (자식 객체를 참조 할 수 있게됨)
	 * 
	 * [instanceof 연산자]
	 * 
	 * - 참조변수 instanceof 클래스명
	 * 
	 * - "참조변수"가 참조하는 객체가 "클래스명"클래스로 만들어진 객체 또는 상속받은 객체인 경우 true 반환 아니면 false 반환
	 * 
	 * [바인딩(Binding)]
	 * - 메서드 호출부와 실제 메서드를 연결하는 것
	 * 
	 * 1. 정적 바인딩
	 *  - 프로그럼 실행 "전" 컴파일 단계에서 메스드 - 메서드 호출부 연결
	 *  - 참조변수의 자료형을 확인하여 해당 클래스의 메서드와 연결
	 * 
	 * 2. 동적 바인딩
	 *  - 프로그램 실행 "중" (runtime 시) 메서드 호출부와 실제 참조하는 객체의 오버라이딩 된 메서드와 연결 
	 *    (오버라이딩된 메서드가 우선권을 갖는다.)
	 * 
	 */
	public void printObject(Object obj) {

		String result = null;

		if(obj instanceof Child) {
			// obj가 참조하는 객체의 타입이 Child 또는 Child를 상속 받은 자식 타입인 경우
			result = "[Child Type]\n";
			
			Child c = (Child)obj;
			
			result += c.getLastName() + " / " + c.getMoney() + " / " +  c.getCar();
		}else if(obj instanceof Parent) {
			// obj가 참조하는 객체의 타입이 Parent 또는 Parent를 상속 받은 자식 타입인 경우
			result = "[Parent Type]\n";

			Parent p = (Parent)obj;

			result += p.getLastName() + " / " + p.getMoney();
//		}else if(obj instanceof Object) {
		// => 모든 클래스/객체는 Object 의 자식이기 때문에 else로 해도 상관 없음0
		}else {
			// obj가 참조하는 객체의 타입이 Object 또는 Object를 상속 받은 자식 타입인 경우
			
			result = "[Object Type] 필드 없음";
		}
//		else {
//			result = "이건 말두 안돼";
//		}

		System.out.println("====================================================");
		System.out.println(result);
		System.out.println("====================================================");

	}

	// 매개 변수의 다형성 확인
	public void test1() {

		Object obj = new Object();
		Parent parent = new Parent("김", 500);
		Child child = new Child("dl", 6000, "테슬라");

		printObject(obj); // 같은 object 타입 전달 가능
		printObject(parent); // Object의 자식 타입인 Parent 전달 가능 => 업 캐스팅
		printObject(child); // Object의 후손 타입인 Child 전달 가능 => 업 캐스팅

	}
	
	/* [반환형의 다형성]
	 * - 메서드의 반환형을 부모 타입으로 설정하여 return 되는 자식 객체의 주소를 참조할 수 있게 한다.
	 * 
	 * - 다형성의 업캐스팅 적용
	 */
	
	/**
	 * 전달 받은 num 값에 따라 알맞은 객체를 생성 반환하는 메서드
	 * @param num : 1 = Child , 2 = Parent, 나머지 = Object 
	 * @return 생성된 객체 참조 주소 반환
	 */
	public Object getInstance(int num) {
		
		// if, for, whild 의
		// {} 내부 코드가 한 줄인 경우 {} 생략 가능
		if(num == 1) return new Child();
		if(num == 2) return new Parent();
		
		return new Object();
	}
	
	// 반환형의 다형성 확인
	public void test2() {
		
		// o1, o2 는 업캐스팅 상태
		Object o1 = getInstance(1); // Child 객체 반환 => 업캐스팅
		Object o2 = getInstance(2); // Parent 객체 반환 => 업캐스팅
		Object o3 = getInstance(123123); // Object 반환
		
		printObject(o1);
		printObject(o2);
		printObject(o3);
	}
	
	/* [바인딩(Binding)]
	 * - 메서드 호출부와 실제 실행할 메서드 코드를 연결하는 것
	 * 
	 * [정적 바인딩]
	 * - 프로그램 실행 전
	 * 컴파일 단계에서 메서드와 메서드 호출부를 연결
	 * 
	 * [동적 바인딩]
	 * - 프로그램 실행 중(RunTime)
	 *  정적 바인딩 된 메서드를 실제 객체 타입을 기준으로 연결
	 *  
	 *  - 왜 사용?
	 *  1) 다운 캐스팅의 번거로움을 없앰
	 *  
	 *  2) 재정의 된 메서드(조금 더 효율적 또는 알맞는 기능)를 수행
	 *  
	 *  * 상속, 오버라이딩, 업캐스팅(+ 메모리 구조)을 알아야 동적 바인딩을 알 수 있다.
	 * 
	 */
	
	// 바인딩 확인
	public void test3() {
		
		Parent p1 = new Parent("김", 10); // 부모 = 부모
		Child c1 = new Child("최", 20, "테슬라"); // 자식 = 자식
		
		Parent p2 = new Child("박",30, "포터"); // 부모 = 자식(업캐스팅)
	
		// 정적 바인딩 : 프로그램 실행 X, 컴파일 단계에서 연결
		
		// (정적 바인딩 일 때)section01.dto.Parent.toString () => Parent 랑 연결
		// (동적 바인딩 일 때)section01.dto.Parent.toString () => Parent 랑 연결
		System.out.println("p1.toString() : " + p1.toString());
		
		// (정적 바인딩 일 때)section01.dto.Child.toString () => Child 랑 연결
		// (동적 바인딩 일 때)section01.dto.Child.toString () => Child 랑 연결
		System.out.println("c1.toString() : " + c1.toString());
		
		// (정적 바인딩 일 때)section01.dto.Parent.toString () => Parent 랑 연결
		// (동적 바인딩 일 때)section01.dto.Child.toString ()  => Child 랑 연결
		System.out.println("p2.toString() : " + p2.toString());
	}
	
	/* [객체 배열의 다형성]
	 * - 부모 타입의 참조 변수를 묶음으로 다루어서 배열 각 요소에 업캐스팅 적용
	 * 
	 * * 객체 배열 : 객체 참조 변수의 묶음
	 */
	
	// 객체 배열의 다형성 확인
	public void test4() {
		
		// Object 객체 참조 변수 5칸 짜리 배열 생성해서
		// Object[] 참조 변수 arr에 배열 주소 대입
		Object[] arr = new Object[5];
		
		for(int i = 0; i < arr.length; i++) {
			//					1, 2, 3 반복 Child, Parent, Object 반복으로 나옴
			arr[i] = getInstance(i % 3 +1);
		}
		
		System.out.println("=========================================================");
		
		// 객체 배열의 다형성 + 동적 바인딩
		
		// * 동적 바인딩
		// - 실행 중 메서드 호출부 연결이 실제 참조하는 객체의 오버라이딩 된 메서드로 연결되는 것
		// 	 (오버라이딩 된 메서드가 우선권을 갖는다.)
		
		for(Object obj: arr) {
			// 실제 참조 중인 객체의 toString()이 호출됨
			System.out.println(obj.toString());
		}
		
		System.out.println("==========================================================");
		
		System.out.println("[동적 바인딩이 없다면]");
		for(Object obj: arr) {
			// 참조 객체 타입 검사 후 다운 캐스팅
			if(obj instanceof Child) {
				Child c = (Child)obj;
				System.out.println( c.toString());
			}else if(obj instanceof Parent) {
				Parent p = (Parent)obj;
				System.out.println(p.toString());
			}else {
				System.out.println(obj.toString());
			}
		}
		
		/* debug 모드
		 * - 이클립스 등 IDE 에서 제공하는 기능
		 * - 코드 수행 중 지정된 지점(breakpoint)에서 실행을 멈추고 
		 * 	 해당 시점에 존재하는 변수/필드 값을 확인하는 모드
		 * 
		 * 실행 : ctrl + f11
		 * 디버그 실행 : f11
		 */
	}
	
	// 다운 캐스팅 시 주의 사항
	// - 강제 형변환이 적용되는 참조 변수가 형변환 하려는 타입의 객체를 참조하고 있는지 확인 필요
	// => instanceof 사용 
	public void test5() {
		
		Parent p = new Child("김", 200, "소나타");
		
		/*
		 * * ClassCastException 발생
		 *  - 참조변수의 강제 형변환(다운 캐스팅) 시 참조하는 객체가 변환하려는 타입이 아니거나 상속 관계도 아니면
		 *    형변환 불가(ClassCastException) 발생
		 */
		
		// java.lang.ClassCastException: class section01.dto.Child cannot be cast to class java.lang.String
		// 235번 코드에 넣으면 에러남 p 넣으면
		// instanceof 사용 해 줘야 함
		test6(p);
	}
	
	// 전달 받은 객체를 String 타입으로 다운 캐스팅(강제 형변환)
	public void test6(Object obj) {
		
//		String p = (String)obj;
//		System.err.println(p);
		
		if(obj instanceof String) {
			String p = (String)obj;
			System.err.println(p);
		}else {
			// String이 아니면 객체를 만들 때 사용한 클래스명 출력
			System.out.println(obj.getClass().getName());
		}
		
	}
	
	
}
