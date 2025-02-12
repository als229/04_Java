package section04.exception;

import java.io.IOException;

/* [사용자 정의 예외를 만드는 방법]
 * - 아무 Exception 관련 클래스를 상속 받기!
 * 
 * [사용자 정의 Checked/UnChecked Exception 만들기]
 * 
 * - Checked : Checked Exception 클래스 상속 받기
 * 
 * - UnChecked : UnChecked Exception 클래스 상속 받기
 * 	=> RuntimeException 또는 자식 클래스들
 * 
 */
public class MyTestException 
//	extends Exception{ // CheckedException 으로 만들겠다
	extends RuntimeException{ // UnCheckedException 으로 만들겠다
	
	
}
