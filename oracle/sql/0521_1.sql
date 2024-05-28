-- 5/21 쿼리실습 1

--1. 직원의 풀네임(FRIST_NAME||' '||LAST_NAME)을 내림차순 정렬 조회
SELECT FIRST_NAME || ' ' || LAST_NAME AS FULLNAME
FROM EMPLOYEES
ORDER BY FULLNAME DESC ;

--2. 직원 중에서 2005년 이후 입사자 수를 조회
SELECT COUNT(*)
FROM EMPLOYEES
WHERE HIRE_DATE > TO_DATE('2005/01/01', 'YYYY/MM/DD') ;

--3. 연봉이 전체평균연봉보다 높은 직원의 정보를 연봉이 많은 순으로 조회 (연봉 = SALARY*12)
SELECT AVG(SALARY*12)
FROM EMPLOYEES;
SELECT *
FROM EMPLOYEES
WHERE SALARY*12 > 77541.9813084112
ORDER BY SALARY*12 DESC;

--4. 모든 직원의 월급,커미션, 월급 + 커미션이 많은 순으로 조회 (커미션이 NULL이 아닌 경우)
SELECT SALARY , COMMISSION_PCT *SALARY, SALARY +COMMISSION_PCT * SALARY AS SUM_SAL_COM
FROM EMPLOYEES
WHERE COMMISSION_PCT IS NOT NULL
ORDER BY SALARY DESC, COMMISSION_PCT * SALARY DESC, SALARY +COMMISSION_PCT * SALARY DESC;

--**5. 부서별로 연봉을 가장 많이 받는 직원의 정보를 조회
SELECT 
FROM 

--**6. JOB_ID 가 SA_REP인 직원들 중에서 입사일이 가장 빠른 직원의 정보를 조회

--7. MANAGER_ID가 149인 직원들의 직원아이디. 직원풀네임,월급을 조회
SELECT EMPLOYEE_ID ,FIRST_NAME ||' '|| LAST_NAME AS FULLNAME, SALARY  
FROM EMPLOYEES
WHERE MANAGER_ID = 149;

--8. JOB_ID가 S로 시작하는 직원중 최저월급을 받는 직원의 정보를 조회
SELECT *
FROM EMPLOYEES 
WHERE SALARY = SOME (SELECT MIN(SALARY)
									FROM EMPLOYEES
									WHERE JOB_ID LIKE 'S_%');

--9. FRIST_NAME 이나 LAST_NAME이 5문자 이하인 직원의 정보를 조회
SELECT *
FROM EMPLOYEES
WHERE LENGTH(FIRST_NAME) <= 5
		OR  LENGTH(LAST_NAME) <= 5;
	
--10. 짝수년도에 고용된 직원들 중에서 COMMISSIN_PCT가 있는 직원의 정보를 조회
SELECT *
FROM EMPLOYEES
WHERE COMMISSION_PCT IS NOT NULL
			AND	
			MOD(TO_NUMBER(SUBSTR(TO_CHAR(HIRE_DATE),1,2)), 2) = 0;

--11. 월급이 10000이상 이면 고소득자 10000미만 5000이상이면 일반소득자,
--		5000만원미만이면 저소득자로 직원의 정보를 조회
SELECT E.*,
	CASE
		WHEN SALARY  >= 10000 THEN '고소득자'
		WHEN SALARY >= 5000 AND SALARY < 10000 THEN '일반소득자'
		WHEN SALARY < 5000 THEN '저소득자'
	END
FROM EMPLOYEES E;
		
--12. 월급이 2000달러 에서 3000달러 사이(양쪽다 포함) 인 직원의 정보를 월급 많은 순 조회
SELECT *
FROM EMPLOYEES
WHERE SALARY BETWEEN 2000 AND 3000
ORDER BY SALARY DESC;

--13. 매니저가 없는 부서의 부서명을 오름차순 조회
SELECT * 
FROM DEPARTMENTS d 
WHERE MANAGER_ID IS NULL
ORDER BY DEPARTMENT_NAME ;

