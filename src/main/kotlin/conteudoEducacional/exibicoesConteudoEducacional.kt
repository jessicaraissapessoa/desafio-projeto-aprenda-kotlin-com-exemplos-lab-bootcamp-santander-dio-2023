package conteudoEducacional

import aplicacao.menuConteudoEducacional
import aplicacao.menuUsuario
import usuario.exibirListaUsuariosVazia
import usuario.listaUsuarios

fun exibirListaConteudosEducacionaisVazia() {

    do { //Repete execução enquanto desejaAdicionarConteudoEducacionalTeclado não receber um valor que não seja nulo, vazio, sem letras ou diferente de "s" e "n"

        println("Sua lista de conteúdos educacionais está vazia. Deseja adicionar um conteúdo educacional? Digite 's' para sim ou 'n' para não")
        val desejaAdicionarConteudoEducacionalTeclado = readlnOrNull() //Recebimento do valor pelo teclado

        if (desejaAdicionarConteudoEducacionalTeclado.isNullOrEmpty() || !desejaAdicionarConteudoEducacionalTeclado.any { it.isLetter() } || (!desejaAdicionarConteudoEducacionalTeclado.equals("s") && !desejaAdicionarConteudoEducacionalTeclado.equals("n"))) {
            println("-----Seleção inválida!-----".uppercase())
        } else if (desejaAdicionarConteudoEducacionalTeclado == "s") cadastrarConteudoEducacional() //Segue para o cadastro de conteúdo educacional
        else println("Lista de conteúdos educacionais vazia")

    } while (desejaAdicionarConteudoEducacionalTeclado.isNullOrEmpty() || !desejaAdicionarConteudoEducacionalTeclado.any { it.isLetter() } || (!desejaAdicionarConteudoEducacionalTeclado.equals("s") && !desejaAdicionarConteudoEducacionalTeclado.equals("n")))
}


fun exibirConteudosEducacionais() { //Impressão de listaConteudosEducacionais

    if (listaConteudosEducacionais.isEmpty()) exibirListaConteudosEducacionaisVazia()  //Caso a lista de conteúdos educacionais esteja vazia, executar função exibirListaConteudosEducacionaisVazia()

    val builder = StringBuilder()  //Usando StringBuilder para construir a string

    for (conteudoEducacional in listaConteudosEducacionais) {
        builder.append(conteudoEducacional.toString())  //Adiciona o toString() de cada conteúdo educacional
        builder.append("\n") //Adicionar uma quebra de linha entre cada conteúdo educacional
    }

    println(builder.toString())
}

fun exibirConteudosEducacionaisOpcaoMenu() { //Versão de exibirConteudosEducacionais() para encaminhamento de menuConteudoEducacional()

    if (listaConteudosEducacionais.isEmpty()) exibirListaConteudosEducacionaisVazia()  //Caso a lista de conteúdos educacionais esteja vazia, executar função exibirListaConteudosEducacionaisVazia()

    val builder = StringBuilder() //Usando StringBuilder para construir a string

    for (conteudoEducacional in listaConteudosEducacionais) {
        builder.append(conteudoEducacional.toString())  //Adiciona o toString() de cada conteúdo educacional
        builder.append("\n") //Adicionar uma quebra de linha entre cada conteúdo educacional
    }

    println(builder.toString())

    do { //Repete execução enquanto editarOutroUsuario não receber um valor que não seja nulo, vazio, sem letras ou diferente de "s"

        println("Digite 's' para voltar ao menu de CONTEÚDO EDUCACIONAL")
        val voltarParamenuConteudoEducacional = readlnOrNull() //Recebimento do valor pelo teclado

        when(voltarParamenuConteudoEducacional) {
            "s" -> menuConteudoEducacional() //Segue para função menuConteudoEducacional()
            "n" -> print("")
        }

    } while (voltarParamenuConteudoEducacional.isNullOrEmpty() || !voltarParamenuConteudoEducacional.any { it.isLetter() } || (!voltarParamenuConteudoEducacional.equals("s")))

}