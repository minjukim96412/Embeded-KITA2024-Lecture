--Hello PL/SSQL 출력
SET SERVEROUTPUT ON;
BEGIN
		DBMS_OUTPUT.PUT_LINE('HELLO, PL/SQL!');
END;


DECLARE
V_EMPNO NUMBER(4) := 7788; 
V_ENAME VARCHAR2(10);
BEGIN
	V_ENAME := 'SCOTT';
DBMS_OUTPUT.PUT_LINE('V_EMPNO : ' || V_EMPNO);
DBMS_OUTPUT.PUT_LINE('V_ENAME : ' || V_ENAME);
END;

-- 상수에 값을 대입한 후 출력하기
DECLARE
	V_TAX CONSTANT NUMBER(1) := 3;
	BEGIN
		DBMS_OUTPUT.PUT_LINE('V_TAX : ' || V_TAX);
	END;
	
--변수에 기본값을 설정한 후 출력하기
DECLARE
	V_DEPTNO NUMBER(2) DEFAULT 10;
	BEGIN
		DBMS_OUTPUT.PUT_LINE('V_DEPTNO : ' || V_DEPTNO);
	END;
	
-- 변수에 NOT NULL을 설정하고 값을 대입한 후 출력하기

DECLARE
	V_DEPTNO NUMBER(2) NOT NULL := 10;
	BEGIN
		DBMS_OUTPUT.PUT_LINE('V_DEPTNO : ' || V_DEPTNO);
	END;


-- 변수에 NOT NULL 및 기본값을 설정하고 값을 대입한 후 출력하기

DECLARE
	V_DEPTNO NUMBER(2) NOT NULL DEFAULT 10;
	BEGIN
		DBMS_OUTPUT.PUT_LINE('V_DEPTNO : ' || V_DEPTNO);
	END;

--  참조형(열)의 변수에 값을 대입한 후 출력하기

DECLARE
	V_DEPTNO DEPT.DEPTNO%TYPE := 50;
	BEGIN
		DBMS_OUTPUT.PUT_LINE('V_DEPTNO : ' || V_DEPTNO);
	END;

--  참조형(행)의 변수에 값을 대입한 후 출력하기

DECLARE
	V_DEPT_ROW DEPT%ROWTYPE;
	BEGIN
		SELECT  DEPTNO, DNAME, LOC INTO V_DEPT_ROW
		FROM DEPT 
		WHERE DEPTNO = 40;
		DBMS_OUTPUT.PUT_LINE('DEPTNO : ' || V_DEPT_ROW.DEPTNO);
		DBMS_OUTPUT.PUT_LINE('DNAME : ' || V_DEPT_ROW.DNAME);
		DBMS_OUTPUT.PUT_LINE('LOC : ' || V_DEPT_ROW.LOC);
	END;

DECLARE
	V_NUMBER NUMBER := 14;
BEGIN
	IF MOD(V_NUMBER, 2) = 1 THEN
		DBMS_OUTPUT.PUT_LINE('V_NUMBER는 홀수 입니다!');
	ELSE
		DBMS_OUTPUT.PUT_LINE('V_NUMBER는 짝수 입니다!');
	END IF;
END;

DECLARE
	V_SCORE NUMBER := 20;
BEGIN
	IF V_SCORE >=90 THEN 
		DBMS_OUTPUT.PUT_LINE('A학점');
	ELSIF V_SCORE >=80 THEN 
		DBMS_OUTPUT.PUT_LINE('B학점');
	ELSIF V_SCORE >=70 THEN 
		DBMS_OUTPUT.PUT_LINE('C학점');
	ELSIF V_SCORE >=60 THEN 
		DBMS_OUTPUT.PUT_LINE('D학점');
	ELSE
		DBMS_OUTPUT.PUT_LINE('F학점');
	END IF;
END;

DECLARE
	V_SCORE NUMBER := 100;
