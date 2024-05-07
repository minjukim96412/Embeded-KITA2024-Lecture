package javabasic;

public class ContException extends Exception {
	@Override
	public String getMessage() {
		return "보험가입자와 통화 ";
	}
}
