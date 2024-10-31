# language: pt
Funcionalidade: Cadastro de novo usuário
  Como usuário da API
  Quero cadastrar um novo usuário
  Para que o registro seja salvo corretamente no sistema
  Cenário: Cadastro bem-sucedido de entrega
    Dado que eu tenha os seguintes dados da entrega:
      | campo       | valor                 |
      | idUsuario   | 0                     |
      | nome        | Ariana Oliveira       |
      | email       | ariana.O@gmail.com    |
      | senha       | ariana1234            |
      | role        | USER                  |
    Quando eu enviar a requisição para o endpoint "/usuario" de cadastro de entregas
    Então o status code da resposta deve ser 201