**Teste da Base 2**

Este documento tem como finalidade explicar como foi realizado os testes e como configurar os ambientes para execução dos teste automatizados. 

---

# Automação

Foi realizado uma automação em funcionalidades que apresentaram ser mais criticas do sistema mantis como reports de bugs e retorno de solução por parte do desenvolvedor, foi ultilizado a metodologia BDD para especificações de cenarios para automatizaçao.

Todos os cenarios e especificações realizadas podem ser encontradas dentro da pasta feature (src/teste/resources/features).

Toda condificação do teste automatizado pode ser encontrada dentro do pacote steps (br.vm.marcos.steps) e a configurações do execultavel do testes esta presente no arquivo RunnerTest (br.vm.marcos.runner)

Todos os testes foram realizados usando o Fedora 28 como SO.

Abaixo segue os passos para montar o ambiente e execução dos testes.

## Montando o Ambiente Java

1. Faça a Clonagem do repositorio base2 para um repositorio de sua preferencia em sua maquina.
2. Apos a clonagem, baixe a IDE eclipse-java-oxygen ou uma outra versão do eclipse de sua preferencia.
3. Acesse o site do [geckodriver](https://github.com/mozilla/geckodriver/releases) e baixe a versão v0.20.1 de acordo com o sistema operacional.
4. Apos o termino do Download, extraia o executável do geckodriver e copie ele para a pasta /bin/. 
5. Importe o projeto Maven (file/inport/Maven/Existing Maven Projects) presente no repositorio "base2".

Apos a execução destes 5 passos, o ambiente para execução dos testes esta pronto.

---

## Rodando os Teste 

1. Abra a IDE Eclipse 
2. Abrar o arquivo runner (src/test/java/br.vm.marcos.runner/RunnerTest.java).
3. Execulte o arquivo ultilizando o junit.

## Observação

Para que todos os teste rodem sem interferencias, a base de dados do mantis deve esta limpa, antes do teste verifique se possue algum bug cadastrado para o projeto marcos lopes, caso acha, remova antes de rodar os teste.