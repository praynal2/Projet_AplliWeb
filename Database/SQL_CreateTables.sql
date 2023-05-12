create table favoritestyles (
	favstyle_id int not null auto_increment,
    client_id int not null,
    style_id int not null,
    primary key (favstyle_id),
    foreign key (client_id) references clients (id),
    foreign key (style_id) references styles (id)
) ENGINE=InnoDB;