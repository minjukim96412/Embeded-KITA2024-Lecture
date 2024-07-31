CREATE TABLE PRODUCT (
	PNO NUMBER PRIMARY KEY, -- 품번
	PCOMP VARCHAR2(200), -- 제조사
	PNAME VARCHAR2(200), -- 상품명
	PCOLOR VARCHAR2(200), -- 색상
	PAMT NUMBER, -- 수량
	PPRICE NUMBER, -- 가격
	PMDATE DATE -- 제조일시
);
TRUNCATE table PRODUCT; 
DROP TABLE product;

DROP sequence seq_product;
CREATE sequence seq_product;

SELECT * FROM PRODUCT ORDER BY sno ASC ;

SELECT trigger_name, trigger_type, triggering_event, table_name 
FROM user_triggers
WHERE table_name = 'PRODUCT';

SELECT column_name, data_default 
FROM user_tab_columns 
WHERE table_name = 'PRODUCT';


CREATE  TABLE BOARD (
	BID NUMBER PRIMARY KEY,
	BTITLE VARCHAR2(2000) NOT NULL,
	BCONTENT VARCHAR2(4000),
	BWRITER VARCHAR2(200),
	BCOUNT NUMBER,
	BREGDATE TIMESTAMP
);

SELECT * FROM BOARD ;

TRUNCATE table BOARD; 
DROP TABLE BOARD ;

DROP SEQUENCE SEQ_BOARD;
CREATE SEQUENCE  SEQ_BOARD;

update BOARD set BCOUNT = 3 where bid=2;

CREATE TABLE MEMBER (
	MID VARCHAR2(200) PRIMARY KEY,
	MPASS VARCHAR2(200) NOT NULL
);
SELECT * FROM MEMBER ;
INSERT INTO MEMBER VALUES('홍길동', '1234');
INSERT INTO MEMBER VALUES('hong', '1234');
INSERT INTO MEMBER VALUES('강감찬', '1234');

SELECT * FROM MEMBER WHERE MID = 'hong';

TRUNCATE table BOARD ; 
ALTER TABLE board ADD (bsort varchar2(200));
ALTER TABLE board ADD (bsort varchar2(200));
ALTER TABLE board DROP COLUMN sfn;

SELECT * 
FROM board
WHERE   LIKE 's'%; 

CREATE TABLE reply (
	rid number PRIMARY KEY,
	MID VARCHAR2(200) ,
	rcontent varchar2(200),
	bid NUMBER
);

DROP TABLE reply;
SELECT * FROM reply;

CREATE SEQUENCE seq_reply;
DROP  SEQUENCE seq_reply;