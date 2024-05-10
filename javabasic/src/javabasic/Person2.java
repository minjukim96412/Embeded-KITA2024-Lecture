package javabasic;

public class Person2 {
	
	String name;
	int age;
	
	
	public Person2(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}


	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public boolean equals(Object obj) {
		Person2 p = (Person2)obj;
		if(p.name.equals(this.name) && p.age == this.age) {
			return true;
		}else {
			return false;
		}
	}
	
	
	@Override
	public String toString() {
		return this.name + "님은" + this.age + "살 입니다!";
	}
	
	
}
