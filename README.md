# Projeto RESTful API com Java Spring Boot

<img src="https://maven.apache.org/images/maven-logo-black-on-white.png"  height="25"/> <img src="https://cdn.icon-icons.com/icons2/1381/PNG/512/mysqlworkbench_93532.png" height="25"/> <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" height="25"/> <img src="https://www.vectorlogo.zone/logos/auth0/auth0-icon.svg" height="25"/> <img src="https://www.vectorlogo.zone/logos/dozermapper/dozermapper-icon.svg"  height="25"/>

Este projeto é um exemplo de uma aplicação Java Spring Boot que implementa uma RESTful API integrada com um banco de dados MySQL. Além disso, utiliza as seguintes tecnologias e frameworks:

- :rocket: [Spring Boot](https://spring.io/projects/spring-boot): É um framework que facilita a criação de aplicativos Java independentes e prontos para produção. Ele oferece uma configuração padrão sensata para começar a desenvolver novos projetos rapidamente.

- :wrench: [Maven](https://maven.apache.org/): É uma ferramenta de automação de compilação amplamente utilizada no desenvolvimento Java. Ele fornece um conjunto de convenções e configurações para gerenciar as dependências do projeto e construir o aplicativo.

- :floppy_disk: [MySQL](https://www.mysql.com/): É um sistema de gerenciamento de banco de dados relacional amplamente utilizado. Neste projeto, o MySQL é usado como banco de dados para armazenar os dados da aplicação.

- :lock: [Spring Security](https://spring.io/projects/spring-security): É um framework de segurança poderoso e altamente personalizável para aplicativos Java. Ele oferece recursos de autenticação e autorização para proteger os recursos da aplicação.

- :key: [Auth0](https://auth0.com/): É uma plataforma de autenticação e autorização em nuvem que facilita a implementação de recursos de autenticação seguros em aplicativos.

- :link: [HATEOAS](https://spring.io/projects/spring-hateoas): É uma abordagem arquitetural que permite aos clientes navegarem e interagirem com uma API RESTful de forma mais intuitiva, através da inclusão de links hipermídia nos recursos retornados.

- :twisted_rightwards_arrows: [Dozer Mapper](https://dozermapper.github.io/): É uma biblioteca de mapeamento de objetos Java que facilita a conversão entre objetos de diferentes tipos.

## Funcionamento

A aplicação foi desenvolvida seguindo os princípios do RESTful API e utiliza o padrão arquitetural MVC (Model-View-Controller) para organizar o código. A estrutura básica do projeto é a seguinte:

- O pacote `model` contém as classes que representam os objetos de domínio da aplicação.
- O pacote `repository` contém as interfaces de repositório que definem as operações de acesso a dados.
- O pacote `service` contém as classes de serviço que implementam a lógica de negócio da aplicação.
- O pacote `controller` contém as classes de controle que definem os endpoints da API e processam as requisições recebidas.
- O pacote `security` contém as classes de configuração para o Spring Security.
- O pacote `config` contém as classes de configuração adicionais da aplicação.
- O pacote `exception` contém as classes de exceção personalizadas da aplicação.
- O pacote `dto` contém as classes de transferência de dados usadas para serializar e desserializar os dados das requisições e respostas da API.

A autenticação e autorização são gerenciadas pelo Spring Security, que utiliza o Auth0 como provedor de identidade. A integração com o banco de dados MySQL é realizada pelo Spring Data JPA. O HATEOAS é utilizado para incluir links hipermídia nos recursos da API, permitindo uma navegação mais fácil e intuitiva para os clientes.

O Dozer Mapper é utilizado para mapear os objetos de domínio para objetos de transferência de dados (DTO) e vice-versa. Isso ajuda a separar as responsabilidades entre as camadas de domínio e de apresentação da aplicação.

## Executando o Projeto

Para executar o projeto, siga as seguintes etapas:

1. Clone o repositório do GitHub:
git clone https://github.com/xrkmed/rest-with-springboot-and-java.git

2. Importe o projeto em sua IDE Java preferida.

3. Configure as propriedades do banco de dados MySQL no arquivo `application.yml`.

4. Execute o projeto como um aplicativo Java Spring Boot.

Uma vez que o projeto esteja em execução, você pode interagir com a API RESTful usando as rotas e endpoints disponíveis. Consulte a documentação do projeto para obter mais detalhes.


