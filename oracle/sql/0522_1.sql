-- join / Subquery

-- *풀네임 : FULL_NAME||' '||LAST_NAME

--1. 직원의 풀네임과 부서명조회
SELECT E.FIRST_NAME||' '||E.LAST_NAME AS "풀네임", D.DEPARTMENT_NAME AS "부서명"
FROM EMPLOYEES e, DEPARTMENTS d 
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID;

--2. 각 직원의 풀네임, 직무 id, 직무명, 직무별최대급여와 최저급여의 차이를 조회
SELECT E.FIRST_NAME||' '||E.LAST_NAME AS "풀네임", 
				J.JOB_ID ,
				J.JOB_TITLE ,
				(J.MAX_SALARY - J.MIN_SALARY ) 
FROM EMPLOYEES e ,JOBS j 
WHERE E.JOB_ID = J.JOB_ID ;

--3. 2006년에 일을한 직원의 풀네임과 작업시작일, 작업종료일을 조회
SELECT E.FIRST_NAME||' '||E.LAST_NAME , JH.START_DATE ,JH.END_DATE 
FROM EMPLOYEES e , JOB_HISTORY jh 
WHERE JH.START_DATE  <=  TO_DATE('2006', 'YYYY')  AND JH.END_DATE >= TO_DATE('2006', 'YYYY')
				AND E.EMPLOYEE_ID = JH.EMPLOYEE_ID ;

--4. 풀네임이 D로 시작하는 직원 중 JOB_ID가 IT_PROG인 직원아이디와 풀네임, 직업명을 조회
SELECT E.EMPLOYEE_ID , E.FIRST_NAME||' '||E.LAST_NAME ,J.JOB_TITLE 
FROM EMPLOYEES e , JOBS j 
WHERE E.FIRST_NAME||' '||E.LAST_NAME LIKE 'D_%'
			AND E.JOB_ID = 'IT_PROG'
				AND E.JOB_ID = J.JOB_ID ;
		
-- 5. 직원 중 부서아이디가 20 또는 50인 직원들의 아이디와 풀네임, 부서아이디, 부서명을 조회
SELECT E.EMPLOYEE_ID , E.FIRST_NAME||' '||E.LAST_NAME , D.DEPARTMENT_ID ,D.DEPARTMENT_NAME 
FROM EMPLOYEES e ,DEPARTMENTS d 
WHERE D.DEPARTMENT_ID IN(20 ,50)
				AND D.DEPARTMENT_ID = E.DEPARTMENT_ID ;

-- 6. 직원 중 부서아이디가 3의 배수인 직원들의 아이디, 풀네임, 부서아이디, 부서명을 조회
SELECT E.EMPLOYEE_ID , E.FIRST_NAME||' '||E.LAST_NAME, D.DEPARTMENT_ID, D.DEPARTMENT_NAME
FROM EMPLOYEES e ,DEPARTMENTS d
WHERE MOD(D.DEPARTMENT_ID, 3) = 0
			AND D.DEPARTMENT_ID  = E.DEPARTMENT_ID ;
			
-- 7. 직원아이디가 100인 직원과 같은 부서에 근무하는 직원들의
--     직원아이디, 풀네임, 부서아이디, 부서명을 조회
SELECT E.EMPLOYEE_ID , E.FIRST_NAME||' '||E.LAST_NAME, D.DEPARTMENT_ID, D.DEPARTMENT_NAME
FROM EMPLOYEES e , DEPARTMENTS d 
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID
				AND E.DEPARTMENT_ID = (SELECT DEPARTMENT_ID 
													FROM EMPLOYEES 
													WHERE EMPLOYEE_ID = 100);
		
SELECT *
FROM EMPLOYEES e ;
-- 8. 부서명이 M로 시작하는 부서에 근무하는 직원들의
--     직원아이디, 풀네임, 부서아이디, 부서명을 조회
SELECT E.EMPLOYEE_ID , E.FIRST_NAME||' '||E.LAST_NAME, D.DEPARTMENT_ID, D.DEPARTMENT_NAME
FROM EMPLOYEES e , DEPARTMENTS d 
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID
				AND D.DEPARTMENT_NAME LIKE 'M%';
												
