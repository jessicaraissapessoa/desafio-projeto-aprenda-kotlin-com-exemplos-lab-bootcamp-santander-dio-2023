package formacao

import aplicacao.menuFormacao
import usuario.cadastrarUsuario
import usuario.exibirListaUsuariosVazia
import usuario.exibirUsuarios
import usuario.listaUsuarios

fun editarUsuariosFormacao() {

    if (listaUsuarios.isEmpty()) exibirListaUsuariosVazia() //Caso a lista de usuários esteja vazia, executar função exibirListaUsuariosVazia()
    if (listaFormacoes.isEmpty()) exibirListaFormacoesVazia() //Caso a lista de formações esteja vazia, executar função exibirListaFormacoesVazia()

    do { //Repete execução enquanto não receber 1, 2 ou 3

        println("----------------------------------------------------------------------------------------" +
                "\nSelecione a edição que deseja fazer informando número correspondente:" +
                "\n1 - Adicionar usuário(s) à uma formação" +
                "\n2 - Remover usuário(s) de uma formação" +
                "\n3 - Voltar" +
                "\n----------------------------------------------------------------------------------------")
        val opcao = readlnOrNull()

        when (opcao) {
            "1" -> adicionarUsuarioFormacao()
            "2" -> excluirUsuarioFormacao()
            "3" -> menuFormacao()
        }

        if (opcao.isNullOrEmpty() || (!opcao.equals("1") && !opcao.equals("2")  && !opcao.equals("3"))) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        }

    } while (opcao.isNullOrEmpty() || (!opcao.equals("1") && !opcao.equals("2") && !opcao.equals("3")))

}

fun adicionarUsuarioFormacao() {

    if (listaUsuarios.isEmpty()) exibirListaUsuariosVazia() //Caso a lista de usuários esteja vazia, executar função exibirListaUsuariosVazia()
    if (listaFormacoes.isEmpty()) exibirListaFormacoesVazia() //Caso a lista de formações esteja vazia, executar função exibirListaFormacoesVazia()

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

        println("Informe o ID da formação na qual deseja adicionar usuário(s):")
        selecaoFormacao = readlnOrNull() //Recebimento do valor do ID da formação selecionada pelo usuário

        if (!opcoesFormacao.contains(selecaoFormacao)) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        }

    } while (!opcoesFormacao.contains(selecaoFormacao))

    val indexFormacao = selecaoFormacao!!.toInt() - 1 //índice da formação na mutableList listaFormacoes
    val formacaoSelecionada = listaFormacoes[indexFormacao] //formaçãoSelecionada recebe a Formacao equivalente de listaFormações

    adicionarUsuarioFormacaoSelecionada(formacaoSelecionada)
}


fun adicionarUsuarioFormacaoSelecionada(formacaoSelecionada: Formacao) {

    println("ID: ${formacaoSelecionada.idFormacao} | NOME: ${formacaoSelecionada.nomeFormacao}\n\t↳ NÍVEL: ${formacaoSelecionada.nivelDificuldadeFormacao}\n")

    println("----- Lista de usuários cadastrados na formação -----\n".uppercase())
    exibirInscritosFormacao(formacaoSelecionada)

    println("----- Lista de usuários no sistema -----\n".uppercase())
    exibirUsuarios()

    //Se quiser inscrever usuário que não está ainda no sistema
    println("Para adicionar usuário(s) novo(s) antes de seguir, digite 'add'. Senão, digite qualquer outra coisa.")
    val addUsuarioAntes = readlnOrNull()
    if (addUsuarioAntes == "add") {
        cadastrarUsuario()
        exibirUsuarios()
    } else println()

    val opcoesUsuario = mutableListOf<String>() //Variável opcoes recebe os valores de cada id de usuário de listaUsuarios
    for (usuario in listaUsuarios) {
        val opcao = usuario.idUsuario
        opcoesUsuario.add(opcao.toString())
    }

    var selecaoUsuario : String? //Variável que vai receber escolha de usuário dentre as opções acima

    do { //Repete execução enquanto não recebe um valor correspondente a algum dos valores da variável opcoes

        println("Informe o ID do usuário que deseja inscrever na formação:")
        selecaoUsuario = readlnOrNull() //Recebimento do valor do ID do usuário selecionado

        if (!opcoesUsuario.contains(selecaoUsuario)) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        }

    } while (!opcoesUsuario.contains(selecaoUsuario))

    val indexUsuario = selecaoUsuario!!.toInt() - 1 //índice de Usuário na mutableList listaUsuarios
    val usuarioSelecionado = listaUsuarios[indexUsuario] //usuarioSelecionado recebe o Usuário equivalente de listaUsuarios

    //Verificação se o usuário já não está inscrito na formação. Se não estiver inscrito, é feita inscrição:
    if (formacaoSelecionada.inscritosFormacao.any { it.idUsuario == usuarioSelecionado.idUsuario }) {
        println("Inscrição falhou: usuário já está inscrito na formação selecionada")
    } else {
        formacaoSelecionada.inscritosFormacao.add(listaUsuarios[indexUsuario])
        println("Adição bem sucedida: usuário de ID " + listaUsuarios[indexUsuario].idUsuario + " inscrito em formação de ID " + formacaoSelecionada.idFormacao)
    }

    do { //Repete execução enquanto não receber valor válido: "s" ou "n"

        println("Deseja inscrever outro usuário nessa formação? Digite 's' para sim ou 'n' para não")
        val adicionarOutroUsuarioFormacao = readlnOrNull()

        if (adicionarOutroUsuarioFormacao.isNullOrEmpty() || !adicionarOutroUsuarioFormacao.any { it.isLetter() } || (!adicionarOutroUsuarioFormacao.equals("s") && !adicionarOutroUsuarioFormacao.equals("n"))) {
            println("-----Seleção inválida!-----".uppercase())
        }

        when(adicionarOutroUsuarioFormacao) {
            "s" -> adicionarUsuarioFormacaoSelecionada(formacaoSelecionada) //"Loop" de adicionarUsuariosFormacao() -> Segue cadastrando usuários na mesma formação
            "n" -> {
                println("Inscrição de usuários em formação de ID ${formacaoSelecionada.idFormacao} concluída\n")
                println(formacaoSelecionada)
            }
        }

    } while (adicionarOutroUsuarioFormacao.isNullOrEmpty() || !adicionarOutroUsuarioFormacao.any { it.isLetter() } || (!adicionarOutroUsuarioFormacao.equals("s") && !adicionarOutroUsuarioFormacao.equals("n")))

    editarFormacao()

}

