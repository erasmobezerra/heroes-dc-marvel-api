# API de Gerenciamento de Herois com Spring Web Flux

API desenvolvida durante o curso **Construindo uma API Rest de consulta de cidades do Brasil do zero até a produção**, ministrado
pelo professor <a href="https://www.linkedin.com/in/kamila-santos-oliveira/" target="_blank">Kamila Santos</a>.

O projeto original implementado pela professora você pode encontrar
<a href="https://github.com/Kamilahsantos/Heroes-SpringWebflux-API" target="_blank">clicando aqui.</a>

## Stack utilizada

  * Java8
  * spring webflux
  * Spring data
  * dynamodb
  * junit
  * sl4j
  * reactor
  
### Executar DynamoDB Local: 

Na pasta em que o jar está baixado: 
> $ java -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar -sharedDb
 
Para listar as tabelas criadas:  
> $ aws dynamodb list-tables --endpoint-url http://localhost:8000

Documentação gerada pela aplicação swagger: 
* http://localhost:8080/swagger-ui-heroes-reactive-api.html
