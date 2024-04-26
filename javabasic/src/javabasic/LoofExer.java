package javabasic;

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
		


		
		
		
	}
}
