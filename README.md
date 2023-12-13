# Calculadora de Seguros

Este foi criado para criar uma calculadora que calcula o preço de seguros se baseando em sua categoria e preço base com a inclusão de impostos.

## Como Iniciar

1. Clone o repositório: `git clone git@github.com:williammmiranda/calculadora-seguro.git`
2. Navegue até o diretório do projeto: `cd ../calculadora-seguro/target/`
3. Execute o aplicativo: `java -jar calculadora-seguro-0.0.1-SNAPSHOT.jar`
4. Acesse o swagger do projeto para execução local [aqui](http://localhost:8080/swagger-ui/)

## Solução do projeto

### Resumo

Para fazer o projeto foi feito um CRUD que consiste no gerenciamento do cadastro de seguros. 

A funcionalidade core do projeto é o calculo do preço final do mesmo que envolve impostos, para isso foi feito um tratamento para que de forma simples novas categorias de seguro possam ser incluídas assim como novos impostos sem a necessidade de muitas horas de desenvolvimento.

### Organização

O projeto foi organizado levando em consideração o padrão Clean Architeture. 

### Testes

Dentro do projeto foi feita a cobertura de 100% das regras de negócio, através dos testes unitários, conforme relatório gerado pelo jacoco.

Também para os serviços expostos foram feitos testes de integração.

### Gerenciamento de Erros

Visando o gerenciamento de erros foi criado um interceptor para os mesmos sejam expostos ao usuário assim que eles forem acionados por um GlobalExceptionHandler deixando assim o código mais limpo.

### Logs

Para os logs foi usado o Sl4j documentando os passos de execução para caso algo aconteça ser identificado facilmente o ponto do erro.

### Trace

## Premissas assumidas

Visto que se tratava de um calculo para seguros foi premissa que um gerenciamento simples precisava ser feita.

Por se tratar de um projeto teste não considerei a inclusão de mais de um serviço de atualização sendo assim é possível atualizar os mesmos campos no serviço do POST. Essa premissa também foi adotada para a busca onde eu considerei apenas a busca por ID.

Para o retorno das APIs também foi considerado o formato e nomes dos campos fornecido na documentação.

Por se tratara de um projeto teste também não foi implementado nenhum tipo de autenticação.