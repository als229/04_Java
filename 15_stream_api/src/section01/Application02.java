package section01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Application02 {
	public static void main(String[] args) {
		
		/* 스트림 생성 방법 */
		
		// 1) 배열 => 스트림
		String[] names = {"짱구", "훈이", "맹구"};
		
		Stream<String> nameStream = Arrays.stream(names);
		
		// 스트림 + 메서드 참조
		nameStream.forEach(System.out::println);
		
		// 두번 하면 오류남
//		nameStream.forEach(System.out::println);
		// java.lang.IllegalStateException: stream has already been operated upon or closed 
		// IllegalState : 잘못된 상태			                ||
		// 									스트림이 이미 작동되었거나 종료되었습니다.
		// 스트림은 1회용이다.
		
		// 2) 컬렉션 => Stream
//		List<String> animals = new ArrayList<String>();
//		
//		animals.add("dog");
//		animals.add("cat");
//		animals.add("cow");
//		animals.add("rat");
//		animals.add("pig"); => 너무 길다
		
		System.out.println();
		
		List<String> animals = Arrays.asList("dog", "cat", "cow", "rat", "pig");
		// asList => 고정된 길이의 List 생성 및 요소 추가 방법
		
		Stream <String> animalStream = animals.stream();
		
		animalStream.filter(animal -> animal.startsWith("c")).forEach(System.out::println); //startsWith("c") : c로 시작하는 동물만 필터링 
		
		System.out.println();
		
		// 3) Stream 개체 생성
		
		IntStream intStream1 = IntStream.range(3, 7); // 3이상 7미만
		IntStream intStream2 = IntStream.rangeClosed(3, 7); // 3이상 7이하
		
		intStream1.forEach(System.out::print);
		System.out.println();
		
		intStream2.forEach(System.out::print);
		System.out.println();
		
		LongStream longStream = LongStream.rangeClosed(1, 9);
		longStream.forEach(a -> System.out.print(a));
		System.out.println();
		
		System.out.println();
		DoubleStream doubleStream = DoubleStream.of(3.14, 4.5, 11.7);
//		double sum = 0;
//		doubleStream.forEach(num -> System.out.print(sum += num)); // 에러남 람다식 안에 지역변수는 상수여야함
		double sum = doubleStream.reduce(0, (a,b) -> a + b);
		// reduce : 줄여요 => 0이 a, b에 내용물들 하나 하나 들어감.
		System.out.println(sum);
		
		System.out.println();
		Stream<String> fruitStream = Stream.of("사과", "딸기", "바나나");
		fruitStream.forEach(System.out::println);
		
	}
}
