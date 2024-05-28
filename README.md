
# Desapega da TI

Projeto proposto pela faculdade UNISUL para a matéria de Programação.

Consiste em um gerenciador de estoque para uma empresa, realizando o CRUD dos produtos
## Rodando localmente

Clone o projeto

```bash
  git clone https://github.com/Gabriel-Passoss/desapega-da-ti.git
```

Entre no diretório do projeto

```bash
  cd desapega-da-ti
```

Instale as dependências

```bash
  mvn clean install
```

Suba um container MySQL

```bash
  docker compose up -d
```

Adicione a tabela necessária no banco de dados

```bash
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

Inicie o projeto localmente


## Autores

- [@Gabriel dos Passos](https://github.com/Gabriel-Passoss)
- [@Rodrigo Luigi](https://github.com/RodrigoLuigi)
- [@Leonardo Schimitt](https://github.com/SchmittLeonardo)


## Stack utilizada

Java, Maven, SwingUI, MySQL, Docker

