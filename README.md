# 📚 BibliotecaAPI

![Java](https://img.shields.io/badge/Java-11%2B-orange?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-Framework-brightgreen?style=for-the-badge&logo=springboot)
![Maven](https://img.shields.io/badge/Maven-Build-red?style=for-the-badge&logo=apachemaven)
![REST API](https://img.shields.io/badge/API-REST-blue?style=for-the-badge)

---

## 🏫 Sobre o Projeto

A **BibliotecaAPI** é uma aplicação backend desenvolvida em **Java com Spring Boot**, que simula um sistema de gerenciamento de biblioteca.

---

## 📦 Estrutura do projeto

* Controller → endpoints da API
* Service → regras de negócio
* Repository → acesso ao banco
* Model → entidades JPA
* DTO → transferência de dados
* Exception/Handler → tratamento de erros
  
---

## 📁 Estrutura de Pastas

```text
BibiliotecaAPI/
├── src/
│   ├── main/
│   │   ├── java/br/com/projeto/biblioteca/
│   │   │   ├── controller/
│   │   │   ├── database/
│   │   │   │   ├── model/
│   │   │   │   └── repository/
│   │   │   ├── dto/
│   │   │   ├── exception/
│   │   │   ├── handler/
│   │   │   └── service/
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```
---

# 📚 Endpoints

## 👨‍🏫 Autor

| Método | Endpoint                   | Descrição                |
| ------ | -------------------------- | ------------------------ |
| POST   | `/autores`                 | Cria um novo autor       |
| GET    | `/autores`                 | Lista todos os autores   |
| GET    | `/autores/{id}`            | Busca autor por ID       |
| DELETE | `/autores/{id}`            | Deleta um autor          |
| PUT    | `/autores/{id}`            | Atualiza um autor        |
| GET    | `/autores/{autorId}/obras` | Lista livros de um autor |

---

## 👤 Cliente

| Método | Endpoint         | Descrição                        |
| ------ | ---------------- | -------------------------------- |
| POST   | `/clientes`      | Cria um novo cliente             |
| GET    | `/clientes`      | Lista todos os clientes          |
| GET    | `/clientes/{id}` | Busca cliente por ID             |
| DELETE | `/clientes/{id}` | Deleta um cliente                |
| PATCH  | `/clientes/{id}` | Atualiza parcialmente um cliente |

---

## 📖 Livro

| Método | Endpoint       | Descrição                      |
| ------ | -------------- | ------------------------------ |
| POST   | `/livros`      | Cria um novo livro             |
| GET    | `/livros`      | Lista todos os livros          |
| GET    | `/livros/{id}` | Busca livro por ID             |
| PATCH  | `/livros/{id}` | Atualiza parcialmente um livro |

---

## 🔄 Empréstimo

| Método | Endpoint                     | Descrição                |
| ------ | ---------------------------- | ------------------------ |
| POST   | `/emprestimos`               | Realiza um empréstimo    |
| PUT    | `/emprestimos/{id}/devolver` | Marca devolução do livro |

---

## 🚀 Tecnologias utilizadas

* Java 11
* Spring Boot 2.7.18
* Spring Web
* Spring Data JPA
* Spring Validation
* PostgreSQL
* Lombok
* Maven

---

## 🗄️ Banco de Dados

Banco utilizado: **PostgreSQL**

Configuração (application.properties):

```properties
server.port=8082
spring.application.name=BibliotecaAPI

spring.datasource.url=jdbc:postgresql://localhost:5432/library
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

### 📌 Observações:

* O banco deve se chamar: `library`
* Usuário padrão: `postgres`
* Senha padrão: `postgres`
* Hibernate está configurado como `update` (cria/atualiza tabelas automaticamente)

---

## ▶️ Como executar o projeto

### 1. Pré-requisitos

Antes de rodar o projeto, você precisa ter instalado:

* Java 11
* Maven
* PostgreSQL
* Uma IDE (IntelliJ, Eclipse ou VS Code)

---

### 2. Criar o banco de dados

No PostgreSQL, execute:

```sql
CREATE DATABASE library;
```

---

### 3. Clonar o projeto

```bash
git clone <URL_DO_REPOSITORIO>
cd BibliotecaAPI
```

---

### 4. Rodar a aplicação

Com Maven:

```bash
mvn spring-boot:run
```

Ou execute a classe principal:

```java
BibliotecaApplication.java
```
## 🧪 Como testar a API

Para testar os endpoints da aplicação, é recomendado utilizar ferramentas como:

* Postman
* Insomnia

Essas ferramentas permitem enviar requisições HTTP (GET, POST, PUT, DELETE, PATCH) para a API e visualizar as respostas de forma organizada.

### 📌 Como funciona

Você deve informar:
* A URL do endpoint (ex: `http://localhost:8082/livros`)
* O método HTTP (GET, POST, etc.)
* O corpo da requisição (quando necessário, em JSON)

### 📍 Exemplo de requisição

```http
POST http://localhost:8082/livros
```

```json
{
  "titulo": "Clean Code",
  "autorId": 1
}
```
---


