package javabasic.oop;

class Human {

	private String name;
	private int age;
	
	Human(String name,int age){
		this.name = name;
		this.age = age;
	}
//	// getter(get + 변수명 대문자로 시작)
//	public String getName() {
//		return name;
//	}
//	
//	public void setName(String name) {
//		this.name = name;
//	}
//	
//	//age의 getter/setter
//	
//	public int getAge() {
//		return age;
//	}
//	
//	public void setAge(int age) {
//		this.age = age;
//	}

	//alt + shift + s + r
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age + 15;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
