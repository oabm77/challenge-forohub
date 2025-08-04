create table topico(
    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(512) not null,
    fecha_creacion datetime not null,
    status varchar(100) not null,
    autor bigint not null,
    curso bigint not null,
    respuestas int not null default 0,
    primary key(id),
    constraint fk_topico_usuario_id foreign key (autor) references usuario(id),
    constraint fk_topico_curso_id foreign key (curso) references curso(id)
);