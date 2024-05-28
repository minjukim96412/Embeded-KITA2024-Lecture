--HR

--실습) TRIGGER
--JOBS테이블에 INSERT할때 최저월급보다 적은 월급이 아니어야하고,
--전체 최고월급보다 높은 월급이 아닌 데이터가 입력되도록 트리거 작성

SELECT MIN(MIN_SALARY), MAX(MAX_SALARY)
FROM JOBS j ;

INSERT INTO JOBS VALUES('ID01', 'FISHER', 2000, 50000);
INSERT INTO JOBS VALUES('ID02', 'FISHER', 3000, 40000);

CREATE TABLE JOBS_COPY
	AS SELECT * FROM JOBS;

CREATE OR REPLACE TRIGGER TRG_JOBS_SAL
BEFORE
INSERT ON JOBS_COPY
FOR EACH ROW
DECLARE 
	MINSAL JOBS_COPY.MIN_SALARY %TYPE;
	MAXSAL JOBS_COPY.MAX_SALARY %TYPE;
BEGIN
	SELECT MIN(MIN_SALARY) , MAX(MAX_SALARY) INTO MINSAL, MAXSAL
	FROM JOBS_COPY;
		IF INSERTING THEN 
			IF :NEW.MIN_SALARY < MINSAL THEN
				RAISE_APPLICATION_ERROR(-20000, '너무 낮은 급여');	
			END IF;
			IF :NEW.MAX_SALARY > MAXSAL THEN
				RAISE_APPLICATION_ERROR(-20000, '너무 높은 급여');							
			END IF;
	END IF;
END;


INSERT INTO JOBS_COPY VALUES('ID01', 'FISHER', 2000, 40000);
INSERT INTO JOBS_COPY VALUES('ID02', 'FISHER', 3000, 50000);
INSERT INTO JOBS_COPY VALUES('ID03', 'FISHER', 3000, 30000);


SELECT *
FROM USER_TRIGGERS ;

SELECT *
FROM JOBS_COPY jc ;


