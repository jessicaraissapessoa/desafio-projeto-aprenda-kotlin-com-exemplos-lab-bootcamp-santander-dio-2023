# Desafio de Projeto: Lab Aprenda Kotlin com Exemplos - Bootcamp Santander/DIO - 2023

<br>
Repositório destinado à minha abstração para o desafio de projeto "Abstraindo Formações da DIO Usando Orientação a Objetos com Kotlin", do bootcamp Santander 2023, na trilha "Mobile Android com Kotlin"

<br>

## Tecnologias utilizadas
###
* **Linguagem:** Kotlin
* **Versionamento:** Git/GitHub
* **IDE:** Intellij IDEA Ultimate

<br>

## O projeto
###
* Trata-se de uma aplicação para a simulação de um sistema da DIO. 
* O sistema construído apresenta usuários, formações, conteúdos educacionais, tipos de usuário, tipos de conteúdo educacional e níveis de dificuldade (aplicáveis a formações e conteúdos educacionais)
* Formações podem conter conteúdos educacionais e usuários cadastrados

<br>

## Alguns detalhes sobre a aplicação
###

* Não há banco de dados. Assim, ao encerrar a execução, todos os dados (usuários, conteúdos, formações cadastrados etc) são perdidos;
- A simulação de uma espécie de interface executada no console somada à conexão construída entre todas as funções permite que haja navegação cíclica e contínua entre todas essas funções armazenando e utilizando os dados durante esse tempo de execução;
* Os dados das classes e variáveis diversas não são inseridos previamente à execução. Todos os valores são recebidos por um sistema de leitura de entrada por teclado e, portanto, são informados pelo usuário;
- Todas as recepções de valores por entrada possuem suas validações mediante cada caso e necessidade.<br>Ex: validações para não receber números, validações para não receber null, validações para receber valores dentre opções oferecidas etc;
* Também há verificações que trazem feedback e opções ao usuário.<br>Ex: O usuário vai cadastrar um usuário em uma formação, mas não há funcionários cadastrados no sistema. Será avisado que não há usuários cadastrados no sistema e dada a opção de fazer esse cadastro de usuários no sistema.<br>Ex: O usuário está fazendo remoção de usuários em uma formação. Quando não houver mais usuários nessa, será dado um aviso sobre e a aplicação irá direcionar para o menu; 
- É feito o uso de sobrecarga de construtor em classes para chamadas de construtor vazio e em alguns casos, são determinados valores padrões (que podem ser alterados) às variáveis;
* Há loops que permitem ao usuário efetuar operações repetidamente de forma facilitada.<br>Ex: Remover mais de um usuário da mesma formação em sequência;

<br>

## Organização
###

