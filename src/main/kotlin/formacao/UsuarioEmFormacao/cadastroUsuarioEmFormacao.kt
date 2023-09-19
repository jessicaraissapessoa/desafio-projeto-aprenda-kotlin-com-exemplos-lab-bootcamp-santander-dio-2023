package formacao.UsuarioEmFormacao

import formacao.*
import usuario.cadastrarUsuario
import usuario.exibirListaUsuariosVazia
import usuario.exibirUsuarios
import usuario.listaUsuarios

fun cadastrarUsuarioFormacao() {

    if (listaUsuarios.isEmpty()) exibirListaUsuariosVazia() //Caso a lista de usuários esteja vazia, executar função exibirListaUsuariosVazia()
    if (listaFormacoes.isEmpty()) exibirListaFormacoesVazia() //Caso a lista de formações esteja vazia, executar função exibirListaFormacoesVazia()

    println("----- Lista de formações cadastrados -----\n".uppercase())
    exibirListaFormacoes()

    val opcoesFormacao = mutableListOf<String>() //Variável opcoes recebe os valores de cada id de formação de listaFormacoes
    for (formacao in listaFormacoes) {
        val opcao = formacao.idFormacao
        opcoesFormacao.add(opcao.toString())
    }

    var selecaoFormacao : String? //Variável que vai receber escolha de formação dentre as opções acima

    do { //Repete execução enquanto não recebe um valor correspondente a algum dos valores da variável opcoes

        println("Informe o ID da formação na qual deseja cadastrar usuário(s):")
        selecaoFormacao = readlnOrNull() //Recebimento do valor do ID da formação selecionada pelo usuário

        if (!opcoesFormacao.contains(selecaoFormacao)) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        }

    } while (!opcoesFormacao.contains(selecaoFormacao))

    val indexFormacao = selecaoFormacao!!.toInt() - 1 //índice da formação na mutableList listaFormacoes
    val formacaoSelecionada = listaFormacoes[indexFormacao] //formaçãoSelecionada recebe a Formacao equivalente de listaFormações

    selecionarUsuariosFormacao(formacaoSelecionada)

}


fun selecionarUsuariosFormacao(formacaoSelecionada: Formacao) {

    if (listaUsuarios.isEmpty()) exibirListaUsuariosVazia() //Caso a lista de usuários esteja vazia, executar função exibirListaUsuariosVazia()

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
            "s" -> selecionarUsuariosFormacao(formacaoSelecionada) //"Loop" de selecionarUsuariosFormacao() -> Segue cadastrando usuários na mesma formação
            "n" -> {
                println("Inscrição de usuários em formação de ID ${formacaoSelecionada.idFormacao} concluída\n")
                println(formacaoSelecionada)


                do { //Repete execução enquanto não receber valor válido: "s" ou "n"

                    println("Deseja inscrever usuários em outra formação? Digite 's' para sim ou 'n' para não")
                    val adicionarUsuariosEmOutraFormacao = readlnOrNull()

                    if (adicionarUsuariosEmOutraFormacao.isNullOrEmpty() || !adicionarUsuariosEmOutraFormacao.any { it.isLetter() } || (!adicionarUsuariosEmOutraFormacao.equals("s") && !adicionarUsuariosEmOutraFormacao.equals("n"))) {
                        println("-----Seleção inválida!-----".uppercase())
                    }

                    when (adicionarUsuariosEmOutraFormacao) {
                        "s" -> cadastrarUsuarioFormacao() //"Loop" de cadastrarUsuarioFormacao() -> Segue cadastrando usuários, mas em outra formação
                        "n" -> exibirInscritosFormacao(formacaoSelecionada)
                    }

                } while (adicionarUsuariosEmOutraFormacao.isNullOrEmpty() || !adicionarUsuariosEmOutraFormacao.any { it.isLetter() } || (!adicionarUsuariosEmOutraFormacao.equals("s") && !adicionarUsuariosEmOutraFormacao.equals("n")))

            }
        }

    } while (adicionarOutroUsuarioFormacao.isNullOrEmpty() || !adicionarOutroUsuarioFormacao.any { it.isLetter() } || (!adicionarOutroUsuarioFormacao.equals("s") && !adicionarOutroUsuarioFormacao.equals("n")))

    //Se deseja remover usuários
    do { //Repete execução enquanto não receber valor válido: "s" ou "n"

        println("Deseja remover usuários dessa formação? Digite 's' para sim ou 'n' para não")
        val removerUsuarioDaFormacao = readlnOrNull()

        if (removerUsuarioDaFormacao.isNullOrEmpty() || !removerUsuarioDaFormacao.any { it.isLetter() } || (!removerUsuarioDaFormacao.equals("s") && !removerUsuarioDaFormacao.equals("n"))) {
            println("-----Seleção inválida!-----".uppercase())
        }

        when(removerUsuarioDaFormacao) {
            "s" -> excluirUsuarioFormacao(formacaoSelecionada) //Direciona para função de remoção de usuários da formação
            "n" -> exibirInscritosFormacao(formacaoSelecionada) //Exibe inscritos da formação
        }

    } while (removerUsuarioDaFormacao.isNullOrEmpty() || !removerUsuarioDaFormacao.any { it.isLetter() } || (!removerUsuarioDaFormacao.equals("s") && !removerUsuarioDaFormacao.equals("n")))

}