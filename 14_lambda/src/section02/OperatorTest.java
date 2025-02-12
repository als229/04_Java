package section02;

import java.util.function.IntBinaryOperator;
import java.util.function.UnaryOperator;

public class OperatorTest {
	public static void main(String[] args) {
		
		/* Operator 계열
		 * - 매개 변수와 반환 값의 타입이 같은 함수형 인터페이스
		 * - applyXXX() 메서드 제공
		 */
		
		// Unary : 단일 요소로 된('어네어리'로 읽음)
		/* UnaryOperator<T> : T를 전달 받아 T를 반환 */
		
		UnaryOperator<String> addString = str -> "[" + str + "] 님 반갑스빈다.";
		
		System.out.println(addString.apply("김관민"));
		
		// IntBinaryOperator : int 매개 변수 2개를 전달 받아 int 반환
		IntBinaryOperator squre = (a, x) -> {
			int result = 1;
			
			for(int i = 0; i < x; i++) {
				result *= a;
			}
			
			return result;
		};
		
		System.out.println(squre.applyAsInt(2, 10)); // 1024
		System.out.println(squre.applyAsInt(2, 16)); // 65536 => 2byte 범위 => 유니코드가 0 ~ 65536까지 범위
	}
}
