package aplicacao

import enums.TipoConteudoEducacional

fun telaInicial() {

    do { //Repete execução enquanto não receber 1, 2 ou 3

        println("----------------------------------------------------------------------------------------" +
                "\nSelecione o que deseja acessar informando número correspondente:" +
                "\n1 - Usuários".uppercase() +
                "\n2 - Conteúdos educacionais".uppercase() +
                "\n3 - Formações".uppercase())
        val opcao = readlnOrNull()

        when (opcao) {
            "1" -> menuUsuario()
            "2" -> menuConteudoEducacional()
            "3" -> menuFormacao()
        }

        if (opcao.isNullOrEmpty() || (!opcao.equals("1") && !opcao.equals("2")  && !opcao.equals("3"))) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        }

    } while (opcao.isNullOrEmpty() || (!opcao.equals("1") && !opcao.equals("2") && !opcao.equals("3")))

}