-- 9. 직무아이디가 IT_PROG인 직원들 중 최소월급을 받는 사람과
--       최대월급을 받는 사람의 직원아이디, 풀네임, 부서명, 월급을 조회
SELECT E.EMPLOYEE_ID , E.FIRST_NAME||' '||E.LAST_NAME, D.DEPARTMENT_NAME, E.SALARY ,E.JOB_ID 
FROM EMPLOYEES e , DEPARTMENTS d
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID
			AND (E.SALARY  = (SELECT MAX(SALARY)
												FROM EMPLOYEES 
												WHERE  JOB_ID LIKE 'IT_PROG')
							OR E.SALARY  = (SELECT MIN(SALARY)
												FROM EMPLOYEES 
												WHERE  JOB_ID LIKE 'IT_PROG')
					)
			AND E.JOB_ID LIKE 'IT_PROG' ;
																				
SELECT *
FROM JOBS j  ;
SELECT *
FROM EMPLOYEES e ;
-- 10. 모든 직원의 직원아이디, 풀네임, 부서명, 커미션이 포함된 월급을 조회
--       (단, 커미션퍼센트가 NULL인 경우는 제외, 커미션은 월급*커미션포인트)
SELECT E.EMPLOYEE_ID ,E.FIRST_NAME||' '||E.LAST_NAME AS "풀네임", 
			D.DEPARTMENT_NAME AS "부서명",
			(E.COMMISSION_PCT *E.SALARY) +E.SALARY AS "월급"
FROM EMPLOYEES e, DEPARTMENTS d 
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID
			AND E.COMMISSION_PCT IS NOT NULL;


-- 11. 커미션퍼센트가 NULL인 직원들이 근무하는 부서별로
--      부서아이디, 부서명, 부서직원들의 커미션이 포함된 월급의 합계를 조회
--      (단, 커미션퍼센트가 NULL인 경우는 제외, 커미션은 월급*커미션포인트)
SELECT D.DEPARTMENT_ID AS "부서아이디" ,
			D.DEPARTMENT_NAME AS "부서명",
			SUM(E.SALARY + E.SALARY*NVL(E.COMMISSION_PCT,0)) AS "합계"
FROM EMPLOYEES e, DEPARTMENTS d 
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID
			AND E.COMMISSION_PCT IS NULL
GROUP BY D.DEPARTMENT_ID , D.DEPARTMENT_NAME;
		
		
-- 12. 최대급여와 최소급여의 차가 가장 큰 직무를 수행하는 직원들의
--      직무아이디, 직무명, 직원아이디, 풀네임을 조회					
SELECT J.JOB_ID AS "직무아이디", 
			J.JOB_TITLE AS "직무명", 
			E.EMPLOYEE_ID AS "직원아이디",
			E.FIRST_NAME||' '||E.LAST_NAME AS "풀네임"
FROM EMPLOYEES e ,JOBS j 
WHERE   MAX_SALARY - MIN_SALARY 
				=(SELECT MAX(MAX_SALARY - MIN_SALARY)
				FROM JOBS);													
													
SELECT MAX_SALARY - MIN_SALARY
FROM JOBS j ;

SELECT *
FROM JOBS j ;

SELECT *
FROM EMPLOYEES e ;

SELECT *
FROM JOB_HISTORY jh ;

-- 13. 직무수행시간(END_DATE - START_DATE)이 가장 길었던 직무를 수행했던 부서에
--      근무하는 직원들의 직무아이디, 직무명, 부서명, 직원아이디, 풀네임을 조회

SELECT J.JOB_ID AS "직무아이디", 
			J.JOB_TITLE AS "직무명", 
			D.DEPARTMENT_NAME AS "부서명" ,
			E.EMPLOYEE_ID AS "직원아이디",
			E.FIRST_NAME||' '||E.LAST_NAME AS "풀네임"
