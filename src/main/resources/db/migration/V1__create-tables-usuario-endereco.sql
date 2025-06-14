CREATE TABLE endereco (
                          id BIGSERIAL PRIMARY KEY,
                          uuid UUID not null,
                          cep VARCHAR(10) NOT NULL,
                          rua VARCHAR(100) NOT NULL,
                          numero INT NOT NULL,
                          bairro VARCHAR(50) NOT NULL,
                          cidade VARCHAR(50) NOT NULL,
                          estado VARCHAR(2) NOT NULL
);


CREATE TABLE usuario (
                         id BIGSERIAL PRIMARY KEY,
                         uuid UUID not null,
                         fk_id_endereco BIGINT,
                         nome VARCHAR(100) NOT NULL,
                         cpf VARCHAR(14) NOT NULL UNIQUE,
                         telefone VARCHAR(15) NOT NULL UNIQUE,
                         data_nascimento VARCHAR(10) NOT NULL,
                         email VARCHAR(100) NOT NULL UNIQUE,
                         senha VARCHAR(100) NOT NULL,
                         permissao VARCHAR(20),
                         FOREIGN KEY (fk_id_endereco) REFERENCES endereco(id)
);

CREATE TABLE viagem (
                         id BIGSERIAL PRIMARY KEY,
                         uuid UUID not null,
                         nome VARCHAR(100) NOT NULL,
                         data_viagem DATE NOT NULL,
                         motorista VARCHAR(100) NOT NULL,
                         quantidade_vagas INT NOT NULL
);
