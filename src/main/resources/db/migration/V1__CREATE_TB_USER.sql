CREATE TABLE tb_user
(
    id                bigint       not null auto_increment primary key,
    name              varchar(60)  not null,
    email             varchar(50)  not null,
    password          varchar(100) not null,
    cpf               varchar(14)  not null,
    user_group        smallint     not null,
    status            int,
    registration_date datetime(6) not null
);

INSERT INTO tb_user (name, email, password, cpf, user_group, status, registration_date)
VALUES ('Ramon', 'ramon@jersey.com', '$2a$12$djZnPE5KGqU6dSou48v1OeYq7josh4JO1Tu454wFlxFkIMQM.1v7m', '954.290.950-01',
        1, 1, NOW()),
       ('Alexandre', 'ale@jersey.com', '$2a$12$djZnPE5KGqU6dSou48v1OeYq7josh4JO1Tu454wFlxFkIMQM.1v7m', '179.966.280-25',
        1, 1, NOW()),
       ('Lucas', 'lucas@jersey.com', '$2a$12$djZnPE5KGqU6dSou48v1OeYq7josh4JO1Tu454wFlxFkIMQM.1v7m', '157.302.310-83',
        1, 1, NOW()),
       ('Erick', 'erick@jersey.com', '$2a$12$djZnPE5KGqU6dSou48v1OeYq7josh4JO1Tu454wFlxFkIMQM.1v7m', '410.550.890-39',
        1, 1, NOW());
