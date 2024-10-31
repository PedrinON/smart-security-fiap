# language: pt
Funcionalidade: Cadastro de novo usuário
  Como usuário da API
  Quero cadastrar um novo usuário
  Para que o registro seja salvo corretamente no sistema
  Cenário: Cadastro bem-sucedido do usuario
    Dado que eu tenha os seguintes dados da entrega:
      | campo       | valor                 |
      | idUsuario   | 0                     |
      | nome        | Pedro Martins         |
      | email       | pedro@gmail.com       |
      | senha       | pedroH1234            |
      | role        | USER                  |
    Quando eu enviar a requisição para o endpoint "/usuario" de cadastro de entregas
    Então o status code da resposta deve ser 201

  Cenário: Cadastro do usuário sem sucesso ao passar o campo email inválido
    Dado que eu tenha os seguintes dados da entrega:
      | campo       | valor                 |
      | idUsuario   | 0                     |
      | nome        | Ariana Oliveira       |
      | email       | ariana.Ogmail.com     |
      | senha       | ariana1234            |
      | role        | USER                  |
    Quando eu enviar a requisição para o endpoint "/usuario" de cadastro de entregas
    Então o status code da resposta deve ser 400
    E o corpo de resposta de erro da api deve retornar a mensagem "Dados fornecidos estão em formato inválido."