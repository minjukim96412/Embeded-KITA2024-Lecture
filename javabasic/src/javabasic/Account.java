package javabasic;

public class Account {

	private String name;
	private int money; //계좌잔액
	Account(String name, int money) {
		super();
		this.name = name;
		this.money = money;
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
	 * @return the money
	 */
	public int getMoney() {
		return money;
	}
	/**
	 * @param money the money to set
	 */
	public void setMoney(int money) {
		this.money = money;
	}
	
	@Override
	public String toString() {
		return this.name + "님의 계좌 잔액 : " + this.money;
	}
	
//	public synchronized void deposite(int money) {
//		this.money += money;
//	}
//	public synchronized void withdraw(int money) {
//		this.money -= money;
//	}
	public void deposite(int money) {
		synchronized(this) {
		this.money += money;
		}
	}
	public synchronized void withdraw(int money) {
		synchronized(this) {
		this.money -= money;
		}
	}
	
}
