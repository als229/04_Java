package section02;

/* Object 클래스
 * - 모든 클래스(객체)의 최상위 부모
 * - 모든 클래스(객체)가 공통적으로 가져야 하는 기능이 모여 있음
 * 
 * - 클래스 선언부에 아무런 상속 구문이 작성되지 않으면 컴파일러가 자동으로 [extends Object] 추가
 */

/*
 * *** 자바에서 클래스간의 상속은 단일 상속만 지원!! ***
 */

/* final 클래스 / final 메서드
 * 
 * - final : 마지막, 최종 
 * 
 * - final class : 상속 불가 클래스
 * => 다른 클래스가 필드/메서드를 상속 받아 사용하지 못하게 하려고
 * 	  ( + 모든 메서드 오버라이딩 불가) 
 * 
 * - final method : 오버라이딩 불가 메서드
 * => 이미 완벽한 기능 / 바꾸면 문제가 생기는 기능 재정의 방지
 * 
 * - final variable : 값 대입 불가 변수(상수)
 */

//The type Student cannot subclass the final class Person
// final 쓰면 Student에 에러남
public /* final */  class Person /* extends Object */{
	private String name;
	private int age;
	
	// 기본 생성자
	public Person() {
		System.out.println("[Person 기본 생성자로 생성됨]");
	}

	// alt + shift + s => o 생성자 단축키
	public Person(String name, int age) {
		System.out.println("[Person 매개 변수 있는 생성자로 생성됨]");
		
		this.name = name;
		this.age = age;
	}

	// getter/setter 생성
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	/* Object.toString() 메서드
	 * - 객체를 사람이 읽기 쉬운 간단한 문자열 형태로 반환하는 목저의 메서드
	 * 
	 * - 모든 자식 클래스에서 재정의(오버라이딩)해서 사용
	 */
	
	/* 오버라이딩(Over + riding)
	 * - 덮어쓰다, '재정의' 하다라는 의미
	 * - 부모와 같은 이름의 메서드를 자식이 다시 정의하는 기술
	 * 	 (자식이 용도에 맞게 코드를 수정)
	 * 
	 * [오버라이딩 성립 조건]
	 * 
	 * 1) 변경 불가
	 * - 메서드명 
	 * - 반환형 
	 * - 매개변수의 타입, 개수, 순서
	 * 
	 * 2) 변경 가능
	 * - 접근 제어자 같거나 넓은 범위로 변경 가능
	 * - 예외처리는 같거나 좁은 범위로 변경 가능
	 * 
	 * *** 주의 사항 ***
	 * 부모의 private 메서드는 오버라이딩 불가!
	 * (직접 접근이 차단되어 있어 재정의 자체가 불가)
	 *  
	 * ========================================================
	 * 어노테이션(Annotation, 주석) : 컴파일러를 위한 주석
	 * - 코드의 추가적인 정보 제공 목적
	 * - 컴파일러에게 지시하는 목적
	 * 
	 * @Override 어노테이션(Annotation, 주석)
	 * 1) 해당 메서드가 오버라이딩 되었음을 명시 (정보 제공)
	 * 2) 컴파일러에게 해당 메서드 오버라이딩이 문제없이 작성되었는지 확인(검증)하라 지시
	 *	  (성립 조건을 위배하지 않았는지 확인)
	 *
	 * - 상속관계에서 부모의 메서드를 자식이 용도에 맞게 재정의 하는 것
	 */
	
	/*
	 * 오버로딩 vs 오버라이딩
	 * 
	 * 오버라이딩(Over + riding)
	 * - 덮어쓰다, '재정의' 하다라는 의미
	 * - 부모와 같은 이름의 메서드를 자식이 다시 정의하는 기술
	 * 	 (자식이 용도에 맞게 코드를 수정)
	 * 
	 * 오버로딩(Overloading, 과적)
	 * - 하나의 클래스에 같은 이름의 메서드를 여러 개 작성하는 기술
	 * - 비슷한 기능을 제공하는 메서드들을 하나의 이름으로 관리
	 * 
	 * [공통점]
	 * - 메서드 이름이 동일해야 한다.
	 * 
	 * [차이점]
	 * 오버로딩                              		||  오버라이딩
	 * 						                        ||
	 * 같은 클래스에 작성			  	 			||  하위(자식) 클래스에 작성
	 * 매개 변수(개수,순서,타입) 하나라도 다름      ||  매개 변수 동일
	 * 반환형 관계 없음                             ||  반환형 동일
	 * 접근 제어자 관계 없음                        ||  접근 제어자가 같거나 넓은 범위
	 * 예외처리 관계 없음                           ||  예외처리 같거나 좁은 범위
	 * 
	 */
	
	@Override
	public String toString() {
		return String.format("name : %s age : %d", name, age );
	}

	//Cannot override the final method from Person
	// final 적으면 Student introduce 에 에러남
	// 부모 메서드
	public /* final */ String introduce(String alias) {
		return String.format("[Person] 이름은 %s 이고 별명은 %s 입니다.", name, alias);
	}
	
}
