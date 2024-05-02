package javabasic.oop;

public class Keyboard extends Device {

	private int keyCount;//키 개수
	private String keyboardType; // 키보드 종류(기계식, 멤브레인...)
	
	Keyboard() {
		
	}

	Keyboard(int keyCount, String keyboardType) {
		super();
		this.keyCount = keyCount;
		this.keyboardType = keyboardType;
	}

	/**
	 * @return the keyCount
	 */
	public int getKeyCount() {
		return keyCount;
	}

	/**
	 * @param keyCount the keyCount to set
	 */
	public void setKeyCount(int keyCount) {
		this.keyCount = keyCount;
	}

	/**
	 * @return the keyboardType
	 */
	public String getKeyboardType() {
		return keyboardType;
	}

	/**
	 * @param keyboardType the keyboardType to set
	 */
	public void setKeyboardType(String keyboardType) {
		this.keyboardType = keyboardType;
	}

	@Override
	void on() {
		System.out.println("키보드를 켜다.");
	}

	@Override
	void off() {
		System.out.println("키보드를 끄다.");
	}
	
	
	
	
}
