package section02;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamTest {
	public static void main(String[] args) {
		
		/* 스트림 - 최종 연산 
		 * - 스트림의 요소를 소모하여 결과를 만들어 내는 연산
		 */
		
		List<Integer> numbers = Arrays.asList(2, 7, 14, 23, 34, 52);
		
		/* 메서드 체이닝(method chaining)
		 * - 앞선 메서드의 반환 값을 이용해서 다른 메서드 호출
		 * - 메서드 호출이 연속된 모양
		 */
		
		/* void forEach() : 각 요소에 대해 지정된 작업 수행 */
		numbers.stream().forEach(num -> System.out.print(num + " / "));
		System.out.println();

		/* long count() : 스트림에 저장된 요소의 개수 반환 */
		long count = numbers.stream().count();
		System.out.println(count);
		System.out.println();
		
		/* java.util.Optional<T> min(), max() : 최소/최대값 반환 */
		
		Optional<Integer> min = numbers.stream().min((n1, n2) -> n1.compareTo(n2));
		System.out.println("최솟값 : " + min.get());
		
		Optional<Integer> max = numbers.stream().max((n1, n2) -> n1.compareTo(n2));
		System.out.println(max);
		System.out.println();
		
		/* reduce(초기값, (a, b) -> {})
		 * - 스트림 요소를 이용해서 하나의 값을 도출함
		 * - 도출되려는 결과는 "초기값" 변수에 누적됨
		 */
		
		// 합계
		int sum = numbers.stream().reduce(0, (a,b) -> a+b);
		
		// 모든 요소를 곱한 결과
		int result = numbers.stream().reduce(1,(a, b) -> a * b);
		
		System.out.println("합계 : " + sum);
		System.out.println("곱 : " + result);
		
		System.out.println("=============================================================");
		
		/* 중간연산
		 * - 기존 스트림을 이용해서 새로운 스트림을 만드는 연산
		 */

		/* filter() : 기존 스트림에서 조건에 맞는 요소만을 이용해 새로운 스트림을 생성 */
		
		// numbers에서 짝수만 출력하기
		numbers.stream().filter(num -> num % 2 == 0).forEach(a -> System.out.print(a + " ")); // 짝수로 필터링된 스트림 생성
		System.out.println();
		// numbers에서 짝수 합 구하기
		int evenSum = numbers.stream().filter(num -> num % 2 == 0).reduce(0, (a,b) -> a+b);
		System.out.println("numbers 짝수 합 : " + evenSum);
		
		/* mpa() 
		 * - 스트림의 모든 요소를 새로운 형태로 변환 후 새 스트림으로 반환
		 * - 기존 스트림과 새 스트림의 요소 개수가 같음 
		 */
		
		numbers.stream().map(num -> num * 2).forEach(num -> System.out.print(num + " "));
		System.out.println();
		
		
		/* sorted()
		 * - 객체에 정의된 기본 정렬 방식으로 정렬된 스트림 생성 (Comparable Interface 상속 필요)
		 */
		
		List<Integer> list = Arrays.asList(1,8,4,123,65,99,741,55,43);
		
		list.stream().sorted().forEach(a -> System.out.print(a + " "));
		
		// => 중간에 들어가서 중간연산
		
		
	}
}
