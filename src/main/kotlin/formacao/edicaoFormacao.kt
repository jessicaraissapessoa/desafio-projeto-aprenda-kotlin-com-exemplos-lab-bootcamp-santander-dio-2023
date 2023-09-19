package formacao

import enums.NivelDificuldade
import formacao.ConteudoEmFormacao.editarConteudosFormacao
import formacao.UsuarioEmFormacao.editarUsuariosFormacao
import usuario.exibirListaUsuariosVazia
import usuario.listaUsuarios

fun editarFormacao() {

    if (listaFormacoes.isEmpty()) exibirListaFormacoesVazia() //Caso a lista de formações esteja vazia, executar função exibirListaFormacoesVazia()

    println("----- Lista de formações cadastrados -----\n".uppercase())
    exibirListaFormacoes()

    do { //Repete execução enquanto não receber valor válido: "s" ou "n"

        println("Deseja visualizar os detalhes de alguma formação antes de seguir? Digite 's' para sim ou 'n' para não.")
        val visualizarDetalhesFormacao = readlnOrNull()

        if (visualizarDetalhesFormacao.isNullOrEmpty() || !visualizarDetalhesFormacao.any { it.isLetter() } || (!visualizarDetalhesFormacao.equals("s") && !visualizarDetalhesFormacao.equals("n"))) {
            println("-----Seleção inválida!-----".uppercase())
        }

        when(visualizarDetalhesFormacao) {
            "s" -> exibirFormacaoDetalhada()
            "n" -> println()
        }

        println("Seguindo edição de formações...")

    } while (visualizarDetalhesFormacao.isNullOrEmpty() || !visualizarDetalhesFormacao.any { it.isLetter() } || (!visualizarDetalhesFormacao.equals("s") && !visualizarDetalhesFormacao.equals("n")))


    val opcoesFormacao = mutableListOf<String>() //Variável opcoes recebe os valores de cada id de formação de listaFormacoes
    for (formacao in listaFormacoes) {
        val opcao = formacao.idFormacao
        opcoesFormacao.add(opcao.toString())
    }

    var selecaoFormacao : String? //Variável que vai receber escolha de formação dentre as opções acima

    do { //Repete execução enquanto não recebe um valor correspondente a algum dos valores da variável opcoes

        println("Informe o ID da formação que deseja editar:")
        selecaoFormacao = readlnOrNull() //Recebimento do valor do ID da formação selecionada pelo usuário

        if (!opcoesFormacao.contains(selecaoFormacao)) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        }

    } while (!opcoesFormacao.contains(selecaoFormacao))

    val indexFormacao = selecaoFormacao!!.toInt() - 1 //índice da formação na mutableList listaFormacoes
    val formacaoSelecionada = listaFormacoes[indexFormacao] //formaçãoSelecionada recebe a Formacao equivalente de listaFormações

    //Edição de dados (nome/dificuldade)
    do { //Repete execução enquanto não receber valor válido: "s" ou "n"

        println("Deseja editar nome e/ou nível de dificuldade da formação? Digite 's' para sim ou 'n' para não.")
        val editarNomeNivelFormacao = readlnOrNull()

        if (editarNomeNivelFormacao.isNullOrEmpty() || !editarNomeNivelFormacao.any { it.isLetter() } || (!editarNomeNivelFormacao.equals("s") && !editarNomeNivelFormacao.equals("n"))) {
            println("-----Seleção inválida!-----".uppercase())
        }

        when(editarNomeNivelFormacao) {
            "s" -> editarDadosFormacao(formacaoSelecionada) //Segue para editarDadosFormacao() passando formacaoSelecionada
            "n" -> println()
        }

    } while (editarNomeNivelFormacao.isNullOrEmpty() || !editarNomeNivelFormacao.any { it.isLetter() } || (!editarNomeNivelFormacao.equals("s") && !editarNomeNivelFormacao.equals("n")))

    //Edição de usuários
    do { //Repete execução enquanto não receber valor válido: "s" ou "n"

        if (listaUsuarios.isEmpty()) exibirListaUsuariosVazia() //Caso a lista de usuários esteja vazia, executar função exibirListaUsuariosVazia()

        println("Deseja editar usuário(s) cadastrado(s) na formação? Digite 's' para sim ou 'n' para não.")
        val editarUsuariosFormacao = readlnOrNull()

        if (editarUsuariosFormacao.isNullOrEmpty() || !editarUsuariosFormacao.any { it.isLetter() } || (!editarUsuariosFormacao.equals("s") && !editarUsuariosFormacao.equals("n"))) {
            println("-----Seleção inválida!-----".uppercase())
        }

        when(editarUsuariosFormacao) {
            "s" -> editarUsuariosFormacao(formacaoSelecionada) //Segue para editarUsuariosFormacao() passando formacaoSelecionada
            "n" -> println()
        }

    } while (editarUsuariosFormacao.isNullOrEmpty() || !editarUsuariosFormacao.any { it.isLetter() } || (!editarUsuariosFormacao.equals("s") && !editarUsuariosFormacao.equals("n")))

    //Edição de conteúdos educacionais
    do { //Repete execução enquanto não receber valor válido: "s" ou "n"

        if (listaFormacoes.isEmpty()) exibirListaFormacoesVazia() //Caso a lista de formações esteja vazia, executar função exibirListaFormacoesVazia()

        println("Deseja editar conteúdo(s) educacional(is) cadastrado(s) na formação? Digite 's' para sim ou 'n' para não.")
        val editarConteudosFormacao = readlnOrNull()

        if (editarConteudosFormacao.isNullOrEmpty() || !editarConteudosFormacao.any { it.isLetter() } || (!editarConteudosFormacao.equals("s") && !editarConteudosFormacao.equals("n"))) {
            println("-----Seleção inválida!-----".uppercase())
        }

        when(editarConteudosFormacao) {
            "s" -> editarConteudosFormacao(formacaoSelecionada) //Segue para editarConteudosFormacao() passando formacaoSelecionada
            "n" -> println()
        }

    } while (editarConteudosFormacao.isNullOrEmpty() || !editarConteudosFormacao.any { it.isLetter() } || (!editarConteudosFormacao.equals("s") && !editarConteudosFormacao.equals("n")))

    //"Loop" para editar outras formações. Recursivo de editarFormacao()
    do { //Repete execução enquanto não receber valor válido: "s" ou "n"

        println("Deseja editar outra formação? Digite 's' para sim ou 'n' para não.")
        val editarOutraFormacao = readlnOrNull()

        if (editarOutraFormacao.isNullOrEmpty() || !editarOutraFormacao.any { it.isLetter() } || (!editarOutraFormacao.equals("s") && !editarOutraFormacao.equals("n"))) {
            println("-----Seleção inválida!-----".uppercase())
        }

        when(editarOutraFormacao) {
            "s" -> editarFormacao() //Função recursiva: repete editarFormacao() para poder editar outra formação
            "n" -> println()
        }

    } while (editarOutraFormacao.isNullOrEmpty() || !editarOutraFormacao.any { it.isLetter() } || (!editarOutraFormacao.equals("s") && !editarOutraFormacao.equals("n")))

}


