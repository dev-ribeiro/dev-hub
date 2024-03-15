CREATE TABLE IF NOT EXISTS negocio.posts (
    id VARCHAR(36) PRIMARY KEY,
    id_pessoa VARCHAR(36),
    titulo VARCHAR(50) NOT NULL,
    conteudo VARCHAR(500) NOT NULL,
    data_criacao TIMESTAMP NOT NULL,
    data_atualizacao TIMESTAMP NOT NULL,
    
    FOREIGN KEY (id_pessoa) REFERENCES gestao.pessoa(id)
);
