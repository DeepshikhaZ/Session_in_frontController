DROP TABLE Student_master;
CREATE TABLE Student_master
(student_id NUMBER(6) PRIMARY KEY,
student_name VARCHAR2(25));

select * from Student_master;


create sequence seq_Student_master
start with 100;