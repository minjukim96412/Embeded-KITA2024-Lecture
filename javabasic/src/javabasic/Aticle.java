package javabasic;

import java.sql.Timestamp;

//게시물
public class Aticle {

	private int bno; // 번호
	private String bTitle;// 제목
	private String bContent;// 내용
	private String bWriter;// 작성자
	private Timestamp bregdate;// 작성일시

	Aticle(int bno, String bTitle, String bContent, String bWriter, Timestamp bregdate) {
		super();
		this.bno = bno;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bWriter = bWriter;
		this.bregdate = bregdate;
	}

	/**
	 * @return the bno
	 */
	public int getBno() {
		return bno;
	}

	/**
	 * @param bno the bno to set
	 */
	public void setBno(int bno) {
		this.bno = bno;
	}

	/**
	 * @return the bTitle
	 */
	public String getbTitle() {
		return bTitle;
	}

	/**
	 * @param bTitle the bTitle to set
	 */
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	/**
	 * @return the bContent
	 */
	public String getbContent() {
		return bContent;
	}

	/**
	 * @param bContent the bContent to set
	 */
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	/**
	 * @return the bWriter
	 */
	public String getbWriter() {
		return bWriter;
	}

	/**
	 * @param bWriter the bWriter to set
	 */
	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}

	/**
	 * @return the bregdate
	 */
	public Timestamp getBregdate() {
		return bregdate;
	}

	/**
	 * @param bregdate the bregdate to set
	 */
	public void setBregdate(Timestamp bregdate) {
		this.bregdate = bregdate;
	}

	@Override
	public String toString() {
		return "Aticle [bno=" + bno + ", bTitle=" + bTitle + ", bContent=" + bContent + ", bWriter=" + bWriter
				+ ", bregdate=" + bregdate + "]";
	}

}
