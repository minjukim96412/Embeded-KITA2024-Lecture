package javabasic;

public class Operator {
	public static void main(String[] args) {
		
		//단항 연산자
		int i = 100;
		int j = -i;
		
		//이항 연산자
		int i2 = i+j;
		
		//삼항연산자
		int i3 = i2 == 100 ? 100 : 0;
		
		//산술연산자
		int i4 = 10;
		int i5 = 20;
		System.out.println(i4 + i5);
		System.out.println(i4 % i5);
		
		
		int i6 = 15;
		if (i6 == 15) {
			System.out.println("i6은 15입니다.");
		}else {
			System.out.println("i6은 15가 아닙니다.");
		}
		
		//논리연산자
		boolean b = false;
		System.out.println(b & true);
		System.out.println(b & false);
		System.out.println(b | true);
		System.out.println(b | false);
		//&&는 좌항이 false이면 우항 평가하지 않음. 전체가 false 이므로
		//||는 좌항이 true이면 우항 평가하지 않음. 전체가 true이므로
		System.out.println(b &&  true);
		System.out.println(b && false);
		System.out.println(b || true);
		System.out.println(b || false);
		
	}
}
