package list.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import list.dto.BookDTO;
import list.service.BookService;

/**
 * 도서 관리 프로그램 입/출력 담당 클래스(UI)
 */
public class BookView {

	private Scanner sc = new Scanner(System.in);
	private BookService service = new BookService();

	/**
	 * 프로그램 메인 메뉴
	 */
	public void displayMenu() {
		int input = 0; // 메뉴 번호를 저장할 변수
		
		do {
			System.out.println("\n***** 도서 관리 프로그램 ******\n");
			System.out.println("1. 전체 조회");
			System.out.println("2. index 번호로 조회");
			System.out.println("3. 책 추가하기");
			System.out.println("4. 책 가격 수정하기");
			System.out.println("5. 책 제거하기(index)");
			// 추가메뉴
			System.out.println("6. 제목이 일치하는 책 한 권 조회하기");
			System.out.println("7. 제목이 일치하는 책 제거하기");
			System.out.println("8. 출판사가 일치하는 책 모두 조회하기");
			System.out.println("9. 저자가 일치하는 책 모두 조회하기");
			System.out.println("10. 검색어가 제목, 저자에 포함된 모든 책 조회하기");
			System.out.println("11. bookList 제목 오름차순으로 정렬시키기");
			
			System.out.println("0. 프로그램 종료");
			System.out.println(); // 줄 바꿈
			
			System.out.println("메뉴 번호 입력 >> ");
			
			input = sc.nextInt();
			sc.nextLine(); // 입력 버퍼에 남아 있는 문자열 제거(오류 방지)

			System.out.println("===================================================");
			
			switch(input) {
			case 1 : selectAll();break;
			case 2 : selectIndex();break;
			case 3 : addBook();break;
//			case 4 : modifyBookPrice();break; // 방법 1
			case 4 : modifyBookPrice2();break; // 방법 2
			case 5 : removeBook();break;
			case 6 : selectTitle();break;
			case 7 : removeBookTitle();break;
			case 8 : selectPublisherAll();break;
			case 9 : selectAuthorAll();break;
			case 10 : searchBook();break;
			case 11 : bookListSorting();break;
			case 0 : System.out.println("*** 프로그램이 종료됩니다 ***");break;
			
			default : System.out.println("@@@ 메뉴 번호 잘못 입력 @@@");
			}
			
		} while(input != 0);
	}

