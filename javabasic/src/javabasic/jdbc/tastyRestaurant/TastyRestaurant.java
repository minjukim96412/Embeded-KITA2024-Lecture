package javabasic.jdbc.tastyRestaurant;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TastyRestaurant {
	
	private int tid;
	private String restaurant_name;
	private String food_category;
	private String restaurant_ip;
	private String restaurant_menu;
	private int menu_price;
	private double restaurant_score;
	private String restaurant_review;
	private Timestamp tregdate;
	private static List<TastyRestaurant> tastyList;

    
	public TastyRestaurant() {
		// TODO Auto-generated constructor stub
	}

	public TastyRestaurant(int tid, String restaurant_name, String food_category, String restaurant_ip,
			String restaurant_menu, int menu_price, double restaurant_score, String restaurant_review, Timestamp tregdate) {
		super();
		this.tid = tid;
		this.restaurant_name = restaurant_name;
		this.food_category = food_category;
		this.restaurant_ip = restaurant_ip;
		this.restaurant_menu = restaurant_menu;
		this.menu_price = menu_price;
		this.restaurant_score = restaurant_score;
		this.restaurant_review = restaurant_review;
		this.tregdate = tregdate;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getRestaurant_name() {
		return restaurant_name;
	}

	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}

	public String getFood_category() {
		return food_category;
	}

	public void setFood_category(String food_category) {
		this.food_category = food_category;
	}

	public String getRestaurant_ip() {
		return restaurant_ip;
	}

	public void setRestaurant_ip(String restaurant_ip) {
		this.restaurant_ip = restaurant_ip;
	}

	public String getRestaurant_menu() {
		return restaurant_menu;
	}

	public void setRestaurant_menu(String restaurant_menu) {
		this.restaurant_menu = restaurant_menu;
	}

	public int getMenu_price() {
		return menu_price;
	}

	public void setMenu_price(int menu_price) {
		this.menu_price = menu_price;
	}

	public double getRestaurant_score() {
		return restaurant_score;
	}

	public void setRestaurant_score(double restaurant_score) {
		this.restaurant_score = restaurant_score;
	}

	public String getRestaurant_review() {
		return restaurant_review;
	}

	public void setRestaurant_review(String restaurant_review) {
		this.restaurant_review = restaurant_review;
	}

	public Timestamp getTregdate() {
		return tregdate;
	}

	public void setTregdate(Timestamp tregdate) {
		this.tregdate = tregdate;
	}

	
	public static List<TastyRestaurant> getTastyList() {
        if (tastyList == null) {
            try {
                fetchTastyList(); // DAO 호출은 여기서 이루어집니다.
            } catch (SQLException e) {
                e.printStackTrace();
                tastyList = new ArrayList<>(); // 예외 발생 시 빈 리스트로 초기화
            }
        }
        return tastyList;
    }
	
	private static void fetchTastyList() throws SQLException {
        TastyRestaurantDAO trd = new TastyRestaurantDAO();
        tastyList = trd.listTasty();
        if (tastyList.isEmpty()) {
            throw new SQLException("저장된 맛집정보가 없습니다.");
        }
    }
	
	@Override
	public String toString() {
		return "Tastyrestaurant [tid=" + tid + ", restaurant_name=" + restaurant_name + ", food_category=" + food_category
				+ ", restaurant_ip=" + restaurant_ip + ", restaurant_menu=" + restaurant_menu + ", menu_price=" + menu_price
				+ ", restaurant_score=" + restaurant_score + ", restaurant_review=" + restaurant_review + ", tregdate="
				+ tregdate + "]";
	}
	
	
	
	
}
