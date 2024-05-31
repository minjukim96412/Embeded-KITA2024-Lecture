CREATE  TABLE PERSON(
	PHONENUMBER NUMBER PRIMARY KEY,
	NAME VARCHAR2(20),
	PHONENUMBER NUMBER(20),
	COLOR VARCHAR2(20),
	FOREIGN KEY(OWNER_PHONENUM) REFERENCES STUDENT(PHONENUMBER)
);

CREATE  TABLE CAT(
	OWNER_PHONENUM NUMBER PRIMARY KEY,
	NAME VARCHAR2(20),
	AGE NUMBER(20),
	COLOR VARCHAR2(20),
	FOREIGN KEY(OWNER_PHONENUM) REFERENCES STUDENT(PHONENUMBER)
);