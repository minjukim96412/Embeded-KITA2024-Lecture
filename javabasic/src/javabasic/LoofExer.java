package javabasic;

import java.util.Iterator;

public class LoofExer {

	public static void main(String[] args) {
		
		// 별찍기 1
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		// 별찍기 2
		//    *
		//   **
		//  ***
		// ****
		//*****
		
		for (int i = 0; i < 5; i++) {
				for (int k = 0; k < 4-i; k++) {
					System.out.print(" ");
				}
				for (int j = 0; j <= i; j++) {
						System.out.print("*");
				}
			System.out.println(" ");
		}
		
		// 별찍기 3
		//*****
		//****
		//***
		//**
		//*
		
		System.out.println();
		for (int i = 0; i < 6; i++) {
			for (int k = 0; k < 5-i; k++) {
				System.out.print("*");
			}
			for (int j = 0; j <= i; j++) {
					System.out.print(" ");
			}
		System.out.println(" ");
		}
		
		// 별찍기 4
		//*****
		//*	  *	
		//*	  *	
		//*	  *	
		//*****
		
		System.out.println()
		;
		
		for (int i = 0; i <5; i++) {
			for (int j = 0; j < 5; j++) {
				if (i % 4 == 0 || j % 4 == 0) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}	
			}
			System.out.println();
		}
		
		// 별찍기 5
		//***** 
		//** **	
		//*	* *	
		//** **	
		//*****
		
		System.out.println();
		
		for (int i = 0; i <5; i++) {
			for (int j = 0; j < 5; j++) {
				if (i % 4 == 0 || j % 4 == 0 || i==j || i*j == 3) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}	
			}
			System.out.println();
		}
		
		// 별찍기 6
		//***** 
		//   *	
		// 	* 	
		// * 	
		//*****
		System.out.println();
		
		int keyNum = 10;
		
		for (int i = 0; i < keyNum+1; i++) {
			for (int j = 0; j < keyNum+1; j++) {
				if (i == 0 || i == keyNum || i+j == keyNum) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
		
		
		// 별찍기 7
		//*   * 
		//*   *
		//*****	
		//*   *	
		//*   *
		
		System.out.println();
		
		
		for (int i = 0; i < keyNum+1; i++) {
			for (int j = 0; j < keyNum+1; j++) {
				if (j % keyNum == 0 || i == (keyNum/2)) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}	
			}
			System.out.println();
		}
		
		// 별찍기 7
		//  * 
		// ***   
		//*****	
		// ***	
		//  *
		System.out.println();

		
		for (int i = 0; i < keyNum+1; i++) {
			for (int j = 0; j < keyNum+1; j++) {
				
					if(i+j < keyNum/2) {
						System.out.print(" ");
					}else if (j-i > keyNum/2){
							System.out.print(" ");
					}else if (i-j > keyNum/2) {
							System.out.print(" ");
					} else if(i+j > keyNum+(keyNum/2)){
							System.out.print(" ");
					}else {
							System.out.print("*");
						}	
				}
				System.out.println();	
				}
	}
}

