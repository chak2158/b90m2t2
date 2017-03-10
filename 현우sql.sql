

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
values(129, s_review_comment_no.nextVal, '아이디1', '댓글1');
insert into tb_review_comment (review_no, no, member_id, review_comment) 
values(129, s_review_comment_no.nextVal, '아이디2', '댓글2');
insert into tb_review_comment (review_no, no, member_id, review_comment) 
values(129, s_review_comment_no.nextVal, '아이디3', '댓글3');
insert into tb_review_comment (review_no, no, member_id, review_comment) 
values(129, s_review_comment_no.nextVal, '아이디4', '댓글4');
insert into tb_review_comment (review_no, no, member_id, review_comment) 
values(129, s_review_comment_no.nextVal, '아이디5', '댓글5');
insert into tb_review_comment (review_no, no, member_id, review_comment) 
values(129, s_review_comment_no.nextVal, '아이디6', '댓글6');

