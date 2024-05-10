package javabasic.io;

import java.io.Serializable;

public class StudentScore implements Serializable{
	
	
	private static long serialVersionUID = 3977161085483731816L;
	
	private int sno;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	
	StudentScore(int sno, String name, int kor, int eng, int math, int total) {
		super();
		this.sno = sno;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = total;
	}
	
	
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	/**
	 * @param serialversionuid the serialversionuid to set
	 */
	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}


	/**
	 * @return the sno
	 */
	public int getSno() {
		return sno;
	}


	/**
	 * @param sno the sno to set
	 */
	public void setSno(int sno) {
		this.sno = sno;
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
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}


	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = kor + eng +math;
	}


	@Override
	public String toString() {
		return "StudentScore [sno=" + sno + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math
				+ ", total=" + total + "]" ;
	}
	
	
	
}
