create table e_pingou.User
(
	uid int auto_increment
		primary key,
	nick varchar(15) null,
	phone varchar(11) null,
	password varchar(32) null,
	qq varchar(12) null,
	avater varchar(100) null,
	name varchar(10) null,
	email varchar(320) null,
	email_valid tinyint(1) null,
	address varchar(20) null,
	token varchar(32) not null
)
;

create table e_pingou.second_hand_good
(
	gid int auto_increment
		primary key,
	seller int not null,
	name varchar(30) not null,
	description varchar(200) null,
	price double null,
	sold tinyint(1) default '0' not null,
	category int default '7' not null
)
;

create table e_pingou.second_hand_picture
(
	pid int auto_increment
		primary key,
	name varchar(40) not null,
	gid int not null
)
;

create index second_hand_picture_second_hand_good_gid_fk
	on second_hand_picture (gid)
;