BEGIN
	CASE TRUNC(V_SCORE/10 )
		WHEN 10 THEN DBMS_OUTPUT.PUT_LINE('A학점');
		WHEN 9 THEN DBMS_OUTPUT.PUT_LINE('A학점');
		WHEN 8 THEN DBMS_OUTPUT.PUT_LINE('B학점');
		WHEN 7 THEN DBMS_OUTPUT.PUT_LINE('C학점');
		WHEN 6 THEN DBMS_OUTPUT.PUT_LINE('D학점');
		ELSE DBMS_OUTPUT.PUT_LINE('F학점');
	END CASE;
END;

DECLARE
	V_SCORE NUMBER := 100;
BEGIN
	CASE 
		WHEN V_SCORE >=90 THEN DBMS_OUTPUT.PUT_LINE('A학점');
		WHEN V_SCORE >=80 THEN DBMS_OUTPUT.PUT_LINE('B학점');
		WHEN V_SCORE >=70 THEN DBMS_OUTPUT.PUT_LINE('C학점');
		WHEN V_SCORE >=60 THEN DBMS_OUTPUT.PUT_LINE('D학점');
		ELSE DBMS_OUTPUT.PUT_LINE('F학점');
	END CASE;
END;

DECLARE
	V_NUM NUMBER := 0;
BEGIN
	LOOP
		DBMS_OUTPUT.PUT_LINE('현재 V_NUM : ' || V_NUM);
		V_NUM := V_NUM + 1;
		EXIT WHEN V_NUM > 4;
	END LOOP;
END;

DECLARE
	V_NUM NUMBER := 0;
BEGIN
	LOOP
		DBMS_OUTPUT.PUT_LINE('현재 V_NUM : ' || V_NUM);
		V_NUM := V_NUM + 1;
		IF V_NUM > 4 THEN
			EXIT;
		END IF;
	END LOOP;
END;

DECLARE
	V_NUM NUMBER := 0;
BEGIN
	WHILE V_NUM < 5 LOOP
		DBMS_OUTPUT.PUT_LINE('현재 V_NUM : ' || V_NUM);
		V_NUM := V_NUM + 1;
	END LOOP;
END;


BEGIN
	FOR i  IN 0..4 LOOP
		DBMS_OUTPUT.PUT_LINE('현재 i의 값 : ' || i);
	END LOOP;
END;

BEGIN
	FOR i  IN REVERSE 0..4 LOOP
		DBMS_OUTPUT.PUT_LINE('현재 i의 값 : ' || i);
	END LOOP;
END;

BEGIN
	FOR i  IN 0..4 LOOP
		CONTINUE WHEN MOD(i, 2) = 1;
		DBMS_OUTPUT.PUT_LINE('현재 i의 값 : ' || i);
	END LOOP;
END;

--PL/SQL 실습 1
--1. 구구단 출력

BEGIN
 FOR i IN 1..9 LOOP
 	FOR j IN 1..9 LOOP
 		DBMS_OUTPUT.PUT_LINE( i || ' X ' || j || '=' || i*j );
 	END LOOP;
 END LOOP;
 END;

-- 2. 별찍기
/*
   1)          2)              3)
*oooo    oooo*    oooo*oooo           
**ooo    ooo**    ooo***ooo
***oo    oo***    oo*****oo
****o    o****    o*******o
*****    *****    *********
**/

1)

BEGIN
 FOR i IN 1..5 LOOP
 	FOR j IN 1..i LOOP
 		DBMS_OUTPUT.PUT('*');
 	END LOOP;
 	FOR j IN (i+1)..5 LOOP
 		DBMS_OUTPUT.PUT('o');
 	END LOOP;
 		DBMS_OUTPUT.PUT_LINE('');
 END LOOP;
 END;

--2)

BEGIN
 FOR i IN 1..5 LOOP
 	FOR j IN (i+1)..5 LOOP
 		DBMS_OUTPUT.PUT('o');
 	END LOOP;
 	FOR j IN 1..i LOOP
 		DBMS_OUTPUT.PUT('*');
 	END LOOP;
 		DBMS_OUTPUT.PUT_LINE('');
 END LOOP;
 END;

