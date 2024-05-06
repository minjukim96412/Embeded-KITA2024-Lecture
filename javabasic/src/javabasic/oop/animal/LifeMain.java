package javabasic.oop.animal;

public class LifeMain {
	public static void main(String[] args) {
		
	
		ILife dog1 = new Dog("말티즈");
		ILife cat1 = new Cat("러시안고양이");
		
		ILife rose1 = new Rose("백장미");
		ILife lily1 = new Lily("홍백합");
		
		//개를 숨쉬도록 해보자.
		dog1.breath();
		//장미를 광합성하게 해보자
		// 방법 1: ((IPlant) rose1).light()
		// 방법 2 (인터페이스 분리 이용)
		rose1.light(); 
		cat1.breath();
		lily1.light();
		
		
		
	}
}
