package javabasic.oop;

public class Device {

	private String name;
	private int price;
	private int weight;

	Device() {

	}

	Device(String name, int price, int weight) {
		this.name = name;
		this.price = price;
		this.weight = weight;
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
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	void on() {
		System.out.println("켜다.");
	}
	void off() {
		System.out.println("끄다.");
	}
	
}
