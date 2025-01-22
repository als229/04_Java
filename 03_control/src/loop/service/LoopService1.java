package loop.service;

import java.util.Scanner;

/**
 * 반복문 기능 제공 클래스1
*/
public class LoopService1 {

	// 필드
	Scanner sc = new Scanner(System.in);
	
	public void displayMenu() {
		System.out.println("1. method1()");
		System.out.println("2. method2()");
		System.out.println("3. method3()");
		System.out.println("4. method4()");
		System.out.println("5. method5()");
		System.out.println("6. method6()");
		System.out.println("7. method7()");
		System.out.println("8. method8()");
	
		System.out.println("실행할 메서드 번호 입력 >> ");
		
		int input = sc.nextInt();
		
		System.out.println("\n============================================\n");
		
		switch(input) {
		case 1: method1(); break;
		case 2: method2(); break;
		case 3: method3(); break;
		case 4: method4(); break;
		case 5: method5(); break;
		case 6: method6(); break;
		case 7: method7(); break;
		case 8: method8(); break;
		
		default : System.out.println("없는 번호 입력함");
		}
	}

	/**
	 * for문을 이용해서 1~10까지 출력하기
	 */
	public void method1() {
		
//		for(초기식; 조건식; 증감식) {
//			System.out.println(i);
//		}
		// 초기식 : for문에서 사용할 지역 변수 선언
		// => 대부분 for문 제어를 위한 변수를 선언
		
		// 조건식 : 결과가 true/false가 나오는 식
		
		// 증감식 : 초기식 변수를 증가/감소 시켜 조건식의 결과가 변할 수 있게 제어하는 식
		
		for(int i = 1; i <=10; i++) {
			System.out.println(i);
		}
		
	}
	
	/**
	 * 987654321 출력하기
	 */
	public void method2() {
		for(int i = 9; i >= 1; i--) {
			System.out.print(i);
		}
		
		System.out.println("\n======================================");
		
		// for문 초기식, 조건식, 증감식 다르게
		for(int i =0; i <9; i++) {
			System.out.print(9 - i);
		}
	}
	
	/**
	 * 두 정수를 입력 받아
	 * 두 정수 사이 모든 정수를 출력
	 * (무조건 첫 번째 입력이 작은 수)
	 * <pre>
	 * 첫 번째 정수 입력 : 5
	 * 두 번째 정수 입력 : 12
	 * 5 6 7 8 9 10 11 12
	 * </pre>
	 */
	public void method3() {
		System.out.print("첫 번째 정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 정수 입력 : ");
		int num2 = sc.nextInt();
		
		for(int i = num1; i <= num2; i++) {
			System.out.print(i + " ");
		}
	}
	
	/**
	 * 입력된 두 정수 사이의 모든 정수 출력
	 * <ul>
	 * 	<li>입력 1이 입력 2보다 작거나 같은 경우 : 1234~ 증가하며 출력</li>
	 * 	<li>입력 1이 입력 2보다 큰 경우 : 9876~ 감소하며 출력</li>
	 * </ul>
	 */
	public void method4() {
		System.out.print("첫 번째 정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 정수 입력 : ");
		int num2 = sc.nextInt();
		
		if(num1 <= num2) {
			for(int i = num1; i <= num2; i++) {
				System.out.print(i + " ");
			}
		}else {
			for(int i = num1; i >= num2; i--) {
				System.out.print(i + " ");
			}
		}
	}
	
	/**
	 * 두 정수를 입력 받아
	 * 작은 수 부터 큰 수 까지 1씩 증가하며 출력
	 * <pre>
	 * [실행화면]
	 * 입력 1 : 3
	 * 입력 2 : 6
	 * 3 4 5 6
	 * 
	 * =========================================
	 * 입력 1 : 7
	 * 입력 2 : 2
	 * 2 3 4 5 6 7 
	 *
	 * </pre>
	 */
	public void method5() {
		System.out.print("입력 1 : ");
		int num1 = sc.nextInt();
		System.out.print("입력 2 : ");
		int num2 = sc.nextInt();
		int temp = 0;
		int temp2 = 0;
		
		// 내가 한 코드
//		if(num1 <= num2) {
//			temp = num1;
//			temp2 = num2;
//		}else {
//			temp = num2;
//			temp2 = num1;
//		}
//		
//		for(int i = temp; i <= temp2; i++) {
//			System.out.print(i + " ");
//		}
//		
		// 강사님 방법 1
//		if(num1 <= num2) {
//			for(int i = num1; i < num2; i++) {
//				System.out.println(i + " ");
//			}
//		}else {
//			for(int i = num2; i <= num1; i++) {
//				System.out.println(i + " ");
//			}
//		}
		
		// 강사님 방법 2
		// for문 초기식, 조건식에 사용될 변수를 미리 정해놓고 대입될 값을 바꾸는 방법
//		int start = num1;
//		int end = num2;
//		
//		if(num2 < num1) {
//			start = num2;
//			end = num1;
//		}
//		
//		for(int i = temp; i <= temp2; i++) {
//			System.out.print(i + " ");
//		}
//		
		// 강사님 방법 3) num1, num2 바꾸기(swap)
		
		if(num2 < num1) {
			// 임시 변수에 num2 저장
			temp = num2;
			// num2를 num1에 넣기
			num2 = num1;
			// temp에 있던 num2 값을 num1에 넣기 
			num1 = temp;
		}
		
		for(int i=num1; i<=num2; i++) {
			System.out.print(i + " ");
		}
	}
	
	/**
	 * 1부터 100 사이의 정수 중
	 * 입력 받은 정수의 배수가 몇 개,배수의 합 구하기
	 */
	public void method6() {
		System.out.println("정수 입력 : ");
		int num = sc.nextInt();
		int sum = 0; // 합계 저장용 변수
		int cnt = 0; // 갯수 저장용 변수
		
		for(int i = 1; i <= 100; i++) {
			if(i % num == 0) {
				sum += i;
				cnt++;
			}
		}
		
		System.out.println("배수의 합 : " + sum + " 배수의 갯수 : " + cnt);
		
	}
	
	/**
	 * 입력 받은 단 출력하기(구구단)
	 */
	public void method7() {
		System.out.println("정수 입력 :");
		int num = sc.nextInt();
		
		for(int i = 1; i <= 9; i++) {
			System.out.printf("%2d X%2d = %2d\n", num, i, num*i);
		}
		
	}
	
	/**
	 * 입력 받은 두 정수 사이의 구구단을 모두 출력
	 * <pre>
	 * 시작 단 : 3
	 * 종료 단 : 5
	 * 
	 *  [3단]
	 *  3 x 1 = 3
	 *  .....
	 *  [4단]
	 *  4 x 1 = 4
	 *   ......
	 *  [5단]
	 *  5 x 1 = 5
	 *  .....
	 * </pre>
	 */
	public void method8() {
		System.out.println("시작 단 :");
		int start = sc.nextInt();
		System.out.println("종료 단 :");
		int end = sc.nextInt();

		for(int i = start; i <= end; i++) {
			System.out.printf("\n   [%d]단\n",i);
			for(int j = 1; j <= 9; j++) {
				System.out.printf("%2d X%2d = %2d", i, j, i*j);
			}
			System.out.println();
		}
	}
	
}
