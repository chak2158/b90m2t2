create table tb_my_page(
		id varchar2(20),
		title varchar2(1000) not null,
		start_date varchar2(10),
		end_date varchar2(10),
		primary key (id)
)

drop table tb_my_page

select  *
		from tb_my_page;