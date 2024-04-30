package javabasic.oop;

public class PhoneMain {
	public static void main(String[] args) {
	
	//객체를 3개 생성	
		Phone phone1 = new Phone();
		Phone.objCount++;
		Phone phone2 = new Phone();
		Phone.objCount++;
		Phone phone3 = new Phone();
		Phone.objCount++;
		
	//객체 데이터 설정
		phone1.name = "아이폰";
		phone1.color = "빨간색";
		phone1.data = 128;
		
		phone2.name = "갤럭시";
		phone2.color = "검정색";
		phone2.data = 256;
		
		phone3.name = "블랙베리";
		phone3.color = "흰색";
		phone3.data = 64;
		
	//객체 데이터 출력	
		
		System.out.println(phone1.name + "의 색상은 " + phone1.color + "이며 용량은 " + phone1.data + "GB 입니다.");
		System.out.println(phone2.name + "의 색상은 " + phone2.color + "이며 용량은 " + phone2.data + "GB 입니다.");
		System.out.println(phone3.name + "의 색상은 " + phone3.color + "이며 용량은 " + phone3.data + "GB 입니다.");
		
	//객체 메소드 호출
		phone1.phoneON();
		phone1.phoneOFF();
		phone1.call();
		phone1.hangUP();
		
		phone2.phoneON();
		phone2.phoneOFF();
		phone2.call();
		phone2.hangUP();
		
		phone3.phoneON();
		phone3.phoneOFF();
		phone3.call();
		phone3.hangUP();
		
		
		
	//생성된 객체 수
		System.out.println("총" + Phone.objCount + "개의 객체가 생성됨!");
	}//main
}//class
