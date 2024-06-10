package json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonEx1 {
	public static void main(String[] args) {
		
		Gson gson1 = new Gson();
		Gson gson2 = new GsonBuilder().create();
		Gson gson3 = new GsonBuilder().setPrettyPrinting().create();
		
		
		//Map 객체를 Json 문자열로
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "유관순");
		map.put("age", "20");
		map.put("gender", "femail");
		String mapStr = gson3.toJson(map);
		System.out.println(mapStr);
		
		//Json 문자열을 Map객체로 
		String jsonStr3 = "{\"name\":\"홍길동\", \"age\":\"30\"}";
		Map<String, String> map2 = gson3.fromJson(jsonStr3, Map.class);
		for(Map.Entry<String, String> entry : map2.entrySet()) {
			System.out.println(entry.getKey()+"="+entry.getValue());
		} 
		
		//List 객체를 
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person("홍길동", 30));
		personList.add(new Person("강감찬", 40));
		personList.add(new Person("이순신", 50));
		String jsonStr4 = gson3.toJson(personList);
		
		
	}//main
}//class
