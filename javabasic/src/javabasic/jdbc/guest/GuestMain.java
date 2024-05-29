package javabasic.jdbc.guest;

import java.sql.Connection;
import java.util.List;

import javabasic.jdbc.ConnectionUtil;

public class GuestMain {
	
	public static void main(String[] args) throws Exception{
		
		GuestDao guestDao = new GuestDao();
		
		
			Guest guest = new Guest(7,"장보고", 30, "M", "999999-9999999", null);
			int result = guestDao.insertGuest(guest);
			if (result > 0) {
				System.out.println("등록 완료!");
			}
		
		//수정
			
			//삭제
			
			//목록
			
			
			
			
			//한행조회
			
			
	}//main
	
}//class
