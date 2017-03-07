delete 
from tb_member_profile_img 

delete
from tb_camp_member



select * from tb_camp_member

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

select * from tb_camp_member
select * from tb_member_profile_img


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
	foreign key(member_id) references tb_camp_member(member_id) on delete set null,
	foreign key(member_id) references tb_social_member(social_user_email) on delete set null
)

create table tb_social_member ( 
	social_user_email varchar(40) primary key
);

insert into tb_social_member (
	social_user_email
) values ( 
	'email'
)