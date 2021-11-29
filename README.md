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

## Executar DynamoDB Local: 

Nota: Necessário já ter uma conta na AWS - Amazon Web Services

-AWS CLI instalação: 
* https://docs.aws.amazon.com/pt_br/cli/latest/userguide/getting-started-install.html

-Gerar ID de chave de acesso e Chave de acesso secreta:
* https://docs.aws.amazon.com/pt_br/cli/latest/userguide/cli-configure-quickstart.html#cli-configure-quickstart

-Criar um usuário do IAM de administração:
* https://docs.aws.amazon.com/pt_br/mediapackage/latest/ug/setting-up-create-iam-user.html

-Navegue no terminal até a pasta em que o jar está baixado e execute: 
> $ java -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar -sharedDb

-De posse das suas chaves de acesso, configure suas credenciais com o seguinte comando abaixo:
```shell script
$ aws configure
  << exemplo para ilustração >>
  AWS Access Key ID [None]: AKIAIOSFODNN7EXAMPLE
  AWS Secret Access Key [None]: wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY
  Default region name [None]: us-west-2
  Default output format [None]: json
```
-Para listar as tabelas criadas:  
> $ aws dynamodb list-tables --endpoint-url http://localhost:8000

<br>

## Documentação
Documentação gerada pela aplicação swagger: 
* http://localhost:8080/swagger-ui-heroes-reactive-api.html