fun excluirUsuarioFormacao() {

    if (listaUsuarios.isEmpty()) exibirListaUsuariosVazia() //Caso a lista de usuários esteja vazia, executar função exibirListaUsuariosVazia()
    if (listaFormacoes.isEmpty()) exibirListaFormacoesVazia() //Caso a lista de formações esteja vazia, executar função exibirListaFormacoesVazia()

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

        println("Informe o ID da formação da qual deseja remover usuário(s):")
        selecaoFormacao = readlnOrNull() //Recebimento do valor do ID da formação selecionada pelo usuário

        if (!opcoesFormacao.contains(selecaoFormacao)) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        }

    } while (!opcoesFormacao.contains(selecaoFormacao))

    val indexFormacao = selecaoFormacao!!.toInt() - 1 //índice da formação na mutableList listaFormacoes
    val formacaoSelecionada = listaFormacoes[indexFormacao] //formaçãoSelecionada recebe a Formacao equivalente de listaFormações

    excluirUsuarioFormacaoSelecionada(formacaoSelecionada)
}

fun excluirUsuarioFormacaoSelecionada(formacaoSelecionada: Formacao) {

    if (formacaoSelecionada.inscritosFormacao.isEmpty()) {
        println("Não há usuários para excluir da formação.")
        editarFormacao()
    } else {

        println("ID: ${formacaoSelecionada.idFormacao} | NOME: ${formacaoSelecionada.nomeFormacao}\n\t↳ NÍVEL: ${formacaoSelecionada.nivelDificuldadeFormacao}\n")

        println("----- Lista de usuários cadastrados na formação -----\n".uppercase())
        exibirInscritosFormacao(formacaoSelecionada)

        println("----- Lista de usuários no sistema -----\n".uppercase())
        exibirUsuarios()

        val opcoesUsuario = mutableListOf<String>() //Variável opcoes recebe os valores de cada id de usuário de listaUsuarios
        for (usuario in listaUsuarios) {
            val opcao = usuario.idUsuario
            opcoesUsuario.add(opcao.toString())
        }

        var selecaoUsuario : String? //Variável que vai receber escolha de usuário dentre as opções acima

        do { //Repete execução enquanto não recebe um valor correspondente a algum dos valores da variável opcoes

            println("Informe o ID do usuário que deseja remover da formação:")
            selecaoUsuario = readlnOrNull() //Recebimento do valor do ID do usuário selecionado

            if (!opcoesUsuario.contains(selecaoUsuario)) {
                println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
            }

        } while (!opcoesUsuario.contains(selecaoUsuario))

        val indexUsuario = selecaoUsuario!!.toInt() - 1 //índice de Usuário na mutableList listaUsuarios
        val usuarioSelecionado = listaUsuarios[indexUsuario] //usuarioSelecionado recebe o Usuário equivalente de listaUsuarios

        if (formacaoSelecionada.inscritosFormacao.remove(usuarioSelecionado)) {
            println("Remoção bem sucedida de:\n$usuarioSelecionado!\n")
            println("ID: ${formacaoSelecionada.idFormacao} | NOME: ${formacaoSelecionada.nomeFormacao}\n\t↳ NÍVEL: ${formacaoSelecionada.nivelDificuldadeFormacao}\n")
            exibirInscritosFormacao(formacaoSelecionada)
        } else println("Remoção falhou")

        do { //Repete execução enquanto não receber valor válido: "s" ou "n"

            println("Deseja remover outro usuário dessa formação? Digite 's' para sim ou 'n' para não")
            val excluirOutroUsuarioFormacao = readlnOrNull()

            if (excluirOutroUsuarioFormacao.isNullOrEmpty() || !excluirOutroUsuarioFormacao.any { it.isLetter() } || (!excluirOutroUsuarioFormacao.equals("s") && !excluirOutroUsuarioFormacao.equals("n"))) {
                println("-----Seleção inválida!-----".uppercase())
            }

            when(excluirOutroUsuarioFormacao) {
                "s" -> excluirUsuarioFormacaoSelecionada(formacaoSelecionada) //"Loop" de excluirUsuarioFormacao() -> Segue removendo usuários na mesma formação
                "n" -> {
                    println("Remoção de usuários em formação de ID ${formacaoSelecionada.idFormacao} concluída\n")
                    println(formacaoSelecionada)
                }
            }

        } while (excluirOutroUsuarioFormacao.isNullOrEmpty() || !excluirOutroUsuarioFormacao.any { it.isLetter() } || (!excluirOutroUsuarioFormacao.equals("s") && !excluirOutroUsuarioFormacao.equals("n")))

        editarFormacao()
    }

}