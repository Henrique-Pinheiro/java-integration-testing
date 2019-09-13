#language: pt

Funcionalidade: A API /merchant, Obtém os dados do usuario
  http://apollo-core-ecscluster-hml-1454189126.sa-east-1.elb.amazonaws.com/api/apollo/user-information/v1/merchant

  @done
  Esquema do Cenário: Solicitação de dados do usuário realizada com sucesso
    Dado que eu esteja logado com o EC <ec> o usuário <user> e a senha <pass>
    E eu envie a requisição
    Quando eu receber o status <status> da requisição
    E os dados do estabalecimento: nome da compania <nome_compania>, numero do ec <ec> e cnpj <cnpj> devem ser retornados
    E os dados do contato: nome do contato <nome_contato>, email <email> e numero do telefone <numero_tel> também devem ser retornados
    Então os dados do endereço: nome da rua <nome_rua>, cep <cep>, cidade <cidade>, bairro <bairro>, estado <estado> e numero <numero> devem exibidos

    Exemplos:
      | ec         | user       | pass   | status | nome_compania              | cnpj           | nome_contato           | email           | numero_tel | nome_rua | cep      | cidade  | bairro       | estado | numero |
   #   | 2000463023 | 2000463023 | 123456 | 200    | MASSA DADOS AFIL. - 001-17734 | 99914179000230 | MASSA DADOS AFIL. - 001-17734 | EYVDV8@PRESTADORCBMP.COM.BR                                S | 923128950  | R ALEXANDRE DUMAS | 04717004 | SAO PAULO | CHACARA SANTO ANTONIO | SP     | 17734  |
      | 2000463023 | 2000463023 | 123456 | 200    | PJ04541 - CONVIVÊNCIA FINC | 99906385000207 | SEM INFORMAÇÃO DO NOME | teste@cielo.com | 923282139  | Satélite | 06602230 | JANDIRA | Quase Aldeia | SP     | 324    |

  @ignored
  Esquema do Cenário: Solicitação de dados com token expirado
    Dado que eu esteja logado com o EC <ec> o usuário <user> e a senha <pass>
    E o token deve estar expirado
    E eu envie a requisição
    Quando eu receber o status <status> da requisição
    Então devera ser exibida a mensagem "Sessão Expirada"

    Exemplos:
      | ec         | user       | pass   | status |
      | 2000463023 | 2000463023 | 123456 | 401    |

  @doing
  Esquema do Cenário: Solicitação de dados com login invalido
    Dado que eu não esteja autenticado
    E eu envie a requisição
    Quando eu receber o status <status> da requisição
    Então devera ser exibida a mensagem "Parâmetro 'access_token' não pode ser vazio"

    Exemplos:
      | status |
      | 400    |
