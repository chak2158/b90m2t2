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
	password varchar2(20) not null,
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
	member_id varchar2(20),
	recom_status char(1),
	check(recom_status in ('1','0')),
	reg_date date default sysdate,
	foreign key(review_no) references tb_review_board(review_no) on delete set null
)





