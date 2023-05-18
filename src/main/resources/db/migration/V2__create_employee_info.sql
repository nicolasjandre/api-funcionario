create table cargo (
    cargo_id bigint not null,
    nome varchar(255),
    salario numeric(38, 2),
    primary key (cargo_id)
);

create table funcionario (
    funcionario_id bigint not null,
    cpf varchar(255),
    nome varchar(255),
    cargo_id bigint,
    turno_id bigint,
    primary key (funcionario_id)
);

create table turno (
    turno_id bigint not null,
    duracao_descanso integer,
    hora_descanso varchar(255),
    hora_entrada varchar(255),
    hora_saida varchar(255),
    tipo_turno smallint,
    primary key (turno_id)
);

alter table
    if exists funcionario
add
    constraint cpf_unique unique (cpf);

alter table
    if exists funcionario
add
    constraint FK1mmiur94efkujcsaab0cdgskv foreign key (cargo_id) references cargo;

alter table
    if exists funcionario
add
    constraint FKi3vol732uudaha2769nqm0kat foreign key (turno_id) references turno;