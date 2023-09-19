package formacao.UsuarioEmFormacao

import formacao.Formacao
import formacao.exibirInscritosFormacao
import usuario.exibirListaUsuariosVazia
import usuario.listaUsuarios

fun excluirUsuarioFormacao(formacaoSelecionada: Formacao) {

    if (listaUsuarios.isEmpty()) exibirListaUsuariosVazia() //Caso a lista de usuários esteja vazia, executar função exibirListaUsuariosVazia()

    println("ID: ${formacaoSelecionada.idFormacao} | NOME: ${formacaoSelecionada.nomeFormacao}\n\t↳ NÍVEL: ${formacaoSelecionada.nivelDificuldadeFormacao}\n")
    exibirInscritosFormacao(formacaoSelecionada)

    val opcoesUsuario = mutableListOf<String>() //Variável opcoes recebe os valores de cada id de usuário cadastrado na formação
    for (usuario in formacaoSelecionada.inscritosFormacao) {
        val opcao = usuario.idUsuario
        opcoesUsuario.add(opcao.toString())
    }

    var selecaoRemocaoUsuarioFormacao : String? //Variável que vai receber escolha de usuário dentre as opções acima

    if (formacaoSelecionada.inscritosFormacao.isEmpty()) println("Não há usuários para excluir da formação.")
    else {
        do { //Repete execução enquanto não recebe um valor correspondente a algum dos valores da variável opcoes

            println("Informe o ID do usuário que deseja remover da formação:")
            selecaoRemocaoUsuarioFormacao = readlnOrNull() //Recebimento do valor do ID do usuário selecionado

            if (!opcoesUsuario.contains(selecaoRemocaoUsuarioFormacao)) {
                println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
            }

        } while (!opcoesUsuario.contains(selecaoRemocaoUsuarioFormacao))

        val indexUsuario = selecaoRemocaoUsuarioFormacao!!.toInt() - 1 //índice de Usuário na mutableList listaUsuarios
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
                "s" -> excluirUsuarioFormacao(formacaoSelecionada) //"Loop" de excluirUsuarioFormacao() -> Segue excluindo usuários na mesma formação
                "n" -> exibirInscritosFormacao(formacaoSelecionada)
            }

        } while (excluirOutroUsuarioFormacao.isNullOrEmpty() || !excluirOutroUsuarioFormacao.any { it.isLetter() } || (!excluirOutroUsuarioFormacao.equals("s") && !excluirOutroUsuarioFormacao.equals("n")))

    }

    do { //Repete execução enquanto não receber valor válido: "s" ou "n"

        println("Deseja adicionar usuários nessa formação? Digite 's' para sim ou 'n' para não")
        val adicionarUsuarioFormacao = readlnOrNull()

        if (adicionarUsuarioFormacao.isNullOrEmpty() || !adicionarUsuarioFormacao.any { it.isLetter() } || (!adicionarUsuarioFormacao.equals("s") && !adicionarUsuarioFormacao.equals("n"))) {
            println("-----Seleção inválida!-----".uppercase())
        }

        when(adicionarUsuarioFormacao) {
            "s" -> selecionarUsuariosFormacao(formacaoSelecionada) //Direciona para função que adiciona usuários
            "n" -> exibirInscritosFormacao(formacaoSelecionada)
        }

    } while (adicionarUsuarioFormacao.isNullOrEmpty() || !adicionarUsuarioFormacao.any { it.isLetter() } || (!adicionarUsuarioFormacao.equals("s") && !adicionarUsuarioFormacao.equals("n")))

}