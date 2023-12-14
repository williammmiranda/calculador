# Calculadora de Seguros

Este foi criado para criar uma calculadora que calcula o preço de seguros se baseando em sua categoria e preço base com a inclusão de impostos.

## Como Iniciar

Como pré-requisito:
1. Ter o SDK do Java 11 instalado

Passos para execução:

1. Clone o repositório: `git clone git@github.com:williammmiranda/calculadora-seguro.git`
2. Navegue até o diretório do projeto: `cd ../calculadora-seguro`
3. Execute o aplicativo: `java -jar calculadora-seguro-0.0.1.jar`
4. Acesse o swagger do projeto para execução local [aqui](http://localhost:8080/swagger-ui/)

## Solução do projeto

### Resumo

Para fazer o projeto foi feito um CRUD que consiste no gerenciamento do cadastro de seguros. 

A funcionalidade core do projeto é o calculo do preço final do seguro. O desenvolvimento foi feito forma que de uma forma simples novas categorias de seguro possam ser incluídas assim como novos impostos sem afetar serviços já existentes e com o mínimo de esforço possível.

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

Para os traces esta sendo utilizado o Spring Cloud Sleuth e gerando um arquivo de log no nível de INFO. Este arquivo pode ser visto dentro da pasta logs/sleuth.log do projeto.

### Metricas

Para as métricas foi utilizado o Micrometer que podem ser acessadas nessa lista
1. POST: `curl --location --request GET 'http://localhost:8080/actuator/metrics/criarSeguro'`
2. PUT: `curl --location --request GET 'http://localhost:8080/actuator/metrics/atualizarSeguro'`
3. GET: `curl --location --request GET 'http://localhost:8080/actuator/metrics/buscarSeguroPorId'`
4. DELETE: `curl --location --request GET 'http://localhost:8080/actuator/metrics/excluirSeguro'`

Observação as métricas só são acessíveis após a execução dos endpoints

## Premissas assumidas

Visto que se tratava de um calculo para seguros foi premissa que um gerenciamento simples precisava ser feita.

Por se tratar de um projeto teste não considerei a inclusão de mais de um serviço de atualização sendo assim é possível atualizar os mesmos campos no serviço do POST. Essa premissa também foi adotada para a busca onde eu considerei apenas a busca por ID.

Para o retorno das APIs também foi considerado o formato e nomes dos campos fornecido na documentação.

Por se tratara de um projeto teste também não foi implementado nenhum tipo de autenticação.