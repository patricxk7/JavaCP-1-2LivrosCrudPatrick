# CRUD de Livros

Projeto desenvolvido em Java com integração ao Oracle Database, utilizando JDBC e padrões de projeto para implementação de um sistema CRUD (Create, Read, Update e Delete).

## Objetivo

Desenvolver uma aplicação capaz de realizar o gerenciamento de livros em um banco de dados Oracle, aplicando conceitos de Programação Orientada a Objetos, JDBC e padrões de projeto.

O sistema permite:

- Cadastrar livros
- Listar livros cadastrados
- Buscar livros por ID
- Atualizar informações de livros
- Excluir livros

## Tecnologias

- Java
- JDBC
- Oracle Database
- Oracle JDBC Driver
- IntelliJ IDEA
- Git e GitHub

## Padrões de Projeto

### Singleton

Utilizado na classe `ConnectionSingleton` para garantir uma única instância compartilhada da conexão com o banco de dados.

### DAO

O padrão DAO é utilizado para separar a lógica de acesso ao banco de dados da lógica principal da aplicação.

A interface `LivrosDAO` define as operações disponíveis:

- `salvar()`
- `buscarPorId()`
- `listarTodos()`
- `atualizar()`
- `deletar()`

A classe `LivrosDAOImpl` implementa essas operações utilizando JDBC.

### Factory

A classe `DAOFactory` é responsável pela criação do objeto `LivrosDAO`, utilizando a conexão fornecida pelo `ConnectionSingleton`.

## Estrutura do Projeto

```text
src
├── br.com.cp12.crudlivros
│   └── Main.java
│
├── connection
│   └── ConnectionSingleton.java
│
├── dao
│   ├── LivrosDAO.java
│   └── LivrosDAOImpl.java
│
├── factory
│   └── DAOFactory.java
│
└── model
    └── Livros.java
