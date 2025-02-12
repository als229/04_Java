package section02;

public class Main2 {

	public static void main(String[] args) {
		
		// 인스턴스 내부 클래스 생성 방식
//		OuterClass2 outer = new OuterClass2();
//		OuterClass2.StaticInnerClass inner = outer.new StaticInnerClass();
		// Illegal enclosing instance specification for type OuterClass2.StaticInnerClass
		// 오류남
		
		/* 정적 내부 클래스 생성 방법
		 * - 외부 인스턴스 생성 없이 바로 내부 클래스 이용 가능
		 */
		OuterClass2.StaticInnerClass inner = new OuterClass2.StaticInnerClass();
		
		inner.display();
		
		// 참조 변수를 이용한 static 호출 권장 X
//		inner.staticDisplay();
		// The static method staticDisplay() from the type OuterClass2.StaticInnerClass should be accessed in a static way
		// 노랑줄 생김

		// 클래스 명으로 호출 권장 O
		OuterClass2.StaticInnerClass.staticDisplay();
		// 이렇게 호출하는 걸 권장
		
	}

}
