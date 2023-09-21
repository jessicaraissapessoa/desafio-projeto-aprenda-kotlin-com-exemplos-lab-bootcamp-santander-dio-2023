package conteudoEducacional

import aplicacao.menuConteudoEducacional

fun excluirConteudoEducacional() { //Função para remover conteúdo educacional

    if (listaConteudosEducacionais.isEmpty()) exibirListaConteudosEducacionaisVazia()  //Caso a lista de conteúdos educacionais esteja vazia, executar função exibirListaConteudosEducacionaisVazia()

    println("----- Lista de conteúdos educacionais cadastrados -----\n".uppercase())
    exibirConteudosEducacionais()

    //Variável opcoes recebe os valores de cada id de conteúdo educacional de listaConteudosEducacionais
    val opcoes = mutableListOf<String>()
    for (conteudoEducacional in listaConteudosEducacionais) {
        val opcao = conteudoEducacional.idConteudoEducacional
        opcoes.add(opcao.toString())
    }

    var selecaoRemocaoConteudoEducacional : String? //Variável que receberá opção informada por teclado em do/while seguinte

    do { //Repete execução enquanto não recebe um valor correspondente a algum dos valores da variável opcoes

        println("Informe o ID do conteúdo educacional que deseja excluir:")
        selecaoRemocaoConteudoEducacional = readlnOrNull() //Recebimento do valor pelo teclado

        if (!opcoes.contains(selecaoRemocaoConteudoEducacional)) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        }

    } while (!opcoes.contains(selecaoRemocaoConteudoEducacional))

    val idConteudoEducacional = selecaoRemocaoConteudoEducacional!!.toInt() //Recebe o valor do id selecionado
    val conteudoSelecionado = listaConteudosEducacionais.find { it.idConteudoEducacional == idConteudoEducacional } //Recebe o conteúdo selecionado

    if (conteudoSelecionado != null) { //Remoção com feedback
        val removido = listaConteudosEducacionais.remove(conteudoSelecionado)

        if (removido) {
            println("Remoção bem sucedida de:\n$conteudoSelecionado!\n")
        } else println("Remoção falhou")
    }

    if (listaConteudosEducacionais.isNotEmpty()) {

        //"Loop" de excluirConteudoEducacional()
        do { //Repete execução enquanto desejaExcluirOutroConteudoEducacional não receber um valor que não seja nulo, vazio, sem letras ou diferente de "s" e "n"

            println("Gostaria de excluir outro conteúdo educacional? Digite 's' para sim ou 'n' para não")
            val desejaExcluirOutroConteudoEducacional = readlnOrNull() //Recebimento do valor pelo teclado

            when(desejaExcluirOutroConteudoEducacional) {
                "s" -> excluirConteudoEducacional() //Segue para função excluirConteudoEducacional()
                "n" -> println("")
            }

            if (desejaExcluirOutroConteudoEducacional.isNullOrEmpty() || !desejaExcluirOutroConteudoEducacional.any { it.isLetter() } || (!desejaExcluirOutroConteudoEducacional.equals("s") && !desejaExcluirOutroConteudoEducacional.equals("n"))) {
                println("-----Seleção inválida!-----".uppercase())
            } else println("")

        } while (desejaExcluirOutroConteudoEducacional.isNullOrEmpty() || !desejaExcluirOutroConteudoEducacional.any { it.isLetter() } || (!desejaExcluirOutroConteudoEducacional.equals("s") && !desejaExcluirOutroConteudoEducacional.equals("n")))

    } else {
        println("Não há mais conteúdos educacionais para remover")
    }

    menuConteudoEducacional()
}