fun editarDadosFormacao(formacaoSelecionada: Formacao) {

    println("ID: ${formacaoSelecionada.idFormacao} | NOME: ${formacaoSelecionada.nomeFormacao}\n↳ NÍVEL: ${formacaoSelecionada.nivelDificuldadeFormacao}")

    //Edição do nome da formação
    do { //Repete execução enquanto não recebe um valor correspondente a "s" ou "n"
        println("Deseja editar o nome da formação? Digite 's' para sim ou 'n' para não")
        val respostaEditarNomeFormacao = readlnOrNull() //Recebimento do valor pelo teclado

        if (respostaEditarNomeFormacao.isNullOrEmpty() || ((respostaEditarNomeFormacao != "s") && (respostaEditarNomeFormacao != "n"))) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        } else {
            var tecladoNovoNomeFormacao : String? //Variável de novoNomeFormacao que preencherá nomeFormacao após edição

            if (respostaEditarNomeFormacao == "s") { //Se recebeu "s", segue para alteração do nome da formação
                do { //Repete execução enquanto tecladoNovoNomeFormacao não receber um valor que não seja nulo, vazio, sem letras ou com números
                    println("Insira novo nome completo da formação:")
                    tecladoNovoNomeFormacao = readlnOrNull() //Recebimento do valor pelo teclado

                    if (tecladoNovoNomeFormacao.isNullOrEmpty() || !tecladoNovoNomeFormacao.any { it.isLetter() } || tecladoNovoNomeFormacao.any { it.isDigit() }) {
                        println("-----Nome inválido!-----".uppercase())
                    }
                } while (tecladoNovoNomeFormacao.isNullOrEmpty() || !tecladoNovoNomeFormacao.any { it.isLetter() } || tecladoNovoNomeFormacao.any { it.isDigit() })

                formacaoSelecionada.nomeFormacao = tecladoNovoNomeFormacao //Atribuição de novo nome à formação do ID informado

                //Mensagem de feedback da edição do nome da formação
                println("Alteração do nome da formação bem sucedida:\n" +
                        "ID: ${formacaoSelecionada.idFormacao} | NOME: ${formacaoSelecionada.nomeFormacao}\n\t↳ NÍVEL: ${formacaoSelecionada.nivelDificuldadeFormacao}\n")
            }
        }
    } while (respostaEditarNomeFormacao.isNullOrEmpty() || ((respostaEditarNomeFormacao != "s") && (respostaEditarNomeFormacao != "n")))

    //Edição do nível de dificuldade da formação
    do {  //Repete execução enquanto não recebe um valor correspondente a "s" ou "n"

        println("Deseja editar o nível de dificuldade da formação? Digite 's' para sim ou 'n' para não")
        val respostaEditarNivelDificuldadeFormacao = readlnOrNull() //Recebimento do valor pelo teclado

        if (respostaEditarNivelDificuldadeFormacao.isNullOrEmpty() || ((respostaEditarNivelDificuldadeFormacao != "s") && (respostaEditarNivelDificuldadeFormacao != "n"))) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        } else {
            var selecaoNovoNivelDificuldadeFormacao : String //Variável de novoNivelDificuldadeFormacao que preencherá NivelDificuldadeFormacao após edição

            if (respostaEditarNivelDificuldadeFormacao == "s") { //Se recebeu "s", segue para alteração do nível de dificuldade da formação

                do { //Repete execução enquanto não recebe 1, 2 ou 3
                    println("Selecione o novo nível de dificuldade da formação informando o número correspondente:" +
                            "\n1 - Básico\n2 - Intermediário\n3 - Avançado")
                    var tecladoNivelDificuldadeFormacao = readlnOrNull() //Recebe escolha do usuário entre as opções
                    selecaoNovoNivelDificuldadeFormacao = tecladoNivelDificuldadeFormacao.toString() //recebe o valor de tecladoNivelDificuldadeFormacao


                    when (tecladoNivelDificuldadeFormacao) {
                        "1" -> selecaoNovoNivelDificuldadeFormacao = NivelDificuldade.BASICO.toString() //muda o valor de selecaoNovoNivelDificuldadeFormacao para o valor do enum enums.enums.NivelDificuldade
                        "2" -> selecaoNovoNivelDificuldadeFormacao = NivelDificuldade.INTERMEDIARIO.toString()  //muda o valor de selecaoNovoNivelDificuldadeFormacao para o valor do enum enums.enums.NivelDificuldade
                        "3" -> selecaoNovoNivelDificuldadeFormacao = NivelDificuldade.AVANCADO.toString() //muda o valor de selecaoNovoNivelDificuldadeFormacao para o valor do enum enums.enums.NivelDificuldade

                    }

                    if (tecladoNivelDificuldadeFormacao.isNullOrEmpty() || (!tecladoNivelDificuldadeFormacao.equals("1") && !tecladoNivelDificuldadeFormacao.equals("2") && !tecladoNivelDificuldadeFormacao.equals("3"))) {
                        println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
                    }

                } while (tecladoNivelDificuldadeFormacao.isNullOrEmpty() || (!tecladoNivelDificuldadeFormacao.equals("1") && !tecladoNivelDificuldadeFormacao.equals("2") && !tecladoNivelDificuldadeFormacao.equals("3")))

                formacaoSelecionada.nivelDificuldadeFormacao = selecaoNovoNivelDificuldadeFormacao //Alteração do nível de dificuldade da formação do ID informado

                //Mensagem de feedback da edição do nível de dificuldade da formação
                println("Alteração do tipo do conteúdo educacional bem sucedida:\n" +
                        "ID: ${formacaoSelecionada.idFormacao} | NOME: ${formacaoSelecionada.nomeFormacao}\n\t↳ NÍVEL: ${formacaoSelecionada.nivelDificuldadeFormacao}\n")
            }
        }
    } while (respostaEditarNivelDificuldadeFormacao.isNullOrEmpty() || ((respostaEditarNivelDificuldadeFormacao != "s") && (respostaEditarNivelDificuldadeFormacao != "n")))

}