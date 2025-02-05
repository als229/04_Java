package section03.dto;

/** Calculaor 인터페이스 구현체
 * - 모든 인터페이스 구현체는 같은 형태를 띄고 있다! *** 중요 ***
 * 
 */
public class KKMCalculator implements Calculator{

	@Override
	public int plus(int a, int b) {
		int num = a + b;
		
		return checkNum(num);
	}
	
	@Override
	public int minus(int a, int b) {
		int num = a - b;
		return checkNum(num);
	}

	@Override
	public int multi(int a, int b) {
		int num = a * b;
		
		return checkNum(num);
	}

	@Override
	public double div(int a, int b) {
		int num = a / b;
		
		return checkNum(num);
	}

	@Override
	public int mod(int a, int b) {
		int num = a % b;
		
		return checkNum(num);
	}

	@Override
	public int pow(int a, int x) {
		int num = (int)Math.pow(a, x);
		
		return checkNum(num);
	}

	@Override
	public double areaOfCircle(double r) {
		double num = PI*r*r;
		
		return checkNum(num);
	}

	
}
