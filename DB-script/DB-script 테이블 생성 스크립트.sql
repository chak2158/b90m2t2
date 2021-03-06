drop table tb_review_comment
drop table tb_review_image
drop table tb_review_recom
drop table tb_review_board
drop table tb_calendar
drop table tb_member_profile_img
drop table tb_camp_member

drop sequence s_calendar_no;
drop sequence s_review_board_no;
drop sequence s_review_image_no;
drop sequence s_review_recome_no;
drop sequence s_review_comment_no;

purge recyclebin;

create sequence s_calendar_no;
create sequence s_review_board_no;
create sequence s_review_image_no;
create sequence s_review_recome_no;
create sequence s_review_comment_no;

create table tb_camp_member(
	member_id varchar2(20) primary key,
	password varchar2(40) not null,
	home_addr varchar2(100) not null,
	birth_year char(4) not null,
	birth_month char(2) not null,
	birth_date char(2) not null,
	email varchar(50) not null,
	phone_number varchar2(15) null
);

create table tb_member_profile_img( 
	member_id varchar2(20),
	ori_name varchar2(150) not null,
	system_name varchar2(200) not null,
	file_size number not null,
	file_path varchar2(1000) not null,
	foreign key(member_id) references tb_camp_member(member_id) on delete set null
)

create table tb_calendar ( 
	no number(6) primary key,
	member_id varchar2(20),
	calendar_title varchar2(150) not null,
	start_date date,
	end_date date,
	description varchar2(2000),
	foreign key(member_id) references tb_camp_member(member_id) on delete set null
)

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

create table tb_review_image( 
	no number(6) primary key,
	review_no number(6),
	ori_name varchar2(150) not null,
	system_name varchar2(200) not null,
	file_size number not null,
	file_path varchar2(1000) not null,
	foreign key(review_no) references tb_review_board(review_no) on delete set null
)

create table tb_review_recom ( 
	no number(6) primary key,
	review_no number(6),
	member_id varchar2(20),
	recom_status char(1),
	check(recom_status in ('1', '0')),
	foreign key(member_id) references tb_camp_member(member_id) on delete set null,
	foreign key(review_no) references tb_review_board(review_no) on delete set null
)

create table tb_review_comment ( 
	no number(6) primary key,
	review_no number(6),
	member_id varchar2(20) not null,
	comment varchar2(1000) not null,
	reg_date date default sysdate,
	foreign key(review_no) references tb_review_board(review_no) on delete set null
)




-- root 회원가입 --

insert into tb_camp_member (
	member_id,
	password,
	home_addr,
	birth_year,
	birth_month,
	birth_date,
	phone_number,
	email
) values ( 
	'root',
	'1234',
	'성남',
	1992,
	02,
	16,
	'010-7742-9198',
	'memosha@nate.com'
) 
	
	
-- 리뷰 게시판 데이터 -- 
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
	
select * from tb_review_board

-- review_no 삽입 요망.

insert into tb_review_comment (review_no, no, member_id, review_comment) 
values(, s_review_comment_no.nextVal, '아이디1', '댓글1');
insert into tb_review_comment (review_no, no, member_id, review_comment) 
values(, s_review_comment_no.nextVal, '아이디2', '댓글2');
insert into tb_review_comment (review_no, no, member_id, review_comment) 
values(, s_review_comment_no.nextVal, '아이디3', '댓글3');
insert into tb_review_comment (review_no, no, member_id, review_comment) 
values(, s_review_comment_no.nextVal, '아이디4', '댓글4');
insert into tb_review_comment (review_no, no, member_id, review_comment) 
values(, s_review_comment_no.nextVal, '아이디5', '댓글5');
insert into tb_review_comment (review_no, no, member_id, review_comment) 
values(, s_review_comment_no.nextVal, '아이디6', '댓글6');



