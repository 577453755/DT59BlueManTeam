/*
第一题
*/
CREATE TABLE sales
(
	empid INT,
	proid INT,
	num   FLOAT,
	saDate DATETIME
)
BEGIN;
	INSERT INTO sales VALUES(1234,567890,33.5,'2004-12-21');
	INSERT INTO sales VALUES(1234,598701,44.8,'2004-11-21');
	INSERT INTO sales VALUES(1234,598701,45.2,'2004-10-01');
	INSERT INTO sales VALUES(1234,567890,66.5,'2004-9-21');
	INSERT INTO sales VALUES(3456,789065,22.5,'2004-10-01');
	INSERT INTO sales VALUES(3456,789065,77.5,'2004-10-27');
	INSERT INTO sales VALUES(3456,678901,48.5,'2004-12-21');
COMMIT;

SELECT * FROM sales;

SELECT  
sa.`empid`,
sa.`proid` ,
SUM(CASE WHEN MONTH(saDate)=9 THEN num ELSE num=0 END) AS 九月份,
SUM(CASE WHEN MONTH(saDate)=10 THEN num ELSE num=0 END) AS 十月份,
SUM(CASE WHEN MONTH(saDate)=11 THEN num ELSE num=0 END) AS 十一月份,
SUM(CASE WHEN MONTH(saDate)=12 THEN num ELSE num=0 END) AS 十二月份
FROM sales sa
GROUP BY proid


/*
第二题
*/
CREATE TABLE ABC
(
	A VARCHAR(10),
	B INT,
	C CHAR(2),
	D VARCHAR(10)
)
INSERT INTO ABC VALUES('王小',10,'正','二班');
INSERT INTO ABC VALUES('李大',20,'正','一班');
INSERT INTO ABC VALUES('张五',15,'负','一班');
INSERT INTO ABC VALUES('赵三',40,'负','二班');
INSERT INTO ABC VALUES('王小',5 ,'负','二班')

SELECT * FROM ABC

SELECT
A,
SUM(CASE WHEN c='正' THEN b ELSE -b END) AS B,
D 
FROM abc
GROUP BY a 
