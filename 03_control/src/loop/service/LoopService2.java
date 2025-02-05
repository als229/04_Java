package loop.service;

import java.util.Scanner;

public class LoopService2 {

	Scanner sc = new Scanner(System.in);
	
	public void displayMenu() {
		System.out.println("[LoopService22222222222]");
		System.out.println("1. method1()");
		System.out.println("2. method2()");
		System.out.println("3. method3()");
		System.out.println("4. method4()");
		System.out.println("5. method5()");
		System.out.println("6. method6()");
		
		System.out.println("번호 입력 >>");
		int input = sc.nextInt();
		
		switch(input) {
			case 1 : method1(); break;
			case 2 : method2(); break;
			case 3 : method3(); break;
			case 4 : method4(); break;
			case 5 : method5(); break;
			case 6 : method6(); break;
			default : System.out.println("잘못 입력");
		}
	}

	/**
	 * 다음 모양 출력하기
	 * <pre>
	 * (0,0) (0,1) (0,2)
	 * (1,0) (1,1) (1,2)
	 * (2,0) (2,1) (2,2)
	 * (3,0) (3,1) (3,2)
	 * </pre>
	 */
	public void method1() {
		// 행 0 ~ 3
		// 열 0 ~ 2
		for(int row = 0; row <= 3; row++) {
			for(int col = 0; col <=3; col++) {
				System.out.printf("(%d,%d) ", row, col);
			}
			System.out.println();
		}
	}
	
	/*
	 * 분기문
	 * - break; : 현재 반복 종료
	 * 
	 * - continue : 다음 반복문으로 넘어가기
	 * 
	 */
	
	/**
	 * 1~20까지 출력
	 * 단, 입력받은 수에서 반복 멈추기
	 */
	public void method2() {
		System.out.println("stop number : ");
		int num = sc.nextInt();
		
		for(int i = 1; i <= 20; i++) {
			System.out.print(i + " ");
			if(i == num) {
				break;
			}
		}
	}
	
	/**
	 * 1 ~ 20 까지 출력
	 * 단, 입력받은 수의 배수는 출력 X
	 */
	public void method3() {
		System.out.println("continue number : ");
		int num = sc.nextInt();
		
		for(int i = 1; i <= 20; i++) {
			if(i % num == 0) {
				continue;
			}
			System.out.print(i + " ");
		}
	}
	
	/**
	 * 0이 입력 될 때 까지 입력된 모든 숫자 합계 구하기
	 */
	public void method4() {
		int sum = 0;
		int num = -1;
		
		while(num != 0) {
			System.out.print("정수 입력 : ");
			num = sc.nextInt();
			sum += num;
		}
		
		System.out.println("합계 : " + sum);
	}
	
	/*
	 * do ~ while 문
	 * 
	 * - while 문의 조건식이 시작이 아닌 마지막 부분으로 이동한 반복문
	 * 
	 * - 최소 1회 이상의 반복 보장
	 * [작성법]
	 * do{
	 * 	반복문 내용
	 * } while(조건식);
	 * 
	 */
	
	public void method5() {
		int sum = 0;
		int num = 0;
		
		do {
			System.out.print("정수 입력 : ");
			num = sc.nextInt();
			sum += num;
		}while(num != 0);
		System.out.println("합계 : " + sum);
	}
	
	public void method6() {
		
		
	}
	
	
	
	
	
	
	
	
}
