create table respuesta(
    id bigint not null auto_increment,
    mensaje varchar(512) not null,
    topico bigint not null,
    fecha_creacion datetime not null,
    autor bigint not null,
    solucion tinyint not null default 0,
    primary key(id),
    constraint fk_respuesta_topico_id foreign key (topico) references topico(id),
    constraint fk_respuesta_usuario_id foreign key (autor) references usuario(id)
);