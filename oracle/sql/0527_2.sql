-- 커서 실습

--1. DEPARTMENTS테이블의 전체행의 데이터를 커서를 사용해서 출력해 보세요.
DECLARE
	CURSOR C1 IS
	SELECT *
	FROM DEPARTMENTS;
BEGIN
	FOR C1_REC IN C1 LOOP
		DBMS_OUTPUT.PUT_LINE(
									C1_REC.DEPARTMENT_ID ||' '||
									C1_REC.DEPARTMENT_NAME ||' '||
									C1_REC.MANAGER_ID ||' '||
									C1_REC.LOCATION_ID 
		);
	END LOOP;
END;

SELECT DEPARTMENT_ID ,DEPARTMENT_NAME ,MANAGER_ID ,LOCATION_ID 
FROM DEPARTMENTS d ;
--2. 20번 부서에 근무하는 직원들의 직원아이디, 직원풀네임 조회 할 수 있는 VW_EMP20이라는 뷰를 생성
CREATE VIEW VW_EMP20
	AS(
			SELECT EMPLOYEE_ID AS "EMPID", 
							FIRST_NAME ||' '|| LAST_NAME AS "FULLNAME"
			FROM EMPLOYEES e 
			WHERE DEPARTMENT_ID = 20
	);


	SELECT 
	FROM EMPLOYEES e ;
	SELECT *
	FROM VW_EMP20;
	DROP VIEW VW_EMP20;
--3. VW_EMP20뷰의 직원아이디, 직원풀네임을 커서를 사용해서 출력해 보세요.
DECLARE
	CURSOR C1 IS
	SELECT *
	FROM VW_EMP20;
BEGIN
	FOR C1_REC IN C1 LOOP
		DBMS_OUTPUT.PUT_LINE(
		C1_REC.EMPID ||' '||
		C1_REC.FULLNAME 
		);
	END LOOP;
END;

--4. 30,40,50 번 부서에 근무하는 직원들의 부서아이디, 부서명, 직원아이디, 
--    직원풀네임을 조회할 수 있는 VW_MEP345라는 뷰를 생성해 보세요
CREATE VIEW VW_EMP345
	AS(
			SELECT D.DEPARTMENT_ID ,
						D.DEPARTMENT_NAME, 
						E.EMPLOYEE_ID,
						E.FIRST_NAME ||' '|| E.LAST_NAME AS "FNAME"
			FROM EMPLOYEES e , DEPARTMENTS d 
			WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID 
						AND D.DEPARTMENT_ID IN (30,40,50)
	);

SELECT *
FROM VW_EMP345;

-- 5. VW_EMP345뷰에서 30번 부서의 직원들의 직원아이디, 직원풀네임을 커서를 사용해서 출력해 보세요.
DECLARE
	CURSOR C1 IS
	SELECT *
	FROM VW_EMP345
	WHERE DEPARTMENT_ID = 30;
BEGIN
	FOR C1_REC IN C1 LOOP
		DBMS_OUTPUT.PUT_LINE(
		--C1_REC.DEPARTMENT_ID ||' '|| 
		C1_REC.EMPLOYEE_ID ||' '|| 
		C1_REC.FNAME
		);
	END LOOP;
END;

-- 6. 연관배열에 모든 직원정보의 직원아이디, 직원풀네임을 레코드타입으로 저장하여 커서를 사용해서 출력해 보세요.
DECLARE
	TYPE REC_DEPT IS RECORD(
		E_ID EMPLOYEES.EMPLOYEE_ID%TYPE,
		E_FNAME EMPLOYEES.FIRST_NAME%TYPE,
		E_LNAME EMPLOYEES.LAST_NAME%TYPE
	);

	TYPE ITAB_DEPT IS TABLE OF REC_DEPT
		INDEX BY PLS_INTEGER;
	DEPT_ARR ITAB_DEPT;
	IDX PLS_INTEGER := 0;
CURSOR C1 IS
	SELECT EMPLOYEE_ID E_ID,
				FIRST_NAME E_FNAME, 
				LAST_NAME E_LNAME 
	FROM EMPLOYEES ;
BEGIN
	FOR C1_REC IN C1 LOOP
		IDX := IDX+1;
		DEPT_ARR(IDX).E_ID := C1_REC.E_ID;
		DEPT_ARR(IDX).E_FNAME := C1_REC.E_FNAME;
		DEPT_ARR(IDX).E_LNAME := C1_REC.E_LNAME;
					DBMS_OUTPUT.PUT_LINE(
						C1_REC.E_ID ||' : '||
						C1_REC.E_FNAME ||' '|| 
						C1_REC.E_LNAME
					);
					END LOOP;
					
END;


	SELECT EMPLOYEE_ID ,FIRST_NAME, LAST_NAME 
	FROM EMPLOYEES e ;

SELECT *
	FROM DEPARTMENTS d ;
-- 7. 연관배열에 부서번호가 50이하인 부서정보를 레코드타입으로 저장하여 커서를 사용해서 출력해 보세요

DECLARE
	TYPE REC_DEPT IS RECORD(
		DID DEPARTMENTS.DEPARTMENT_ID%TYPE,
		DNAME DEPARTMENTS.DEPARTMENT_NAME%TYPE,
		MID DEPARTMENTS.MANAGER_ID%TYPE,
		LID DEPARTMENTS.LOCATION_ID%TYPE
	);
                                                                                                                                                                                                                                                                                                                                                                                                     
	TYPE ITAB_DEPT IS TABLE OF REC_DEPT
		INDEX BY PLS_INTEGER;
	DEPT_ARR ITAB_DEPT;
	IDX PLS_INTEGER := 0;

	CURSOR C1 IS
	 				SELECT DEPARTMENT_ID DID,
	 							DEPARTMENT_NAME DNAME,
	 							MANAGER_ID MID,
	 							LOCATION_ID LID
					FROM DEPARTMENTS 
					WHERE DEPARTMENT_ID <= 50;
BEGIN
	FOR C1_REC IN C1 LOOP
						IDX := IDX + 1;
					DEPT_ARR(IDX).DID := C1_REC.DID;
					DEPT_ARR(IDX).DNAME := C1_REC.DNAME;
					DEPT_ARR(IDX).MID := C1_REC.MID;
					DEPT_ARR(IDX).LID := C1_REC.LID;
				
					DBMS_OUTPUT.PUT_LINE(
					C1_REC.DID ||' '||
					C1_REC.DNAME ||' '||
					C1_REC.MID ||' '||
					C1_REC.LID 
					);
					END LOOP;
					
END;


