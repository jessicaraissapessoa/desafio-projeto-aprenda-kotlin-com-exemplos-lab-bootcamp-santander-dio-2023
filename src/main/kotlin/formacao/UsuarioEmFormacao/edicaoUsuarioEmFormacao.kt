package formacao.UsuarioEmFormacao

import formacao.Formacao
import formacao.exibirInscritosFormacao
import usuario.exibirListaUsuariosVazia
import usuario.listaUsuarios

fun editarUsuariosFormacao(formacaoSelecionada: Formacao) {

    if (listaUsuarios.isEmpty()) exibirListaUsuariosVazia() //Caso a lista de usuários esteja vazia, executar função exibirListaUsuariosVazia()

    println("ID: ${formacaoSelecionada.idFormacao} | NOME: ${formacaoSelecionada.nomeFormacao}\n\t↳ NÍVEL: ${formacaoSelecionada.nivelDificuldadeFormacao}\n")
    exibirInscritosFormacao(formacaoSelecionada)


    do { //Repete execução enquanto não recebe 1, 2 ou 3
        println("Selecione ação que deseja fazer informando o número correspondente:" +
                "\n1 - Adicionar usuário à formação\n2 - Excluir usuário da formação\n3 - Nenhum dos dois")
        var tecladoEditarUsuariosFormacao = readlnOrNull() //Recebe escolha do usuário entre as opções


        when (tecladoEditarUsuariosFormacao) {
            "1" -> selecionarUsuariosFormacao(formacaoSelecionada) //Segue para seleção de usuário que passa parâmetro
            "2" -> excluirUsuarioFormacao(formacaoSelecionada) //Segue para seleção de usuários para remoção passando parâmetro
            "3" -> println() //Encerra editarUsuariosFormacao(formacaoSelecionada: Formacao)

        }

        if (tecladoEditarUsuariosFormacao.isNullOrEmpty() || (!tecladoEditarUsuariosFormacao.equals("1") && !tecladoEditarUsuariosFormacao.equals("2") && !tecladoEditarUsuariosFormacao.equals("3"))) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        }

    } while (tecladoEditarUsuariosFormacao.isNullOrEmpty() || (!tecladoEditarUsuariosFormacao.equals("1") && !tecladoEditarUsuariosFormacao.equals("2") && !tecladoEditarUsuariosFormacao.equals("3")))

}