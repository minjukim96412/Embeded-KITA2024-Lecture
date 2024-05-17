package javabasic.jdbc;

import java.sql.SQLException;

public class TranSactionExer {
public static void main(String[] args) {
		
		BoardMain bm = new BoardMain();	
	
		try {
			//1. 쿼리문마다 커밋되는 것을 방지
			if(bm.conn != null) {
				bm.conn.setAutoCommit(false);
			}
			
			Board board1 = new Board(0, "제목1", "내용1", null);
			bm.insertBoard(board1);
			
			Board board2 = new Board(1, "제목2", "내용2", null);
			bm.insertBoard(board2);
			
			Board board3 = new Board(2, "수정된제목2", "수정된내용2", null);
			bm.updateBoard(board3);
			
			bm.conn.commit();
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (ArithmeticException ae) {
			ae.printStackTrace();
			try {
				bm.conn.rollback();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		
	}
	
}
