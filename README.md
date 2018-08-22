**Teste da Samba Tech**

Este documento tem como finalidade explicar como foi realizado os testes e como configurar os ambientes para execução dos teste automatizados. 

---

# Primeira Fase do Teste

A primeira fase do teste que foi os teste manuais na aplicação foram realizados seguindo a metodologia BDD similar ao que foi aplicado na fase de automação.

Os arquivos BDD com os descritivos da primeira fase se encontra dentro do diretorio Testes Manuais Specs

Nele sera encontrado os cenarios aplicado para a execução dos testes manuais.

Os bugs e melhorias encontrados durante o primeira fase estão descritos como issues dentro do projeto do github, separados por milestones e indentificados atraves de tags.

A organização de prioridade foi definida baseada na ordenação da lista dentro de cada milestone. 

---

# Segunda Fase do teste - Automação

Na segunda fase do teste, foi realizado uma automação em funcionalidades que apresentaram algum bug e outras partes do sistema que apresentaram ser de maior criticidade, foram ultilizados a metodologia BDD para especificações de cenarios para automatizaçao.

O diretorio rubyteste possui os cenarios codificados em liguagem Ruby e o Selenium para interação com webdrive.
O diretorio javateste possui os cenarios codificados em java e o Selenium para interação com webdrive.

Em ambas as linguagens, o ultimo cenario da funcionalidade "conteudo.feature" esta apresentando uma falha, isto se deve pelo bug em dawnload de conteudo, assim que o bug for corrigido, e teste pode ser ajustado para estar conteplando esta fase.

Todos os testes foram realizados usando o Fedora 28 como SO.

Abaixo segue os passos para montar o ambiente e execução dos testes.

## Montando o Ambiente em Ruby

1. Faça a Clonagem do repositorio sambatech para um repositorio de sua preferencia em sua maquina.
2. Acesse a pasta /sambatech/rubyteste.
3. Dentro da pasta execulte o comando "bundle install" para instalar todas as dependencias do projeto.
4. Feito a instalação, acesse o site do [geckodriver](https://github.com/mozilla/geckodriver/releases) e baixe a versão v0.20.1 de acordo com o sistema operacional.
5. Apos o termino do Download, extraia o executável do geckodriver e copie ele para a pasta /bin/.

Apos a execução destes 5 passos, o ambiente para execução dos testes esta pronto.

---

## Rodando os Teste e Coletando Evidencias em Ruby

1. Acesse a pasta /sambatech/rubyteste
2. Execulte o comando "cucumber"
3. Apos o termino da execução, todas as evidencias coletadas poderam ser vista no arquivo sambatech/rubyteste/results/report.html
4. Em casos de falha no teste, e coletado uma evidencia no formato print que pode ser vista clicando em "Clique aqui para ver a evidência", no final de todos os steps presente no arquivo report.htm

## Estrutura Dos Testes

Todos os cenarios e especificações realizadas podem ser encontradas dentro da pasta /sambatech/rubyteste/features/specs.

Toda condificação do teste automatizado pode ser encontrada dentro da pasta /sambatech/rubyteste/features/step_definitions e sua strutura de pageobjects dentro da pasta /sambatech/rubyteste/features/pages.

Demais pastas são ultilizadas como strutura de configuração e suporte para o projeto. 


## Montando o Ambiente em Java

1. Faça a Clonagem do repositorio sambatech para um repositorio de sua preferencia em sua maquina.
2. Apos a clonagem, baixe a IDE eclipse-java-oxygen ou uma outra versão do eclipse de sua preferencia.
3. Acesse o site do [geckodriver](https://github.com/mozilla/geckodriver/releases) e baixe a versão v0.20.1 de acordo com o sistema operacional.
4. Apos o termino do Download, extraia o executável do geckodriver e copie ele para a pasta /bin/. 
5. Importe o projeto Maven (file/inport/Maven/Existing Maven Projects) presente no repositorio "javateste".

Apos a execução destes 5 passos, o ambiente para execução dos testes esta pronto.

---

## Rodando os Teste em Java

1. Abra a IDE Eclipse 
2. Abrar o arquivo runner (src/test/java/br.vm.marcoslopes.runner/RunnerTest.java).
3. Execulte o arquivo ultilizando o junit.

## Estrutura Dos Testes

Todos os cenarios e especificações realizadas podem ser encontradas dentro da pasta feature (src/teste/resources/features).

Toda condificação do teste automatizado pode ser encontrada dentro do pacote steps (br.vm.marcoslopes.steps) e a configurações do execultavel do testes esta presente no arquivo RunnerTest (br.vm.marcoslopes.runner)

Demais pastas são ultilizadas como strutura de configuração e suporte para o projeto. 


# Observação
Na raiz do repositorio sambatech se encontra o arquivo PDF contendo as considerações finais que levantei apos execução deste processo de testes.