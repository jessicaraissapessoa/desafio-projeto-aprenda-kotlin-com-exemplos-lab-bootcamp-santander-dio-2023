package usuario

import enums.TipoUsuario

fun editarUsuario() { //Função para editar usuário

    if (listaUsuarios.isEmpty()) exibirListaUsuariosVazia() //Caso a lista de usuários esteja vazia, executar função exibirListaUsuariosVazia()

    println("----- Lista de usuários cadastrados -----\n".uppercase())
    exibirUsuarios()

    //Variável opcoes recebe os valores de cada id de usuário de listaUsuarios
    val opcoes = mutableListOf<String>()
    for (usuario in listaUsuarios) {
        val opcao = usuario.idUsuario
        opcoes.add(opcao.toString())
    }

    var selecaoEdicaoUsuario : String? //Variável que receberá opção informada por teclado em do/while seguinte
    var usuarioParaEdicao : Usuario?

    do { //Repete execução enquanto não recebe um valor correspondente a algum dos valores da variável opcoes

        println("Informe o ID do usuário que deseja editar:")
        selecaoEdicaoUsuario = readlnOrNull() //Recebimento do valor do ID informado pelo usuário

        if (!opcoes.contains(selecaoEdicaoUsuario)) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        }

    } while (!opcoes.contains(selecaoEdicaoUsuario))

    val index = selecaoEdicaoUsuario?.toInt()!! - 1 //Variável que recebe valor do que será o índice do elemento de listaUsuarios
    usuarioParaEdicao = listaUsuarios[index] //Usuário a ser editado é o elemento listaUsuarios[<índice do elemento dentro do array>]

    //Edição do nome do usuário
    do { //Repete execução enquanto não recebe um valor correspondente a "s" ou "n"
        println("Deseja editar o nome do usuário? Digite 's' para sim ou 'n' para não")
        val respostaEditarNomeUsuario = readlnOrNull() //Recebimento do valor pelo teclado

        if (respostaEditarNomeUsuario.isNullOrEmpty() || ((respostaEditarNomeUsuario != "s") && (respostaEditarNomeUsuario != "n"))) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        } else {
            var tecladoNovoNomeUsuario : String? //Variável de novoNomeUsuario que preencherá nomeUsuario após ediçao

            if (respostaEditarNomeUsuario == "s") { //Se recebeu "s", segue para alteração do nome do usuário
                do { //Repete execução enquanto tecladoNovoNomeUsuario não receber um valor que não seja nulo, vazio, sem letras ou com números
                    println("Insira novo nome completo do usuário:")
                    tecladoNovoNomeUsuario = readlnOrNull() //Recebimento do valor pelo teclado

                    if (tecladoNovoNomeUsuario.isNullOrEmpty() || !tecladoNovoNomeUsuario.any { it.isLetter() } || tecladoNovoNomeUsuario.any { it.isDigit() }) {
                        println("-----Nome inválido!-----".uppercase())
                    }
                } while (tecladoNovoNomeUsuario.isNullOrEmpty() || !tecladoNovoNomeUsuario.any { it.isLetter() } || tecladoNovoNomeUsuario.any { it.isDigit() })

                usuarioParaEdicao.nomeUsuario = tecladoNovoNomeUsuario //Atribuição de novo nome ao usuário do ID informado

                println("Alteração do nome do usuário bem sucedida:\n$usuarioParaEdicao\n") //Mensagem de feedback da edição do nome do usuário
            }
        }
    } while (respostaEditarNomeUsuario.isNullOrEmpty() || ((respostaEditarNomeUsuario != "s") && (respostaEditarNomeUsuario != "n")))

    //Edição do tipo do usuário
    do {  //Repete execução enquanto não recebe um valor correspondente a "s" ou "n"

        println("Deseja editar o tipo do usuário? Digite 's' para sim ou 'n' para não")
        val respostaEditarTipoUsuario = readlnOrNull() //Recebimento do valor pelo teclado

        if (respostaEditarTipoUsuario.isNullOrEmpty() || ((respostaEditarTipoUsuario != "s") && (respostaEditarTipoUsuario != "n"))) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        } else {
            var selecaoNovoTipoUsuario : String //Variável de novoTipoUsuario que preencherá nomeUsuario após edição

            if (respostaEditarTipoUsuario == "s") { //Se recebeu "s", segue para alteração do tipo do usuário

                do { //Repete execução enquanto não recebe 1 ou 2
                    println("Selecione o novo tipo do usuário informando o número correspondente:" +
                            "\n1 - Instrutor(a)\n2 - Aluno(a)")
                    var tecladoNovoTipoUsuario = readlnOrNull() //Recebe escolha do usuário entre as opções
                    selecaoNovoTipoUsuario = tecladoNovoTipoUsuario.toString() //recebe o valor de tecladoTipoUsuario


                    when (tecladoNovoTipoUsuario) {
                        "1" -> selecaoNovoTipoUsuario = TipoUsuario.INSTRUTOR.toString() //muda o valor de selecaoNovoTipoUsuario para o valor do enum enums.TipoUsuario
                        "2" -> selecaoNovoTipoUsuario = TipoUsuario.ALUNO.toString() //muda o valor de selecaoNovoTipoUsuario para o valor do enum enums.TipoUsuario
                    }

                    if (tecladoNovoTipoUsuario.isNullOrEmpty() || (!tecladoNovoTipoUsuario.equals("1") && !tecladoNovoTipoUsuario.equals("2"))) {
                        println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
                    }

                } while (tecladoNovoTipoUsuario.isNullOrEmpty() || (!tecladoNovoTipoUsuario.equals("1") && !tecladoNovoTipoUsuario.equals("2")))

                usuarioParaEdicao.tipoUsuario = selecaoNovoTipoUsuario //Alteração do tipo do usuário do ID informado

                println("Alteração do tipo do usuário bem sucedida:\n$usuarioParaEdicao\n") //Mensagem de feedback da edição do tipo do usuário
            }
        }
    } while (respostaEditarTipoUsuario.isNullOrEmpty() || ((respostaEditarTipoUsuario != "s") && (respostaEditarTipoUsuario != "n")))

    println("Edição do usuário de ID $selecaoEdicaoUsuario concluída") //Feedback da conclusão da edição do usuário

    if (listaUsuarios.isNotEmpty()) {

        //"Loop" de editarUsuario()
        do { //Repete execução enquanto editarOutroUsuario não receber um valor que não seja nulo, vazio, sem letras ou diferente de "s" e "n"

            println("Gostaria de editar outro usuário? Digite 's' para sim ou 'n' para não")
            val editarOutroUsuario = readlnOrNull() //Recebimento do valor pelo teclado

            when(editarOutroUsuario) {
                "s" -> editarUsuario() //Segue para função editarUsuario()
                "n" -> println("")
            }

            if (editarOutroUsuario.isNullOrEmpty() || !editarOutroUsuario.any { it.isLetter() } || (!editarOutroUsuario.equals("s") && !editarOutroUsuario.equals("n"))) {
                println("-----Seleção inválida!-----".uppercase())
            } else println("")

        } while (editarOutroUsuario.isNullOrEmpty() || !editarOutroUsuario.any { it.isLetter() } || (!editarOutroUsuario.equals("s") && !editarOutroUsuario.equals("n")))

    }

}