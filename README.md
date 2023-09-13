# Autenticação Stateful e Stateless em Microsserviços

Este repositório contém o projeto desenvolvido para abordar os conceitos de autenticação stateful e stateless em microsserviços.

## Tecnologias Utilizadas

O projeto foi desenvolvido utilizando as seguintes tecnologias:

- **Java 17:** A linguagem de programação principal usada no projeto.
- **Spring Boot 3:** Framework para o desenvolvimento de aplicações Java baseadas em microsserviços.
- **API REST:** Utilizada para criar endpoints para comunicação entre os microsserviços.
- **PostgreSQL (Container):** Banco de dados relacional usado para armazenar os dados do aplicativo, executado em um contêiner Docker.
- **Redis (Container):** Banco de dados em memória usado para armazenar cache e dados temporários, executado em um contêiner Docker.
- **Docker:** Usado para empacotar a aplicação e suas dependências em contêineres isolados.
- **docker-compose:** Ferramenta para definir e executar aplicativos compostos por vários contêineres Docker.
- **JWT (JSON Web Tokens):** Utilizado para autenticação e autorização na API.

## Descrição do Projeto

Foram desenvolvidos 2 projetos, o projeto stateless e o projeto stateful. Cada projeto possui 2 aplicações, totalizando 4 APIs. Em cada projeto, temos a API de Auth, responsável por gerar o token. Em cada projeto, temos a API chamada Any, responsável por retornar uma informação, qualquer, que irá apenas simular um microsserviço aleatório que precisa validar o token.

Na arquitetura stateful, foi utilizado o banco de dados NoSQL Redis para armazenar os tokens.

## Acessando as Aplicações

Os acessos de host e porta das aplicações são os seguintes:

- **stateless-auth-api:** http://localhost:8080/swagger-ui/index.html
- **stateless-any-api:** http://localhost:8081/swagger-ui/index.html
- **stateful-auth-api:** http://localhost:8082/swagger-ui/index.html
- **stateful-any-api:** http://localhost:8083/swagger-ui/index.html

## Acessando os Bancos de Dados

Os acessos de host e porta dos bancos de dados são os seguintes:

- **stateless-auth-db (PostgreSQL):** localhost:5432
- **stateful-auth-db (PostgreSQL):** localhost:5433
- **token-redis (Redis):** localhost:6379

## Executando os Projetos

Existem três maneiras de rodar todos os projetos, via script utilitário que deixei para auxiliar no desenvolvimento, manualmente ou via docker-compose.

**Observação:** Independente da maneira que você queira rodar, será necessário realizar o build das aplicações com o comando `gradle build` na raiz de cada aplicação, para poder criar suas imagens, ou seja, será necessário ter o Docker e o Gradle instalado.

### Rodando tudo com script utilitário

Para rodar tudo com o script, basta executar o comando:

`python build.py`

Para isso, será necessário ter o Python 3 instalado.

O script fará todos os seguintes processos:

- Parará e apagará todos os containers rodando.
- Entrará no diretório de cada uma das 4 APIs e rodará o comando `gradle build` em paralelo para não levar muito tempo realizando sequencialmente.
- Irá aguardar o build de cada API finalizar.
- Assim que todos os builds finalizarem, então irá executar todos os containers novamente.

### Execução das Aplicações Manualmente

Para rodar as aplicações, será necessário ter instalado:

- Docker
- Java 17
- Gradle 7.6 ou superior

Para rodar as aplicações, você pode rodar diretamente via IDE, ou também, pode executar o comando `gradle bootRun` na raiz de cada aplicação. Realizar o build antes.

### Execução dos Containers

Para executar tudo, basta executar o arquivo `docker-compose.yml` com o comando:

`docker-compose up --build -d`

Lembrando que será necessário realizar o build das aplicações na primeira vez que for executar o docker-compose, ou a cada nova alteração, para que seja sempre construída uma imagem com as últimas alterações.
