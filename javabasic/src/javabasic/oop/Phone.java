package javabasic.oop;

public class Phone {
	
	static int objCount = 0;//static은 초기화 해주기
	
	String name; //""자동 초기화
	String color;//0 자동 초기화
	int data;
	
	static int getObjCount() {
		return objCount;
	}
	
	void phoneON() {
		System.out.println(this.name+"전원을 킨다.");
	}
	void phoneOFF() {
		System.out.println(this.name+"전원을 끈다.");
	}
	void call() {
		System.out.println(this.name+"전화를 건다.");
	}
	void hangUP() {
		System.out.println(this.name+"전화를 끊다.");
	}

}
