alter table curso add column activo tinyint not null default 1;
alter table usuario add column activo tinyint not null default 1;
alter table topico add column activo tinyint not null default 1;
alter table respuesta add column activo tinyint not null default 1;