FROM EMPLOYEES e , JOBS j ,DEPARTMENTS d 
WHERE E.JOB_ID = J.JOB_ID 
			AND E.DEPARTMENT_ID  = D.DEPARTMENT_ID 
			AND E.DEPARTMENT_ID  = (SELECT DEPARTMENT_ID 
											FROM JOB_HISTORY
										WHERE  END_DATE - START_DATE
														=(SELECT MAX(END_DATE - START_DATE)
															FROM JOB_HISTORY
															)
														);
													

-- 14. 시애틀(Seattle)에 있는 부서에 근무하는 모든 직원들의
--      부서아이디, 부서명, 직원아이디, 풀네임을 조회
SELECT D.DEPARTMENT_ID AS "부서아이디",
			D.DEPARTMENT_ID AS "부서명" ,
			E.EMPLOYEE_ID AS "직원아이디",
			E.FIRST_NAME||' '||E.LAST_NAME AS "풀네임"
--			,L.CITY  
FROM EMPLOYEES e , DEPARTMENTS d ,LOCATIONS l 
WHERE D.DEPARTMENT_ID = E.DEPARTMENT_ID 
			AND D.LOCATION_ID = L.LOCATION_ID 
			AND	L.CITY = 'Seattle';
													
SELECT *
FROM LOCATIONS l ;
SELECT *
FROM COUNTRIES c ;
SELECT *
FROM REGIONS r ;	

--
-- 15. 유럽(Europe)에 있는 도시들에 있는 모든 부서에 근무하는 직원들의
--      도시명, 부서아이디, 부서명, 직원아이디, 풀네임을 조회


--FROM COUNTRIES c ,REGIONS r 
--WHERE R.REGION_NAME = 'Europe'
--			AND C.REGION_ID  = R.REGION_ID ;
--SELECT *
--FROM COUNTRIES c , LOCATIONS l
--WHERE C.COUNTRY_ID IN('NL','FR','UK','BE','CH','IT','DE')
--AND L.COUNTRY_ID = C.COUNTRY_ID ;
--
--SELECT *
--FROM LOCATIONS l,DEPARTMENTS d
--WHERE D.LOCATION_ID  IN('2900','3000','2700','1000','1100','3100','2400','2500','2600')
--AND D.LOCATION_ID = L.LOCATION_ID  ;
--
--SELECT *
--FROM DEPARTMENTS d, EMPLOYEES e 
--WHERE D.DEPARTMENT_ID IN('40','80','70')
--AND E.DEPARTMENT_ID = D.DEPARTMENT_ID  ;

SELECT L.LOCATION_ID AS "도시명",
			D.DEPARTMENT_ID AS "부서아이디",
			D.DEPARTMENT_NAME AS "부서명",
			E.EMPLOYEE_ID AS "직원아이디",
			E.FIRST_NAME||' '||E.LAST_NAME AS "풀네임"
FROM EMPLOYEES e ,DEPARTMENTS d , LOCATIONS l ,COUNTRIES c ,REGIONS r 
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID 
			AND D.LOCATION_ID = L.LOCATION_ID 
			AND L.COUNTRY_ID = C.COUNTRY_ID 
			AND C.REGION_ID  = R.REGION_ID 
			AND R.REGION_NAME = 'Europe';

-- 16. 유럽(Europe)에 위치하고 있는 부서들 중 직원수가 가장 많은 부서의
--      도시명, 부서아이디, 부서명, 직원수를 조회
	
SELECT *
FROM (
		SELECT L.CITY AS "도시명",
			D.DEPARTMENT_ID AS "부서아이디",
			D.DEPARTMENT_NAME AS "부서명",
			MAX(E.EMPLOYEE_ID) MAX_EID 
		FROM	
			EMPLOYEES e ,DEPARTMENTS d , LOCATIONS l ,COUNTRIES c ,REGIONS r 
		WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID 
			AND D.LOCATION_ID = L.LOCATION_ID 
			AND L.COUNTRY_ID = C.COUNTRY_ID 
			AND C.REGION_ID  = R.REGION_ID 
			AND R.REGION_NAME = 'Europe'
		GROUP BY D.DEPARTMENT_ID , D.DEPARTMENT_NAME ,L.CITY
		ORDER BY MAX_EID DESC
		)
WHERE ROWNUM = 1;


		