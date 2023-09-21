package aplicacao

import conteudoEducacional.cadastrarConteudoEducacional
import conteudoEducacional.editarConteudoEducacional
import conteudoEducacional.excluirConteudoEducacional
import conteudoEducacional.exibirConteudosEducacionaisOpcaoMenu

fun menuConteudoEducacional() {

    do { //Repete execução enquanto não receber 1, 2, 3, 4 ou 5

        println("----------------------------------------------------------------------------------------" +
                "\nMENU CONTEÚDO EDUCACIONAL" +
                "\nSelecione o que deseja acessar em CONTEÚDO EDUCACIONAL informando número correspondente:" +
                "\n1 - Lista de conteúdos educacionais cadastrados" +
                "\n2 - Cadastrar conteúdo(s) educacional(is)" +
                "\n3 - Editar conteúdo(s) educacional(is) cadastrado(s)" +
                "\n4 - Remover conteúdo(s) educacional(is) cadastrado(s)" +
                "\n5 - Voltar para tela inicial" +
                "\n----------------------------------------------------------------------------------------")
        val opcao = readlnOrNull()

        when (opcao) {
            "1" -> exibirConteudosEducacionaisOpcaoMenu()
            "2" -> cadastrarConteudoEducacional()
            "3" -> editarConteudoEducacional()
            "4" -> excluirConteudoEducacional()
            "5" -> telaInicial()
        }

        if (opcao.isNullOrEmpty() || (!opcao.equals("1") && !opcao.equals("2")  && !opcao.equals("3") && !opcao.equals("4") && !opcao.equals("5"))) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        }

    } while (opcao.isNullOrEmpty() || (!opcao.equals("1") && !opcao.equals("2") && !opcao.equals("3") && !opcao.equals("4") && !opcao.equals("5")))

}