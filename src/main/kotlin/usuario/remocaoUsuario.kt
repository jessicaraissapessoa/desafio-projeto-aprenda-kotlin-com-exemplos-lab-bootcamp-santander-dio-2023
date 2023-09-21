package usuario

import aplicacao.menuUsuario

fun excluirUsuario() { //Função para remover usuário

    if (listaUsuarios.isEmpty()) exibirListaUsuariosVazia() //Caso a lista de usuários esteja vazia, executar função exibirListaUsuariosVazia()

    println("----- Lista de usuários cadastrados -----\n".uppercase())
    exibirUsuarios()

    //Variável opcoes recebe os valores de cada id de usuário de listaUsuarios
    val opcoes = mutableListOf<String>()
    for (usuario in listaUsuarios) {
        val opcao = usuario.idUsuario
        opcoes.add(opcao.toString())
    }

    var selecaoRemocaoUsuario : String? //Variável que receberá opção informada por teclado em do/while seguinte

    do { //Repete execução enquanto não recebe um valor correspondente a algum dos valores da variável opcoes

        println("Informe o ID do usuário que deseja excluir:")
        selecaoRemocaoUsuario = readlnOrNull() //Recebimento do valor pelo teclado

        if (!opcoes.contains(selecaoRemocaoUsuario)) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        }

    } while (!opcoes.contains(selecaoRemocaoUsuario))

    val idUsuario = selecaoRemocaoUsuario!!.toInt() //índice de Usuário na mutableList listaUsuarios
    val usuarioSelecionado = listaUsuarios.find { it.idUsuario == idUsuario } //usuarioSelecionado recebe o Usuário equivalente de listaUsuarios

    if (usuarioSelecionado != null) { //Remoção com feedback
        val removido = listaUsuarios.remove(usuarioSelecionado)

        if (removido) {
            println("Remoção bem sucedida de:\n$usuarioSelecionado!\n")  //Mensagem de feedback da remoção
        } else println("Remoção falhou")
    }

    if (listaUsuarios.isNotEmpty()) {

        //"Loop" de excluirUsuario()
        do { //Repete execução enquanto excluirOutroUsuario não receber um valor que não seja nulo, vazio, sem letras ou diferente de "s" e "n"

            println("Gostaria de excluir outro usuário? Digite 's' para sim ou 'n' para não")
            val excluirOutroUsuario = readlnOrNull() //Recebimento do valor pelo teclado

            when(excluirOutroUsuario) {
                "s" -> excluirUsuario() //Segue para função excluirUsuario()
                "n" -> println("")
            }

            if (excluirOutroUsuario.isNullOrEmpty() || !excluirOutroUsuario.any { it.isLetter() } || (!excluirOutroUsuario.equals("s") && !excluirOutroUsuario.equals("n"))) {
                println("-----Seleção inválida!-----".uppercase())
            } else println("")

        } while (excluirOutroUsuario.isNullOrEmpty() || !excluirOutroUsuario.any { it.isLetter() } || (!excluirOutroUsuario.equals("s") && !excluirOutroUsuario.equals("n")))

    }

    menuUsuario()

}