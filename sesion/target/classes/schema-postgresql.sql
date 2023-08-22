/*create database prueba
    with
    Owner = postgres
    tablespace = pg_default;*/

create table persona(
    id integer primary key,
    nombres varchar(60) not null,
    apellidos varchar(60) not null,
    identificacion varchar(10) not null,
    fecha_nacimiento date not null
);

create table usuarios(
    id integer primary key,
    user_name varchar(50),
    password varchar (50),
    mail varchar(120),
    session_active char(1),
    persona_id_persona2 integer,
    status char(20),
    constraint usuarios_persona_fkv1 foreign key (persona_id_persona2)
    references persona(id)
);

create table sessions(
    fecha_ingreso date not null,
    fecha_cierre date not null,
    usuarios_id int not null,
    constraint sessions_usuarios_fk foreign key (usuarios_id)
    references usuarios(id)
);

create table rol(
    id integer primary key,
    rol_name varchar(50) not null
);

create table rol_opciones(
    nombre_opcion varchar(50) not null,
    id int primary key
);

create table rol_usuarios(
    rol_id int not null,
    usuarios_id int not null,
    constraint relation_4_pk primary key (rol_id, usuarios_id),
    constraint relation_4_rol_fk foreign key (rol_id)
    references rol(id),
    constraint relation_4_usuarios_fk foreign key (usuarios_id)
    references usuarios(id)
);

create table rol_rol_opciones(
    rol_id int not null,
    rol_opciones_id int not null,
    constraint relation_10_pk primary key (rol_id, rol_opciones_id),
    constraint relation_10_rol_fk foreign key (rol_id)
    references rol(id),
    constraint relation_10_rol_opciones_fk foreign key (rol_opciones_id)
    references rol_opciones(id)
);

insert into rol_opciones (nombre_opcion, id) values
('administrador', 1),
('usuario', 2);

insert into rol (id, rol_name) values 
(1, 'administrador');

insert into rol_rol_opciones (rol_id,rol_opciones_id) values
(1,1);