-- java프로젝트
-- java,JDBC, Oracle데이터베이스를 활용한 프로젝트 만들기
-- 주제 : 맛집리스트 만들기
-- 가게이름  음식카테고리 주소 주요메뉴 메뉴가격 별점(5점 만점 기준 ) 한줄후기
-- 카테고리별로 리스트 조회기능
-- 가능하면  gui만들어서 데이터 넣어보기

CREATE TABLE TASTY_RESTRAINT_LIST(
   TID NUMBER PRIMARY KEY, 
	RESTRAINT_NAME VARCHAR2(50) NOT NULL ENABLE,
	FOOD_CATEGORY VARCHAR2(20), 
	RESTRAINT_IP VARCHAR2(100), 
	RESTRAINT_MENU VARCHAR2(100), 
	MENU_PRICE NUMBER,
	RESTRAINT_SCORE NUMBER CHECK (RESTRAINT_SCORE BETWEEN 0 AND 5),
	RESTRAINT_REVIEW VARCHAR2(50), 
	BREGDATE TIMESTAMP
	);
	
CREATE SEQUENCE SEQ_TASTY_RESTRAINT_LIST;

