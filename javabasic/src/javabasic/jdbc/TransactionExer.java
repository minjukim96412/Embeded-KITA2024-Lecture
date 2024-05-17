package javabasic.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionExer {
	
	public static void main(String[] args) {
		
		Connection conn = ConnectionUtil.getConnection();
		
		try {
			//1. 쿼리문마다 커밋되는 것을 방지
			if(conn != null) {
			conn.setAutoCommit(false);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
	}
	
}
