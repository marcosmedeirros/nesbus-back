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
                         quantidade_vagas INT NOT NULL
);

CREATE TABLE solicitacao (
                         id BIGSERIAL PRIMARY KEY,
                         uuid UUID not null,
                         fk_id_usuario BIGINT,
                         fk_id_viagem BIGINT,
                         status BOOLEAN NOT NULL,
                         acompanhante BOOLEAN NOT NULL,
                         informacoes VARCHAR(200),
                         hospital VARCHAR(100) NOT NULL,
                         FOREIGN KEY (fk_id_usuario) REFERENCES usuario(id)


);

CREATE TABLE viagemdata (
                             id BIGSERIAL PRIMARY KEY,
                             uuid UUID not null,
                             fk_id_solicitacao BIGINT NOT NULL,
                             fk_id_viagem BIGINT NOT NULL,
                             vagas_ocupadas INT NOT NULL,
                             CONSTRAINT fk_viagem FOREIGN KEY (fk_id_viagem) REFERENCES viagem(id) ON DELETE RESTRICT,
                             CONSTRAINT fk_solicitacao FOREIGN KEY (fk_id_solicitacao) REFERENCES solicitacao(id) ON DELETE CASCADE
);