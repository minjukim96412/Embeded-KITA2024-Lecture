package javabasic.jdbc.tastyRestraint;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javabasic.jdbc.ConnectionUtil;
import javabasic.jdbc.guest.Guest;

public class TastyRestraintDAO {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public TastyRestraintDAO() throws SQLException{
		conn = javabasic.jdbc.tastyRestraint.ConnectionUtil.getConnection();
	}
	
	public List<TastyRestraint> listTasty() throws SQLException{
		String sql = " SELECT TID, RESTRAINT_NAME, FOOD_CATEGORY,"
				+ " RESTRAINT_IP, RESTRAINT_MENU, MENU_PRICE, "
				+ "RESTRAINT_SCORE, RESTRAINT_REVIEW, TREGDATE  "
				+ " FROM TASTY_RESTRAINT_LIST ";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<TastyRestraint> tastyList = new ArrayList<TastyRestraint>();
		while (rs.next()) {
			TastyRestraint tastyRestraint = new TastyRestraint();
			tastyRestraint.setTid(rs.getInt("TID"));
			tastyRestraint.setRestraint_name(rs.getString("RESTRAINT_NAME"));
			tastyRestraint.setFood_category(rs.getString("FOOD_CATEGORY"));
			tastyRestraint.setRestraint_ip(rs.getString("RESTRAINT_IP"));
			tastyRestraint.setRestraint_menu(rs.getString("RESTRAINT_MENU"));
			tastyRestraint.setMenu_price(rs.getInt("MENU_PRICE"));
			tastyRestraint.setRestraint_score(rs.getInt("RESTRAINT_SCORE"));
			tastyRestraint.setRestraint_review(rs.getString("RESTRAINT_REVIEW"));
			tastyRestraint.setTregdate(rs.getTimestamp("TREGDATE"));		
			tastyList.add(tastyRestraint);
		}
		return tastyList;
	}
	
}//TastyRestraintDAO
