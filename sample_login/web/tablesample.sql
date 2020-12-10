
select * from tab;


drop table userstest purge;

select * from userlist;

select profileimg from userlist where userid='hi'

insert into userlist(userid,pwd,name) values('hi','1234','어드민');

create sequence board_seq increment by 1  start with 1 nocycle nocache;
SELECT * FROM BOARDLIST WHERE USERID='hi' 
SELECT PROFILEIMG FROM BOARDLIST WHERE USERID='hi' 
insert into boardlist(idx,userid,content,img,logtime) values(board_seq.nextval,'hi','test','/insta/upload/dog.jpg','2019-01-01');
select * from boardlist;
drop sequence board_seq;
drop table boardtest purge;

update userlist set profileimg = 'dog.jpg'
select * from boardtest;


---------------------------------------------------------------------------------------------------------------------------------------------------

create table userlist(
userid varchar2(15) primary key,
pwd varchar2(12) not null,
name varchar2(20) not null,
email varchar2(100) not null,
address varchar2(160),
chk varchar2(12),
profileimg varchar2(100));




create table boardlist(
idx number(6) primary key,		--글번호
userid varchar2(15)not null,	--유져이름
content varchar2(200),		--글내용
img varchar2(200),
logtime DATE DEFAULT SYSDATE);




create table reply(
idx number(6)	primary key	
boardidx number(6)not null ,
content varchar2(200)),
logtime DATE DEFAUKY SYSDATE);



create sequence board_seq increment by 1 start with 1 nocycle nocache;
create sequence reply_seq increment by 1 start with 1 nocycle nocache;

select * from userlist ;
select * from boardlist;
delete from USERLIST where pwd='1234';
drop table boardlist;
drop table userlist;




