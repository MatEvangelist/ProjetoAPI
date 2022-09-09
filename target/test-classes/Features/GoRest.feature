#language: pt
#Author: Mathews Evangelista
#Version: 1.0
#Encoding: UTF-8

@GoRest
Funcionalidade: Criar e editar contas de usuários
  Eu como administrador do sistema, quero cadastrar, editar e excluir usuários do sistema

  Cenário: Cadastro novo usuário API GoRest
    Dado que possuo um token valido
    Quando envio um request de cadastro de usuario com dados validos
    Então o usuario deve ser criado corretamente
    E o status code do request deve ser 201