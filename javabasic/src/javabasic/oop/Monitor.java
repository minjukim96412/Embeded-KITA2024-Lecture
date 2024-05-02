package javabasic.oop;

public class Monitor extends Device {

	private int xSize; //화면의 가로넓이
	
	private int ySize; //화면의 세로높이

	public Monitor() {
		
	}
	
	Monitor(int xSize, int ySize){
		this.xSize = xSize;
		this.ySize = ySize;
	}
	
	/**
	 * @return the xSize
	 */
	public int getxSize() {
		return xSize;
	}

	/**
	 * @param xSize the xSize to set
	 */
	public void setxSize(int xSize) {
		this.xSize = xSize;
	}

	/**
	 * @return the ySize
	 */
	public int getySize() {
		return ySize;
	}

	/**
	 * @param ySize the ySize to set
	 */
	public void setySize(int ySize) {
		this.ySize = ySize;
	}

	@Override
	void on() {
		System.out.println("모니터를 켜다.");
	}

	@Override
	void off() {
		System.out.println("모니터를 끄다.");
	}

	
	
}
