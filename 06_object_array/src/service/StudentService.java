package service;

import java.util.Random;

import dto.StudentDTO;

/* Service
 * - 프로그램의 실질적인 기능(비지니스 로직)을 제공하는 클래스
 */

public class StudentService {
	
	// StudentDTO 객체 배열 선언
	private StudentDTO[] students = new StudentDTO[5];

	// new StudentDTO[5] 
	// - StudentDTO 참조형 변수 5칸짜리 배열 생성
	// - 인덱스 : 0 ~ 4
	// - 각 인덱스 요소의 초기값 : null(참조 객체 없음)

	/*
	 * 생성자
	 * - 객체가 생성될 때 수행할 명령어를 작성한 특수한 메서드
	 * - 객체 생성 시 1회만 수행
	 * - 모든 클래스는 1개 이상의 생성자가 있어야함
	 * - 생성자가 없을 시 컴파일러가 자동으로 기본 생성자 추가해줌.
	 */
	/* 기본 생성자 */
	public StudentService() {
		System.out.println("[초기 학생 정보가 추가됨...]\n");
		
		students[0] = new StudentDTO("20250001", "짱구", '남');
		students[1] = new StudentDTO("20250002", "유리", '여');
		students[2] = new StudentDTO("20250003", "훈이", '남');
//		students[3] = new StudentDTO("20250004", "맹구", '남');
//		students[4] = new StudentDTO("20250005", "철수", '남');
		
		// 자바 제공 난수 발생 객체
		Random random = new Random();
		
		for(StudentDTO std: students) {
			
			if(std == null) {
				continue;
			}
			
			// random.nextInt(101) : 0 이상 101 미만의 정수형 난수 생성 
			std.setHtml(random.nextInt(101));
			std.setCss(random.nextInt(101));
			std.setJs(random.nextInt(101));
			std.setJava(random.nextInt(101));
		}
	}
	
	/**
	 * students 객체 배열을 반환하는 메서드
	 * (students에 저장된 주소가 복사되서 반환됨 = 얕은 복사)
	 * @return students
	 */
	public StudentDTO[] getStudents() {
		return students;
	}
	
	/**
	 * <pre> 
	 * student 객체 배열 요소 중 
	 * 비어있는(null) 인덱스를 찾아 전달 받은 StudentDTO객체를 추가 후 true 반환
	 * 단, 비어있는 인덱스가 없으면 false 반환
	 * </pre>
	 * 
	 * @param student : 추가하려는 학생 객체 참조 주소
	 * @return 추가 성공 : true/ 추가 실패 : false
	 * 
	 */
	public boolean addStudent(StudentDTO student) {
		
		// students 객체 배열에서 null인 인덱스 찾기
		for(int i = 0; i < students.length; i++) {
			if(students[i] == null) { 
				// i 번째 인덱스 요소가 참조하는게 없을 경우
				// 전달 받은 StudentDTO 객체 추가 후 true 반환
				students[i] = student;
				
				return true;
			}
		}

		// students에 null이 존재하지 않을 경우 == 꽉참
		return false;
	}

	/** index번째 학생 반환 service 메서드
	 * @param index
	 * @return index 번째 학생 객체 참조 주소 || null
	 */
	public StudentDTO selectIndex(int index) {
		// 배열의 크기 보다 큰 숫자 입력시 에러남
		// java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5\
		
		// index가 배열 범위를 벗어난 경우
		if(index < 0 || index >= students.length) {
			return null;
		}
		
		return students[index];
	}

