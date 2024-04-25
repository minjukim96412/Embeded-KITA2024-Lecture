package javabasic;

public class TypeCasting {
	public static void main(String[] args) {
		
//		기본타입의 형변환에서 표현범위가 작은 타입에서 큰 타입으로의 형변환 묵시적(자동)
		byte b = 100;
		int i = b;
		//int i = (int)b;
		
//		기본타입의 형변환에서 표현범위가 큰 타입에서 작은 타입으로의 형변환은 명시적(강제)
		
		int i2 = 2100000000;
		byte b2 = (byte)i2;
		
//		int i3 = 100/0;
		
		System.out.println(i);		//데이터 무손실
		System.out.println(b2); //데이터가 손실되어 0만 출력됨 
//		System.out.println(i3); ->0으로 나눌 수 없어 에러발생
		

		//boolean타입은 어떤 다른 타입과도 형변환 되지 않는다.
		//boolean bool = true;
		//int i3 = bool;
		
		
			
	}
}
