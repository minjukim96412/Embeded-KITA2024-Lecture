-- JOIN / SUBQUERY 2
-- 17. 부서별로 최저급여를 받는 직원들의 직원아이디, 풀네임, 급여를 조회
SELECT E.EMPLOYEE_ID , 
			FIRST_NAME||' '||LAST_NAME AS "풀네임" ,
				J.MIN_SALARY
				,E.DEPARTMENT_ID 	
FROM EMPLOYEES e ,JOBS j 
WHERE E.JOB_ID = J.JOB_ID 
GROUP BY E.EMPLOYEE_ID , 
			FIRST_NAME||' '||LAST_NAME , J.MIN_SALARY;
										
SELECT E.EMPLOYEE_ID ,  FIRST_NAME||' '||LAST_NAME AS "풀네임" , MIN(SALARY)
FROM EMPLOYEES e
GROUP BY E.EMPLOYEE_ID ,  FIRST_NAME||' '||LAST_NAME ;

--18. 부서별 급여 평균이 위에서 3번째인 부서에 근무하는 직원들의 직원아이디, 풀네임, 급여를 조회
SELECT *
FROM; 
SELECT E.EMPLOYEE_ID ,AVG(SALARY)
FROM EMPLOYEES E
WHERE ROWNUM = 3
GROUP BY E.EMPLOYEE_ID;

--19. 캐나다에 위치한 부서에 근무하는 직원들의 평균 월급 보다 적은 월급을 받는 
--     직원들의 직원아이디,풀네임 급여를 조회
--20. 부서별로 직원수가 5명 이하인 부서의 부서아이디, 부서명, 직원아이디, 풀네임을 조회
--21. 국가별로 소속직원의 수를 계산하여 국가아이디, 국가명, 소속직원 수 를 조회
--22. 근무한 경력이 있느 직워들의 직원아이디, 풀네임, 부서가 위치한 도시명을 조회
--23. 부서별 직원의 수, 직원 총 월급, 직원 총 월급 평균을 직원 총월급의 내림차순으로 정렬하여 조회 
--24. 대륙별(REGION) 대륙명, 소속부서의수, 소속직원의 수, 소속직원의 총 급여를 조회
--25. 부서내의 직원 월급평균보다 적게 받는 직원들의 월급을 5% 인상하여 부서명, 직원아이디, 풀네임, 인상전 급여, 인상 후 급여 조회
--
--
--
--
--
--
--
--
