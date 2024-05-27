--5/24 금 오후 실습 

--[SYSTEM 게정 접속]

--1.테이블 스페이스 생성
--테이블스페이스명: GUEST_TABLESPACE
--데이터파일 : D:ORACLE/GUEST_TABLESPACE.DBF
-- 		   		기본용량 : 100M, 기본용량 초과시 10M증가, 최대용량 제한 없음

--2. 사용자 생성
--	아이디: GUEST, 비밀번호 : 1234
--	권한(롤): CONNECT, RESOURCE
--	테이블스페이스 : GUEST_TABLESPACE


-- [GUEST 계정 접속]
--
--1. 테이블 생성
--	테이블명: GUEST
--	컬럼 : 번호 GNO(PK), 이름 GNAME(NOTNULL), 나이 GAGE(1~150)
--			,성별 GGENDER(M또는F), 주민번호 GSID(UNIQUE), 접속일시 GCOUNT(NOT NULL)

--2. 시퀀스 생성
--		시퀀스 명 : SEQ_GUEST (1부터 1씩 증가 최대 1000, NOCYCLE, NOCACHE)

--[GUEST 테이블]
--임의의 데이터 5건 입력

--[JDBC 프로그래밍]
--Guest.java(데이터클래스), GuestMain.java(메인클래스), ConnectionUtil.java(커넥션유틸리티), GuestDao.java(CRUD기능 클래스)
--1. 패키지 : javabasic.jdbc.guest
--2. GuestDao.java = > CRUD 기능 구형 (list, get, write, update, delete)


CREATE TABLESPACE GUEST_TABLESPACE
DATAFILE 'C:\Users\Administrator\Desktop\oracle\guest_tablespace.dbf' -- 저장할 데이터 파일
SIZE 100M -- 기본용량
AUTOEXTEND ON NEXT 10M -- 기본 용량 초과시 자동증가할 용량
MAXSIZE UNLIMITED; --최대용량을 제한하지 않음

DROP TABLESPACE GUEST_TABLESPACE;
DROP USER GUEST;

-- TSUSER가 생성되고 TEST_TABLESPACE라는 테이블스페이스를 사용하게 된다.
CREATE USER GUEST IDENTIFIED BY 1234
DEFAULT TABLESPACE GUEST_TABLESPACE;

GRANT RESOURCE, CREATE SESSION, CREATE TABLE TO GUEST;

--데이터파일 조회
SELECT * FROM DBA_DATA_FILES;

--테이블스페이스 조회
SELECT * FROM DBA_TABLESPACES;

--1. 테이블 생성
--	테이블명: GUEST
--	컬럼 : 번호 GNO(PK), 이름 GNAME(NOTNULL), 나이 GAGE(1~150)
--			,성별 GGENDER(M또는F), 주민번호 GSID(UNIQUE), 접속일시 GCOUNT(NOT NULL)
CREATE TABLE GUEST (
	GNO NUMBER CONSTRAINT GUEST_PK PRIMARY KEY,
	GNAME VARCHAR2(20) CONSTRAINT GUEST_NAME_NN NOT NULL,
	GAGE NUMBER  CONSTRAINT GUEST_NUM_CK CHECK (GAGE >0 AND GAGE < 151),
	GGENDER CHAR(1) CONSTRAINT GUEST_GEN_CK CHECK (GGENDER IN ('M','F')),
	GSID VARCHAR(20) CONSTRAINT GUEST_UQ UNIQUE,
	GCOUNT TIMESTAMP CONSTRAINT GUEST_COUNT_NN NOT NULL
);       

--2. 시퀀스 생성
--		시퀀스 명 : SEQ_GUEST (1부터 1씩 증가 최대 1000, NOCYCLE, NOCACHE)
CREATE SEQUENCE SEQ_GUEST
INCREMENT BY 1 -- 1씩 증가
START WITH 1 -- 1번부터 시작
MAXVALUE 1000 -- 최대값
MINVALUE 1 ;-- 최소값

--[GUEST 테이블]
--임의의 데이터 5건 입력

SELECT * FROM GUEST;
DROP TABLE GUEST;
DROP SEQUENCE SEQ_GUEST;

INSERT INTO GUEST
VALUES(1, '홍길동', 15, 'M', '123456-1234567',SYSDATE);
INSERT INTO GUEST
VALUES(2, '강감찬', 20, 'M', '123456-1212121',SYSDATE);
INSERT INTO GUEST
VALUES(3, '유관순', 22, 'F', '765432-2234567',SYSDATE);
INSERT INTO GUEST
VALUES(4, '이순신', 10, 'M', '123456-3234567',SYSDATE);
INSERT INTO GUEST
VALUES(5, '아이유', 18, 'F', '123456-4234567',SYSDATE);




SELECT * FROM GUEST ct ;