Em [src/main/kotlin](https://github.com/jessicaraissapessoa/desafio-projeto-aprenda-kotlin-com-exemplos-lab-bootcamp-santander-dio-2023/tree/main/src/main/kotlin) estão os códigos da aplicação.
Esses códigos estão divididos em packages (pastas/diretórios). Segue a descrição do que engloba cada package:

| Package                                                                                                                                                                                                 | Descrição                                                                                                                                                                | Arquivos                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [src/main/kotlin/aplicacao](https://github.com/jessicaraissapessoa/desafio-projeto-aprenda-kotlin-com-exemplos-lab-bootcamp-santander-dio-2023/tree/main/src/main/kotlin/aplicacao)                     | Pasta contém a main (inicializadora da aplicação) e as simulações de interfaces (menus para navegação do usuário que conectam e ordenam todas as execuções da aplicação) | [Main.kt](https://github.com/jessicaraissapessoa/desafio-projeto-aprenda-kotlin-com-exemplos-lab-bootcamp-santander-dio-2023/blob/main/src/main/kotlin/aplicacao/Main.kt)<br/>[telaInicial.kt](https://github.com/jessicaraissapessoa/desafio-projeto-aprenda-kotlin-com-exemplos-lab-bootcamp-santander-dio-2023/blob/main/src/main/kotlin/aplicacao/telaInicial.kt)<br/>[menuUsuario.kt](https://github.com/jessicaraissapessoa/desafio-projeto-aprenda-kotlin-com-exemplos-lab-bootcamp-santander-dio-2023/blob/main/src/main/kotlin/aplicacao/menuUsuario.kt)<br/>[menuConteudoEducacional.kt](https://github.com/jessicaraissapessoa/desafio-projeto-aprenda-kotlin-com-exemplos-lab-bootcamp-santander-dio-2023/blob/main/src/main/kotlin/aplicacao/menuConteudoEducacional.kt)<br/>[menuFormacao.kt](https://github.com/jessicaraissapessoa/desafio-projeto-aprenda-kotlin-com-exemplos-lab-bootcamp-santander-dio-2023/blob/main/src/main/kotlin/aplicacao/menuFormacao.kt)                                                                                                                                                                                                                                                                                                                                                                                                                                                                               |
| [src/main/kotlin/enums](https://github.com/jessicaraissapessoa/desafio-projeto-aprenda-kotlin-com-exemplos-lab-bootcamp-santander-dio-2023/tree/main/src/main/kotlin/enums)                             | Pasta contém todos os enums da aplicação. Tipo de dado que armazena conjuntos de valores fixos                                                                           | [TipoUsuario.kt](https://github.com/jessicaraissapessoa/desafio-projeto-aprenda-kotlin-com-exemplos-lab-bootcamp-santander-dio-2023/blob/main/src/main/kotlin/enums/TipoUsuario.kt)<br/>[TipoConteudoEducacional.kt](https://github.com/jessicaraissapessoa/desafio-projeto-aprenda-kotlin-com-exemplos-lab-bootcamp-santander-dio-2023/blob/main/src/main/kotlin/enums/TipoConteudoEducacional.kt)<br/>[NivelDificuldade.kt](https://github.com/jessicaraissapessoa/desafio-projeto-aprenda-kotlin-com-exemplos-lab-bootcamp-santander-dio-2023/blob/main/src/main/kotlin/enums/NivelDificuldade.kt)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             |
| [src/main/kotlin/usuario](https://github.com/jessicaraissapessoa/desafio-projeto-aprenda-kotlin-com-exemplos-lab-bootcamp-santander-dio-2023/tree/main/src/main/kotlin/usuario)                         | Pasta contém classe e funções relativas ao usuário. Adição, edição e remoção de usuários no sistema                                                                      | [Usuario.kt](https://github.com/jessicaraissapessoa/desafio-projeto-aprenda-kotlin-com-exemplos-lab-bootcamp-santander-dio-2023/blob/main/src/main/kotlin/usuario/Usuario.kt)<br/>[listaUsuarios.kt](https://github.com/jessicaraissapessoa/desafio-projeto-aprenda-kotlin-com-exemplos-lab-bootcamp-santander-dio-2023/blob/main/src/main/kotlin/usuario/listaUsuarios.kt)<br/>[exibicoesUsuario.kt](https://github.com/jessicaraissapessoa/desafio-projeto-aprenda-kotlin-com-exemplos-lab-bootcamp-santander-dio-2023/blob/main/src/main/kotlin/usuario/exibicoesUsuario.kt)<br/>[cadastroUsuario.kt](https://github.com/jessicaraissapessoa/desafio-projeto-aprenda-kotlin-com-exemplos-lab-bootcamp-santander-dio-2023/blob/main/src/main/kotlin/usuario/cadastroUsuario.kt)<br/>[edicaoUsuario.kt](https://github.com/jessicaraissapessoa/desafio-projeto-aprenda-kotlin-com-exemplos-lab-bootcamp-santander-dio-2023/blob/main/src/main/kotlin/usuario/edicaoUsuario.kt)<br/>[remocaoUsuario.kt](https://github.com/jessicaraissapessoa/desafio-projeto-aprenda-kotlin-com-exemplos-lab-bootcamp-santander-dio-2023/blob/main/src/main/kotlin/usuario/remocaoUsuario.kt)                                                                                                                                                                                                                                                                                   |
| [src/main/kotlin/conteudoEducacional](https://github.com/jessicaraissapessoa/desafio-projeto-aprenda-kotlin-com-exemplos-lab-bootcamp-santander-dio-2023/tree/main/src/main/kotlin/conteudoEducacional) | Pasta contém classe e funções relativas ao conteúdo educacional. Adição, edição e remoção de conteúdos educacionais no sistema                                           | [ConteudoEducacional.kt](https://github.com/jessicaraissapessoa/desafio-projeto-aprenda-kotlin-com-exemplos-lab-bootcamp-santander-dio-2023/blob/main/src/main/kotlin/conteudoEducacional/ConteudoEducacional.kt)<br/>[listaConteudosEducacionais.kt](https://github.com/jessicaraissapessoa/desafio-projeto-aprenda-kotlin-com-exemplos-lab-bootcamp-santander-dio-2023/blob/main/src/main/kotlin/conteudoEducacional/listaConteudosEducacionais.kt)<br/>[exibicoesConteudoEducacional.kt]()<br/>[cadastroConteudoEducacional.kt](https://github.com/jessicaraissapessoa/desafio-projeto-aprenda-kotlin-com-exemplos-lab-bootcamp-santander-dio-2023/blob/main/src/main/kotlin/conteudoEducacional/cadastroConteudoEducacional.kt)<br/>[edicaoConteudoEducacional.kt](https://github.com/jessicaraissapessoa/desafio-projeto-aprenda-kotlin-com-exemplos-lab-bootcamp-santander-dio-2023/blob/main/src/main/kotlin/conteudoEducacional/edicaoConteudoEducacional.kt)<br/>[remocaoConteudoEducacional.kt](https://github.com/jessicaraissapessoa/desafio-projeto-aprenda-kotlin-com-exemplos-lab-bootcamp-santander-dio-2023/blob/main/src/main/kotlin/conteudoEducacional/remocaoConteudoEducacional.kt)                                                                                                                                                                                                                                                         |
| [src/main/kotlin/formacao](https://github.com/jessicaraissapessoa/desafio-projeto-aprenda-kotlin-com-exemplos-lab-bootcamp-santander-dio-2023/tree/main/src/main/kotlin/formacao)                       | Pasta contém classe e funções relativas à formação educacional. Adição, edição e remoção de formações, de usuários em formações e de conteúdos educacionais em formações | [Formacao.kt](https://github.com/jessicaraissapessoa/desafio-projeto-aprenda-kotlin-com-exemplos-lab-bootcamp-santander-dio-2023/blob/main/src/main/kotlin/formacao/Formacao.kt)<br/>[listaFormacoes.kt](https://github.com/jessicaraissapessoa/desafio-projeto-aprenda-kotlin-com-exemplos-lab-bootcamp-santander-dio-2023/blob/main/src/main/kotlin/formacao/listaFormacoes.kt)<br/>[exibicoesFormacao.kt](https://github.com/jessicaraissapessoa/desafio-projeto-aprenda-kotlin-com-exemplos-lab-bootcamp-santander-dio-2023/blob/main/src/main/kotlin/formacao/exibicoesFormacao.kt)<br/>[cadastroFormacao.kt](https://github.com/jessicaraissapessoa/desafio-projeto-aprenda-kotlin-com-exemplos-lab-bootcamp-santander-dio-2023/blob/main/src/main/kotlin/formacao/cadastroFormacao.kt)<br/>[edicaoFormacao.kt](https://github.com/jessicaraissapessoa/desafio-projeto-aprenda-kotlin-com-exemplos-lab-bootcamp-santander-dio-2023/blob/main/src/main/kotlin/formacao/edicaoFormacao.kt)<br/>[remocaoFormacao.kt]()<br/>[edicaoUsuarioEmFormacao.kt](https://github.com/jessicaraissapessoa/desafio-projeto-aprenda-kotlin-com-exemplos-lab-bootcamp-santander-dio-2023/blob/main/src/main/kotlin/formacao/edicaoUsuarioEmFormacao.kt)<br/>[edicaoConteudoEmFormacao.kt](https://github.com/jessicaraissapessoa/desafio-projeto-aprenda-kotlin-com-exemplos-lab-bootcamp-santander-dio-2023/blob/main/src/main/kotlin/formacao/edicaoConteudoEmFormacao.kt) |

<br>

## Screenshots de demonstração
###

### Navegação entre menus e encerramento da execução:

<br>

![navegacaoEEncerramento.png](imagensREADME/navegacaoEEncerramento.png "navegação entre menus e encerramento da execução")

<br>

### Construção de uma formação (há saltos entre o momento de uma imagem e outra):

<br>

**Parte da criação da formação:**

![criandoFormacao.png](imagensREADME/criandoFormacao.png "Criação de uma formação")

<br>

**Parte do cadastro de usuários em uma formação:**

![cadastrandoUsuariosFormacao.png](imagensREADME/cadastrandoUsuariosFormacao.png "Inserindo usuários em uma formação")

<br>

**Parte de loop de cadastro de conteúdos educacionais em uma mesma formação:**

![cadastrandoConteudosFormacao.png](imagensREADME/cadastrandoConteudosFormacao.png "Inserindo conteúdos educacionais em uma formação")

<br>

### Validação de valor de entrada:

<br>

Validações ao cadastrar usuário:
* Tentativas barradas ao preencher o nome do usuário: dígito, vazio, caractere especial
* Tentativa barrada ao cadastrar usuário: usuário com mesmo nome e tipo já havia sido previamente cadastrado no sistema

![validacaoCadastroUsuario.png](imagensREADME/validacaoCadastroUsuario.png "Validações em cadastro de usuário")

<br>

## Como usar este repositório
###

* Nessa tela inicial do repositório, faça um fork clicando na opção, conforme mostra a imagem a seguir. Isso criará uma cópia (clone) desse repositório em seus repositórios no GitHub
  ![fork](imagensREADME/fork.png "fork")
- Preencha o formulário "Create a new fork" para customizar clone será criado em seu GitHub
* No repositório, acima dos arquivos, sempre haverá aviso caso tenha sido feitas alterações no repositório original. Com "Sync fork" você puxa essas alterações para seu repositório, mantendo-o atualizado
  ![syncfork](imagensREADME/syncfork.png "sync fork")
- Para criar uma cópia local desse repositório clonado, selecione/crie a pasta para ele no computador
* No seu repositório clonado, clique em Code e copie o link na aba HTTPS
  ![linkhttps](imagensREADME/linkhttps.png "linkhttps")
- Nessa pasta, inicialize o Git Bash
* Comando `git clone linkDoSeuRepositorioClonado`
- Comando `git remote add upstream https://github.com/jessicaraissapessoa/desafio-projeto-aprenda-kotlin-com-exemplos-lab-bootcamp-santander-dio-2023.git`
* Comando `git remote -v`
- Agora há conexão com os repositórios clone e original
* Agora divirta-se com a aplicação na IDE de sua preferência

<br>

## Repositório das aulas que antecederam Projeto
###

Esse desafio de projeto faz parte do módulo "Conhecendo a linguagem de Programação Kotlin". Eu também tenho um reposítorio para os códigos que desenvolvi no decorrer das aulas desse módulo, para quem tiver interesse. Inclusive já linkei o repositório do desafio de projeto no README do repositório dessas aulas.
**Acesse o repositório GitHub**:

[Conhecendo a linguagem de programação Kotlin - Bootcamp Santander/DIO 2023](https://github.com/jessicaraissapessoa/conhecendo-kotlin-bootcamp-santander-dio-2023/tree/main)






