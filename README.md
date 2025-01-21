# Forum Hub

## Dependências e Tecnologias

* Java 23
* Spring Boot 3.4.1
* Maven
* Lombok
* Spring Web
* Spring Boot DevTools
* Spring Data JPA
* Flyway Migration
* MySQL Driver
* Spring Validation
* Spring Security
* DevTools
* Json Web Token
* Spring Doc

## Tabelas

As tabelas e relacionamentos foram realizadas com base no esquema fornecido pelo desafio:

![diagrama](assets/diagrama_banco_de_dados_forumhub.png)



## Desafio Alura

Para o desafio Alura, será focado no CRUD relacionado a Tópicos. Para isso foi criado um primeiro usuário que recebe administrador que futuramente será levado em conta para mais funcionalidades da API.

```
INSERT INTO usuarios (nome, email, senha, admin, ativo)
VALUES 
    ('DBA', 'DBA@forumhub.com', '123', 1, 1);
```

Além disso foram preenchidos valores nas demais tabelas para garantir a criação de diversas instancias de tópicos.

```
INSERT INTO alura_challenge.cursos (nome, categoria)
VALUES 
	('Java e Orientação a Objetos', 'BACK_END'),
	('Java e Spring Framework', 'FULLSTACK'),
	('Iniciante em Programação', 'FRONTEND');
```

