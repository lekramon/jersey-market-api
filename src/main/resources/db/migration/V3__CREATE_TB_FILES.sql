CREATE TABLE tb_files
(
    id                bigint       not null auto_increment primary key,
    data              longblob     not null,
    filename          varchar(255) not null,
    type              varchar(255) not null,
    registration_date datetime(6) not null,
    product_id        bigint,
    foreign key (product_id) references tb_product (id)
);