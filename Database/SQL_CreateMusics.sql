create table musics (
	id int not null auto_increment,
    music_name char(20) not null,
    price int not null,
    style_id int not null,
    music_url char(100) not null,
    image_url char(100) not null,
    primary key (id),
    foreign key (style_id) references styles (id)
) ENGINE=InnoDB;