package condition.service;

import java.util.Scanner;

/** 
 * 기능(예제, 연습문제) 제공용 클래스
 */
public class ConditionService {
	
	// 필드(field) = 멤버 변수 = 인스턴스 변수
	// - 해당 클래스(객체) 내에서 언제, 어디서든지 사용 가능한 변수
	Scanner sc = new Scanner(System.in);

	/** 
	 * 1 ~ 10 사이 난수(정수)가 짝수인지 홀수인지 검사
	 * */
	public void method1() {
		
		int randomNumber = (int)(Math.random()*10 +1);
		
//		String result = num%2 == 0 ? "짝수" : "홀수";
		
		// 2로 나눴을 때 나머지가 0인지 아닌지 결과를 저장
		// == 0 이면 짝수(true), 1이면 홀수(false)
		boolean result = randomNumber % 2 == 0;
		
		if(result) {
			System.out.println(randomNumber + " 은 짝수 입니다.");
		}else {
			System.out.println(randomNumber + " 은 홀수 입니다.");
		}
		
//		System.out.println(randomNumber + "은 " + result + "입니다.");
	}
	
	/** 
	 * 나이를 입력 받아 "어린이", "청소년", "성인" 구분
	 * <pre>
	 * 13세 이하 "어린이"
	 * 13세 초과 19세 이하 "청소년"
	 * 19세초과 "성인"
	 * </pre>
	 * */
	public void method2() {
		String result = "";
		
		System.out.println("나이를 입력해 주세유.");
		int age = sc.nextInt();

		if(age <= 13) {
			result = "어린이";
		}else if(age <= 19) {
			result = "청소년";
		}else {
			result = "성인";
		}
		
		System.out.println(result + " 입니다.");
	}
	
	/**
	 * 나이를 입력받아 구분하기
	 * <pre>
	 * 13세 이하 "어린이"
	 * 13세 초과 19세 이하 "청소년"
	 * 	- 14 ~ 16세 : 청소년(중)
	 *  - 17 ~ 19세 : 청소년(고)
	 * 19세초과 "성인"
	 * 0 미만 100 이상 : 잘못 입력하셨습니다
	 * </pre>
	 * */
	public void method3() {
		// 내 코드
//		String result = "";
//
//		System.out.println("나이를 입력해 주세유.");
//		int age = sc.nextInt();
//		
//		if(age < 0 || 100 <= age) {
//			result = "잘못 입력하셨습니다.";
//			System.out.println(result);
//			return;
//		}
//		
//		if(age <= 13) {
//			result = "어린이";
//		}else if(age <= 19) {
//			result = age <= 16 ? "청소년(중)" : "청소년(고)";
//		}else {
//			result = "성인";
//		}
//		
//		System.out.println(result);
		
		
		//========================================================= 
		// 강사님 코드
		
		System.out.println("나이를 입력해 주세유.");
		int age = sc.nextInt();
		
		// 1. 가장 넓은 범위 먼저 제거
		// 2. 잘못된 값이 들어올 수도 있으니까 먼저 제거
		if(age < 0 || 100 <= age) {
			System.out.println("잘못 입력하셨습니다.");
			return;
		}
		
		String result = "";

		if(age <= 13) {
			result = "어린이";
		}else if(age <= 19) {
			result = "청소년" + ((age <=16) ? "(중)" : "(고)");
		}else {
			result = "성인";
		}
		
		System.out.println(result);
		
	}
	// =======================================================================
	/* switch - case - default*/
	
	/**
	 * ConditionService에 작성된 메서드를 골라서 실행하는 메서드
	 * */
	public void displayMenu() {
		
		System.out.println("1. method1()");
		System.out.println("2. method2()");
		System.out.println("3. method3()");
		System.out.println("메뉴 번호 입력 >> ");
		int input = sc.nextInt();
		
		// (중요) 같은 클래스 내 필드, 메서드는 이름만 부르면 호출 가능!
		switch(input){
		case 1 : method1(); break;
		case 2 : method2(); break;
		case 3 : method3(); break;
		default : System.out.println("없는 메뉴 번호 입니다.");
		
		}
		
	}
	
