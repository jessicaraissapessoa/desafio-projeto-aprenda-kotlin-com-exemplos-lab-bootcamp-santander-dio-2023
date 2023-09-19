package usuario

import aplicacao.menuUsuario

fun exibirListaUsuariosVazia() {

    do { //Repete execução enquanto desejaAdicionarUsuarioTeclado não receber um valor que não seja nulo, vazio, sem letras ou diferente de "s" e "n"

        println("Sua lista de usuários está vazia. Deseja adicionar um usuário? Digite 's' para sim ou 'n' para não")
        val desejaAdicionarUsuarioTeclado = readlnOrNull() //Recebimento do valor pelo teclado

        when(desejaAdicionarUsuarioTeclado) {
            "s" -> cadastrarUsuario() //Segue para função cadastrarUsuario()
            "n" -> println("")
        }

        if (desejaAdicionarUsuarioTeclado.isNullOrEmpty() || !desejaAdicionarUsuarioTeclado.any { it.isLetter() } || (!desejaAdicionarUsuarioTeclado.equals("s") && !desejaAdicionarUsuarioTeclado.equals("n"))) {
            println("-----Seleção inválida!-----".uppercase())
        }

    } while (desejaAdicionarUsuarioTeclado.isNullOrEmpty() || !desejaAdicionarUsuarioTeclado.any { it.isLetter() } || (!desejaAdicionarUsuarioTeclado.equals("s") && !desejaAdicionarUsuarioTeclado.equals("n")))

}


fun exibirUsuarios() {

    if (listaUsuarios.isEmpty()) exibirListaUsuariosVazia() //Caso a lista de usuários esteja vazia, executar função exibirListaUsuariosVazia()

    val builder = StringBuilder() //Usando StringBuilder para construir a string

    for (usuario in listaUsuarios) {
        builder.append(usuario.toString()) //Adiciona o toString() de cada usuário
        builder.append("\n") //Adicionar uma quebra de linha entre cada usuário
    }

    println(builder.toString())
}


fun exibirUsuariosOpcaoMenu() { //Versão de exibirUsuarios() para encaminhamento de menuUsuario()

    if (listaUsuarios.isEmpty()) exibirListaUsuariosVazia() //Caso a lista de usuários esteja vazia, executar função exibirListaUsuariosVazia()

    val builder = StringBuilder() //Usando StringBuilder para construir a string

    for (usuario in listaUsuarios) {
        builder.append(usuario.toString()) //Adiciona o toString() de cada usuário
        builder.append("\n") //Adicionar uma quebra de linha entre cada usuário
    }

    println(builder.toString())

    do { //Repete execução enquanto editarOutroUsuario não receber um valor que não seja nulo, vazio, sem letras ou diferente de "s"

        println("Digite 's' para voltar ao menu de USUÁRIO")
        val voltarParaMenuUsuario = readlnOrNull() //Recebimento do valor pelo teclado

        when(voltarParaMenuUsuario) {
            "s" -> menuUsuario() //Segue para função menuUsuario()
            "n" -> print("")
        }

    } while (voltarParaMenuUsuario.isNullOrEmpty() || !voltarParaMenuUsuario.any { it.isLetter() } || (!voltarParaMenuUsuario.equals("s")))

}