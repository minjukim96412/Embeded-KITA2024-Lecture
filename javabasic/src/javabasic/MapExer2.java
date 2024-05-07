package javabasic;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class MapExer2 {
	public static void main(String[] args) {
		
		Aticle a1 = new Aticle(1, "제목1", "내용1", "작성자1"
				, new Timestamp(System.currentTimeMillis()));
		Aticle a2 = new Aticle(2, "제목2", "내용2", "작성자2"
				, new Timestamp(System.currentTimeMillis()));
		Aticle a3 = new Aticle(3, "제목3", "내용3", "작성자3"
				, new Timestamp(System.currentTimeMillis()));
		
		Map<Integer, Aticle> aMap = new HashMap<Integer, Aticle>();
		aMap.put(a1.getBno(), a1);		
		aMap.put(a2.getBno(), a2);		
		aMap.put(a3.getBno(), a3);
		
		System.out.println(aMap.get(a2.getBno()));
	}//main
}//class
