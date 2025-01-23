package loop.practice;

import java.lang.reflect.Array;
import java.util.Scanner;

public class LoopPractice {

	Scanner sc = new Scanner(System.in);

	public void practice1() {

		System.out.print("1이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();

		if (num <= 0) {
			System.out.println("1이상의 숫자를 입력하세요.");
			return;
		}

		for (int i = 1; i <= num; i++) {
			System.out.print(i + " ");
		}

	}

	public void practice2() {

		System.out.print("1이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();

		if (num <= 0) {
			System.out.println("1이상의 숫자를 입력하세요.");
			return;
		}

		for (int i = num; i >= 1; i--) {
			System.out.print(i + " ");
		}
	}

	public void practice3() {
		System.out.print("정수를 하나 입력하세요");
		int num = sc.nextInt();
		int sum = 0;

		for (int i = 1; i <= num; i++) {

			System.out.print(i);
			if (i != num) {
				System.out.print(" + ");
			}
			sum += i;
		}
		System.out.print(" = " + sum);

	}

	public void practice4() {
		System.out.print("첫 번째 숫자 :");
		int start = sc.nextInt();

		System.out.print("두 번째 숫자 : ");
		int end = sc.nextInt();

		if (start <= 0 || end <= 0) {
			System.out.println("1 이상의 숫자를 입력해주세요");
			return;
		}

		int tmp = 0;

		if (end < start) {
			tmp = end;
			end = start;
			start = tmp;
		}

		for (int i = start; start <= end; start++) {
			System.out.println(start + " ");
		}
	}

	public void practice5() {
		System.out.print("숫자 : ");
		int dan = sc.nextInt();

		System.out.println("===== " + dan + "단 =====");
		for (int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %d\n", dan, i, dan * i);
		}

	}

	public void practice6() {
		System.out.print("숫자 : ");
		int start = sc.nextInt();

		if (start < 2 || 9 < start) {
			System.out.println("2~9 사이 숫자만 입력해주세요.");
			return;
		}

		for (int i = start; i <= 9; i++) {
			System.out.println("===== " + i + "단 =====");
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%2d X %2d = %2d \n", i, j, i * j);
			}
			System.out.println();
		}

	}

	public void practice7() {
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();

		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

	public void practice8() {
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();

//		 for(int i = num; i > 0; i--) {
//			 for(int j = 0; j < i; j++) {
//				 System.out.print("*");
//			 }
//			 System.out.println();
//		 }
		for (int i = 1; i <= num; i++) {
			for (int j = num; j >= i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void practice9() {
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();

//		 for(int i = num; i > 0; i--) {
//			 for(int j = 1; j <= num; j++) {
//				 if(i <= j) {
//					 System.out.print("*");
//				 }else {
//					 System.out.print(" ");
//				 }
//			 }
//			 System.out.println();
//		 }

		for (int i = 1; i <= num; i++) {
			for (int j = num; j > 0; j--) {
				if (i < j) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}

	}

	public void practice10() {
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();

		for (int i = 1; i <= num * 2 - 1; i++) {
			if (i <= num) {
				for (int j = 1; j <= i; j++) {
					System.out.print("*");
				}
			} else {
				for (int j = num * 2 - 1; j >= i; j--) {
					System.out.print("*");
				}
			}
			System.out.println();
		}

	}

	public void practice11() {
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
//		    *       3(4-1) 1(4*2-7) 3
//		   ***      2(4-2) 3(4*2-5) 2
//		  *****     1(4-3) 5(4*2-3) 1
//		 *******    0(4-4) 7(4*2-1) 0

		 for(int i = 1; i <= num; i++) {
			 for(int j = num; j > i ; j--) {
				 System.out.print(" ");
			 }
			 for(int j = 1; j <= 2*i-1 ; j++ ) {
				 System.out.print("*");
			 }
			 System.out.println();
		 }

		// 강사님 방법1
		for(int row = 1; row <=num; row++) {

			for(int blank = 1; blank <= num-row; blank++) {
				System.out.print(" ");
			}

			for(int col =1; col <= 2*row-1; col++) {
				System.out.print("*"); 
			}

			System.out.println();
		}
		// 강사님 방법2
		for (int row = 1; row <= num; row++) {
			for (int col = 1; col <= num*2-1; col++) {
				if (num - row >= col || num + row <= col) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}

	public void practice12() {
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();

		for (int i = 1; i <= num; i++) {
			System.out.print("*");

			if (i == 1 || i == num) {
				for (int j = 2; j < num; j++) {
					System.out.print("*");
				}
			} else {
				for (int j = 2; j < num; j++) {
					System.out.print(" ");
				}
			}
			System.out.print("*");
			System.out.println();
		}
		for (int i = 1; i <= num; i++) {
			for(int col = 1; col <= num; col++) {
				if(i == 1 || i == num || col ==1 || col == num) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	public void practice13() {
		System.out.print("자연수 하나를 입력하세요 : ");
		int num = sc.nextInt();
		int cnt = 0;

		for (int i = 1; i <= num; i++) {
			if (i % 2 == 0 || i % 3 == 0) {
				System.out.print(i + " ");
			}
			if (i % 2 == 0 && i % 3 == 0) {
				cnt++;
			}
		}
		System.out.println();
		System.out.println("count : " + cnt);
	}

	public void pracitce14() {
		System.out.print("숫자 : ");
		int num = sc.nextInt();
		int cnt = 0;

		if (num < 2) {
			System.out.println("잘못 입력 하셨습니다");
			return;
		}

		for (int i = 2; i <= num; i++) {
			if (num % i == 0) {
				cnt++;
			}
		}

		if (cnt == 1) {
			System.out.println("소수입니다.");
		} else {
			System.out.println("소수가 아닙니다.");
		}

	}

	public void pracitce15() {
		int cnt = 0;
		boolean pass;

		do {
			pass = false;
			System.out.print("숫자 : ");
			int num = sc.nextInt();

			if (num < 2) {
				System.out.println("잘못 입력 하셨습니다");
				pass = true;
				continue;
			}

			for (int i = 2; i <= num; i++) {
				if (num % i == 0) {
					cnt++;
				}
			}
		} while (pass);

		if (cnt == 1) {
			System.out.println("소수입니다.");
		} else {
			System.out.println("소수가 아닙니다.");
		}
	}

	public void pracitce16() {
		System.out.print("숫자 : ");
		int num = sc.nextInt();
		int cnt = 0;
		int realCnt = 0;
		String numList = "";

//		if (num < 2) {
//			System.out.println("잘못 입력 하셨습니다");
//			return;
//		}
//
//		for (int i = 2; i <= num; i++) {
//			cnt = 0;
//			for (int j = 2; j <= i; j++) {
//				if (i % j == 0) {
//					cnt++;
//				}
//
//				if (i == j) {
//					if (cnt == 1) {
//						numList += i + " ";
//						realCnt++;
//					}
//				}
//			}
//		}
		
		// 강사님 코드
		
		for(int i =2; i <= num; i ++) {
			boolean flag = true; // 깃발(신호 용도) 
			// true인 경우 : 소수 O
			// false인 경우 : 소수 X
			
			// 1과 자기 자신(num)을 빼ㅣㄴ 정수를 한개씩 접근
			for(int x=2; x<i; x++) {
				if(i % x== 0) {
					flag = false;
					break;
				}
			}
			if(flag) {
				System.out.print(i + " "); // 1과 자기자신 빼고 나누어 떨어지는 수 존재
				cnt++;
			}
		}

		System.out.println("cnt : " + cnt);
//		System.out.println(numList);
//		System.out.printf("2부터 %d까지 소수의 개수는 %d개입니다.", num, realCnt);

	}

}
