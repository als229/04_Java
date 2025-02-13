package section01;

public class Main1 {

	public static void main(String[] args) {
		
		/* 함수형 인터페이스
		 * - 추상 메서드가 1개만 있는 메서드
		 * 
		 * @FunctionalInterface 어노테이션
		 * - 함수형 인터페이스 작성법이 맞는지 컴파일러에게 검증하라고 지시하는 어노테이션
		 * 
		 * 람다식(또는 람다 표현식)
		 * - 메서드를 하나의 식으로 표현하는 익명 함수
		 * - 함수형 인터페이스를 구현하는데 사용
		 * 
		 * Java 제공 함수형 인터페이스
		 * - java.util.function 패키지에 존재
		 * 
		 * 1. Consumer<T> : 매개 변수를 소비, 		매개변수 O, 반환 X
		 * 2. Supplier<T> : 값만 제공,        		매개변수 X, 반환 O
		 * 3. Function<T, R> : T를 받고 R을 반환,	매개변수 O, 반환 O
		 * 4. Operator<T> : T를 받고 T반환,     	매개변수 O, 반환 O
		 * 5. Predicate<T> : T를 받고 T/F 반환, 	매개변수 O, 반환 O
		 * 
		 * 메서드 참조
		 * - 함수형 인터페이스를 람다식으로 표현하는 것이 아닌 이미 존재하는 메서드를 참조시키는 방법
		 * 
		 * ex) Consumer<T> con = () -> {}; (X)
		 * 	   Consumer<T> con = 클래스명::메서드명 (O)
		 */

		/* Calculator 구현체를 만들어서 메서드 수행하기 */

		/* 1. 인터페이스를 상속 받은 클래스 이용 */
		Calculator calc1 = new CalculatorImpl(); // 구현체 객체 이용
		System.out.println("calc1.sumTwoNumber(3, 5) : " + calc1.sumTwoNumber(3, 5)); // 8
		
		/* 2. 익명 내부 클래스 이용 */
		
		Calculator calc2 = new Calculator() {
			@Override
			public int sumTwoNumber(int a, int b) {
				return a + b;
			}
		};
		
		System.out.println("calc2.sumTwoNumber(3, 5) : " + calc2.sumTwoNumber(3, 5)); // 8
		
		/* 3. 람다 이용 (익명 내부 클래스를 이용함)  */
		// () -> {}
		
		// Calculator 인터페이스
		// == 함수형 인터페이스 -> 추상 메서드 1개만 존재!
		// => 추상 메서드 int sumTwoNumber(int a, int b)
		Calculator calc3 = (a, b) -> {return a + b;};
		// => 람다식은 컴파일 시 익명 내부 클래스로 변환 된다!!
		System.out.println("calc3.sumTwoNumber(100, 899) : " + calc3.sumTwoNumber(100, 899)); // 999
		
		// {} 내부 코드가 한 줄 => {}, return 생략 가능
		Calculator calc4 = (a, b) -> (a + b) * 2;
		System.out.println("calc4.sumTwoNumber(3, 4) : " + calc4.sumTwoNumber(3, 4)); // 999
		
		// a^3 + b^3 반환하는 람다식 작성
//		Calculator calc5 = (a, b) -> a*a + b*b*b; 
		Calculator calc5 = (a, b) -> (int)(Math.pow(a, 2) + Math.pow(b, 3));
		System.out.println("calc5.sumTwoNumber(3, 4) : " + calc5.sumTwoNumber(3, 4)); // 73
	}

}
