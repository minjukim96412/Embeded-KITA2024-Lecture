package javabasic.oop;

class HumanMain {
	public static void main(String[] args) {
		
		Human human1 = new Human("홍길동", 80);
		//private이므로 직접 접근 불가
//		System.out.println(human1.name);
//		System.out.println(human1.age);
		
		System.out.println(human1.getName());
		
		//private이므로 직접 접근 불가
//		human1.name = "강감찬";
		
		human1.setName("강감찬");
		System.out.println(human1.getName());
		
		human1.setAge(50);
		System.out.println(human1.getAge());
	}
}
