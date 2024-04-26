package javabasic;

import java.util.Scanner;

public class Condition {
	
	public static void main(String[] args) {
		
		//if 문
		int i = 15;
		
		if (i < 10) {
			System.out.println("i가 10보다 작습니다!");	
		} else if (i == 15) {
			System.out.println("i는 15입니다!");
		} 
		else {
			System.out.println("i가 10보다 작지 않고 15가 아닙니다!");
		}
		
		System.out.println("-------------------");
		
		//switch 문
		int j = 1;
		
		switch (j) {
		case 1: {
			System.out.println("남성입니다!");
			break;
			}
		case 2: {
			System.out.println("여성입니다!");
			break;
			}
		default : {
			System.out.println("남성도 여성도 아닙니다!");
			break;
			} 
		}
	
		System.out.println("--------------------");
		
		int h = 2;
	
		if (h == 1) {
			System.out.println("남성입니다!");
		} else if (h == 2) {
			System.out.println("여성입니다!");
		} else {
			System.out.println("남성도 여성도 아닙니다!");
		}
	
		
	}//main
		
}//class
