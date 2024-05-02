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
 * 소스코드(java파일)과 실행결과를 캡쳐이미지로 압축해서 realchoky@naver.com으로 이름써서 제출
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
		int bonus = (int) (Math.random() * 45) + 1;
		int arr1Leng = arr1.length;
		
		
		while(true) {
		// 랜덤 숫자 6자리 겹치지않게 만들기
		for (int i = 0; i < arr1Leng; i++) {
			arr1[i] = (int) (Math.random() * 45) + 1;
			for (int k = 0; k < arr1Leng; k++) {
				if (i != k && arr1[i] == arr1[k]) {
					while (arr1[i] == arr1[k]) {
						arr1[i] = (int) (Math.random() * 45) + 1;
					}
				}
			}
			// 보너스 볼은 따로 겹치지않게 하나 만들기
			if (arr1[i] == bonus) {
				while (arr1[i] == bonus) {
					bonus = (int) (Math.random() * 45) + 1;
				}
			}
		}


		Arrays.sort(arr1);// 배열 오름차순 정렬

//			for (int i = 0; i < arr1Leng; i++) {
//				System.out.printf("%3d", arr1[i]);
//			}

//			System.out.println(" 보너스볼 :" + bonus);
		System.out.println("추첨 번호 : " + Arrays.toString(arr1) + " 보너스볼 :" + bonus);//로또 검증
		
		System.out.println();
		System.out.println("숫자 6개를 입력하세요");

		int[] choiceArray = new int[6];
		int choiceLeng = choiceArray.length;

		for (int i = 0; i < arr1Leng; i++) {
			int choice = sc.nextInt();
			choiceArray[i] = choice;
		}
		for (int i = 0; i < arr1Leng; i++) {
			for (int j = 0; j < choiceArray.length; j++) {
				if (i != j && choiceArray[i] == choiceArray[j]) {
					System.out.println("같은 숫자를 입력하셨습니다.다시 입력해 주세요");
					int choice1 = sc.nextInt();
					choiceArray[i] = choice1;
				}
				if(choiceArray[i] < 1 || choiceArray[i] > 45) {
					System.out.println("숫자를 잘못 입력하셨습니다. 1 ~ 45 숫자 중에서 "
							+ "다시 입력해 주세요");
					int choice1 = sc.nextInt();
					choiceArray[i] = choice1;
				}
			}
		}

		Arrays.sort(choiceArray);
		System.out.println("입력하신 숫자 : " + Arrays.toString(choiceArray));

		int correct = 0;
		for (int i = 0; i < choiceLeng; i++) {
			for (int j = 0; j < choiceArray.length; j++) {
				if (arr1[i] == choiceArray[j]) {
					correct++;
				}
			}
//			System.out.println(correct); //카운트 검증
		}

		System.out.println("추첨 번호 : " + Arrays.toString(arr1) + " 보너스볼 :" + bonus);
		
		if (correct == 0 || correct == 1 || correct == 2) {
			System.out.println("꽝! 다음기회에");
		} else if (correct == 3) {
			System.out.println("축하합니다! 5등에 당첨되셨습니다!");
		} else if (correct == 4) {
			System.out.println("축하합니다! 4등에 당첨되셨습니다!");
		} else if (correct == 6) {
			System.out.println("축하합니다! 1등에 당첨되셨습니다!");
		}
		int bonusNum = 0;
		for (int i = 0; i < choiceLeng; i++) {
			if (choiceArray[i] == bonus) {
				bonusNum = i;
			}
		}

		if (correct == 5) {
			if (choiceArray[bonusNum] == bonus) {
				System.out.println("축하합니다! 2등에 당첨되셨습니다!");
			} else {
				System.out.println("축하합니다! 3등에 당첨되셨습니다!");
			}
			
		}
		}//while
	}// main
}// class
