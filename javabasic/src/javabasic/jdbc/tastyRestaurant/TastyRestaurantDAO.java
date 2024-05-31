package javabasic.jdbc.tastyRestaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import javabasic.jdbc.ConnectionUtil;

public class TastyRestaurantDAO {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String columnName;
	Object newData;
	int id;
	public TastyRestaurantDAO() throws SQLException{
		conn = ConnectionUtil.getConnection();
	}
	
	public List<TastyRestaurant> listTasty() throws SQLException{
		String sql = " SELECT TID, Restaurant_NAME, FOOD_CATEGORY,"
				+ " Restaurant_IP, Restaurant_MENU, MENU_PRICE, "
				+ "Restaurant_SCORE, Restaurant_REVIEW, TREGDATE  "
				+ " FROM TASTY_Restaurant_LIST ORDER BY TID";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<TastyRestaurant> tastyList = new ArrayList<TastyRestaurant>();
		while (rs.next()) {
			TastyRestaurant tastyRestaurant = new TastyRestaurant();
			tastyRestaurant.setTid(rs.getInt("TID"));
			tastyRestaurant.setRestaurant_name(rs.getString("Restaurant_NAME"));
			tastyRestaurant.setFood_category(rs.getString("FOOD_CATEGORY"));
			tastyRestaurant.setRestaurant_ip(rs.getString("Restaurant_IP"));
			tastyRestaurant.setRestaurant_menu(rs.getString("Restaurant_MENU"));
			tastyRestaurant.setMenu_price(rs.getInt("MENU_PRICE"));
			tastyRestaurant.setRestaurant_score(rs.getDouble("Restaurant_SCORE"));
			tastyRestaurant.setRestaurant_review(rs.getString("Restaurant_REVIEW"));
			tastyRestaurant.setTregdate(rs.getTimestamp("TREGDATE"));		
			tastyList.add(tastyRestaurant);
		}
		return tastyList;
	}//list
	
	int updateTasty()  throws SQLException {
		String sql = "UPDATE TASTY_RESTAURANT_LIST SET " + columnName + " = ? WHERE tid = ?";
		pstmt = conn.prepareStatement(sql);
	    pstmt.setObject(1, newData);
	    pstmt.setInt(2, id);
	    return pstmt.executeUpdate();
    }
	
 // 게시물 삭제
 	int deleteTasty(TastyRestaurant tastyRestaurant) throws SQLException {
 		String sql = " delete TASTY_RESTAURANT_LIST where TID=? ";
 		pstmt = conn.prepareStatement(sql);
 		pstmt.setInt(1, tastyRestaurant.getTid());
 		return pstmt.executeUpdate();
 	}

 	
 	
 	
 	
}//TastyRestaurantDAO
