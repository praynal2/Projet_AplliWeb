create table favorites (
	favorite_id int not null auto_increment,
    client_id int not null,
    music_id int not null,
    primary key (favorite_id),
    foreign key (client_id) references clients (id),
    foreign key (music_id) references musics (id)
) ENGINE=InnoDB;