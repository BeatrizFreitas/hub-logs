#hublogsquickstart

Uma Api capaz de gerir os logs cadastrados sem deixar de garantir segurança para os usuários que as utilizam. 
A aplicação foi desenvolvida em java, utilizando springboot e persiste os seus dados no postgresql.

##Começando 

Para executar o projeto, será necessário:
    - Maven
    - Docker
    - Docker-compose

## Construção
Para construir o projeto com o Maven, executar os comando abaixo:

```shell
mvn clean install
```

O comando irá baixar todas as dependências do projeto e criar um diretório target com os artefatos construídos, que incluem o arquivo jar do projeto. Além disso, serão executados os testes unitários, e se algum falhar, o Maven exibirá essa informação no console.

##Deploy
O projeto foi estruturado para rodar via Docker, orquestrando a task via Docker-compose.

```shell
docker build ./ -t application
```shell

```shell
docker-compose up
```

##Testes
Para rodar os testes, utilize o comando abaixo:

````sheel
mvn test
````

##Contribuiçoes
Contribuições são sempre bem-vindas! Para contribuir lembre-se sempre de adicionar testes unitários para as novas classes com a devida documentação.

##Licença
Nao se aplica.


