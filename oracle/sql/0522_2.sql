-- JOIN / SUBQUERY 2
-- 17. 부서별로 최저급여를 받는 직원들의 직원아이디, 풀네임, 급여를 조회

select EMPLOYEE_ID AS "직원아이디",
			E1.FIRST_NAME||' '||E1.LAST_NAME AS "풀네임",
			SALARY AS "급여"
			,DEPARTMENT_ID 
from employees e1
where salary in (
	select MIN(salary)
	from employees e2
	where e1.department_id = e2.department_id)
order by department_id;
														
														
--18. 부서별 급여 평균이 위에서 3번째인 부서에 근무하는 직원들의 직원아이디, 풀네임, 급여를 조회
	
SELECT EMPLOYEE_ID AS "직원아이디",
				FIRST_NAME||' '||LAST_NAME AS "풀네임",
				SALARY AS "급여"
--				,DEPARTMENT_ID 
FROM  EMPLOYEES 			
WHERE	DEPARTMENT_ID		= (SELECT DEPARTMENT_ID
											FROM(
														SELECT ROWNUM "RN", SAL.*
														FROM(
																	SELECT ROUND(AVG(SALARY)) SA, E.DEPARTMENT_ID
																	FROM EMPLOYEES E
																	WHERE DEPARTMENT_ID IS NOT NULL
																	GROUP BY  DEPARTMENT_ID
																	ORDER BY ROUND(AVG(SALARY)) DESC
																) SAL 
													) 
											WHERE RN = 3
											);
											
											
SELECT *
FROM EMPLOYEES e 
WHERE DEPARTMENT_ID = 70;

--19. 캐나다에 위치한 부서에 근무하는 직원들의 평균 월급 보다 적은 월급을 받는 
--     직원들의 직원아이디,풀네임 급여를 조회

SELECT EMPLOYEE_ID AS "직원아이디",
				FIRST_NAME||' '||LAST_NAME AS "풀네임",
				SALARY AS "급여"
FROM EMPLOYEES e
WHERE	E.SALARY  <	(SELECT AVG(SALARY )
											FROM LOCATIONS l , COUNTRIES c , DEPARTMENTS d ,EMPLOYEES e 
											WHERE C.COUNTRY_ID = L.COUNTRY_ID 
											AND L.LOCATION_ID = D.LOCATION_ID 
											AND D.DEPARTMENT_ID = E.DEPARTMENT_ID 
											AND C.COUNTRY_NAME = 'Canada'
											GROUP BY D.DEPARTMENT_ID);


--20. 부서별로 직원수가 5명 이하인 부서의 부서아이디, 부서명, 직원아이디, 풀네임을 조회

SELECT D.DEPARTMENT_ID AS "부서아이디",
			D.DEPARTMENT_NAME AS "부서명",
			E.EMPLOYEE_ID AS "직원아이디",
			E.FIRST_NAME||' '||E.LAST_NAME AS "풀네임"							
FROM	EMPLOYEES e , DEPARTMENTS d 									
WHERE	E.DEPARTMENT_ID = D.DEPARTMENT_ID 
			AND E.DEPARTMENT_ID  = SOME (SELECT DEPARTMENT_ID 
													 FROM EMPLOYEES 
					 	 							WHERE DEPARTMENT_ID IS NOT NULL
													 GROUP BY DEPARTMENT_ID 
						 								HAVING COUNT(*) <= 5);
										
--21. 국가별로 소속직원의 수를 계산하여 국가아이디, 국가명, 소속직원 수 를 조회
						 							
SELECT C.COUNTRY_ID ,C.COUNTRY_NAME ,COUNT(*)
FROM COUNTRIES c ,LOCATIONS l ,DEPARTMENTS d ,EMPLOYEES e 
WHERE C.COUNTRY_ID = L.COUNTRY_ID 
			AND L.LOCATION_ID = D.LOCATION_ID 
			AND D.DEPARTMENT_ID  = E.DEPARTMENT_ID 
GROUP BY C.COUNTRY_ID ,C.COUNTRY_NAME;
									 							
--22. 근무한 경력이 있는 직원들의 직원아이디, 풀네임, 부서가 위치한 도시명을 조회
SELECT DISTINCT E.EMPLOYEE_ID AS "직원아이디",
							E.FIRST_NAME||' '||E.LAST_NAME AS "풀네임" ,
							L.CITY AS "도시명"
FROM JOB_HISTORY jh ,EMPLOYEES e ,DEPARTMENTS d ,LOCATIONS l 
WHERE JH.JOB_ID = E.JOB_ID 
			AND E.DEPARTMENT_ID = D.DEPARTMENT_ID 
			AND D.LOCATION_ID = L.LOCATION_ID ;

--23. 부서별 직원의 수, 직원 총 월급, 직원 총 월급 평균을 직원 총월급의 내림차순으로 정렬하여 조회 
		
SELECT COUNT(*) , 
			SUM(E.SALARY) , 
			AVG(E.SALARY) AS "AVGSAL"
FROM EMPLOYEES e 
WHERE E.DEPARTMENT_ID IS NOT NULL
GROUP BY E.DEPARTMENT_ID 
ORDER BY AVGSAL DESC;

--24. 대륙별(REGION) 대륙명, 소속부서의수, 소속직원의 수, 소속직원의 총 급여를 조회
SELECT R.REGION_NAME AS "대륙명",  
			COUNT(DISTINCT D.DEPARTMENT_NAME) AS "소속부서의 수", 
			COUNT(E.EMPLOYEE_ID) AS "소속직원의 수", 
			SUM(E.SALARY) AS "소속직원의 총급여"
FROM EMPLOYEES e ,DEPARTMENTS d ,LOCATIONS l ,COUNTRIES c ,REGIONS r
WHERE E.DEPARTMENT_ID  = D.DEPARTMENT_ID 
			AND D.LOCATION_ID = L.LOCATION_ID
			AND L.COUNTRY_ID = C.COUNTRY_ID 
			AND C.REGION_ID = R.REGION_ID
GROUP BY R.REGION_NAME ;

--25. 부서내의 직원 월급평균보다 적게 받는 직원들의 월급을 5% 인상하여 부서명, 직원아이디, 풀네임, 인상전 급여, 인상 후 급여 조회
SELECT D.DEPARTMENT_NAME AS "부서명", 
			E.EMPLOYEE_ID AS "직원아이디", 
			E.FIRST_NAME||' '||E.LAST_NAME AS "풀네임" , 
			E.SALARY AS "인상전 급여", 
			E.SALARY + E.SALARY * 0.05 AS "인상 후 급여"
FROM EMPLOYEES e , DEPARTMENTS d 
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID 
			AND e.SALARY  < (SELECT AVG(SALARY)
											from employees e2
										where e.department_id = e2.department_id);
														
