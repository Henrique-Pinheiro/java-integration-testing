#language: pt

Funcionalidade: API - /me - Obtém as informações do usuário
  http://apollo-core-ecscluster-hml-1454189126.sa-east-1.elb.amazonaws.com/api/apollo/user-information/v1/me

  @run
  Esquema do Cenário: Solicitação de dados do usuário realizada com sucesso
    Dado que eu esteja autenticado com o EC <ec>, Usuário <user>, Senha <pass>
    Quando eu enviar a requisição
    E receber o status <status>
    Então os dados nome do usário <username>, usuário <user>, email <email>, data de aniversario <dt_aniversario> devem ser retornados
    E os dados cpf <cpf>, ec <ec>, nome do estabelecimento <nome_ec> e cnpj <cnpj> também devem ser retornados

    Exemplos:
      | ec         | user       | pass         | username | status | email                         | dt_aniversario | cpf         | nome_ec                        | cnpj     |
      | 2007700179 | 2007700179 | 654321 | teste do teste | 200    | teste@zurtel.gq               | 1993-08-05     | 27774382003 | MASSA DADOS AFIL. - 237-133469 | 847405572 |
      | 2006005264 | 2006095565 | s@2006095565 | Teste    | 200    | pinheiro_henrique@hotmail.com | 1993-08-05     | 82567045007 | MASSA DADOS AFIL. - 237-175456 | 66624792 |

  @run
  Esquema do Cenário: Solicitação de dados com token expirado
    Dado que eu esteja autenticado com o EC <ec>, Usuário <user>, Senha <pass>
    E o token esteja expirado
    Quando eu enviar a requisição
    E receber o status <status>
    Então deve ser exibida a mensagem "Sessão Expirada"


    Exemplos:
      | ec         | user       | pass   | status |
      | 2007700179 | 2007700179 | 654321 | 401    |

  @run
  Esquema do Cenário: Solicitação de dados com login invalido
    Dado que eu não esteja autenticado
    Quando eu enviar a requisição
    E receber o status <status>
    Então deve ser exibida a mensagem "Parâmetro 'access_token' não pode ser vazio"

    Exemplos:
      | status |
      | 400    |


#      VC7wlbMO3LsDp8tjUaKRlayCeEXt1moKaRoKq3qDpYwDJvAz0e