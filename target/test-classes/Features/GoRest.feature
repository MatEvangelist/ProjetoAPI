#language: pt
#Author: Mathews Evangelista
#Version: 1.0
#Encoding: UTF-8

@GoRest @regressivo
Funcionalidade: Criar e editar contas de usuários
  Eu como administrador do sistema, quero cadastrar, editar e excluir usuários do sistema

  @post
  Cenário: Cadastro novo usuário na API GoRest
    Dado que possuo um token valido
    Quando envio um request de cadastro de usuario com dados validos
    Então o usuario deve ser criado corretamente
    E o status code do request deve ser 201

  @get
  Cenário: Busco um usuário na API GoRest
    Dado que possuo um token valido
    E exista um usuario cadastrado na API
    Quando busco esse usuario
    Então os dados do usuario devem ser retornados
    E o status code do request deve ser 200

  @put
  Cenário: Alterar um usuário na API GoRest com put
    Dado que possuo um token valido
    E exista um usuario cadastrado na API
    Quando altero os dados desse usuario
    Então os dados do usuario devem ser alterados com sucesso
    E o status code do request deve ser 200

  @patch
  Cenário: Alterar um usuário na API GoRest com patch
    Dado que possuo um token valido
    E exista um usuario cadastrado na API
    Quando altero um ou mais dados desse usuario
    Então os dados do usuario devem ser alterados com sucesso
    E o status code do request deve ser 200

  @delete
  Cenário: Deletar um usuário na API GoRest
    Dado que possuo um token valido
    E exista um usuario cadastrado na API
    Quando deleto esse usuario
    Então o usuario e deletado com sucesso
    E o status code do request deve ser 204