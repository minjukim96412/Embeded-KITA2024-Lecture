package javabasic.jdbc.student;

public class Subject {

	private int SubNo;
	private String subName;
	
	public Subject() {
		// TODO Auto-generated constructor stub
	}

	public Subject(int SubNo, String subName) {
		super();
		this.SubNo = SubNo;
		this.subName = subName;
	}

	public int getSubNo() {
		return SubNo;
	}

	public void setSubNo(int SubNo) {
		this.SubNo = SubNo;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	@Override
	public String toString() {
		return subName + "/";
	}
	
	
	
	
}
