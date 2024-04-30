package javabasic.oop;

public class Dog {
	String name;
	int age;
	String color;
	
	Dog(){
		
	}
	
	Dog(String name){
		this.name = name;
	}
	Dog(String name, int age){
		this.name = name;
		this.age = age;
	}
	Dog(String name, int age,String color){
		this.name = name;
		this.age = age;
		this.color = color;
	}
	
	
	
	@Override
	public String toString() {
		return this.name + "은(는)" + this.age + "살 이고 " + this.color + "입니다.";
	}
}
