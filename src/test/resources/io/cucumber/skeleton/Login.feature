#language: pt
Funcionalidade: API - Login
  Link para o Swagger: http://apollo-core-ecscluster-hml-1454189126.sa-east-1.elb.amazonaws.com/api/apollo/user-login/swagger-ui.html

  @done
  Esquema do Cenário: Realizar Login com sucesso
    Dado que eu informe o EC <EC> o usuário <user> e a senha <senha>
    Quando eu enviar a resquisição
    Então o status <status> deve ser exibido
    E os Tokens de autentificação devem ser retornados e validados
    E o usuario deve possuir a convivencia igual a <status_convivencia>

  @LoginFullSec
    Exemplos:
      | EC         | user       | senha     | status | status_convivencia |
      | 1005187565 | 1005187565 | cielo1234 | 200    | false              |
  @LoginMigrado
    Exemplos:
      | EC         | user            | senha  | status | status_convivencia |
      | 2007700179 | 2007700179      | 654321 | 200    | true               |
      |            | 27774382003     | 654321 | 200    | true               |
      |            | teste@zurtel.gq | 654321 | 200    | true               |
  @LoginConvivencia
    Exemplos:
      | EC         | user       | senha        | status | status_convivencia |
        | 2006005264 | 2006095565 | s@2006095565 | 200    | true               |

  @done
  Esquema do Cenário: Realizar Login invalido
    Dado que eu informe o EC <EC> o usuário <user> e a senha <senha>
    Quando eu enviar a resquisição
    Então o status <status> deve ser exibido

    Exemplos:
      | EC         | user            | senha     | status |
      | 1005187564 | 1005187565      | cielo1234 | 401    |
      | 1005187565 | 1005187564      | cielo1234 | 401    |
      |            | teste@zuryel.gq | 654321    | 401    |
      |            | 27774382003     | 654325    | 401    |
      |            | teste@zurtel.gq | 654325    | 401    |
      |            | 2006095565      | cielo1234 | 400    |
      | 2006005264 | 2006095565      |           | 400    |
      |            | 27774382004     | 654321    | 400    |