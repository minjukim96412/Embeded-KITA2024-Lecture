package javabasic.jdbc.guest;

import java.sql.Timestamp;

public class Guest {
	
	private int gNo;
	private String gName;
	private int gAge;
	private String gGender;
	private String gsid;
	private Timestamp gCount;
	
	public Guest() {
		// TODO Auto-generated constructor stub
	}
	
	public Guest(int gNo, String gName, int gAge, String gGender, String gsid, Timestamp gCount) {
		super();
		this.gNo = gNo;
		this.gName = gName;
		this.gAge = gAge;
		this.gGender = gGender;
		this.gsid = gsid;
		this.gCount = gCount;
	}

	public String getGsid() {
		return gsid;
	}

	public void setGsid(String gsid) {
		this.gsid = gsid;
	}

	public int getgNo() {
		return gNo;
	}

	public void setgNo(int gNo) {
		this.gNo = gNo;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public int getgAge() {
		return gAge;
	}

	public void setgAge(int gAge) {
		this.gAge = gAge;
	}

	public String getgGender() {
		return gGender;
	}

	public void setgGender(String gGender) {
		this.gGender = gGender;
	}

	public Timestamp getgCount() {
		return gCount;
	}

	public void setgCount(Timestamp gCount) {
		this.gCount = gCount;
	}

	@Override
	public String toString() {
		return gNo + "번 " + gName + " : " + gAge + "살, " + gGender + ", 접속시간 : "
				+ gCount;
	}
	
	
	
	
}
