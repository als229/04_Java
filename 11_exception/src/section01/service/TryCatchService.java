package section01.service;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatchService {
	
	private Scanner sc = new Scanner(System.in);
	
	/* Exception(예외) : 코드로 해결 가능한 에러
	 * (if, try-catch, throws)
	 * 
	 * Exception Handling(예외 처리)
	 *  발생된 예외를 처리하는 구문(try-catch, throws)
	 */
	
	/** try-catch 작성법
	 * 
	 * <pre>
	 * try { 예외가 발생할 것 같은 구문 }
	 * - 예외가 발생할 가능성이 있는 코드를 시도하는 구문 {}
	 * 
	 * catch(예외 참조 변수){ }
	 * - try에서 던져진 예외를 () 내에 예외 참조 변수가 잡아서 처리하는 구문
	 * => 잡아서 처리하면 예외가 사라짐
	 * => 프로그램이 종료되지 않고 계속 정상수행!
	 * </pre>
	 */
	
	/* 요약 정리
	 * - 오버라이딩 시 throws 구문 작성 방법
	 * 1) 같거나 좁은 범위(세세한, 구체적인 예외)
	 * 2) throws 제거 가능(예외 발생 안하는 코드로 재정의)
	 * 
	 * - 사용자 정의 예외
	 * 	 사용자가 필요한 예외 클래스 만들 수 있음
	 * 
	 * - 사용자 정의 예외 생성 방법
	 * => 아무 Exception 클래스 상속
	 * 
	 *  1) Checked Exception - RuntimeException 또는 자식 뺀 나머지 상속
	 *  2) Unchecked Exception - RuntimeException 또는 자식 상속 
	 *  
	 * IO(입출력)
	 * - 입력 : 프로그램이 데이터를 읽음(read)
	 * - 출력 : 프로그램이 데이터를 씀(write)
	 * 
	 * File 클래스
	 * - 파일 존재 여부 관계 없이 파일을 참조하고 관리하는 객체
	 * 
	 * 경로 작성 시 /, \ 차이
	 * - Linux/Mac 	: /
	 * - windows 	: \
	 * 
	 * 절대경로 : root(/, C:, D: ...) 최상위 폴더를 기준으로 원하는 위치까지의 경로를 작성
	 * 
	 * 상대경로 : 현재 위치(Java는 현재 프로젝트)를 기준으로 원하는 위치까지의 경로를 작성
	 * 
	 * Stream 
	 * - 뜻 : 흐름, 개울, 시냇물
	 * - 실질적 의미 : 데이터가 한 방향으로 흐르게 하는 객체
	 * 
	 * InputStream / OutputStream
	 * - 바이트 기반 스트림(1byte씩 입출력)
	 * 
	 * - 기반 스트림 : 단독으로 생성되어 사용 가능한 스트림
	 * - 보조 스트림 : 기반 스트림에 붙어 기능 향상, 추가 기능 제공하는 스트림
	 * 
	 * Buffer : 데이터를 모아놓는 메모리 공간
	 * 			ex) 장바구니, 트럭
	 * 			=> 한 번에 실어서 많은 데이터를 묶어서 전달
	 * 			=> Buffer를 이용한 속도가 향상된다!
	 */
	public void test1() {
		
		System.out.println("입력 받은 두 정수를 나눈 몫 계산하기_v1");
		
		System.out.println("첫 번째 정수 : ");
		int num1 = sc.nextInt();
		
		System.out.println("두 번째 정수 : ");
		int num2 = sc.nextInt();
		
		try {
			System.out.println("몫 : " + num1 / num2);
			// java.lang.ArithmeticException: / by zero
			// => 산술적 예외 : 0으로 나눌 수 없습니다.
			// + 예외 발생 시 프로그램 비정상 종료!!
		}catch(ArithmeticException e) {
			// try에서 ArithmeticException 객체가 던져지면
			// 매개 변수 e를 이용해서 잡음
			// => 잡아서 처리 => 예외 사라짐 => 프로그램 정상 운영
			System.out.println("0으로 나눌 수 없습니다.");
		}
		System.out.println("------- 프로그램 종료 --------");
	}
	
	public void test2() {
		
		System.out.println("입력 받은 두 정수를 나눈 몫 계산하기_v2");
		
		try {
			System.out.println("첫 번째 정수 : ");
			int num1 = sc.nextInt();
			
			System.out.println("두 번째 정수 : ");
			int num2 = sc.nextInt();
		
			System.out.println("몫 : " + num1 / num2 );
		}catch(InputMismatchException e) {
			// catch는 여러 번 작성 가능!!!!
			// => try에서 예외 발생 시
			// 던져진 예외를 잡아서 처리할 수 있는 catch 문을
			// 위에서 부터 순서대로 탐색
			// => 알맞은 catch 문에 예외 처리 수행
			System.out.println("정수만 입력 해주세요");
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}
		System.out.println("------- 프로그램 종료 --------");
	}
	/**
	 * 예외처리(try-catch) + 다형성(업 캐스팅)
	 */
	public void test3() {
		System.out.println("입력 받은 두 정수를 나눈 몫 계산하기_v2");
		
		try {
			System.out.println("첫 번째 정수 : ");
			int num1 = sc.nextInt();
			
			System.out.println("두 번째 정수 : ");
			int num2 = sc.nextInt();
		
			System.out.println("몫 : " + num1 / num2 );
		}catch(RuntimeException e) {
			// ArithmeticException과 InputMismatchException의 공통부모 타입을 
			// 매개 변수로  선언
			
			// - try 에서 예외 발생 시 "예외 객체 참조 주소"가 던져짐!!!
			
			// - 업 캐스팅 : 부모 타입 참조 변수 = 자식 객체 참조 주소;
			
			// * 결론 : 부모 타입 예외 참조 변수로 던져지는 모든 자식 예외를 잡겠다!!!
			
			System.out.println(e.toString() + "프로그램 실행 중 예외 발생");
		}
		
		System.out.println("------- 프로그램 종료 --------");
	}
	
	/** 예외처리(try-catch) + 다형성(업 캐스팅) + catch 작성 순서
	 * - catch 문은 하위 타입 부터 작성
	 * - 서로 상속 관계가 아닌 Exception에 대한 catch 순서는 관계 없음
	 */
	public void test4() {
		System.out.println("입력 받은 두 정수를 나눈 몫 계산하기_v2");
		
		try {
			System.out.println("첫 번째 정수 : ");
			int num1 = sc.nextInt();
			
			System.out.println("두 번째 정수 : ");
			int num2 = sc.nextInt();
			
			System.out.println("몫 : " + num1 / num2 );
			
			// 강제 예외 발생
			int[] arr = new int[3];
			arr[10] = 100;
			// ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 3
			// 배열 길이 초과 에러
			
			// Unreachable catch block for InputMismatchException. It is already handled by the catch block for RuntimeException
			// RuntimeException 을 처음에 두면 뒤에 catch는 도착할 일이 없어서 에러남(데드코드가 되어버림)
		
			// 부모 타입 예외 처리 구문을 먼저 작성하면 자식 타입 예외까지 모두 잡기 때문에 뒤에 있는 자식 catch 문이 절대로 실행 될 수 없다!!
		}catch(RuntimeException e) {
			System.out.println("프로그램 실행 중 예외 발생");
		} // => 얘가 맨 밑으로 가야함!
		// 데드 코드
//		}catch(InputMismatchException e) {
//			System.out.println("정수만 입력 해주세요");
//		}catch(ArithmeticException e) {
//			System.out.println("0으로 나눌 수 없습니다.");
//		}
		
		System.out.println("------- 프로그램 종료 --------");
	}
	
	/** catch문에 다형성 업 캐스팅 적용 + 예외 강제 발생(예외를 만들어 던짐)
	 * 
	 * - 예외도 클래스다!! => 객체로 만들 수 있다 => new 연산자 사용
	 * 
	 * - 예외 강제 발생 구문 : throw new 예외클래스();
	 */
	public void test5() {
		
		int input = 0;
		
		do {
			System.out.println("--- 강제로 발생시켜 던질 예외 선택 ---");
			
			System.out.println("1. ArithmeticException");
			System.out.println("2. ArrayIndexOutOfBoundsException");
			System.out.println("3. RuntimeException");
			System.out.println("4. IOException");
			System.out.println("5. Exception");
			System.out.println("0. 종료");
			
			try {
				System.out.println("예외 선택 >> ");
				input = sc.nextInt(); // InputMismatchException
				
				switch(input) {
				case 1 : throw new ArithmeticException(); //  break; throw 하면 unreachable 에러 남
				case 2 : throw new ArrayIndexOutOfBoundsException();
				case 3 : throw new RuntimeException();
				case 4 : throw new IOException();
				case 5 : throw new Exception();
				case 0 : System.out.println("종료 선택");
				
				}
				
			}catch(InputMismatchException e) {
				System.out.println("정수만 입력해 주세유.");
				sc.nextLine();// 입력 버퍼에 남은 문자열 제거
				input = -1; // 잘못 입력 된 경우 종료되는 것을 방지
			}catch(ArithmeticException e) {
				System.out.println("ArithmeticException() 처리 완료");
			}catch(RuntimeException e) {
				System.out.println("ArrayIndexOutOfBoundsException");
				System.out.println("또는");
				System.out.println("RuntimeException 처리 완료");
			}catch(Exception e) {
				System.out.println("예외 최상위 부모 Exception으로");
				System.out.println("나머지 모든 예외 잡아서 처리");
			}
			
		}while(input != 0);
		
		System.out.println("--- 프로그램 정상 종료 ---");
	}
	
	/* finally{} 
	 * - 뜻 : 마침내, 마지막으로
	 * - try 구문에서 예외 발생 여부 관계 없이 마지막에 무조건 실행되어야 하는 코드를 작성하는 구문
	 * 
	 * - 중간에 프로그램이 종료되거나 메서드 리턴되어도 무조건 실행
	 * 
	 * - 외부 프로그램/장치와의 연결을 끊어낼 때 주로 사용!
	 * 
	 */
	public void test6() {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("1. 정상수행 / 2. 예외 강제 발생");
			int input = sc.nextInt();
			
			if(input == 1) {
				System.out.println("예외 없이 정상 수행");
			}else {
				System.out.println("[예외 강제 발생]");
				throw new Exception("강제로 던져진 예외");
			}
			
			System.out.println("<<< 프로그램 종료 >>>");
		}catch(Exception e) {
			// 예외 객체 참조 변수 e
			// - 예외와 관련된 기능 제공
			
			// 에러 출력
			System.err.println(e.getMessage());
			// 예외가 던져질 때 담긴 메시지 얻어오기
			
			return; // 메서드를 종료하고 호출한 곳으로 돌아가라!
		} finally {
			// try에서 예외 발생 여부 관계 없이 무조건 수행
			
			System.out.println("<<< 프로그램 종료 >>>");
			sc.close();
		}
	}
}