--3)
BEGIN
 FOR i IN 1..5 LOOP
 	FOR j IN (i+1)..5 LOOP
 		DBMS_OUTPUT.PUT('o');
 	END LOOP;
 	FOR j IN 1..i LOOP
 		DBMS_OUTPUT.PUT('*');
 	END LOOP;
 	FOR j IN 1..(i-1) LOOP
 		DBMS_OUTPUT.PUT('*');
 	END LOOP;
 	FOR j IN (i+1)..5 LOOP
 		DBMS_OUTPUT.PUT('o');
 	END LOOP;
 		DBMS_OUTPUT.PUT_LINE('');
 END LOOP;
 END;


-- 3. SSCORE테이블(학번, 학생명, 국어, 영어, 수학)을 생성하고
--    3명의 데이터를 입력 후 각 학생의 정보를 아래와 같이 출력
--    (반드시 %ROWTYPE을 사용할 것)
--------------------------------------------------
--  학번     이름    국어   영어   수학     총점      평균
--     1   홍길동      90      90      90      270      90   
--     2   강감찬      80      80      80      240      80
--     3   이순신      70      70      70      210      70
--------------------------------------------------
--

CREATE TABLE SSCORE (
	SNO NUMBER  PRIMARY KEY,
	SNAME VARCHAR2(20) NOT NULL,
	SKOR NUMBER  DEFAULT 0,
	SENG NUMBER  DEFAULT 0,
	SMATH NUMBER  DEFAULT 0
);

CREATE SEQUENCE SEQ_SSCORE;

INSERT INTO SSCORE
VALUES(SEQ_SSCORE.NEXTVAL,'홍길동', 90, 90, 90);
INSERT INTO SSCORE
VALUES(SEQ_SSCORE.NEXTVAL, '강감찬', 80, 80, 80);
INSERT INTO SSCORE
VALUES(SEQ_SSCORE.NEXTVAL, '이순신', 70, 70, 70);

DROP TABLE SSCORE;
SELECT * FROM SSCORE;

COMMIT;

DECLARE
	V_SSCORE_ROW SSCORE%ROWTYPE;
	SSUM NUMBER;
--커서는 각각의 SELECT 결과 행들을 지칭 할 수 있는 포인터 (선언 > OPEN > FETCH >CLOSE)
CURSOR C1 IS
	SELECT *
	FROM SSCORE;
BEGIN
	OPEN C1;
LOOP	
	FETCH C1 INTO V_SSCORE_ROW;
	SSUM :=  V_SSCORE_ROW.SKOR +  V_SSCORE_ROW.SENG 
					+  V_SSCORE_ROW.SMATH;
	EXIT WHEN C1%NOTFOUND;
	DBMS_OUTPUT.PUT_LINE(
	V_SSCORE_ROW.SNO 
	|| ' ' || V_SSCORE_ROW.SNAME
	|| ' ' || V_SSCORE_ROW.SKOR 
	|| ' ' || V_SSCORE_ROW.SENG 
	|| ' ' || V_SSCORE_ROW.SMATH
	|| ' ' || SSUM || ' ' || SSUM/3
	);
END LOOP;
CLOSE C1;
END;

--4. 3번실습을 연관배열(Associative Array)과 레코드 타입으로 변환해서 해보기

DECLARE
	--레코드 타입 선언
	--RECORD타입은 다양한 타입을 하나로 묶는데 사용된다.
	--일반적으로 어떤 테이블의 한 행의 전체 컬럼들의 타입을 하나로 묶을 때 사용된다. (레코드 1개 = 한행)
	TYPE REC_SSCORE IS RECORD( 
	SNO SSCORE.SNO%TYPE,
	SNAME SSCORE.SNAME%TYPE,
	SKOR SSCORE.SKOR%TYPE,
	SENG SSCORE.SENG%TYPE,
	SMATH SSCORE.SMATH%TYPE
	);
--연관배열타입 선언
--연관배열타입은 동일한 타입을 하나로 묶는데 사용된다.
--연관배열은 인덱스를 통해서 각각의 요소에 접근한다.
--PLS_INTEGER : 정수
TYPE ITAB_SSCORE IS TABLE OF REC_SSCORE
	INDEX BY PLS_INTEGER;
	SSCORE_ARR ITAB_SSCORE;
	IDX PLS_INTEGER := 0; --연관배열의 인덱스로 사용할 변수
	SSUM NUMBER := 0;
