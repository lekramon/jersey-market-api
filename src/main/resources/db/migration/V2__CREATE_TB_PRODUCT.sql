CREATE TABLE tb_product
(
    productId         bigint        not null auto_increment primary key,
    name              varchar(60)   not null,
    description       varchar(2000) not null,
    price             float(53)     not null,
    quantity          int           not null,
    rating            float(53)     not null,
    status            int,
    registration_date datetime(6) not null
);

INSERT INTO tb_product (name, description, price, quantity, rating, status, registration_date)
VALUES ('Chuteira Nike Superfly 9 Club Futsal',
        'Incline instantaneamente o campo no design ousado da Superfly 9 Club IC leve e baixa. A velocidade está no Air.',
        449.99, 100,
        0, 1, NOW()),
       ('Chuteira Nike Phantom GT2 Academy Society',
        'Continuando o legado da Phantom GT, a Nike Jr. Phantom GT2 Dynamic Fit TF apresenta um design atualizado e um padrão projetado para ajudar a posicionar a bola com uma precisão incomparável. Os cadarços descentralizados criam uma zona de chute livre de obstáculos para chutes, passes e dribles precisos.',
        579.99, 120,
        0, 1, NOW()),
       ('Camisa Nike Liverpool 2023/24 Torcedor Pro Masculina',
        'Homenageie um dos maiores investimentos iniciais do rei com esta camisa de malha respirável. Com um design inspirado tanto no LeBron James como no Liverpool FC, ela celebra a participação do Rei nos Reds. Além disso, a tecnologia de absorção do suor ajuda a manter você seco e concentrado no campo.',
        399.99, 50,
        0, 1, NOW()),
       ('Camisa Nike Liverpool 2023/24 Torcedor Pro Masculina',
        'Homenageie um dos maiores investimentos iniciais do rei com esta camisa de malha respirável. Com um design inspirado tanto no LeBron James como no Liverpool FC, ela celebra a participação do Rei nos Reds. Além disso, a tecnologia de absorção do suor ajuda a manter você seco e concentrado no campo.',
        399.99, 50,
        0, 1, NOW()),
       ('Chuteira Nike Phantom GT2 Academy Society',
        'Continuando o legado da Phantom GT, a Nike Jr. Phantom GT2 Dynamic Fit TF apresenta um design atualizado e um padrão projetado para ajudar a posicionar a bola com uma precisão incomparável. Os cadarços descentralizados criam uma zona de chute livre de obstáculos para chutes, passes e dribles precisos.',
        579.99, 120,
        0, 1, NOW()),
       ('Chuteira Nike Superfly 9 Club Futsal',
        'Incline instantaneamente o campo no design ousado da Superfly 9 Club IC leve e baixa. A velocidade está no Air.',
        449.99, 100,
        0, 1, NOW()),
       ('Regata Nike Dri-FIT ADV AeroSwift Masculina',
        'Você superou as dificuldades para competir com os melhores. Portanto, permita que a regata Nike Dri-FIT ADV AeroSwift leve você até o final. Ela é leve e suave como uma seda e usa nossas tecnologias mais inovadoras para que você dê o melhor de si. Este produto é feito com, no mínimo, 75% de fibras de poliéster reciclado.',
        499.99, 11,
        0, 1, NOW()),
       ('Regata Nike Dri-FIT ADV AeroSwift Masculina',
        'Você superou as dificuldades para competir com os melhores. Portanto, permita que a regata Nike Dri-FIT ADV AeroSwift leve você até o final. Ela é leve e suave como uma seda e usa nossas tecnologias mais inovadoras para que você dê o melhor de si. Este produto é feito com, no mínimo, 75% de fibras de poliéster reciclado.',
        499.99, 11,
        0, 1, NOW()),
       ('Regata Nike Dri-FIT ADV AeroSwift Masculina',
        'Você superou as dificuldades para competir com os melhores. Portanto, permita que a regata Nike Dri-FIT ADV AeroSwift leve você até o final. Ela é leve e suave como uma seda e usa nossas tecnologias mais inovadoras para que você dê o melhor de si. Este produto é feito com, no mínimo, 75% de fibras de poliéster reciclado.',
        499.99, 11,
        0, 1, NOW()),
       ('Chuteira Nike Phantom GT2 Academy Society',
        'Continuando o legado da Phantom GT, a Nike Jr. Phantom GT2 Dynamic Fit TF apresenta um design atualizado e um padrão projetado para ajudar a posicionar a bola com uma precisão incomparável. Os cadarços descentralizados criam uma zona de chute livre de obstáculos para chutes, passes e dribles precisos.',
        579.99, 120,
        0, 1, NOW()),
       ('Chuteira Nike Phantom GT2 Academy Society',
        'Continuando o legado da Phantom GT, a Nike Jr. Phantom GT2 Dynamic Fit TF apresenta um design atualizado e um padrão projetado para ajudar a posicionar a bola com uma precisão incomparável. Os cadarços descentralizados criam uma zona de chute livre de obstáculos para chutes, passes e dribles precisos.',
        579.99, 120,
        0, 1, NOW());
