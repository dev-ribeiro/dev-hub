CREATE TABLE IF NOT EXISTS gestao.pessoa (
    id VARCHAR(36) PRIMARY KEY,
    primeiro_nome VARCHAR(50) NOT NULL,
    sobrenome VARCHAR(100) NOT NULL,
    email VARCHAR(64) UNIQUE NOT NULL,
    celular VARCHAR(15),
    senha VARCHAR(50) NOT NULL
);