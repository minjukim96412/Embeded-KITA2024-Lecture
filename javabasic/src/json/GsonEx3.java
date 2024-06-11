package json;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonEx3 {
	
	//실습 : 네트워크상의 JSON데이터(문자열)를 받아서 List로 변환 후 출력해 보기
	//https://jsonplaceholder.typicode.com/posts
	public static void main(String[] args) {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
				//URI 객체 생성
				URI uri = null;
				try {
					uri = new URI("https://jsonplaceholder.typicode.com/posts");
					URL url = uri.toURL();
					URLConnection conn = url.openConnection();
					if (conn != null) {
						System.out.println("연결되었습니다!");
						System.out.println(conn);
					}
					BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					String line = "";
					String jsonStr = "";
					while((line = br.readLine()) != null) {
						jsonStr += line;
					}
					
					List<Post> postList = gson.fromJson(jsonStr, List.class);
					System.out.println(postList);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			
	}
}
