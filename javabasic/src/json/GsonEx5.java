package json;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;

public class GsonEx5 {
	public static void main(String[] args) throws Exception {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		URI uri = new URI("http://localhost:8888/Jsonserver/json.jsp");
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
		
		List<LinkedTreeMap> personList = gson.fromJson(jsonStr, List.class);
		for (int i = 0; i < personList.size(); i++) {
			
		LinkedTreeMap<String, Object> person1 = personList.get(0);
			for (Map.Entry<String, Object> entry : person1.entrySet()) {
				String key = entry.getKey();
				Object value = entry.getValue();
				System.out.println(key);
				System.out.println(value);
			}
		}
		
		
		
		
	}//main
}//class