	/**targetName과 이름이 일치하는 학생 객체 반환 service 메서드
	 * 
	 * @param targetName
	 * @return 이름이 일치하는 학생 객체 주소 || null
	 */
	public StudentDTO selectName(String targetName) {
		
		for(StudentDTO std : students) {

			// studets 순차 접근 중 null 을 만났을 때
			// == 학생이 없을 경우
			// == 뒤에도 학생이 없을 것이다!!
			if(std == null) {
				return null;
			}
			
			// 학생이 있을 경우 => 이름 비교
			
			// [key point] : 변수에 저장된 값을 잘 기억하자!!
			// 비교 연산자(A == B)
			// - A와 B에 저장된 값이 같으면 ture, 다르면 false 반환
//			if(std.getName() == targetName) {
//				// std.getName()과 targetName에 저장된 값이 같을 경우
//				// - 참조형은 주소를 저장하고 있다!
				// - 생성된 객체는 기본적으로 서로 다른 곳에 생성된다.
				// => 저장된 이름과 입력된 이름이 같아도 같지 않다. false 가 발생할 수 있다.
				// (변수에 저장된 값만 비교)
//			}
			
			// boolean A.equlas(B)
			// - A가 참조하는 객체의 필드와 B가 참조하는 객체의 필드가 같은지 비교하여
			// 같으면 true, 다르면 false 반환
			// (객체가 가지고 있는 실제 값을 비교)
			if(std.getName().equals(targetName)) {
				return std;
			}
		}
		
		// if 문이 하나도 실행되지 않을 경우
		return null;
	}
	
	/** 전달 받은 index가 students 범위 내 인덱스가 맞는지
	 *  + 맞다면 index 번째에 참조하는 학생이 있는지 확인하는 메서드
	 * @param index
	 * @return 1 : 범위초과 / 2 : null / 3 : 참조하는 학생 있음
	 */
	public int checkIndex(int index) {
		
		if(index < 0 || index >= students.length) {
			return 1;
		}
		
		if(students[index] == null) {
			return 2;
		}
		
		return 3;
	}

	/** index 번째 학생의 점수 수정 service 메서드
	 * 
	 * @param index
	 * @param html
	 * @param css
	 * @param js
	 * @param java
	 */
	public void updateScore(int index, int html, int css, int js, int java) {
		students[index].setHtml(html);
		students[index].setCss(css);
		students[index].setJs(js);
		students[index].setJava(java);
		
		// 반환형 void 메서드도 return; 작성이 원래는 필수!
		// => 작성이 안되면 컴파일러가 자동으로 추가해줌
//		return;
	}
	
	/** students 배열에서 점수 평균 최고, 최저 학생 찾기
	 * 
	 * @return result(문자열)
	 */
	public String selectMaxMin() {
		String result = "";
		
		// 점수 평균 최고, 최저 학생의 이름/평균 저장할 변수 선언
		String maxName = null;
		double maxAvg = 0.0;
		
		String minName = null;
		double minAvg = 100.0;
		
		for(StudentDTO std :students) {
			if(std == null) { // 더 이상 참조할 학생이 없을 경우
				break;
			} 
			
			// 현재 접근 중인 학생(std)의 평균 구하기
			int sum = std.getHtml() + std.getCss() + std.getJs() + std.getJava();
			double avg = sum / 4.0;
			
			// 저장된 최고, 최저점과 avg 비교
			if(avg > maxAvg) {
				maxAvg = avg;
				maxName = std.getName();
			}
			
			if(avg < minAvg) {
				minAvg = avg;
				minName = std.getName();
			}
		}

		result = String.format("최고점 : %s(%.1f)\n최저점 : %s(%.1f)", maxName, maxAvg, minName, minAvg);
		return result;
	}

	/** index번째 학생 삭제 후 요소 한 칸씩 당기기
	 * @param index : 삭제할 index 번호
	 * @return 삭제된 학생 이름
	 */
	public String deleteIndex(int index) {

		// 삭제 될 학생의 이름(삭제하기 전에 이름만 백업)
		String studentName = students[index].getName();
		students[index] = null;
		
		// 내 코드
//		for(int i = index; i < students.length; i++ ) {
//			if(i == students.length-1) {
//				students[i] = null;
//			}else {
//				students[i] = students[i+1];
//			}
//		}
		
		// 강사님 코드
		// 삭제된 index 뒤에 요소를 하나씩 당겨오기
		for(int i = index; i < students.length-1; i++ ) {
				students[i] = students[i+1];
		}
		
		// 마지막 index에 null 대입(제일 끝을 null로 만듬)
		students[students.length-1] = null;
		
		return studentName;
	}
	

}
