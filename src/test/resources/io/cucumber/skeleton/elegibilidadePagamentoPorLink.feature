#language: pt

Funcionalidade: API - Eligibilidade do EC - Pagamento por Link
  Serviço que informa a elegibilidade de um EC para a funcionalidade Pagamento por Link

  @done
  Esquema do Cenário: Validar o retorno do serviço para a eligibilidade de EC's
    Dado que eu esteja logado com o EC <EC> o usuário <user> e a senha <senha>
    Quando eu enviar a requisição para o serviço de eligibilidade informando o EC <EC>
    E o status <status> for exibido
    Então a eligibilidade <elegivel> deve ser validada

  @elegivel
    Exemplos:
      | EC         | user       | senha  | status | elegivel |
      | 2000463023 | 2000463023 | 123456 | 200    | sim      |

  @naoElegivel
    Exemplos:
      | EC         | user       | senha     | status | elegivel |
      | 1005187565 | 1005187565 | cielo1234 | 200    | não      |
      | 2007700179 | 2007700179 | 654321    | 200    | não      |




  