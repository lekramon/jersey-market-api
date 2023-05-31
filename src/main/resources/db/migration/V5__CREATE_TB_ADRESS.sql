CREATE TABLE tb_adress
(
    id          bigint       not null auto_increment primary key,
    bairro      varchar(100) not null,
    cep         varchar(9)   not null,
    complemento varchar(100) not null,
    localidade  varchar(100) not null,
    logradouro  varchar(100) not null,
    numero      varchar(10)  not null,
    status      smallint     not null,
    type        smallint     not null,
    uf          varchar(2)   not null,
    client_id bigint,
    foreign key (client_id) references tb_client (id)
);