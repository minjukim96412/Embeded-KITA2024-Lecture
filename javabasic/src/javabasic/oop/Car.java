package javabasic.oop;

public class Car {
	// 객체의 데이터 = 멤버변수(member variable)
	String mfName; //제조사
	String carName;	//이름
	String color;	//색상
	int tireCount; //타이어 수

	//객체의 기능 = 멤버 메소드(member method)
	//this : 메모리에서 참조되는 객체 자신을 가리키는 키워드
	void startCar() {
		System.out.println(this.carName+" 자동차 출발!");
	}
	void stopCar() {
		System.out.println(this.carName+" 자동차 출발!");
	}
	
	void accelCar() {
		System.out.println(this.carName+" 자동차 가속!");
	}
	void breakCar() {
		System.out.println(this.carName+" 자동차 감속!");
	}
	
}
