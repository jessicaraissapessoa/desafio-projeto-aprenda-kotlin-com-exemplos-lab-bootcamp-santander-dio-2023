package formacao

import aplicacao.telaInicial
import enums.NivelDificuldade
import formacao.ConteudoEmFormacao.editarConteudosFormacao
import formacao.UsuarioEmFormacao.editarUsuariosFormacao
import usuario.exibirListaUsuariosVazia
import usuario.listaUsuarios


fun editarFormacao() {

    if (listaFormacoes.isEmpty()) exibirListaFormacoesVazia() //Caso a lista de formações esteja vazia, executar função exibirListaFormacoesVazia()

    do { //Repete execução enquanto não receber 1, 2, 3, 4, 5 ou 6

        println("----------------------------------------------------------------------------------------" +
                "\nSelecione o que deseja editar em FORMAÇÃO informando número correspondente:" +
                "\n1 - Editar nome e/ou nível de dificuldade de uma formação" +
                "\n2 - Editar/Excluir usuário(s) de uma formação" +
                "\n3 - Editar/Excluir conteúdo(s) educacional(is) de uma formação" +
                "\n4 - Remover formação cadastrada" +
                "\n5 - Voltar" +
                "\n----------------------------------------------------------------------------------------")
        val opcao = readlnOrNull()

        when (opcao) {
            "1" -> editarDadosFormacao()
            "2" -> exibirFormacaoDetalhada()
            "3" -> cadastrarFormacao()
            "4" -> editarFormacao()
            "5" -> excluirFormacao()
            "6" -> telaInicial()
        }

        if (opcao.isNullOrEmpty() || (!opcao.equals("1") && !opcao.equals("2")  && !opcao.equals("3") && !opcao.equals("4") && !opcao.equals("5"))) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        }

    } while (opcao.isNullOrEmpty() || (!opcao.equals("1") && !opcao.equals("2") && !opcao.equals("3") && !opcao.equals("4") && !opcao.equals("5")))

}

fun editarDadosFormacao() {

    exibirListaFormacoes()

    do { //Repete execução enquanto não receber valor válido: "s" ou "n"

        println("Deseja visualizar detalhes de alguma formação antes de seguir? Digite 's' para sim ou 'n' para não.")
        val visualizarDetalhes = readlnOrNull()

        if (visualizarDetalhes.isNullOrEmpty() || !visualizarDetalhes.any { it.isLetter() } || (!visualizarDetalhes.equals("s") && !visualizarDetalhes.equals("n"))) {
            println("-----Seleção inválida!-----".uppercase())
        }

        when(visualizarDetalhes) {
            "s" -> exibirFormacaoDetalhada()
            "n" -> println()
        }

    } while (visualizarDetalhes.isNullOrEmpty() || !visualizarDetalhes.any { it.isLetter() } || (!visualizarDetalhes.equals("s") && !visualizarDetalhes.equals("n")))

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

    editarFormacao()
}