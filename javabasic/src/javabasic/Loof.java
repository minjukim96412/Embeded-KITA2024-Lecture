package javabasic;

import java.util.ArrayList;
import java.util.List;

public class Loof {
	public static void main(String[] args) {
//		
//	for (int i = 0; i < 11; i++) {
//		System.out.println(i);
//	}	
//		
//	System.out.println("--------------------");
//	//실습 1) 11부터 33까지 반복해서 출력
//	
//	for (int j = 11; j <= 33; j++) {
//		System.out.println(j);
//	}
//	
//	System.out.println("----------------------");
//	//실습 2) 15부터 30까지 홀수만 출력
//	
////	for (int i = 15; i <= 30; i++) {
////		if (i % 2 != 0) {
////			System.out.println(i);
////		}
////	}
//
//	for (int i = 15; i < 31; i = i+2) {
//		System.out.println(i);
//	}
//	
//	System.out.println("----------------------");
//	
//	//실습3 3부터 100까지 3의 배수만 출력
//	
//	for (int i = 3; i < 101; i = i+3) {
//		System.out.println(i);
//	}
//	
//	System.out.println("----------------------");
//	//실습 4) 1부터 1000까지 정수 중에서 5나 7로 나누어 떨어지는 수 출력
//	
//	for (int i = 1; i <= 1000; i++) {
//		if (i % 5 == 0 || i % 7 == 0) {
//			System.out.println(i);
//		}
//	}
//	System.out.println("----------------------");
//	
//	//실습 5) 1부터 1000까지 소수만 출력 (1과 자기자신으로만 나누어 떨어지는 수)만 출력
//	
//	for (int i = 1; i <= 1000; i++) {
//		if(isprime(i)) {
//			System.out.println(i);
//		}
//	}
//	System.out.println("----------------------");
//	for (int i = 2; i <= 1000; i++) {
//		for (int j = 2; j <= i; j++) {
//			if(i % j == 0){
//				if(i != j){
//					break;
//				}	
//				System.out.println(i);
//			}
//		}
//		
//	}
//	
	//enhanced for
	int[] intArray = {10, 20, 30, 40};
	for(int i : intArray) {
		System.out.println(i);
	}
	
	for (int i = 0; i < intArray.length; i++) {
		System.out.println(intArray[i]);
	}
	
	List<String> strList = new ArrayList<String>();
	strList.add("홍길동");
	strList.add("강감찬");
	strList.add("유관순");
	for(String str : strList) {
		System.out.println(str);
	}
	
	for (int i = 0; i < strList.size(); i++) {
		System.out.println(strList.get(i));
	}
	
	int k = 10;
	while (k < 100) {
		System.out.println(k);
		k++;
	}
	
	int l = 1;
	while(1<100) {
		if(l==50)break;
		l++;
		if(l % 2 == 0) continue;
	System.out.println(l);
		
	}
	System.out.println("--------------------");
	// 실습 1) while 문을 사용하여 10부터 100까지의 정수 중에서 3의 배수만 출력
	
//	int printNum = 10;
//	while(printNum < 101) { 
//		if(printNum % 3 == 0) {
//			System.out.println(printNum);
//		}
//		printNum++;
//	}
	
	System.out.println("------------------------");
	// 실습 2) while 문을 사용하여 10부터 100까지의 정수 중에서 3의 배수이지만
	//		6의 배수는 아닌 수들만 출력
	
//	int printNum2 = 10;
//	
//	while(printNum2 < 101) { 
//		if(printNum2 % 3 == 0) {
//			if(printNum2 % 6 != 0) 
//			System.out.println(printNum2);
//		}
//		printNum2++;
//	}
//	
	//실습 3) while문을 사용해서 10부터 100까지의 정수 중에서 3의 배수가 아닌것들 출력
	int printNum = 9;
	while(printNum < 100) { 
		printNum++;			
		if(printNum % 3 == 0) continue;
			System.out.println(printNum);
	}
	
	int i = 1;
	do {
		System.out.println(i);
		i++;
	}while(i<10);
	
	}// main
	static boolean isprime(int n) {
		if(n==1) return true;
		for(int i = 2; i <n; i++) {
			if(n % i == 0)return false;
		}
		return true;
	}
}// class
