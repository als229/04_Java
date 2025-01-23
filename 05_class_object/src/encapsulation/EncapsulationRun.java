package encapsulation;

public class EncapsulationRun {
	public static void main(String[] args) {
		
		// Person 객체 생성
		Person person1 = new Person();
		
		// private로 바꿔서 직접 접근 안됨.
//		person1.name = "홍길동";
//		person1.height = 180.5; 
//		// 캡슐화 안했을 때 문제점 (1)
//		// => 잘못된 데이터가 대입될 수 있다.
//		
//		Person person2 = new Person();
//		person2.name = "김미영";
//		person2.height = -160.7;
//		System.out.println("person1의 이름 : " + person1.name + " person1의 키 : " + person1.height);
//		System.out.println("person2의 이름 : " + person2.name + " person2의 키 : " + person2.height);

//		위 방식에서
//		getter setter 방식으로 변경
		person1.setName("홍길동"); 
		person1.setHeight(180.5); 
		
		Person person2 = new Person();
		person2.setName("김미영"); 
		person2.setHeight(-160.5); 
		
		System.out.println(person1.getInfo());
		System.out.println(person2.getInfo());
		
	}
}
