create table respuesta(
    id bigint not null auto_increment,
    mensaje varchar(512) not null,
    topico bigint not null,
    fecha_creacion datetime not null,
    autor bigint not null,
    solucion varchar(100),
    primary key(id),
    foreign key (topico) references topico(id) on delete cascade,
    foreign key (autor) references usuario(id) on delete cascade
);