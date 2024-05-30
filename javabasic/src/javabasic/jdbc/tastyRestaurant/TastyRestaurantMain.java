package javabasic.jdbc.tastyRestaurant;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javabasic.jdbc.Board;
import javabasic.jdbc.ConnectionUtil;
import javabasic.jdbc.guest.Guest;
import javabasic.jdbc.guest.GuestDao;

public class TastyRestaurantMain {

	Connection conn;
	CallableStatement cstmt;
	
	public TastyRestaurantMain() {
		conn = ConnectionUtil.getConnection();
	}
	
	public static void main(String[] args) {
		TastyRestaurantMain trm = new TastyRestaurantMain();
		String sql = 
		" { call PROC_INSERT_TASTY(?, ?, ?, ?, ?, ?, ?) } ";
		
		try {
			trm.cstmt = trm.conn.prepareCall(sql);
			trm.cstmt.setString(1, "dlfma");
			trm.cstmt.setString(2, "야식");
			trm.cstmt.setString(3, "주소1");
			trm.cstmt.setString(4, "메뉴1");
			trm.cstmt.setInt(5, 10000);
			trm.cstmt.setDouble(6, 4.5);
			trm.cstmt.setString(7, "내용1");
			
			int result = trm.cstmt.executeUpdate();
			if (result > 0) {
				System.out.println("한 행 입력 완료!");
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		
		List<TastyRestaurant> tastyList = null;
		try {
			TastyRestaurantDAO trd = new TastyRestaurantDAO();
			tastyList = trd.listTasty();
			for (TastyRestaurant tastyRestraint : tastyList) {
				System.out.println(tastyRestraint);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

		
		

		
		
		
	}
	
	
	
	
}
