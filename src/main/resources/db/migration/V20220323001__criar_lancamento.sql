CREATE TABLE lancamento (
	codigo BIGINT AUTO_INCREMENT,
	descricao VARCHAR(50) NOT NULL,
	data_vencimento DATE NOT NULL,
	data_pagamento DATE,
	valor DECIMAL(10,2) NOT NULL,
	observacao VARCHAR(100),
	tipo VARCHAR(20) NOT NULL,
	codigo_categoria BIGINT NOT NULL,
	codigo_pessoa BIGINT NOT NULL,
    CONSTRAINT pk_lancamento PRIMARY KEY (codigo),
	CONSTRAINT fk_lancamento_pessoa FOREIGN KEY (codigo_pessoa) REFERENCES pessoa(codigo),
	CONSTRAINT fk_lancamento_categoria FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;