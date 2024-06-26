--HR

DROP PROCEDURE PROC_DEPT30;

--IN 모드 파라미터 변수 : 프로시져로 들어오는 데이터를 저장할 변수, 모드 기본값
CREATE OR REPLACE PROCEDURE PROC_DEPT30
(
	P_DID DEPARTMENTS.DEPARTMENT_ID%TYPE 
)	
IS 	
	CURSOR CUR_DEPT30
		IS SELECT DEPARTMENT_ID DID, DEPARTMENT_NAME DNAME
			FROM DEPARTMENTS
			WHERE DEPARTMENT_ID = P_DID;
	
	BEGIN 
		FOR ROW_DEPT IN CUR_DEPT30 LOOP
			DBMS_OUTPUT.PUT_LINE(ROW_DEPT.DID ||' '||
												ROW_DEPT.DNAME	);
		END LOOP;
	END;
	
BEGIN
	PROC_DEPT30(80);
END;

CREATE OR REPLACE PROCEDURE PROC_DEPT30
(
	P_DID DEPARTMENTS.DEPARTMENT_ID%TYPE 
)	
IS 	
	CURSOR CUR_DEPT30
		IS SELECT D.DEPARTMENT_ID DID, E.EMPLOYEE_ID EID , 
						E.FIRST_NAME ||' '|| E.LAST_NAME ENAME
			FROM DEPARTMENTS D, EMPLOYEES E
			WHERE D.DEPARTMENT_ID = P_DID
						AND D.DEPARTMENT_ID = E.DEPARTMENT_ID;
	BEGIN 
		FOR ROW_DEPT IN CUR_DEPT30 LOOP
			DBMS_OUTPUT.PUT_LINE(ROW_DEPT.DID ||' '||
												ROW_DEPT.EID ||' '||
												ROW_DEPT.ENAME );
		END LOOP;
	END;
	
SELECT *
FROM EMPLOYEES e ;

--OUT모드 파라미터 변수 : 프로시져에서 나가는 데이터를 저장할 변수
CREATE OR REPLACE PROCEDURE PROC_GET_DNAME
(DID IN DEPARTMENTS.DEPARTMENT_ID%TYPE,
 DNAME OUT DEPARTMENTS.DEPARTMENT_NAME%TYPE)
IS 
BEGIN 	
	SELECT DEPARTMENT_NAME INTO DNAME
	FROM DEPARTMENTS
	WHERE DEPARTMENT_ID = DID;
END;

DECLARE
	V_DNAME DEPARTMENTS.DEPARTMENT_NAME%TYPE;
BEGIN
	PROC_GET_DNAME(30, V_DNAME);
	DBMS_OUTPUT.PUT_LINE(V_DNAME);
END;

--IN OUT 모드 파라미터 변수 : 프로시져로 데이터가 들어오기도 하고 나가기도 하는 변수
CREATE OR REPLACE PROCEDURE PROC_INOUT
(V_DID IN OUT DEPARTMENTS.DEPARTMENT_ID%TYPE)
IS 
BEGIN 
	SELECT DEPARTMENT_ID INTO V_DID
	FROM DEPARTMENTS
	WHERE DEPARTMENT_ID = V_DID;
END;

DECLARE
	V_DID DEPARTMENTS.DEPARTMENT_ID%TYPE;
BEGIN
	V_DID := 50;
	PROC_INOUT(V_DID);
	DBMS_OUTPUT.PUT_LINE(V_DID);
END;


-- FUCTION (함수)
-- 함수는 IN파라미터 밖에 사용하지 못해
-- 함수는 리턴타입, 리턴값이 있다.
-- 함수는 보통 쿼리문 내에서 사용한다.
-- 오라클내에 만들어져있는 내장함수와 사용자가 만드는 사용자정의 함수가 있다.

--직원ID에 해당하는 연봉(SALARY*12)를 반환하는 함수
CREATE OR REPLACE FUNCTION FUNC_YEAR_SAL
(EID IN EMPLOYEES.EMPLOYEE_ID%TYPE)
RETURN NUMBER 
IS 
	ESAL EMPLOYEES.SALARY%TYPE;
