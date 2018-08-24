#language: pt
Funcionalidade: Login
    Sendo um usuário
    Posso acessar a plataforma http://mantis-prova.base2.com.br./login_page.php
    Para ultilizar as funcionalidades de reports de bugs

  Cenario: Usuario faz login
    Dado que eu acesso a aplicação
    Quando informo o usuario "marcos.lopes"
    E a senha "saba1988"
    E seleciono entrar
    Então vejo o painel

  Esquema do Cenario: Tentativa de login
    Dado que eu acesso a aplicação
    Quando informo o usuario <usuario>
    E a senha <senha>
    E seleciono entrar
    Então vejo a mensagem <msg>

    Exemplos: 
      | usuario                    | senha       | msg                                                                                          |
      | "avaliacao_qa_"            | " "         | "Your account may be disabled or blocked or the username/password you entered is incorrect." |
      | " "                        | "123456789" | "Your account may be disabled or blocked or the username/password you entered is incorrect." |
      | " "                        | " "         | "Your account may be disabled or blocked or the username/password you entered is incorrect." |
      | "marcos.vmlopes@gmail.com" | "12345678 " | "Your account may be disabled or blocked or the username/password you entered is incorrect." |