	/**
	 * 전체 조회
	 * - BookService의 필드 bookList를 얻어와 for문을 이용하여 모든 요소 정보 출력
	 *   단, bookList에 저장된 정보가 없으면 "저장된 책이 존재하지 않습니다." 출력
	 */
	private void selectAll() {
		
		System.out.println("\n ### 전체 조회 ### \n");
		
		// 얕은 복사로 왔기 때문에 여기서 수정하면 list가 수정이 됨.
		List<BookDTO> list = service.getBookService();
		
//		if(list.size() == 0) { // 이렇게 해도 되고 메서드도 있음
		// boolean isEmpty() : 저장된 객체가 없으면 true 반환 
		if(list.isEmpty()) {
			System.out.println("저장된 책이 존재하지 않습니다.");
			return;
		}
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(i + ")" + list.get(i));
		}
	}
	
	/**
	 * 조회하려는 책의 index 번호를 입력 받아 책 정보 출력
	 * 
	 * - BookService로부터 index 번째 BookDTO 반환 받기
	 * 
	 * - 단, index 번호가 bookList의 범위를 초과하면 "해당 인덱스에 책이 존재하지 않습니다" 출력
	 * @return
	 */
	private void selectIndex() {
		
		System.out.println("\n ### 인덱스 번호로 조회 ### \n");

		System.out.print("검색할 인덱스 번호를 입력해 주세유. ");
		
		int index = sc.nextInt();
		
		BookDTO book = service.selectIndex(index);
		
		if(book == null) {
			System.out.println("해당 인덱스에 책이 존재하지 않습니다" );
			return;
		}
		
		System.out.println("제목 : " + book.getTitle());
		System.out.println("저자 : " + book.getAuthor());
		System.out.println("가격 : " + book.getPrice());
		System.out.println("출판사 : " + book.getPublisher());
	}
	
	/**
	 *  책 정보 (제목, 저자, 가격, 출판사)를 입력 받아
	 *  BookService의 bookList에 마지막 요소로 추가
	 *  
	 *  단, 모든 정보가 일치하는 책은 추가 X(중복 저장 X)
	 */
	private void addBook() {
		
		System.out.println("\n ### 책 추가하기 ### \n");
		
		System.out.print("제목 : ");
		String title = sc.nextLine(); 
		// nextLine : 엔터가 입력되기 전 까지의 문자열 얻어오기(띄어쓰기 가능)
		
		System.out.print("저자 : ");
		String author = sc.nextLine();
		
		System.out.print("가격 : ");
		int price = sc.nextInt(); 
		sc.nextLine(); // 입력 버퍼 남은 문자열 제거
		// => sc.next() / sc.nextInt() 등을 수행 후 무조건 작성
		
		System.out.print("출판사 : ");
		String publisher = sc.nextLine();
		
		// 서비스 호출
		boolean result = service.addBook(new BookDTO(title, author, price, publisher));
	
		if(result) {
			System.out.println(title + "책이 추가되었습니다.");
		}else {
			System.out.println(title + "책이 이미 존재합니다.");
		}
	}
	
	/** 인덱스 번호를 입력 받아
	 * - 해당 인덱스에 책이 없다면
	 * => "해당 인덱스에 책이 존재하지 않습니다."
	 * 
	 * - 책이 있다면
	 * 1) "수정할 가격 입력 : " 출력
	 * 2) 스캐너로 가격 입력 받기
	 * 3) 입력 받은 index 번째 요소의 가격 수정
	 * 4) "[책 제목] 가격이 [이전가격] => [수정된 가격]으로 수정되었습니다."
	 */
	private void modifyBookPrice() {
		// 방법 1
		System.out.println("\n ### 책 수정하기 ### \n");
		
		System.out.print("수정하실 책의 인덱스 번호를 입력하세유 : ");
		int index = sc.nextInt();
		
//		if(!service.checkIndex(index)) {
//			System.out.println("해당 인덱스에 책이 존재하지 않습니다.");
//			return;
//		}
		BookDTO book = service.selectIndex(index);

		if(book == null) {
			System.out.println("해당 인덱스에 책이 존재하지 않습니다.");
			return;
		}
		
		int originPrice = 0;
			
		System.out.print("수정할 가격 입력 : ");
		int modifyPrice = sc.nextInt();
		
		originPrice = book.getPrice();
		book.setPrice(modifyPrice);
		
		System.out.printf("%s 가격이 [%d] => [%d]으로 수정되었습니다.", book.getTitle(), originPrice, modifyPrice);
		
	}
	
	/* 객체지향주의 SOLID 원칙
	 * 
	 * 1. 단일 책임 원칙(Single Responsibilty Principle, SRP)
	 * => 하나의 객체는 하나의 책임(역할)만 갖는다.
	 * 
	 * 2. 개방-폐쇄 원칙(Open/closed Principle, OCP)
	 * => 확장에는 개방 수정에는 폐쇄
	 * => 기존 코드 수정 X, 새 코드를 작성해라.
	 * => 원래 잘 동작하던 코드를 유지하려고(기존 코드를 잘못 건드리면 오류남)
	 * 
	 * 3. 리스코프 치환 원칙(Liskov Subtitutoin Principle, LSP)
	 * => 서브 타입은 언제나 기반타입으로 교체할 수 있도록 해야한다.
	 * => 자식 객체가 부모 객체(또는 부모 객체 상속)로 교환 되어도 기존 코드에 문제가 없어야 한다.
	 * ex) List로 만들어서 array 리스트랑 linked 리스트 바꿔끼고 하기
	 * 
	 * 4. 인터페이스 분리 원칙(Interface Segregation Principle, ISP)
	 * => 인터페이스를 최대한 필요한 기능만 갖도록 작게 만들자
	 * => 자식이 불필요한 메서드를 상속하지 않도록 하기 위해서
	 * 
	 * 5. 의존 역전 원칙(Dependency Inversion Principle, DIP)
	 * => 결합도를 낮추고, 응집도를 높여서 프로그램의 유연성, 유지보수의 유연성 확보(추상화)
	 */
	// 방법2) 위에 방법1은 객체지향주의 원칙 솔리드 원칙에 어긋나보임. 앞단에서 셋팅을 하는게 문제가 있다. 
	private void modifyBookPrice2() {
		
		System.out.println("\n ### 책 수정하기 ### \n");
		
		System.out.print("수정하실 책의 인덱스 번호를 입력하세유 : ");
		int index = sc.nextInt();
		
		if(!service.checkIndex(index)) {
			System.out.println("해당 인덱스에 책이 존재하지 않습니다.");
			return;
		}
		
		System.out.print("수정할 가격 입력 : ");
		int modifyPrice = sc.nextInt();
		
		// 서비스 호출
		String result = service.modifyBookPrice(index, modifyPrice);
		
		System.out.println(result);
	}
	
	/** index 번호를 입력 받아 책 제거
	 * 
	 * 단, 해당 index에 책이 없으면
	 * "해당 인덱스에 책이 존재하지 않습니다." 출력
	 * 
	 * 있으면 "[책 제목] 책이 제거되었습니다."
	 */
	private void removeBook() {
		
		System.out.println("\n ### 책 제거하기 ### \n");
		
		System.out.print("제거하실 책의 인덱스 번호를 입력하세유 : ");
		int index = sc.nextInt();
		
		BookDTO target = service.removeBook(index);
		
		if(target == null) {
			System.out.println("해당 인덱스에 책이 존재하지 않습니다.");
			return;
		}else {
			System.out.println(target.getTitle() + "책이 제거되었습니다.");
			return;
		}
	}
	
	private void selectTitle() {
		System.out.println("\n ### 제목으로 책 검색하기 ### \n");
		
		System.out.print("검색하실 책의 제목을 입력하세유 : ");
		String selectTitle = sc.nextLine();
		
		BookDTO target = service.selectTitle(selectTitle);
		
		if(target == null) {
			System.out.println("해당 제목의 책이 존재하지 않습니다" );
			return;
		}else {
			System.out.println("제목 : " + target.getTitle());
			System.out.println("저자 : " + target.getAuthor());
			System.out.println("가격 : " + target.getPrice());
			System.out.println("출판사 : " + target.getPublisher());
		}
		
		
	}
		
	/** 제목이 일치하는 책 제거
	 */
	private void removeBookTitle() {
		
		System.out.println("\n ### 제목으로 책 제거하기 ### \n");
		
		System.out.print("삭제하실 책의 제목을 입력하세유 : ");
		String selectTitle = sc.nextLine();
		
		BookDTO target = service.removeBooktTitle(selectTitle);
		
		if(target == null) {
			System.out.println("해당 제목의 책이 존재하지 않습니다" );
			return;
		}else {
			System.out.println(target.getTitle() + " 책을 삭제했습니다.");
		}
	}

	/**
	 * 입력 받은 출판사가 일치하는 모든 책 조회
	 */
	private void selectPublisherAll() {
		
		System.out.println("\n ### 출판사 이름으로 책 검색하기 ### \n");
		
		System.out.print("검색하실 책의 출판사를 입력하세유 : ");
		
		String selectPublisher = sc.nextLine();
		
		List<BookDTO> targetList = service.selectPublisherAll(selectPublisher);
		
//		if(targetList.isEmpty) { isEmpty : 내부에 저장된 내용이 없음. 
//		** targetList == null 하면 참조하는 객체가 없다는 것이지 비어있다는 것은 아님 **
		if(targetList.size() == 0) {
			System.out.println("해당 출판사의 책이 존재하지 않습니다" );
			return;
		}else {
			for(BookDTO book : targetList) {
				System.out.println("================================");
				System.out.println("제목 : " + book.getTitle());
				System.out.println("저자 : " + book.getAuthor());
				System.out.println("가격 : " + book.getPrice());
				System.out.println("출판사 : " + book.getPublisher());
				System.out.println("================================");
			}
		}
	}
	
	private void selectAuthorAll() {
		
		System.out.println("\n ### 저자 이름으로 책 검색하기 ### \n");
		
		System.out.print("검색하실 책의 저자를 입력하세유 : ");
		
		String selectAuthor = sc.nextLine();
		
		List<BookDTO> targetList = service.selectAuthorAll(selectAuthor);
		
		if(targetList.size() == 0) {
			System.out.println("해당 저자의 책이 존재하지 않습니다" );
			return;
		}else {
			for(BookDTO book : targetList) {
				System.out.println("================================");
				System.out.println("제목 : " + book.getTitle());
				System.out.println("저자 : " + book.getAuthor());
				System.out.println("가격 : " + book.getPrice());
				System.out.println("출판사 : " + book.getPublisher());
				System.out.println("================================");
			}
		}
	}
	
	private void searchBook() {
		
		System.out.println("\n ### 제목 , 저자 이름으로 책 검색하기 ### \n");
		
		System.out.print("검색어를 입력하세유 : ");
		
		String selectText = sc.nextLine();
		
		List<BookDTO> targetList = service.searchBook(selectText);
		
		if(targetList.size() == 0) {
			System.out.println("해당 검색어가 포함된 제목, 저자가 존재하지 않습니다" );
			return;
		}else {
			for(BookDTO book : targetList) {
				System.out.println("================================");
				System.out.println("제목 : " + book.getTitle());
				System.out.println("저자 : " + book.getAuthor());
				System.out.println("가격 : " + book.getPrice());
				System.out.println("출판사 : " + book.getPublisher());
				System.out.println("================================");
			}
		}
	}
	
	private void bookListSorting() {
		System.out.println("\n### 제목 오름차순 정렬 시키기 ###\n");
		
		service.bookListSorting();
		
		System.out.println("정렬되었습니다.");
	}
}
