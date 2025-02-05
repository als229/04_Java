package section03.run;

import section03.dto.Calculator;
import section03.dto.KKMCalculator;

public class InterfaceRun {

	public static void main(String[] args) {
		
		// 인터페이스를 부모 타입 참조 변수로 하여 Calculator 구현체 생성하기
		// (업 캐스팅 + 동적 바인딩)
		
		Calculator calc = new KKMCalculator();
		
		System.out.println("calc.plus : " + calc.plus(1234, 5678 ));
		System.out.println("calc.minus : " + calc.minus(10000,1999999999));
		System.out.println("calc.multi : " + calc.multi(3333333, 4444444));
		System.out.println("calc.div : " + calc.div(5, 3));
		System.out.println("calc.mod : " + calc.mod(5, 3));
		System.out.println("calc.pow : " + calc.pow(2, 10));
		System.out.println("calc.areaOfCircle : " + calc.areaOfCircle(10.5));
		
	}

}
