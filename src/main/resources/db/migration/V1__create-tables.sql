-- Tabela cursos
CREATE TABLE cursos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    categoria VARCHAR(100) NOT NULL,

    PRIMARY KEY (id)
);


-- Tabela perfis
CREATE TABLE perfis (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,

    PRIMARY KEY (id)
);


-- Tabela Resposta
CREATE TABLE respostas (
    id BIGINT NOT NULL AUTO_INCREMENT,
    mensagem TEXT NOT NULL,
    topico_id BIGINT NOT NULL,
    data_criacao DATETIME NOT NULL,
    usuario_id BIGINT NOT NULL,

    PRIMARY KEY (id)
);


-- Tabela tópicos
CREATE TABLE topicos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    mensagem TEXT NOT NULL,
    data_criacao DATETIME NOT NULL,
    status VARCHAR(100) NOT NULL,
    usuario_id BIGINT NOT NULL,
    curso_id BIGINT NOT NULL,

    PRIMARY KEY (id)
);


-- Tabela usuarios
CREATE TABLE usuarios (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    admin TINYINT NOT NULL,
    ativo TINYINT NOT NULL,

    PRIMARY KEY (id)
);


-- Tabela intermediária usuários/perfis
CREATE TABLE usuarios_perfis(
    usuario_id BIGINT NOT NULL,
    perfil_id BIGINT NOT NULL,

    PRIMARY KEY (usuario_id, perfil_id)
);

-- Chaves Estrangeiras - Tabela topicos
ALTER TABLE topicos
ADD CONSTRAINT fk_topico_usuario
FOREIGN KEY (usuario_id) REFERENCES usuarios(id);

ALTER TABLE topicos
ADD CONSTRAINT fk_topico_curso
FOREIGN KEY (curso_id) REFERENCES cursos(id);


-- Chaves Estrangeiras - Tabela respostas
ALTER TABLE respostas
ADD CONSTRAINT fk_resposta_topico
FOREIGN KEY (topico_id) REFERENCES topicos(id);

ALTER TABLE respostas
ADD CONSTRAINT fk_resposta_usuario
FOREIGN KEY (usuario_id) REFERENCES usuarios(id);


-- Chaves Estrangeiras - Tabela intermediária usuários/perfis
ALTER TABLE usuarios_perfis
ADD CONSTRAINT fk_int_usuario
FOREIGN KEY (usuario_id) REFERENCES usuarios(id);

ALTER TABLE usuarios_perfis
ADD CONSTRAINT fk_int_perfil
FOREIGN KEY (perfil_id) REFERENCES perfis(id);