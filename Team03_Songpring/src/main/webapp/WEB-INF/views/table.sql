--상품 데이터 베이스
CREATE TABLE songpring_shop(
	num NUMBER PRIMARY KEY,
	title VARCHAR2(100),
	imagePath VARCHAR2(100),
	genre VARCHAR2(100), -- novel, culture, workbook, comicbook, dictionary
	writer VARCHAR2(100),
	publisher VARCHAR2(100),
	regdate DATE,
	price NUMBER,
	content CLOB,
	sellCount NUMBER,
	page NUMBER,
	bookSize VARCHAR2(100)
);
-- 책 번호 시퀀스
CREATE SEQUENCE songpring_shop_seq;
-- 공지사항
CREATE TABLE songpring_notice(
	num NUMBER PRIMARY KEY,
	title VARCHAR2(100),
	content CLOB,
	regdate DATE
);
-- 공지사항 번호 시퀀스
CREATE SEQUENCE songpring_notice_seq;