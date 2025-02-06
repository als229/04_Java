package section02;

//import java.lang.*; // 컴파일러가 자동 추가

public class StringService {

	/* [String]
	 * - java.lang 패키지에서 제공
	 * - 문자열을 저장하고 관련된 기능을 제공하는 클래스
	 * 
	 * [String의 불변성(immutable)]
	 * 
	 * - String은 문자열을 저장하는 필드가 final로 선언되어있음
	 * 	 => 한 번만 값 대입 가능
	 * 
	 * - 저장된 문자열 수정이 불가하기 때문에 수정을 원할 경우 새로운 String 객체를 생성해서 참조
	 * 
	 * ex) String s1 = "hello"; // 참조 주소 : 0x100
	 * 	   s1 += "world"; 		// 참조 주소 : 0x300 => 달라진다
	 */
	
	/**
	 * String 불변성 확인
	 */
	public void test1() {
		
		// int System.identityHashCode(Object obj);
		// => 객체를 구분하는 해시코드 반환
		//    (주소를 이용해서 만들었기 때문에 모든 객체가 다른 값을 지님)
		
		String s1 = "hello";
		System.out.println("s1 : " + s1);
		System.out.println(System.identityHashCode(s1));
		System.out.println("=======================================");
		
		s1 += " World";
		System.out.println("s1 : " + s1);
		System.out.println(System.identityHashCode(s1));
	}
	
	/* [String 객체 생성 방법]
	 * 1) String 리터럴("" 쌍따옴표)을 이용하여 생성
	 * 	  String s1 = "hello";
	 * => heap 메모리 영역에 존재하는 String Constant(상수) Pool에 String 객체 생성 
	 * 
	 * 2) new 연산자를 이용하여 생성
	 *    ex) String s2 = new String("hello");
	 * => new 쓰면 heap 메모리 영역에 독립된 String 객체 생성
	 */
	
	/* [String Constant Pool]
	 * 
	 * - String 리터럴("")을 이용해 생성된 String 객체가 저장되는 Heap 내부 영역
	 * 
	 * - String 리터럴을 이용해서 [동일한 값]의 String 객체를 생성하는 경우
	 *   새로운 객체가 생성되지 않고 기존에 같은 값을 지닌 객체의 주소가 반환된다.
	 *   (메모리 효율을 높여줌)
	 *   
	 *   ex) String s1 = "hello"; // 참조 주소 : 0x100
	 *   	 String s2 = "hello"; // 참조 주소 : 0x100
	 *   
	 *   	 String s3 = new String("hello"); // 참조주소 0x200
	 *   	 String s4 = new String("hello"); // 참조주소 0x300
	 */
	
	public void test2() {
		
		//String 리터럴을 이용해서 객체 생성
		String s1 = "hello"; // 664740647
		System.out.println("s1 : " + System.identityHashCode(s1));
		
		// 같은 값을 지닌 String 객체를 리터럴을 이용해 생성
		String s2 = "hello"; // 664740647
		System.out.println("s2 : " + System.identityHashCode(s2));
		// => s1과 s2 의 주소 값이 String Constant Pool에 생성되기 때문에 같음
		
		String s3 = new String("hello"); // 321001045
		System.out.println("s3 : " + System.identityHashCode(s3));
		// => heap 영역에 별도로 생성되어 주소가 다름!!
		
		System.out.println("===============================================");
		
		System.out.println("[참조 주소 비교] s1 == s2 : " + (s1 == s2)); // true
		System.out.println("[참조 주소 비교] s1 == s3 : " + (s1 == s3)); // false
		
		System.out.println("[필드 값 비교] s1.equals(s2) : " + (s1.equals(s2))); // true
		System.out.println("[필드 값 비교] s1.equals(s3) : " + (s1.equals(s3))); // true
	}
	
}
