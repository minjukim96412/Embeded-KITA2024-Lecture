/*
 * 개인과제
 * 과제명 : 배열로또
 * 제출마감일 : 5/6(화)
 * 과제설명 : 배열을 이용해서 로또 645 프로그램을 작성하세요.
 * 프로세스
 * 1. 프로그램 시작 시 사용자에게 7개의 서로 다른 1~45사이의 숫자를 입력 받는다.
 * 2. 프로그램에서 랜덤한 숫자를 순서대로 7개 추출
 * 3. 등수 산정
 * 	-프로그램에서 추출한 6개와 사용자가 입력한 순서대로 6개가 일치하면 1등
 * 	-프로그램에서 추출한 6개와 사용자가 입력한 순서대로 5개가 일치하고 보너스 숫자(맨마지막 입력)가 일치하면 2등
 * 	-프로그램에서 추출한 5개와 사용자가 입력한 순서대로 5개가 일치하면 3등
 * 	-프로그램에서 추출한 4개와 사용자가 입력한 순서대로 5개가 일치하면 4등
 * 	-프로그램에서 추출한 3개와 사용자가 입력한 순서대로 5개가 일치하면 5등
 * 	-나머지는 "꽝! 다음기회에"
 * 
 * 4. 예시
 * 
 * 사용자가 1 1 2 3 4 5 6 입력시 => 중복 숫자가 있습니다. 다시 입력해 주세요!
 * 사용자가 1 2 3 4 5 6 7 입력하고 랜덤숫자가  1 2 3 4 5 6 45 => 1등
 * 사용자가 1 2 3 4 5 6 7 입력하고 랜덤숫자가  1 2 3 4 5 45 7 => 2등
 * 사용자가 1 2 3 4 5 6 7 입력하고 랜덤숫자가  1 2 3 4 5 33 44 => 3등
 * 사용자가 1 2 3 4 5 6 7 입력하고 랜덤숫자가  1 2 3 4 22 33 44 => 4등
 * 사용자가 1 2 3 4 5 6 7 입력하고 랜덤숫자가  1 2 3 11 22 33 44 => 5등
 * 사용자가 1 2 3 4 5 6 7 입력하고 랜덤숫자가  10 20 30 40 15 16 45 => 꽝
 * 
 * 5. 주요 고려사항
 * - 사용자가 입력한 7개의 숫자에 중복이 있는지 체크, 중복이 있다면 다시 입력
 * -프로그램에서 랜덤하게 생성한 7개의 숫자에 중복이 없어야 한다.
 * 사용자 입역수와 랜덤수와 비교해서 등수 연산 후 출력
 * 
 * 
 * 6.과제 제출 방법
 * 소스코드(java파일)과 실행ㄱ결과를 캡쳐이미지로 압축해서 realchoky@naver.com으로 이름써서 제출
 * */


package javabasic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class ArrayLotto {
	public static void main(String[] args) {
		
//		Math.random() : 0.0<=랜덤실수<1.0
//		int numRandom =(int)(Math.random()*45)+1;//1~45 랜덤

		Scanner sc = new Scanner(System.in);
		int[] arr1 = new int[6];
		int bonus = (int)(Math.random()*45)+1;
		int arr1Leng = arr1.length;
	
			for (int i = 0; i < arr1Leng; i++) {
				arr1[i]=(int)(Math.random()*45)+1;
					for (int k = 0; k <  arr1Leng; k++) {
						if (i!=k && arr1[i] == arr1[k]) {
							while(arr1[i] == arr1[k]) {
							arr1[i]=(int)(Math.random()*45)+1;
							}
						}
					}	
				if (arr1[i] == bonus){
					while(arr1[i] == bonus) {
						bonus=(int)(Math.random()*45)+1;
						}
				}				
//				System.out.printf("%3d", arr1[i]);
				}
			
//			System.out.println(" 보너스볼 :" + bonus);
				
			Arrays.sort(arr1);
			
			for (int i = 0; i < arr1Leng; i++) {
//				System.out.printf("%3d", arr1[i]);
			}
			
//			System.out.println(" 보너스볼 :" + bonus);
					
			System.out.println("숫자 6개를 입력하세요");
				
			int[] choiceArray = new int[6];
			int choiceLeng = choiceArray.length;
			for (int i = 0; i < arr1Leng; i++) {
				int choice = sc.nextInt();
				choiceArray[i] = choice;
			}
			
			Arrays.sort(choiceArray);
			
			for (int j = 0; j < choiceLeng; j++) {
				
				System.out.printf("%3d", choiceArray[j]);
			}
			System.out.println();
			
			int correct = 0;
			for (int i = 0; i < choiceLeng; i++) {
				for (int j = 0; j < choiceArray.length; j++) {	
					if(arr1[i] == choiceArray[j]) {
						correct++;
					}				
				}
				System.out.println(correct);
			}
			
			if(correct == 0 || correct == 1 || correct == 2) {
				System.out.println("꽝! 다음기회에");
			}else if(correct == 3) {
				System.out.println("축하합니다! 5등에 당첨되셨습니다!");
			}else if(correct == 4) {
				System.out.println("축하합니다! 4등에 당첨되셨습니다!");
			}else if(correct == 6) {
				System.out.println("축하합니다! 1등에 당첨되셨습니다!");
			}
			int bonusNum = 0;
			for (int i = 0; i < choiceLeng; i++) {
					if(choiceArray[i] == bonus) {
						bonusNum = i;
					}		
			}
			
			if(correct == 5 ) {
				if(choiceArray[bonusNum] == bonus) {
				System.out.println("축하합니다! 2등에 당첨되셨습니다!");
				}else {
					System.out.println("축하합니다! 등에 당첨되셨습니다!");
				}
			}

			
	}//main
}//class
