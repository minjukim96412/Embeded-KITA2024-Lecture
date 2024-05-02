package javabasic.oop;

public class Printer extends Device {
	
	private int dpi;
	private String color;
	
	public Printer() {
		
	}
	
	Printer(int dpi, String color) {
		super();
		this.dpi = dpi;
		this.color = color;
	}

	/**
	 * @return the dpi
	 */
	public int getDpi() {
		return dpi;
	}

	/**
	 * @param dpi the dpi to set
	 */
	public void setDpi(int dpi) {
		this.dpi = dpi;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	void on() {
		System.out.println("프린터를 켜다.");
	}

	@Override
	void off() {
		System.out.println("프린터를 끄다.");
	}
	
	
}
