CREATE  TABLE TEACHER(
	TID NUMBER PRIMARY KEY,
	TNAME VARCHAR(20),
	TSUBJECT VARCHAR2(20)
);

CREATE SEQUENCE T_SEQ;

CREATE TABLE STUDENT (
	SID NUMBER PRIMARY KEY,
	SNAME VARCHAR2(20),
	TID NUMBER,
	FOREIGN KEY(TID) REFERENCES TEACHER(TID) 
);

CREATE SEQUENCE S_SEQ;

INSERT INTO  TEACHER VALUES(T_SEQ.NEXTVAL, '홍선생', '국어');
INSERT INTO  TEACHER VALUES(T_SEQ.NEXTVAL, '강선생', '영어');
INSERT INTO  TEACHER VALUES(T_SEQ.NEXTVAL, '최선생', '수어');


SELECT *FROM TEACHER ;

DELETE TEACHER;
DROP  TABLE TEACHER;

INSERT INTO  STUDENT VALUES(S_SEQ.NEXTVAL, '김학생', '1');
INSERT INTO  STUDENT VALUES(S_SEQ.NEXTVAL, '이학생', '1');
INSERT INTO  STUDENT VALUES(S_SEQ.NEXTVAL, '박학생', '1');
INSERT INTO  STUDENT VALUES(S_SEQ.NEXTVAL, '유학생', '2');
INSERT INTO  STUDENT VALUES(S_SEQ.NEXTVAL, '장학생', '2');
INSERT INTO  STUDENT VALUES(S_SEQ.NEXTVAL, '조학생', '3');

SELECT *FROM STUDENT ;

--1.

--2. ANSI
SELECT *
FROM TEACHER t ,STUDENT s 
WHERE T.TID = S.TID ;

--OUTER JOIN

--1.오라클
--LEFT OUTER JOIN ( 오른쪽매칭되는 데이터가 없어도 왼쪽데이터는 모두 조회)
SELECT *
FROM TEACHER t , STUDENT s 
WHERE T.TID = S.TID(+);

--RIGHT OUTER JOIN (왼쪽매칭되는 데이터가 없어도 오른쪽데이터는 모두 조회)
SELECT *
FROM TEACHER t , STUDENT s 
WHERE T.TID(+) = S.TID;

--2.ANSI

--LEFT OUTER JOIN (오른쪽매칭되는 데이터가 없어도 왼쪽데이터는 모두 조회)
SELECT *
FROM  TEACHER t LEFT OUTER JOIN STUDENT s 
	ON T.TID = S.TID ;

--RIGHT OUTER JOIN (왼쪽매칭되는 데이터가 없어도 오른쪽데이터는 모두 조회)

SELECT *
FROM  TEACHER t RIGHT OUTER JOIN STUDENT s 
	ON T.TID = S.TID ;

--FULL OUTER JOIN (매칭되는 데이터가 없어도 양쪽데이터는 모두 조회)
SELECT *
FROM  TEACHER t FULL OUTER JOIN STUDENT s 
	ON T.TID = S.TID ;

INSERT  INTO TEACHER  VALUES(T_SEQ.NEXTVAL, NULL, NULL);
INSERT  INTO STUDENT VALUES(S_SEQ.NEXTVAL, NULL, 3);

SELECT *FROM TEACHER ;
SELECT *FROM STUDENT ;

--3개이상의 테이블 조인
CREATE  TABLE FRIEND (
	FID NUMBER PRIMARY KEY,
	FNAME VARCHAR2(20),
	SID NUMBER,
	FOREIGN KEY(SID) REFERENCES STUDENT(SID)
);

CREATE SEQUENCE F_SEQ;

INSERT  INTO FRIEND VALUES(F_SEQ.NEXTVAL, '곽친구', 3);
INSERT  INTO FRIEND VALUES(F_SEQ.NEXTVAL, '왕친구', 3);

SELECT * FROM FRIEND;

-- 3개 INNER JOIN
SELECT *
FROM TEACHER t ,STUDENT s ,FRIEND f 
WHERE T.TID =S.TID 
	AND S.SID = F.SID;

--3개 LEFT OUTER JOIN
SELECT *
FROM TEACHER t ,STUDENT s ,FRIEND f 
WHERE T.TID = S.TID(+) 
	AND S.SID = F.SID(+);

--3개 LEFT OUTER JOIN
SELECT *
FROM TEACHER t ,STUDENT s ,FRIEND f 
WHERE T.TID(+)  = S.TID
	AND S.SID(+)  = F.SID;

--서브 쿼리 (SUBQUERY) : 메인쿼리내에서 사용하는 쿼리

-- WHERE 절에서 단일행 서브쿼리 사용
-- WHERE 절에서 다중행 서브쿼리는 사용불가
SELECT *
FROM DEPARTMENTS d 
WHERE DEPARTMENT_ID = (SELECT DEPARTMENT_ID 
											FROM EMPLOYEES 
											WHERE EMPLOYEE_ID =100);
										
-- IN,ANY,SOM,ALL,EXITS

SELECT *
FROM DEPARTMENTS d 
WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID 
											FROM EMPLOYEES 
											WHERE EMPLOYEE_ID =100
												OR EMPLOYEE_ID = 120);										
										
SELECT *
FROM DEPARTMENTS d 
WHERE DEPARTMENT_ID < ANY (SELECT DEPARTMENT_ID 
											FROM EMPLOYEES 
											WHERE SALARY > 100);	
										
SELECT *
FROM DEPARTMENTS d 
WHERE DEPARTMENT_ID > ANY (SELECT DEPARTMENT_ID 
											FROM EMPLOYEES 
											WHERE EMPLOYEE_ID = 100);											
								
										
SELECT *
FROM EMPLOYEES e ;

--SELECT 구문 서브쿼리
SELECT 'HELLO', (SELECT 'ORACLE' FROM DUAL)
FROM DUAL;

--FROM 구문 서브쿼리

SELECT D.*
FROM (SELECT *
			FROM DEPARTMENTS)D;
