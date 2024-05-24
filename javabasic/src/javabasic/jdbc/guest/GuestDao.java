package javabasic.jdbc.guest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javabasic.jdbc.ConnectionUtil;

public class GuestDao {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public GuestDao() throws SQLException{
		conn = ConnectionUtil.getConnection();
	}
	//리스트 조회
	public List<Guest> listGuest() throws SQLException{
		String sql = " select gno,gname, gage, ggender, gsid, gcount from guest order by gno desc ";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<Guest> guestList = null;
		while (rs.next()) {
			Guest guest = new Guest(
					rs.getInt("gno"),
					rs.getString("gname"),
					rs.getInt("gage"),
					rs.getString("ggender"),
					rs.getString("gsid"),
					rs.getTimestamp("gcount")
					);
			guestList.add(guest);
		}
		return guestList;
	}
	
	//한행 조회
	public Guest getGuest(int gNo) throws SQLException{
		String sql = " select gno,gname, gage, ggender, gsid, gcount ";
		sql += "from guest order by gno desc";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, gNo);
		rs = pstmt.executeQuery();
		Guest guest = null;
		while (rs.next()) {
			guest = new Guest(
					rs.getInt("gno"),
					rs.getString("gname"),
					rs.getInt("gage"),
					rs.getString("ggender"),
					rs.getString("gsid"),
					rs.getTimestamp("gcount")
					);
		}
		return guest;
	}
	
	//등록
	public int insertGuest(Guest guest) throws SQLException{
		String sql = " insert into guest values(seq_guest.nextval, ?, ?, ?,?,sysdate) ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, guest.getgName());
		pstmt.setInt(2, guest.getgAge());
		pstmt.setString(3, guest.getgGender());
		pstmt.setString(4, guest.getGsid());
		return pstmt.executeUpdate();
	}
	
	public int updateGuest(Guest guest) throws SQLException{
		String sql = " update guest set gName=?, gAge=?, gGender=?, gsid=? where gno=? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, guest.getgName());
		pstmt.setInt(2, guest.getgAge());
		pstmt.setString(3, guest.getgGender());
		pstmt.setString(4, guest.getGsid());
		pstmt.setInt(5, guest.getgNo());
		return pstmt.executeUpdate();

	}
	
	public int deleteGuest(int gNo) throws SQLException{
		String sql = " delete from guesst where gno=? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, gNo);
		return pstmt.executeUpdate();
	}
}
