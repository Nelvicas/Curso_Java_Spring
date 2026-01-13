CREATE TABLE medicos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    documento VARCHAR(20) NOT NULL,
    especialidad VARCHAR(50) NOT NULL,

    calle VARCHAR(100) not null,
    barrio VARCHAR(100) not null,
    codigo_postal VARCHAR(12) not null,
    ciudad VARCHAR(100) not null,
    estado VARCHAR(100) not null,
    numero VARCHAR(20),
    complemento VARCHAR(100),

    PRIMARY KEY (id)
);
