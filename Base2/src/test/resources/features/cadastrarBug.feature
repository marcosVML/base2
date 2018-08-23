#language: pt

Funcionalidade: Gestão bugs
    Sendo um usuário
    Posso acessar a plataforma http://mantis-prova.base2.com.br./login_page.php
    Para ultilizar as funcionalidades de reports de bugs

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

Cenario: Editar um novo bug

    Dado que seleciono o projeto
    	E acesso o menu de View Issues
    Quando seleciono um bug da lista
    	E edito este bug 
    Então consigo visualizar o bug alterado no formulario