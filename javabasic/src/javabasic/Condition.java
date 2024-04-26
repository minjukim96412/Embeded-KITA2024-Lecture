package javabasic;

import java.util.Scanner;

public class Condition {
	
	public static void main(String[] args) {
		
		
		
		//if 문
		int i = 15;
		
		if (i < 10) {
			System.out.println("i가 10보다 작습니다!");	
		} else if (i == 15) {
			System.out.println("i는 15입니다!");
		} 
		else {
			System.out.println("i가 10보다 작지 않고 15가 아닙니다!");
		}
		
		System.out.println("-------------------");
		
		//switch 문
		int j = 1;
		
		switch (j) {
		case 1: {
			System.out.println("남성입니다!");
			break;
			}
		case 2: {
			System.out.println("여성입니다!");
			break;
			}
		default : {
			System.out.println("남성도 여성도 아닙니다!");
			break;
			} 
		}
	
		System.out.println("--------------------");
		
		int h = 2;
	
		if (h == 1) {
			System.out.println("남성입니다!");
		} else if (h == 2) {
			System.out.println("여성입니다!");
		} else {
			System.out.println("남성도 여성도 아닙니다!");
		}
	
		System.out.println("----------------");
		
		// 실습 1)
		// 두개의 int 변수를 만들어 각각 5와 10의 값을 대입하고
		// 두 변수의 합을 sum이라는 byte변수에 저장한 후 
		// 값이 10보다 큰지 비교하여 출력
		
		int num1 = 5;
		int num2 = 10;
//		byte sum = (byte)((byte)num1 + (byte)num2);
		byte sum = (byte)(num1 + num2);
		
		if(sum > 10) {
			System.out.println("10보다 큽니다!");
		} else if (sum < 10) {
			System.out.println("10보다 작습니다!");
		} else {
			System.out.println("10과 같습니다!");
		}
		
		System.out.println("-----------------------");
		
		
		//실습 2)
		//num3이라는 int 변수에는 5를 대입하고
		//num4이라는 int 변수에는 10를 대입하고
		//sum2이라는 두 변수의 합를 대입하고
		//mul이라는 두 변수의 곱을 대입하고
		//두 변수의 곱에서 두 변수의 합을 뺀 값을 result 라는 short변수에 저장
		//result가 0~10사이에 있는지, 11~20사이에 있는지, 21~30사이에 있는지,
		//31~41사이에 있는지 출력
		
		int num3 = 5;
		int num4 = 10;
		int sum2 = num3 + num4;
		int mul = num3 * num4;
		short result = (short)(mul - sum2);
		
		System.out.println(sum2 + "/" + mul+ "/" + result);
		
		
		if (result >= 0 && result <= 10 ) {
			System.out.println("0에서 10 사이에 있는 숫자입니다. ");
		} else if(result >= 11 && result <= 20 ) {
			System.out.println("11에서 20 사이에 있는 숫자입니다. ");
		} else if(result >= 21 && result <= 30 ) {
		System.out.println("21에서 30 사이에 있는 숫자입니다. ");
		} else if(result >= 31 && result <= 40 ) {
			System.out.println("31에서 40 사이에 있는 숫자입니다. ");
		}

		System.out.println("--------------------------------");
		//실습 3)
		//키보드에서 숫자를 하나 입력받아서 입력받은 숫자를 5로 나눈 나머지를 출력
		Scanner sc = new Scanner(System.in);
		int result2 = 0;
		System.out.println("숫자 하나를 입력하세요.");
		int choice = sc.nextInt();
		result2 = choice % 5;
		System.out.println(choice + " 를 5로 나눈 나머지 값은 " + result2 + "입니다.");
		
		//실습 4)
		//키보드에서 숫자를 두개를 입력받아서 입력받은 두수의 합을 출력
		Scanner sc2 = new Scanner(System.in);
		int result3 = 0;
		System.out.println("두 수를 입력하세요.");
		int choice2 = sc2.nextInt();
		int choice3 = sc2.nextInt();
		System.out.println("두 수의 합은 " + (choice2+choice3) + "입니다.");
		
		//실습 5)
		//키보드에서 0~6까지의 숫자를 입력받아서 0이면 일요일, 1이면 월요일.. 출력
		Scanner sc3 = new Scanner(System.in);
		
		System.out.println("0~6까지의 숫자 중 하나만 입력하세요");
		int day1 = sc3.nextInt();
		
		switch (day1) {
			case 0: {System.out.println("일요일 입니다."); break;}
			case 1: {System.out.println("월요일 입니다."); break;}
			case 2: {System.out.println("화요일 입니다."); break;}
			case 3: {System.out.println("수요일 입니다."); break;}
			case 4: {System.out.println("목요일 입니다."); break;}
			case 5: {System.out.println("금요일 입니다."); break;}
			case 6: {System.out.println("토요일 입니다."); break;}
			default: {System.out.println("0~6까지의 숫자만 입력해주세요.");break;}
		}
		
	}//main
		
}//class
