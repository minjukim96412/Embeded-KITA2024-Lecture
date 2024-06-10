package json;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//실습: 네트워크상에서 JSON데이터(문자열)를 받아서 객체로 변환 후 출력
//https://jsonplaceholder.typicode.com/posts/1

public class GsonEx4 {
	public static void main(String[] args) throws Exception {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		URI uri = new URI("https://jsonplaceholder.typicode.com/posts/1");
		URL url = uri.toURL();
		URLConnection conn =url.openConnection();
		if (conn != null) {
			System.out.println("연결됨!");
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line = "";
		String jsonStr = "";
		while((line = br.readLine()) != null) {
			jsonStr += line;
		}
		
		Post post = gson.fromJson(jsonStr, Post.class);
		System.out.println(post);
	}//main
}//class
