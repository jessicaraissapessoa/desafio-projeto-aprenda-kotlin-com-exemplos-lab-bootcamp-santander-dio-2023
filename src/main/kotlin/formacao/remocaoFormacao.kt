package formacao

import aplicacao.menuFormacao
import conteudoEducacional.listaConteudosEducacionais

fun excluirFormacao() { //Função para remover formação

    if (listaFormacoes.isEmpty()) exibirListaFormacoesVazia() //Caso a lista de formações esteja vazia, executar função exibirListaFormacoesVazia()

    println("----- Lista de formações cadastradas -----\n".uppercase())
    exibirListaFormacoes()

    //Variável opcoes recebe os valores de cada id de formação de listaFormacoes
    val opcoes = mutableListOf<String>()
    for (formacoes in listaFormacoes) {
        val opcao = formacoes.idFormacao
        opcoes.add(opcao.toString())
    }

    var selecaoRemocaoFormacao : String? //Variável que receberá opção informada por teclado em do/while seguinte

    do { //Repete execução enquanto não recebe um valor correspondente a algum dos valores da variável opcoes

        println("Informe o ID da formação que deseja excluir:")
        selecaoRemocaoFormacao = readlnOrNull() //Recebimento do valor pelo teclado

        if (!opcoes.contains(selecaoRemocaoFormacao)) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        }

    } while (!opcoes.contains(selecaoRemocaoFormacao))

    val idFormacao = selecaoRemocaoFormacao!!.toInt() //índice de Formacao na mutableList listaFormacoes
    val formacaoSelecionada = listaFormacoes.find { it.idFormacao == idFormacao } //formacaoSelecionada recebe a Formacao equivalente de listaFormacoes

    if (formacaoSelecionada != null) { //Remoção com feedback
        val removido = listaFormacoes.remove(formacaoSelecionada)  //Remoção da formação

        if (removido) {  //Mensagem de feedback da remoção
            println("Remoção bem sucedida de:\n$formacaoSelecionada\n")
        } else println("Remoção falhou")
    }

    if (listaFormacoes.isNotEmpty()) {

        //"Loop" de excluirFormacao()
        do { //Repete execução enquanto desejaExcluirOutraFormacao não receber um valor que não seja nulo, vazio, sem letras ou diferente de "s" e "n"

            println("Gostaria de excluir outra formação? Digite 's' para sim ou 'n' para não")
            val desejaExcluirOutraFormacao = readlnOrNull() //Recebimento do valor pelo teclado

            when(desejaExcluirOutraFormacao) {
                "s" -> excluirFormacao() //Segue para função excluirConteudoEducacional()
                "n" -> menuFormacao()
            }

            if (desejaExcluirOutraFormacao.isNullOrEmpty() || !desejaExcluirOutraFormacao.any { it.isLetter() } || (!desejaExcluirOutraFormacao.equals("s") && !desejaExcluirOutraFormacao.equals("n"))) {
                println("-----Seleção inválida!-----".uppercase())
            }

        } while (desejaExcluirOutraFormacao.isNullOrEmpty() || !desejaExcluirOutraFormacao.any { it.isLetter() } || (!desejaExcluirOutraFormacao.equals("s") && !desejaExcluirOutraFormacao.equals("n")))

    }

    menuFormacao()

}