/*
 * 예외처리 실습
 * 
 * 보험사고 발생시에 사고별 대응하는 프로그램 
 * 1.사고유형 : 정면충돌사고,후면충돌사고,접촉사고
 * 2.정면충돌사고시에는 경찰서와 119구급대에 연락
 * 3.후면충돌사고시에는 보험직원을 파견
 * 4.접촉사고시에는 보험가입자와 전화상담
 * 정면충돌사고:후면충돌사고:접촉사고 비율은 1:3:6
 * 	(Math.random으로 1~10 이용, 1=정면, 2~4=후면 5~10=접촉)
 * 
 * 5.뺑소니 사고시에는 경찰서에 대리전화: 11 추가하기
 * 
 * 사용자정의 예외를 생성해서 예외처리를 통해서 구현
 * 
*/


package javabasic;

public class ExceptionExer {
	
	public static final String FRONT_ACC = "정면충돌";
	public static final String BACK_ACC = "후면충돌";
	public static final String CONT_ACC = "접촉사고";
	public static final String HIT_AND_RUN_ACC = "뺑소니";
	

	public static void main(String[] args) {
		for (int i = 0; i < 11; i++) {
			int ran = (int)(Math.random()*11)+1;
			
			try {
			if(ran == 1){
				//정면 충돌
				throw new FrontException();
			}else if(ran > 1 && ran <= 4) {
				//후면 충돌
				throw new BackException();
			}else if(ran > 4 && ran <= 10 ) {
				//접촉사고
				throw new ContException();
			}else {
				throw new HitAndRunException();
					}
			}catch(Exception ex) {
//				if(ex instanceof FrontException) {
//					System.out.println(ex.getMessage() + "정면충돌 처리 완료!");
//				}
//				if(ex instanceof BackException) {
//					System.out.println(ex.getMessage() + "후면충돌 처리 완료!");
//				}
//				if(ex instanceof ContException) {
//					System.out.println(ex.getMessage() + "접촉사고 처리완료!");
//				}
//				if(ex instanceof HitAndRunException) {
//					System.out.println(ex.getMessage() + "뺑소니 처리완료!");
//				}
				String msg= "";
				if(ex instanceof FrontException) {
					msg = "정면충돌 처리 완료!";
				}
				if(ex instanceof BackException) {
					msg = "후면충돌 처리 완료!";
				}
				if(ex instanceof ContException) {
					msg = "접촉사고 처리완료!";
				}
				if(ex instanceof HitAndRunException) {
					msg = "뺑소니 처리완료!";
				}
				System.out.println(ex.getMessage() + msg);
			}

		}	
	}//main
}//class
