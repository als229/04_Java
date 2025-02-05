package encapsulation;

// 클래스 : 객체의 속성과 기능을 정의한 문서(설계도)
public class Person{
	
	/* private 사용으로 직접 접근 제한*/
//	private String name; // 이름
//	private double height; // 키
	private String personName; // 이름
	private double personHeight; // 키
	
	/* private 으로 접근이 제한된 필드를 간접 접근할 수 있는 public 메서드 */
	public void setName(String name) {
		// 현재 객체의 name에 매개변수 name 대입
		this.personName = name;
	}
	
	public void setHeight(double height) {
		
		// 검증 로직 추가(키는 음수일 수 없다.)
		if(height >= 0) {
			this.personHeight = height;
		}else { // 음수인 경우
			this.personHeight = height*-1;
		}
	}
	
	/* Person의 객체 정보를 하나의 문자열로 반환하는 메서드 */
	
	public String getInfo() {
		return "이름 : " + personName + " / 키 : " +personHeight ;
	}
}

