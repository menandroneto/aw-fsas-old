CREATE TABLE pessoa (
    codigo BIGINT AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    logradouro VARCHAR(30),
    numero VARCHAR(30),
    complemento VARCHAR(30),
    bairro VARCHAR(30),
    cep VARCHAR(30),
    cidade VARCHAR(30),
    estado VARCHAR(30),
    ativo BOOLEAN NOT NULL,
    CONSTRAINT pk_pessoa PRIMARY KEY (codigo)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;