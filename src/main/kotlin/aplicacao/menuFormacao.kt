package aplicacao

import formacao.*

fun menuFormacao() {

    do { //Repete execução enquanto não receber 1, 2, 3, 4, 5, 6, 7 ou 8

        println("----------------------------------------------------------------------------------------" +
                "\nSelecione o que deseja acessar em FORMAÇÃO informando número correspondente:" +
                "\n1 - Lista de formações cadastradas" +
                "\n2 - Exibir detalhes de uma formação" +
                "\n3 - Cadastrar formação(ões)" +
                "\n4 - Editar formação(ões) cadastrado(s) - Nome / Nível de dificuldade" +
                "\n5 - Remover formação(ões) cadastrado(s)" +
                "\n6 - Editar usuários de uma formação - Adicionar / Remover" +
                "\n7 - Editar conteúdos educacionais de uma formação - Adicionar / Remover" +
                "\n8 - Voltar para tela inicial" +
                "\n----------------------------------------------------------------------------------------")
        val opcao = readlnOrNull()

        when (opcao) {
            "1" -> exibirListaFormacoesOpcaoMenu()
            "2" -> exibirFormacaoDetalhada()
            "3" -> cadastrarFormacao()
            "4" -> editarDadosFormacao()
            "5" -> excluirFormacao()
            "6" -> editarUsuariosFormacao()
            "7" -> editarConteudosFormacao()
            "8" -> telaInicial()
        }

        if (opcao.isNullOrEmpty() || (!opcao.equals("1") && !opcao.equals("2")  && !opcao.equals("3") && !opcao.equals("4") && !opcao.equals("5") && !opcao.equals("6") && !opcao.equals("7") && !opcao.equals("8"))) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        }

    } while (opcao.isNullOrEmpty() || (!opcao.equals("1") && !opcao.equals("2") && !opcao.equals("3") && !opcao.equals("4") && !opcao.equals("5") && !opcao.equals("6") && !opcao.equals("7") && !opcao.equals("6")))

}