	/** [성적 판별기]
	 * <pre>
	 * 중간고사, 기말고사, 과제 점수를 입력 받아 성적 부여
	 * 
	 * - 중간고사 (40%), 기말고사(50%), 과제(10%)
	 * 
	 * - 입력 시 각각 100점 만점으로 입력 받음
	 * 
	 * - 합산된 점수에 따라 성적 부여
	 * 
	 * 95점 이상 : A+
	 * 90점 이상 : A
	 * 85점 이상 : B+
	 * 80점 이상 : B
	 * 75점 이상 : C+
	 * 70점 이상 : C
	 * 65점 이상 : D+
	 * 60점 이상 : D
	 * 나머지    : F
	 * 
	 * 
	 * [실행 화면]
	 * 이름 : 홍길동
	 * 중간고사 점수(40%) : 100
	 * 기말고사 점수(50%) : 80
	 * 과제 점수(10%) : 50
	 * 
	 * 홍길동의 최종 점수 : 85.0점
	 * 성적 : B+
	 *</pre>
	 */
	public void gradeMethode() {
		String name;
		double finalpoint;
		String grade;
		boolean pass;
		double joongPoint = 0;
		double kimalPoint = 0;
		double kwajaePoint = 0;
		// 자바 지역변수는 초기화가 안됐을 시 빈칸으로 사용 불가. (JS에서는 undefined 로 사용가능)
		
		do	{
			pass = false;
			System.out.println("이름을 입력해 주세유.");
			name = sc.next();
			
			System.out.println("중간고사 점수를 입력해 주세유.");
			joongPoint = sc.nextDouble();
			
			if(joongPoint < 0 || 100 < joongPoint) {
				System.out.println("잘못 입력하셨습니다. 다시 입력하려면 y 종료할거면 n. ");
				
				if(sc.next().toUpperCase().equals("Y")) {
					pass = true;
					continue;
				}else {
					return;
				}
			}
			
			System.out.println("기말고사 점수를 입력해 주세유.");
			kimalPoint = sc.nextDouble();
			
			if(kimalPoint < 0 || 100 < kimalPoint) {
				System.out.println("잘못 입력하셨습니다. 다시 입력하려면 y 종료할거면 n. ");
				
				if(sc.next().toUpperCase().equals("Y")) {
					pass = true;
					continue;
				}else {
					return;
				}
				
			}
			
			System.out.println("과제 점수를 입력해 주세유.");
			kwajaePoint = sc.nextDouble();
			
			if(kwajaePoint < 0 || 100 < kwajaePoint) {
				System.out.println("잘못 입력하셨습니다. 다시 입력하려면 y 종료할거면 n. ");
				
				if(sc.next().toUpperCase().equals("Y")) {
					pass = true;
					continue;
				}else {
					return;
				}
			}
			
		}while (pass);
		
		finalpoint = joongPoint*0.4 + kimalPoint*0.5 + kwajaePoint*0.1;
		int num1 = (int)finalpoint/10; // => finalpoint를 먼저 int로 바꾼 후 10으로 나눔 => 10의 자리 숫자만 남김
		int num2 = (int)finalpoint%10;
		
//		// switch 문으로
//		switch(num1) { // switch 문 조건식 내에는 정수/문자열 작성 가능
//			case 10, 9  : grade = "A" + (num2 >= 5 ? "+" : ""); break; // java에서는 case에 여러 경우를 ',' 기호를 이용해서 작성 가능(JS 에서는 안됨)
//			case 8  	: grade = "B" + (num2 >= 5 ? "+" : ""); break; 
//			case 7  	: grade = "C" + (num2 >= 5 ? "+" : ""); break; 
//			case 6  	: grade = "D" + (num2 >= 5 ? "+" : ""); break; 
//			default 	: grade = "F"; break;
//		}
		
		// switch 문으로 강사님 코드
		switch(num1) { // switch 문 조건식 내에는 정수/문자열 작성 가능
			case 10, 9  : grade = "A" ; break; // java에서는 case에 여러 경우를 ',' 기호를 이용해서 작성 가능(JS 에서는 안됨)
			case 8  	: grade = "B" ; break; 
			case 7  	: grade = "C" ; break; 
			case 6  	: grade = "D" ; break; 
			default 	: grade = "F"; break;
		}
		
		if(finalpoint == 100 ||(num1 >= 6 && num2 >= 5)) {
			grade = grade + "+";
		}
		
		// if 문으로
		
//		if(finalpoint < 0 || 100 < finalpoint) {
//			System.out.println("잘못 입력하셨습니다.");
//			return;
//		}
//		
//		if(finalpoint < 60) {
//			grade = "F";
//		}else if(finalpoint < 70) {
//			grade = "D" + ((finalpoint < 65) ? "" : "+"); 
//		}
//		else if(finalpoint < 80) {
//			grade = "C" + ((finalpoint < 75) ? "" : "+"); 
//		}
//		else if(finalpoint < 90) {
//			grade = "B" + ((finalpoint < 85) ? "" : "+"); 
//		}else {
//			grade = "A" + ((finalpoint < 95) ? "" : "+"); 
//		}
		
		System.out.printf("%s의 최종 점수 : %.1f점\n",name,finalpoint);
		System.out.printf("성적 : %s",grade);
		
	}
}
