use data;
create table clients (
	id int not null auto_increment,
	login char(15) not null,
    pass char(20) not null,
    primary key (id)
);