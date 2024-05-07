package javabasic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListExer {
	public static void main(String[] args) {
		
	List<String> fruitList = new ArrayList<String>();//empty List
	fruitList.add("오렌지");
	fruitList.add("사과");
	fruitList.add("포도");
	fruitList.add("복숭아");
	fruitList.add("딸기");
	
	System.out.println(fruitList.size());//5개인걸 알 수 있음
	
	fruitList.set(1, "바나나");
	
	fruitList.remove(4);
	fruitList.remove("복숭아");
	
	System.out.println(fruitList.size());//값이 몇개 있는지
	
	System.out.println(fruitList.contains("포도")); //리스트안에 포도가 있는지 확인
	
	System.out.println(fruitList.get(1));
	
	Iterator<String> iter = fruitList.iterator();//모여있는애들을 반복시킴
	while(iter.hasNext()) {
		String str = iter.next();
		System.out.println(str);
	}
	
	int listSize = fruitList.size();
	for (int i = 0; i < listSize; i++) {
		System.out.println(fruitList.get(i));
	}
	
	fruitList.forEach(e -> System.out.println(e));
	
	
	fruitList.clear();
	System.out.println(fruitList.size());
	}//main
}//class