BEGIN
	FOR I IN(SELECT * FROM SSCORE ) LOOP --행의 수만큼 반복
	IDX := IDX+1;
	SSCORE_ARR(IDX).SNO := I.SNO;
	SSCORE_ARR(IDX).SNAME := I.SNAME;
	SSCORE_ARR(IDX).SKOR := I.SKOR;
	SSCORE_ARR(IDX).SENG := I.SENG;
	SSCORE_ARR(IDX).SMATH := I.SMATH;
	SSUM := I.SKOR+I.SENG+I.SMATH;
	DBMS_OUTPUT.PUT_LINE(
										SSCORE_ARR(IDX).SNO || ' ' ||
										SSCORE_ARR(IDX).SNAME || ' ' ||
										SSCORE_ARR(IDX).SKOR || ' ' ||
										SSCORE_ARR(IDX).SENG || ' ' ||
										SSCORE_ARR(IDX).SMATH || ' ' ||
										SSUM || ' ' || SSUM/3
										);
	END LOOP;
END;

DECLARE
	--레코드 타입 선언
	--RECORD타입은 다양한 타입을 하나로 묶는데 사용된다.
	--일반적으로 어떤 테이블의 한 행의 전체 컬럼들의 타입을 하나로 묶을 때 사용된다. (레코드 1개 = 한행)
	TYPE REC_SSCORE IS RECORD( 
	SNO SSCORE.SNO%TYPE,
	SNAME SSCORE.SNAME%TYPE,
	SKOR SSCORE.SKOR%TYPE,
	SENG SSCORE.SENG%TYPE,
	SMATH SSCORE.SMATH%TYPE
	);
--연관배열타입 선언
--연관배열타입은 동일한 타입을 하나로 묶는데 사용된다.
--연관배열은 인덱스를 통해서 각각의 요소에 접근한다.
--PLS_INTEGER : 정수
TYPE ITAB_SSCORE IS TABLE OF REC_SSCORE
	INDEX BY PLS_INTEGER;
	SSCORE_ARR ITAB_SSCORE;
	IDX PLS_INTEGER := 0; --연관배열의 인덱스로 사용할 변수
	SSUM NUMBER := 0;
CURSOR C1 IS
	SELECT *
	FROM SSCORE;
BEGIN
	
FOR C1_REC IN C1 LOOP	
	IDX := IDX+1;
	SSCORE_ARR(IDX).SNO := C1_REC.SNO;
	SSCORE_ARR(IDX).SNAME := C1_REC.SNAME;
	SSCORE_ARR(IDX).SKOR := C1_REC.SKOR;
	SSCORE_ARR(IDX).SENG := C1_REC.SENG;
	SSCORE_ARR(IDX).SMATH := C1_REC.SMATH;
	SSUM := C1_REC.SKOR+C1_REC.SENG+C1_REC.SMATH;
	DBMS_OUTPUT.PUT_LINE(
										SSCORE_ARR(IDX).SNO || ' ' ||
										SSCORE_ARR(IDX).SNAME || ' ' ||
										SSCORE_ARR(IDX).SKOR || ' ' ||
										SSCORE_ARR(IDX).SENG || ' ' ||
										SSCORE_ARR(IDX).SMATH || ' ' ||
										SSUM || ' ' || SSUM/3
										);
	END LOOP;
END;

DECLARE
	V_DEPTNO DEPT.DEPTNO%TYPE;
	CURSOR C1 (P_DEPTNO DEPT.DEPTNO%TYPE) IS
		SELECT DEPTNO, DNAME, LOC
		FROM DEPT
		WHERE DEPTNO = P_DEPTNO;
BEGIN
		V_DEPTNO := &INPUT_DEPTNO;
		FOR C1_REC IN C1(V_DEPTNO) LOOP
			DBMS_OUTPUT.PUT_LINE(
											C1_REC.DEPTNO ||' '||
											C1_REC.DNAME ||' '||
											C1_REC.LOC
												);
		END LOOP;
END;
	












