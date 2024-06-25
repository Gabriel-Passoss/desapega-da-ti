# <h1 id="top" align="center">Desapega da **TI** - Controle de Estoque API</h1>

<p align="center">
  <a href="#sobre">Sobre</a> &#xa0; | &#xa0;
  <a href="#gear-features">Features</a> &#xa0; | &#xa0;
  <a href="#-tecnologias">Tecnologias</a> &#xa0; | &#xa0;
  <a href="#-requisitos">Requisitos</a> &#xa0; | &#xa0;
  <a href="#checkered_flag-iniciando">Iniciando</a> &#xa0; | &#xa0;
  <a href="https://github.com/RodrigoLuigi" target="_blank">Autores</a>
</p>

<br>

## <img id="sobre" src="https://imgur.com/VhTBbHg.png" alt="imagem de um notebook" align="center" width="30px"> _**O que desenvolvemos neste Projeto?**_

📌 Desapega da TI é um trabalho acadêmico no qual desenvolvemos um sistema de gerenciamento de produtos e estoque. Uma aplicação de ponta a ponta com front-end utilizando **Java Swing GUI Builder**, back-end utilizando **Java POO** e banco de dados **MySQL**.

Desenvolvemos o projeto utilizando alguns princípios do **SOLID**, com módulos separados para facilitar a escalabilidade e a manutenção da nossa aplicação.

## :gear: Features

:heavy_check_mark: Cadastro de produto\
:heavy_check_mark: Deletar produto\
:heavy_check_mark: Editar produto\
:heavy_check_mark: Listar produtos\
:heavy_check_mark: Pesquisar produtos pelo nome\
:heavy_check_mark: Pesquisar produto pelo ID

## 👨‍💻 Tecnologias

As seguintes ferramentas foram usadas neste projeto:

- [JAVA](https://docs.oracle.com/en/java/)
- [MAVEN](https://maven.apache.org/guides/)
- [DOCKER](https://docs.docker.com/)
- [MySQL](https://dev.mysql.com/doc/)

## :books: Bibliotecas

_**As seguintes bibliotecas foram utilizadas neste projeto:**_

- [Swing GUI Builder](https://docs.oracle.com/javase/tutorial/uiswing/index.html)

## 📝 Requisitos

- [Git](https://git-scm.com)
- [JDK](https://www.oracle.com/br/java/technologies/downloads/)
- [Netbeans](https://netbeans.apache.org/front/main/index.html)

## Diagram

💡 Diagrama de Entidades e Relacionamentos(DER) para evoluir o projeto.

<div align="center">
  <img src="./public/DER.png" width="100%">
</div>

## :checkered_flag: Iniciando

```bash
# Clone este projeto
$ git clone https://github.com/Gabriel-Passoss/desapega-da-ti.git

# Acesse o projeto
$ cd desapega-da-ti

# Instale as dependências
$ mvn clean install

# Inicializando container MySQL
$ docker compose up -d
```


```bash
#Criando a tabela de produtos no banco de dados

  CREATE TABLE IF NOT EXISTS desapega.products (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(250) NOT NULL,
  description VARCHAR(250) NOT NULL,
  quantity INT NOT NULL,
  price DOUBLE NOT NULL,
  created_at DATE NOT NULL,
  PRIMARY KEY (id))
  ENGINE = InnoDB
  AUTO_INCREMENT = 3
  COLLATE = utf8mb4_0900_ai_ci
```


&#xa0;

_**Feito por**_ 

 👨‍🚀 [@Gabriel dos Passos](https://github.com/Gabriel-Passoss)

 👨‍🚀 [@Rodrigo Luigi](https://github.com/RodrigoLuigi)

 👨‍🚀 [@Leonardo Schimitt](https://github.com/SchmittLeonardo)

<a href="#top">🔝 Back to top</a>

