package list.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import list.dto.BookDTO;

/**
 * 도서 관리 프로그램 기능 제공 클래스
 */
public class BookService {

	private List<BookDTO> bookList = new ArrayList<BookDTO>();
	
	// 기본 생성자
	public BookService() {
		// 샘플 데이터 추가
		bookList.add(new BookDTO("소년이 온다", "한강", 15000, "창비"));
		bookList.add(new BookDTO("초역 부처의 말", "코이케 류노스케", 17800,"포레스트 북스"));
		bookList.add(new BookDTO("채식주의자", "한강", 15000, "창비"));
		bookList.add(new BookDTO("작별하지 않는다","한강",16800,"문학동네"));
		bookList.add(new BookDTO("모순", "양귀자", 13000, "쓰다"));
	}
	
	// 얕은 복사로 보냄
	public List<BookDTO> getBookService() {
		return bookList;
	}

	/**
	 *  전달 받은 index 번째 bookList 요소 반환
	 *  단, 범위 초과시 null 반환
	 * @param index
	 * @return BookDTO 참조 주소 또는 null
	 */
	public BookDTO selectIndex(int index) {
		if(checkIndex(index) == false) return null;
		return bookList.get(index);
	}
	
	public boolean checkIndex(int index) {
		if(bookList.size() < 0 || bookList.size() <= index) return false;
		return true;
	}
	
	/** 전달 받은 book을 bookList에 추가 
	 * 단, 책 정보가 모두 일치하는 책이 있다면 추가 X
	 * 
	 * @param book
	 * @return 추가 O : true, 추가 X : false
	 */
	public boolean addBook(BookDTO book) {
		
		boolean check = true;
		
		// 책 정보 비교 방법 1) 필드 값 하나씩 꺼내서 비교
		// 책 정보 비교 방법 2) equals() 오버라이딩 후 이용
		
		// 방법 1) for문 돌리기 
//		for(BookDTO b : bookList) {
//			if(b.equals(book)) return false;
//		}
		
		// 방법 2) contains 사용
		// 단, contains 메서드는 equals가 오버라이딩 돼서 구현을 해 놨을 때만 사용 가능.
		// 자바 컬렉션 프레임 워크에 equals와 hashCode가 구현이 됐을 거라고 전제하에 제공하는 기능.
		// BookDTO의 equals()를 오버라이딩 했기 때문에
		// List가 제공하는 contains()(포함하는지 확인하는 메서드) 사용 가능
		if(bookList.contains(book)) return false;
		
		// add => 메서드는 무조건 true를 반환하게 되어 있다.
		// 컬렉션은 크기 제한이 없어서 무조건 추가가 성공하기 때문.
		return bookList.add(book);
	}

	public String modifyBookPrice(int index, int price) {
		
		BookDTO book = bookList.get(index);
		int originPrice =  book.getPrice();
		book.setPrice(price);
		
		return String.format("%s 가격이 [%d] => [%d]으로 수정되었습니다.",  book.getTitle(), originPrice, book.getPrice());
	}

	/** 책 제거하기
	 * 단, 없으면 null 반환
	 * 제거 성공하면 제거된 BookDTO 반화
	 * 
	 * @param index
	 * @return 제거된 BookDTO
	 */
	public BookDTO removeBook(int index) {
		if(!checkIndex(index)) return null;
		
		BookDTO book = bookList.remove(index);
		
		return book;
	}

	public BookDTO selectTitle(String selectTitle) {
		
		for(BookDTO book: bookList) {
			if(book.getTitle().equals(selectTitle)) {
				return book;
			}
		}
		
		return  null;
	}
	
	public BookDTO removeBooktTitle(String selectTitle) {
		
		for(int i = 0; i < bookList.size(); i++) {
			if(bookList.get(i).getTitle().equals(selectTitle)) {
				return bookList.remove(i);
			}
		}
		// 강사님 코드
//		for(BookDTO book : bookList) {
//			
//			if(book.getTitle().equals(selectTitle)) {
//				bookList.remove(book);
//				//=> Object 넘기면 삭제 성공 시 true  반환 하는 remove도 있음
//				// => 이 방법은 equals() 오버라이딩 되어 있어야 사용 가능한 방법
//			}
//		}
		
		return  null;
	}

	public List<BookDTO> selectPublisherAll(String selectPublisher) {
		
		List <BookDTO> list = new ArrayList<BookDTO>();
		
		for(BookDTO target : bookList) {
			if(target.getPublisher().equals(selectPublisher)) {
				list.add(target);
			}
		}
		
		return list;
	}
	
	public List<BookDTO> selectAuthorAll(String selectAuthor) {
		
		List <BookDTO> list = new ArrayList<BookDTO>();
		
		for(BookDTO target : bookList) {
			if(target.getAuthor().equals(selectAuthor)) {
				list.add(target);
			}
		}
		
		return list;
	}
	
	public List<BookDTO> searchBook(String selectText) {
		
		List <BookDTO> list = new ArrayList<BookDTO>();
		
		for(BookDTO target : bookList) {
//			if(target.getAuthor().contains(selectText)) {
//				list.add(target);
//				continue;
//			}
//			if(target.getTitle().contains(selectText)){
//				list.add(target);
//				continue;
//			}
			// 강사님 코드
			if(target.getTitle().contains(selectText) || target.getAuthor().contains(selectText)) {
				list.add(target);
			}
		}
		return list;
	}
	
	/**
	 * 제목 오름차순 정렬
	 */
	public void bookListSorting() {
		
		Collections.sort(bookList);
		// 원본 리스트가 정렬된 형태로 변경됨
		
	}
}