--14. 매니저의 아이디가 201~205인 부서의 부서명을 오름차순 조회
SELECT *
FROM DEPARTMENTS 
WHERE MANAGER_ID BETWEEN 201 AND 205
ORDER BY DEPARTMENT_NAME ;

--15.부서명에 'a'가 포함되는 부서의 정보를 조회
SELECT *
FROM DEPARTMENTS 
WHERE DEPARTMENT_NAME LIKE '%a%';

--16.부서명이 'P'로 시작하고 's'로 끝나는 부서의 정보를 조회
SELECT *
FROM DEPARTMENTS 
WHERE DEPARTMENT_NAME LIKE '%P%s';

--17. 직원들의 JOB_ID를 12자리에 맞춰 오른쪽으로 정렬해서 조회
SELECT E.*,
		LPAD(JOB_ID, 12, ' ') 
FROM EMPLOYEES E;

--18. 직원들의 JOB_ID를 AC는ACC로 ST는 STT로 변경해서 조회
SELECT E.*,
 			REPLACE(REPLACE(JOB_ID, 'AC_','ACC_'),'ST_','STT_')
FROM EMPLOYEES E;

--19. 직원들의 근무개월 수 , 근무주수, 근무일수를 조회
SELECT HIRE_DATE,
	TRUNC(MONTHS_BETWEEN(SYSDATE, HIRE_DATE)),
	TRUNC((SYSDATE - HIRE_DATE )/7),
	TRUNC((SYSDATE - HIRE_DATE ))
FROM EMPLOYEES e ;

--20. 직원들의 직무시작일과 직무종료일을 '0000년 00월 00일 00시 00분 00초'로 조회
SELECT JH.*,
	TO_CHAR(START_DATE , 'YYYY"년" MON DD"일" HH24"시" MI"분" SS"초"'),
	TO_CHAR(END_DATE , 'YYYY"년" MON DD"일" HH24"시" MI"분" SS"초"')
FROM JOB_HISTORY jh ;

--21. 직원들의 직무시작일은 한달 전으로 직무종료일은 한달 후로 변경해 조회
SELECT JH.*,
	ADD_MONTHS(START_DATE , -1),
	ADD_MONTHS(END_DATE , 1)
FROM JOB_HISTORY jh  ;
--22.직원들의 직무종료일이 포함된 달의 마지막 일자를 조회
SELECT JH.*,
	LAST_DAY(END_DATE)
FROM JOB_HISTORY jh ;

--23. JOB_ID가 IT-PROG 또는 AC_ACCOUNT 또는 AC_MGR인 것에 대해
--		IT_FROG 이면 '정보부', AC_ACCOUT이면 회계부, AC_MGR이면 관리부로 조회
SELECT jh.*,
	REPLACE(REPLACE(REPLACE(JOB_ID, 'IT_PROG','정보부'),'AC_ACCOUNT','회계부'),'AC_MGR','관리부')
FROM JOB_HISTORY jh;

--24. 부서별로 부서아이디, 직원의 월급합계를 조회
SELECT JOB_ID ,SUM(SALARY)
FROM EMPLOYEES e 
GROUP BY JOB_ID ;

--25. 부서별로 부서아이디, 최대급여와 최소급여의 차를 조회
SELECT j.*,
	MAX_SALARY -MIN_SALARY 
FROM JOBS j ;

--26. 부서별로 직원의 수가 5이상인 부서의 부서아이디, 직원수를 조회
SELECT JOB_ID , COUNT(*) 
FROM EMPLOYEES e 
GROUP BY JOB_ID 
	HAVING COUNT(*) >= 5 ;
--**27. 전체직원의 평균월급보다 부서의 평균월급이 높은 부서의 부서아이디, 평균월급을 조회
--**28. 직무아이디, 직무별 소속직원의 수, 부서아이디, 부서별 소속직원의 수를 조회 