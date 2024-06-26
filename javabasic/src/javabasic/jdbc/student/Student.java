package javabasic.jdbc.student;

import java.util.List;

public class Student {
	private int Sno;
	private String sname;
	private int sage;
	private String sgender;
	private List<Subject> subjectList; //과목 리스트 
	
	public Student() {
		
	}

	public Student(int Sno, String sname, int sage, String sgender, List<Subject> subjectList) {
		super();
		this.Sno = Sno;
		this.sname = sname;
		this.sage = sage;
		this.sgender = sgender;
		this.subjectList = subjectList;
	}

	public int getSno() {
		return Sno;
	}

	public void setSno(int Sno) {
		this.Sno = Sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getSage() {
		return sage;
	}

	public void setSage(int sage) {
		this.sage = sage;
	}

	public String getSgender() {
		return sgender;
	}

	public void setSgender(String sgender) {
		this.sgender = sgender;
	}

	public List<Subject> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(List<Subject> subjectList) {
		this.subjectList = subjectList;
	}

	@Override
	public String toString() {
		String sgenderPrn = sgender.equals("M") ? "남자" : "여자";
		String subjectListprn = "";
		for (Subject subject : subjectList) {
			subjectListprn += subject.toString();
		}
		return Sno + "번" + sname + " : " + sage + "살, " + sgenderPrn + ", " + subjectListprn;
	}
	
	



	
}
