create table usuario_perfil(
    usuario_id bigint not null,
    perfil_id bigint not null,
    primary key(usuario_id, perfil_id),
    foreign key (usuario_id) references usuario(id) on delete cascade,
    foreign key (perfil_id) references perfil(id) on delete cascade
);