package section02;

public class OuterClass2 {

	// 외부 클래스의 멤버
	private int outerInstanceNum = 100; // 인스턴스 변수
	private static int outerStaticNum = 20; // 클래스 변수
	
	/* 정적(static) 내부 클래스 정의 */
	public static class StaticInnerClass{
		/*
		 * static() => non-static 호출 X
		 * static() => static 호출 O
		 * non-static() => non-static 호출 O
		 * non-static() => static 호출 O
		 */
		public int innerInstanceNum = 300; // 내부 클래스의 인스턴스 변수
		public static int innerStaticNum = 50; // 내부 클래스의 클래스 변수
		
		public void display() {
			System.out.println("[내부 클래스 display() 메서드]");
			
//			System.out.println("outerInstanceNum : " + outerInstanceNum);
			// Cannot make a static reference to the non-static field outerInstanceNum
			// 오류 발생 - 외부 클래스의 인스턴스 변수 호출 불가
			// static 은 static 끼리만 참조 가능

			// 외부 클래스의 static 변수 호출 가능!
			// => static 끼리는 호출하는데 문제 없음!
			System.out.println("outerStaticNum : " + outerStaticNum);
			
			// 정적(static) 내부 클래스라도 내부의 non-static 멤버 끼리는 호출 가능!
			System.out.println("innerInstanceNum : " + innerInstanceNum);

			// non-static() => static 호출 O
			System.out.println("outerStaticNum : " + outerStaticNum);
		}
		
		public static void staticDisplay() {
			System.out.println("[내부클래스 staticDisplay() 메서드]");
			
			// 외부 클래스의 클래스 변수는 정적 내부 클래스(static) 의 static 메서드에서도 호출 가능~
			System.out.println("outerStaticNum : " + outerStaticNum);

			// 오류 발생 => non-static 멤버 변수 호출 불가
//			System.out.println("innerInstanceNum : " + innerInstanceNum);
			
			System.out.println("innerStaticNum : " + innerStaticNum);
		}
	}
	
}
