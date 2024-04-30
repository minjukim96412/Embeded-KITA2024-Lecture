package javabasic.oop;

public class CarMain {
	public static void main(String[] args) {
		
		Car car1 = new Car();//Car타입의 객체 생성
		car1.mfName = "현대";
		car1.carName = "소나타";
		car1.color = "빨간색";
		car1.tireCount = 4;
		
		System.out.println(car1.mfName + "에서 만든 " + car1.carName+"는 "+car1.color+"이며 타이어 수는 "+car1.tireCount);
		
		car1.startCar();
		car1.accelCar();
		car1.breakCar();
		car1.stopCar();

		car1.carName = "그랜져";
		
		car1.startCar();
		car1.accelCar();
		car1.breakCar();
		car1.stopCar();
		
		Car car2 = new Car();
		
		car2.mfName = "기아";
		car2.carName = "쏘렌토";
		car2.color = "백";
		car2.tireCount = 4;
		
		car2.startCar();
		car2.accelCar();
		car2.breakCar();
		car2.stopCar();
		
		
		
	}//main
}//class







