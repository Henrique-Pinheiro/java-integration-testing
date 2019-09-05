#language: pt

Funcionalidade: API - FAQ do Pagamento por Link
  Serviço que retorna informacões uteis sobre a funcionalidade Pagamento Por Link

  @doing
  Esquema do Cenário: Validar o retorno do serviço FAQ para a funcionalidade Pagamento por Link
    Dado que eu esteja logado com o EC <EC> o usuário <user> e a senha <senha>
    Quando eu enviar a requisição para o serviço de FAQ
    E o status <status> for exibido pelo FAQ
    Então as informações referentes ao FAQ do Pagamento por Link devem ser retornadas
    E o titulo deve ser "Pagamento por Link"

  @elegivel
    Exemplos:
      | EC         | user       | senha  | status |
      | 2000463023 | 2000463023 | 123456 | 200    |