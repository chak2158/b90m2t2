drop table tb_review_board


create table tb_review_board(
	review_no number(2),
	member_id varchar2(20) not null,
	title varchar2(1000) not null,
	content varchar2(3000) not null,
	reg_date date,
	recom_cnt number(6) not null,
	unrecom_cnt number(6) not null,
	map_latitude varchar2(1000) not null,
	map_longitude varchar2(1000) not null,
	view_cnt number(6)
	constraint pk_tb_review_board primary key (review_no)
	);
	
	create sequence tb_review_board_no
	create sequence tb_review_board_no_reg_date
	
	drop sequence tb_board_no_reg_date

create table tb_review_comment(
	no number(6) not null,
	review_no number(6) not null,
	comment varchar2(500) not null,
	member_id varchar2(15) not null,
	reg_date date,
	constraint pk_tb_review_comment primary key (no)
	foreign key(review_no) references tb_review_board(review_no),
	);
	
create sequence tb_review_comment_no
	










