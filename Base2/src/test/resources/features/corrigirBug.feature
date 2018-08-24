#language: pt
Funcionalidade: Corrigir Bug
    Sendo um desenvolvedor
    Posso acessar a plataforma http://mantis-prova.base2.com.br./login_page.php
    Para corrigir um bug reportado

  Contexto: Usuario faz login
    Dado que eu acesso a aplicação
    Quando informo o usuario "marcos.lopes"
    E a senha "saba1988"
    Então seleciono entrar

  Cenario: Cadastrar um novo bug
    Dado que seleciono o projeto
    E acesso o menu de Report Issue
    Quando realizo o preenchimento de todo formulario do bug
    E submeto o formulario
    Então consigo visualizar o formulario no painel de bugs

  Cenario: Corrigindo o bug reportado
    Dado que seleciono o projeto
    E acesso o menu de View Issues
    E seleciono um bug da lista
    Quando eu trato o bug
    Então consigo visualizar o statu de corrigido
    
   Cenario: Duplicar bug não corrigido
    Dado que seleciono o projeto
    E acesso o menu de View Issues
    E seleciono um bug da lista
    Quando eu duplico este bug inserindo os novos dados
    Então consigo visualizar o novo bug na lista
 
  