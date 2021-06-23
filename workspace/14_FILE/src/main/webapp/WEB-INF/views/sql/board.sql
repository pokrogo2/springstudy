DROP TABLE BOARD;
CREATE TABLE BOARD
(
	NO NUMBER PRIMARY KEY,
	WRITER VARCHAR2(32),
	TITLE VARCHAR2(100),
	CONTENT VARCHAR2(100),
	FILENAME VARCHAR2(300),
	POSTDATE DATE
);

DROP SEQUENCE BOARD_SEQ;
CREATE SEQUENCE BOARD_SEQ INCREMENT BY 1 START WITH 1 NOCYCLE NOCACHE; 
