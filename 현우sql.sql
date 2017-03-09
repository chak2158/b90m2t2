drop table tb_review_board
drop table tb_review_comment
drop table tb_review_image
drop table tb_review_recom
select s_review_board_no.nextval from dual
select * from tb_review_board
select * from tb_review_comment
select * from tb_review_image
select * from tb_review_recom
select * from tb_review_image

select 'root'
from TB_REVIEW_COMMENT;
delete tb_review_board;

purge recyclebin

drop sequence s_review_board_no;
drop sequence s_review_comment_no;
drop sequence s_review_image_no;
drop sequence s_review_recome_no;

truncate table tb_review_board;
truncate table tb_review_image;
truncate table tb_review_comment;
truncate table tb_camp_member;
truncate table tb_review_recom;

delete from tb_review_board;
delete from tb_review_image;


create sequence s_review_board_no;
create sequence s_review_comment_no;
create sequence s_review_image_no;
create sequence s_review_recome_no;


create table tb_review_board(
	review_no number(2),
	member_id varchar2(20) not null,
	title varchar2(1000) not null,
	content varchar2(3000) not null,
	reg_date date default sysDate,
	recom_cnt number(6) not null,
	unrecom_cnt number(6) not null,
	map_latitude varchar2(1000) not null,
	map_longitude varchar2(1000) not null,
	view_cnt number(6),
	constraint pk_tb_review_board primary key (review_no)
	);
	
	create table tb_review_board ( 
	review_no number(6) primary key,
	member_id varchar2(20),
	title varchar2(1000) not null,
	content varchar2(3000) not null,
	reg_date date default sysdate,
	recom_cnt number(6) default 0,
	unrecom_cnt number(6) default 0,
	view_cnt number(6) default 0,
	map_latitude varchar2(1000),
	map_longitude varchar2(1000),
	foreign key(member_id) references tb_camp_member(member_id) on delete set null
)
	<!--drop sequence tb_board_no_reg_date --!>
	insert into tb_review_board (review_no, member_id, title, content, recom_cnt, unrecom_cnt, map_latitude, map_longitude, view_cnt) 
	values(s_review_board_review_no.nextVal, 'root', '캠프파이어제목1', '캠핑지내용1', 0, 0, '0', '0', 0);
	insert into tb_review_board (review_no, member_id, title, content, recom_cnt, unrecom_cnt, map_latitude, map_longitude, view_cnt) 
	values(s_review_board_review_no.nextVal, 'root', '캠프파이어제목2', '캠핑지내용2', 01, 01, '01', '01', 01);
	insert into tb_review_board (review_no, member_id, title, content, recom_cnt, unrecom_cnt, map_latitude, map_longitude, view_cnt) 
	values(s_review_board_review_no.nextVal, 'root', '캠프파이어제목3', '캠핑지내용3', 02, 02, '02', '02', 02);
	insert into tb_review_board (review_no, member_id, title, content, recom_cnt, unrecom_cnt, map_latitude, map_longitude, view_cnt) 
	values(s_review_board_review_no.nextVal, 'root', '캠프파이어제목4', '캠핑지내용4', 02, 02, '03', '03', 03);
	insert into tb_review_board (review_no, member_id, title, content, recom_cnt, unrecom_cnt, map_latitude, map_longitude, view_cnt) 
	values(s_review_board_review_no.nextVal, 'root', '캠프파이어제목5', '캠핑지내용5', 02, 02, '04', '04', 04);
	insert into tb_review_board (review_no, member_id, title, content, recom_cnt, unrecom_cnt, map_latitude, map_longitude, view_cnt) 
	values(s_review_board_review_no.nextVal, 'root', '캠프파이어제목6', '캠핑지내용6', 02, 02, '05', '05', 05);
	

	
	
	
	
	

	
	
	
create table tb_review_comment(
	no number(6) primary key,
	review_no number(6),
	member_id varchar2(15) not null,
	review_comment varchar2(500) not null,
	reg_date date default sysDate,
	foreign key(review_no) references tb_review_board(review_no)
);

	insert into tb_review_comment (review_no, no, member_id, review_comment) 
	values(54, s_review_comment_no.nextVal, '아이디1', '댓글1');
	insert into tb_review_comment (review_no, no, member_id, review_comment) 
	values(54, s_review_comment_no.nextVal, '아이디2', '댓글2');
	insert into tb_review_comment (review_no, no, member_id, review_comment) 
	values(54, s_review_comment_no.nextVal, '아이디3', '댓글3');
	insert into tb_review_comment (review_no, no, member_id, review_comment) 
	values(54, s_review_comment_no.nextVal, '아이디4', '댓글4');
	insert into tb_review_comment (review_no, no, member_id, review_comment) 
	values(54, s_review_comment_no.nextVal, '아이디5', '댓글5');
	insert into tb_review_comment (review_no, no, member_id, review_comment) 
	values(54, s_review_comment_no.nextVal, '아이디6', '댓글6');

	



	
		insert into tb_review_board(
		   	review_no, 
		    title, 
		    member_id, 
		    content
		) values (
		  s_review_board_no.nextval,
		   'asd',
		   'root',
		   'asd'
		)    


