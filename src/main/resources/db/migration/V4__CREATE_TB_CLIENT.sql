CREATE TABLE tb_client
(
    id                bigint       not null auto_increment primary key,
    name              varchar(60)  not null,
    email             varchar(50)  not null,
    password          varchar(100) not null,
    cpf               varchar(14)  not null,
    gender            smallint     not null,
    status            int,
    data_nascimento   varchar(10)  not null,
    registration_date datetime(6) not null
);