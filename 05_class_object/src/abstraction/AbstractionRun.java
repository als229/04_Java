package abstraction;

public class AbstractionRun {

	public static void main(String[] args) {
		
		// 클래스에 정의된 내용대로 Heap 메모리 영역에 할당(생성)
		Student std = new Student();
		
		// 값 셋팅
		std.setName("철수");
		std.setStudentNumber("20250001");
		std.setHtml(100);
		std.setCss(70);
		std.setJs(80);
		std.setJava(30);
		
		// 합계 출력하기
		System.out.println(std.getName() + "의 점수 합계 : " + std.getSum());
		
		String result = std.toString();
		System.out.println(result);
		
		System.out.println("==========================================================");
		
		Student std2 = new Student();
		
		std2.setStudentNumber("20250002");
		std2.setName("짱구");
		std2.setHtml(50);
        std2.setCss(40);
		std2.setJs(70);
		std2.setJava(80);
		
		String result2 = std2.toString();
		System.out.println(result2);
		
		System.out.println("==========================================================");
		
		Student std3 = new Student();
		
		std3.setStudentNumber("20250003");
		std3.setName("훈이");
		std3.setHtml(40);
        std3.setCss(50);
		std3.setJs(80);
		std3.setJava(30);
		
		String result3 = std3.toString();
		System.out.println(result3);
		
		
	}
}
