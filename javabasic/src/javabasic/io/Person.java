package javabasic.io;

import java.io.Serializable;

public class Person implements Serializable{
	
	//network상에서 Person의 ID
	public static final long serialVersionUID = 154865214586541L;
	
	String name;
	int age;
	private String sno;//주민번호
	
	public Person(){
		
	}

	public Person(String name, int age, String sno) {
		super();
		this.name = name;
		this.age = age;
		this.sno = sno;
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

	/**
	 * @return the sno
	 */
	public String getSno() {
		return sno;
	}

	/**
	 * @param sno the sno to set
	 */
	public void setSno(String sno) {
		this.sno = sno;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", sno=" + sno + "]";
	}
	
	
	
}
