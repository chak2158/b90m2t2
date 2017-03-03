drop table tb_review_board

select * from tb_review_board

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
	
	create sequence tb_review_board_no
	create sequence tb_review_board_no_reg_date
	
	<!--drop sequence tb_board_no_reg_date --!>
	

	insert into tb_review_board (review_no, member_id, title, content, recom_cnt, unrecom_cnt, map_latitude, map_longitude, view_cnt) 
	values(s_review_board_review_no.nextVal, 'lhw13', '캠프파이어', '캠핑지설명', 0, 0, '0', '0', 0);
	insert into tb_review_board (review_no, member_id, title, content, recom_cnt, unrecom_cnt, map_latitude, map_longitude, view_cnt) 
	values(s_review_board_review_no.nextVal, 'lhw14', '캠프파이어2', '캠핑지설명2', 01, 01, '01', '01', 02);
	insert into tb_review_board (review_no, member_id, title, content, recom_cnt, unrecom_cnt, map_latitude, map_longitude, view_cnt) 
	values(s_review_board_review_no.nextVal, 'lhw15', '캠프파이어3', '캠핑지설명3', 02, 02, '02', '02', 02);
	

	
	create sequence s_review_board_review_no
	
	
	
select * from tb_review_comment
	
	drop table tb_review_comment
	purge recyclebin
	
create table tb_review_comment(
	no number(6) primary key,
	review_no number(6) not null,
	member_id varchar2(15) not null,
	reg_date date default sysDate,
	review_comment varchar2(500) not null,
	foreign key(review_no) references tb_review_board(review_no)
);

	insert into tb_review_comment (review_no, no, member_id, review_comment) 
	values(4, s_review_comment_no.nextVal, '진호', '댓글');

	create sequence tb_review_comment_no




	
	


