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

delete 
from tb_member_profile_img 
where member_id = 'memosha'



