package javabasic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListLinkedList {
	//속도 비교
	public static void main(String[] args) {
		List<String> al = new ArrayList<String>();
		List<String> ll = new LinkedList<String>();
		
		long alStartTime = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			al.add("ArrayList" + i);
		}
		long alEndTime = System.currentTimeMillis();
		
		long alStartTime2 = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			System.out.println(al.get(i));
		}
		long alEndTime2 = System.currentTimeMillis();
		
		
		long llStartTime = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			ll.add("LinkedList" + i);
		}
		long llEndTime = System.currentTimeMillis();
		
		long llStartTime2 = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			System.out.println(ll.get(i));
		}
		long llEndTime2 = System.currentTimeMillis();
		System.out.println("ArrayList add : " + (alEndTime - alStartTime));
		System.out.println("ArrayList get : " + (alEndTime2 - alStartTime2));
		System.out.println("LinkedList add : " + (llEndTime - llStartTime));
		System.out.println("LinkedList add : " + (llEndTime2 - llStartTime2));

	}//main
	
}//class
