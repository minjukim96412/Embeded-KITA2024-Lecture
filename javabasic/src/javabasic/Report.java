package javabasic;

public class Report {
	private int classNum; //반
	private int studentNum;//번호
	private String name; //이름
	private int kor; //국어
	private int eng; //영어
	private int math; //수학
	private int sum; //총점

	Report(int classNum, int studentNum, String name, int kor, int eng, int math, int sum) {
		super();
		this.classNum = classNum;
		this.studentNum = studentNum;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	/**
	 * @return the classNum
	 */
	public int getClassNum() {
		return classNum;
	}
	/**
	 * @param classNum the classNum to set
	 */
	public void setClassNum() {
		this.classNum = classNum;
	}
	
	public int getStudentNum() {
		return classNum;
	}

	public void setStudentNum() {
		this.studentNum = studentNum;
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
	 * @return the kor
	 */
	public int getKor() {
		return kor;
	}
	/**
	 * @param kor the kor to set
	 */
	public void setKor(int kor) {
		this.kor = kor;
	}
	/**
	 * @return the eng
	 */
	public int getEng() {
		return eng;
	}
	/**
	 * @param eng the eng to set
	 */
	public void setEng(int eng) {
		this.eng = eng;
	}
	/**
	 * @return the math
	 */
	public int getMath() {
		return math;
	}
	/**
	 * @param math the math to set
	 */
	public void setMath(int math) {
		this.math = math;
	}
	/**
	 * @return the sum
	 */
	public int getSum() {
		return kor + eng + math;
	}
	
	@Override
	public String toString() {
		return " 학생성적 [반 = " + classNum + ", 학생번호 = " + studentNum + ", 이름 = " + name + ", 국어 = " + kor
				+ ", 영어 = " + eng + ", 수학 = " + math + ", 총점 =" + getSum() + "]";
	}
	

	
}
