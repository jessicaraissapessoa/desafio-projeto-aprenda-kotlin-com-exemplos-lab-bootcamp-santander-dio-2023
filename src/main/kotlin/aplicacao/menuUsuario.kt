package aplicacao

import usuario.cadastrarUsuario
import usuario.editarUsuario
import usuario.excluirUsuario
import usuario.exibirUsuarios

fun menuUsuario() {

    do { //Repete execução enquanto não receber 1, 2 ou 3

        println("----------------------------------------------------------------------------------------" +
                "\nSelecione o que deseja acessar em USUÁRIO informando número correspondente:" +
                "\n1 - Lista de usuários cadastrados" +
                "\n2 - Cadastrar usuário(s)" +
                "\n3 - Editar usuário(s) cadastrado(s)" +
                "\n4 - Remover usuário(s) cadastrado(s)" +
                "\n5 - Voltar para tela inicial" +
                "\n----------------------------------------------------------------------------------------")
        val opcao = readlnOrNull()

        when (opcao) {
            "1" -> exibirUsuarios()
            "2" -> cadastrarUsuario()
            "3" -> editarUsuario()
            "4" -> excluirUsuario()
            "5" -> telaInicial()
        }

        if (opcao.isNullOrEmpty() || (!opcao.equals("1") && !opcao.equals("2")  && !opcao.equals("3") && !opcao.equals("4") && !opcao.equals("5"))) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        }

    } while (opcao.isNullOrEmpty() || (!opcao.equals("1") && !opcao.equals("2") && !opcao.equals("3") && !opcao.equals("4") && !opcao.equals("5")))

}