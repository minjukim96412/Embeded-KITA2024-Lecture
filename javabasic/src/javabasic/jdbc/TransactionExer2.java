package javabasic.jdbc;

public class TransactionExer2 {
	public static void main(String[] args) {
		
		BankAccount hong = new BankAccount(1,"홍길동", 1000);
		BankAccount kang = new BankAccount(2,"강감찬", 0);
		
		
	}//main
	
	//출금 (계좌, 출금할 금액)
	private int withdraw(BankAccount ba, int money) {
		//계좌 잔액이 출금할 금액 이상인지 확인
		if(ba.getBamoney() >= money) {
			
		}
	}
	

	//입금 (계좌, 입금할 금액)
	private int deposit(BankAccount ba, int money) {
		
	}
	
}
