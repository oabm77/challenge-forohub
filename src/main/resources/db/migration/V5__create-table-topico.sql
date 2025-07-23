create table topico(
    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(512) not null,
    fecha_creacion datetime not null,
    status varchar(100) not null,
    autor bigint not null,
    curso bigint not null,
    primary key(id),
    foreign key (autor) references usuario(id) on delete cascade,
    foreign key (curso) references curso(id) on delete cascade
);