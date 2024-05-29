package javabasic.jdbc.tastyRestraint;

import java.sql.Timestamp;

public class TastyRestraint {
	
	private int tid;
	private String restraint_name;
	private String food_category;
	private String restraint_ip;
	private String restraint_menu;
	private int menu_price;
	private int restraint_score;
	private String restraint_review;
	private Timestamp tregdate;
	
	public TastyRestraint() {
		// TODO Auto-generated constructor stub
	}

	public TastyRestraint(int tid, String restraint_name, String food_category, String restraint_ip,
			String restraint_menu, int menu_price, int restraint_score, String restraint_review, Timestamp tregdate) {
		super();
		this.tid = tid;
		this.restraint_name = restraint_name;
		this.food_category = food_category;
		this.restraint_ip = restraint_ip;
		this.restraint_menu = restraint_menu;
		this.menu_price = menu_price;
		this.restraint_score = restraint_score;
		this.restraint_review = restraint_review;
		this.tregdate = tregdate;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getRestraint_name() {
		return restraint_name;
	}

	public void setRestraint_name(String restraint_name) {
		this.restraint_name = restraint_name;
	}

	public String getFood_category() {
		return food_category;
	}

	public void setFood_category(String food_category) {
		this.food_category = food_category;
	}

	public String getRestraint_ip() {
		return restraint_ip;
	}

	public void setRestraint_ip(String restraint_ip) {
		this.restraint_ip = restraint_ip;
	}

	public String getRestraint_menu() {
		return restraint_menu;
	}

	public void setRestraint_menu(String restraint_menu) {
		this.restraint_menu = restraint_menu;
	}

	public int getMenu_price() {
		return menu_price;
	}

	public void setMenu_price(int menu_price) {
		this.menu_price = menu_price;
	}

	public int getRestraint_score() {
		return restraint_score;
	}

	public void setRestraint_score(int restraint_score) {
		this.restraint_score = restraint_score;
	}

	public String getRestraint_review() {
		return restraint_review;
	}

	public void setRestraint_review(String restraint_review) {
		this.restraint_review = restraint_review;
	}

	public Timestamp getTregdate() {
		return tregdate;
	}

	public void setTregdate(Timestamp tregdate) {
		this.tregdate = tregdate;
	}

	
	@Override
	public String toString() {
		return "TastyRestraint [tid=" + tid + ", restraint_name=" + restraint_name + ", food_category=" + food_category
				+ ", restraint_ip=" + restraint_ip + ", restraint_menu=" + restraint_menu + ", menu_price=" + menu_price
				+ ", restraint_score=" + restraint_score + ", restraint_review=" + restraint_review + ", tregdate="
				+ tregdate + "]";
	}
	
	
	
	
}
