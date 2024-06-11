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
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;

public class GsonEx6 {
	public static void main(String[] args) {
		
		 try {
	            Gson gson = new GsonBuilder().setPrettyPrinting().create();
	            URI uri = new URI("https://www.daegufood.go.kr/kor/api/tasty.html?mode=json&addr=%EC%A4%91%EA%B5%AC");
	            URL url = uri.toURL();
	            URLConnection conn = url.openConnection();

	            if (conn != null) {
	                System.out.println("연결됨!");
	            }

	            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	            StringBuilder jsonStrBuilder = new StringBuilder();
	            String line;

	            while ((line = br.readLine()) != null) {
	                jsonStrBuilder.append(line);
	            }

	            String jsonStr = jsonStrBuilder.toString();
	            
            
	            // JSON 문자열을 객체로 파싱
	            LinkedTreeMap<String, Object> jsonObject = gson.fromJson(jsonStr, LinkedTreeMap.class);
	            
	            // JSON 구조를 출력하여 확인
//	            System.out.println(gson.toJson(jsonObject));

	            // "data" 키를 통해 데이터 추출
	            Object listObject = jsonObject.get("data");
//	            System.out.println(listObject);
	            if (listObject instanceof List) {
	                List<LinkedTreeMap<String, Object>> daegueList = (List<LinkedTreeMap<String, Object>>) listObject;
	                for (int i = 0; i < daegueList.size(); i++) {
	                    LinkedTreeMap<String, Object> daegue1 = daegueList.get(i);
	                    for (Map.Entry<String, Object> entry : daegue1.entrySet()) {
	                        String key = entry.getKey();
	                        Object value = entry.getValue();
	                        System.out.println(key + ": " + value);
	                    }
	                    System.out.println("-----------------------------");
	                }
	            } 

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
	}//main
}//class