BEGIN 
	SELECT SALARY*12 INTO ESAL
	FROM EMPLOYEES 
	WHERE EMPLOYEE_ID = EID;
	RETURN ESAL;
END;

DROP FUNCTION FUNC_YEAR_SAL;

SELECT E.* ,FUNC_YEAR_SAL(E.EMPLOYEE_ID)
FROM EMPLOYEES e ;

--실습 ) 두수를 입력하면 합계를 리턴하는 함수를 만들어 테스트
CREATE OR REPLACE FUNCTION FUNC_SUM_NUM
(NUM1 IN NUMBER,
 NUM2 IN NUMBER)
 RETURN NUMBER 
 IS 
	BEGIN 
		RETURN NUM1 + NUM2 ;
	END;
	
SELECT FUNC_SUM_NUM(10, 20)
FROM DUAL;

CREATE OR REPLACE FUNCTION FUNC_SUM_CHAR
(CHAR1 IN VARCHAR2,
CHAR2 IN VARCHAR2)
 RETURN VARCHAR2
 IS 
	BEGIN 
		RETURN CHAR1 ||' '|| CHAR2;
	END;

DROP FUNCTION FUNC_SUM_CHAR;


SELECT E.EMPLOYEE_ID , FUNC_SUM_CHAR(E.FIRST_NAME,E.LAST_NAME)
FROM EMPLOYEES e ;

--패키지 생성
CREATE OR REPLACE PACKAGE PKG_HR
IS 
PROCEDURE PROC_DEPT30
(P_DID DEPARTMENTS.DEPARTMENT_ID%TYPE);	
PROCEDURE PROC_GET_DNAME
(DID IN DEPARTMENTS.DEPARTMENT_ID%TYPE,
 DNAME OUT DEPARTMENTS.DEPARTMENT_NAME%TYPE);
FUNCTION FUNC_YEAR_SAL
(EID IN EMPLOYEES.EMPLOYEE_ID%TYPE)
RETURN NUMBER ;
FUNCTION FUNC_SUM_NUM
(NUM1 IN NUMBER,NUM2 IN NUMBER)
 RETURN NUMBER ;
END;

CREATE OR REPLACE PACKAGE BODY PKG_HR
IS 
PROCEDURE PROC_DEPT30
(P_DID DEPARTMENTS.DEPARTMENT_ID%TYPE)
IS 	
	CURSOR CUR_DEPT30
		IS SELECT DEPARTMENT_ID DID, DEPARTMENT_NAME DNAME
			FROM DEPARTMENTS
			WHERE DEPARTMENT_ID = P_DID;
	
	BEGIN 
		FOR ROW_DEPT IN CUR_DEPT30 LOOP
			DBMS_OUTPUT.PUT_LINE(ROW_DEPT.DID ||' '||
												ROW_DEPT.DNAME	);
		END LOOP;
	END PROC_DEPT30;	

PROCEDURE PROC_GET_DNAME
(DID IN DEPARTMENTS.DEPARTMENT_ID%TYPE,
 DNAME OUT DEPARTMENTS.DEPARTMENT_NAME%TYPE)
 IS 
BEGIN 	
	SELECT DEPARTMENT_NAME INTO DNAME
	FROM DEPARTMENTS
	WHERE DEPARTMENT_ID = DID;
END PROC_GET_DNAME;

FUNCTION FUNC_YEAR_SAL
(EID IN EMPLOYEES.EMPLOYEE_ID%TYPE)
RETURN NUMBER 
IS 
	ESAL EMPLOYEES.SALARY%TYPE;
BEGIN 
	SELECT SALARY*12 INTO ESAL
	FROM EMPLOYEES 
	WHERE EMPLOYEE_ID = EID;
	RETURN ESAL;
END FUNC_YEAR_SAL;

FUNCTION FUNC_SUM_NUM
(NUM1 IN NUMBER,NUM2 IN NUMBER)
 RETURN NUMBER IS 
	BEGIN 
		RETURN NUM1 + NUM2 ;
	END FUNC_SUM_NUM;

END;


SELECT PKG_HR.FUNC_SUM_NUM(10,30)
FROM DUAL;

SELECT PKG_HR.FUNC_YEAR_SAL(110)
	FROM DUAL;

BEGIN
	PKG_HR.PROC_DEPT30(80);
END;








