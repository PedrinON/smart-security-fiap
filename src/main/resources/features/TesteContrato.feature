# language: pt
Funcionalidade: Validar o contrato ao realizar um cadastro bem-sucedido do usuário
  Como usuário da API
  Quero cadastrar um novo usuário bem-sucedido
  Para que eu cosniga validar se o contrato esta conforme o esperado
  Cenario: Validar contrato do cadastro bem-sucedido do usuario
    Dado que eu tenha os seguintes dados da entrega:
      | campo       | valor                 |
      | idUsuario   | 0                     |
      | nome        | Pedro Martins         |
      | email       | pedro@gmail.com       |
      | senha       | pedroH1234            |
      | role        | USER                  |
    Quando eu enviar a requisição para o endpoint "/usuario" de cadastro de entregas
    Então o status code da resposta deve ser 201
    E que o arquivo de contrato esperado é o "Cadastro bem-sucedido do usuario"
    Então a resposta da requisição deve estar em conformidade com o contrato selecionado