package javajdbc;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URLConnection;
import java.sql.Connection;
import java.util.List;

public class JDBCExer {
	
	public static void main(String[] args) {
		Connection conn = ConnectionUtil.getConnection();
		
		
	}
	
	
	//데이터 가져오기
	private String getData(String uri) {
		URLConnection urlc = new URI(uri).toURL().openConnection();
		BufferedReader br =
				new BufferedReader(new InputStreamReader(urlc.getInputStream()));
		String
	     
	     conn = url.openConnection();
		
		return null;
	}
	
	//데이터 입력
	private int insertData(List<UserInfo> uiList) {
		return 0;
	}
	//데이터 출력
		private void listData() {
			
	}
}

