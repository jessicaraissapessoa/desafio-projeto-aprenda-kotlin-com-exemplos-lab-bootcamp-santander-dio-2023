package formacao.ConteudoEmFormacao

import conteudoEducacional.exibirListaConteudosEducacionaisVazia
import conteudoEducacional.listaConteudosEducacionais
import formacao.Formacao
import formacao.exibirConteudosFormacao
import formacao.exibirInscritosFormacao

fun excluirConteudosFormacao(formacaoSelecionada: Formacao) {

    if (listaConteudosEducacionais.isEmpty()) exibirListaConteudosEducacionaisVazia() //Caso a lista de conteúdos educacionais esteja vazia, executar função exibirListaConteudosEducacionaisVazia()

    println("ID: ${formacaoSelecionada.idFormacao} | NOME: ${formacaoSelecionada.nomeFormacao}\n\t↳ NÍVEL: ${formacaoSelecionada.nivelDificuldadeFormacao}\n")
    exibirInscritosFormacao(formacaoSelecionada)

    val opcoesConteudo = mutableListOf<String>() //Variável opcoes recebe os valores de cada id de conteúdo cadastrado na formação
    for (conteudo in formacaoSelecionada.conteudosFormacao) {
        val opcao = conteudo.idConteudoEducacional
        opcoesConteudo.add(opcao.toString())
    }

    var selecaoRemocaoConteudoFormacao : String? //Variável que vai receber escolha de conteúdo dentre as opções acima

    if (formacaoSelecionada.conteudosFormacao.isEmpty()) println("Não há conteúdos para excluir da formação.")
    else {
        do { //Repete execução enquanto não recebe um valor correspondente a algum dos valores da variável opcoesConteudo

            println("Informe o ID do conteúdo educacional que deseja remover da formação:")
            selecaoRemocaoConteudoFormacao = readlnOrNull() //Recebimento do valor do ID do conteúdo selecionado

            if (!opcoesConteudo.contains(selecaoRemocaoConteudoFormacao)) {
                println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
            }

        } while (!opcoesConteudo.contains(selecaoRemocaoConteudoFormacao))

        val indexConteudo = selecaoRemocaoConteudoFormacao!!.toInt() - 1 //índice de Conteudo na mutableList listaConteudosEducacionais
        val conteudoSelecionado = listaConteudosEducacionais[indexConteudo] //usuarioSelecionado recebe o Conteudo equivalente de listaConteudosEducacionais

        if (formacaoSelecionada.conteudosFormacao.remove(conteudoSelecionado)) {
            println("Remoção bem sucedida de:\n$conteudoSelecionado!\n")
            println("ID: ${formacaoSelecionada.idFormacao} | NOME: ${formacaoSelecionada.nomeFormacao}\n\t↳ NÍVEL: ${formacaoSelecionada.nivelDificuldadeFormacao}\n")
            exibirConteudosFormacao(formacaoSelecionada)
        } else println("Remoção falhou")

        do { //Repete execução enquanto não receber valor válido: "s" ou "n"

            println("Deseja remover outro conteúdo educacional dessa formação? Digite 's' para sim ou 'n' para não")
            val excluirOutroConteudoFormacao = readlnOrNull()

            if (excluirOutroConteudoFormacao.isNullOrEmpty() || !excluirOutroConteudoFormacao.any { it.isLetter() } || (!excluirOutroConteudoFormacao.equals("s") && !excluirOutroConteudoFormacao.equals("n"))) {
                println("-----Seleção inválida!-----".uppercase())
            }

            when(excluirOutroConteudoFormacao) {
                "s" -> excluirConteudosFormacao(formacaoSelecionada) //"Loop" de excluirConteudosFormacao() -> Segue excluindo conteúdos na mesma formação
                "n" -> exibirConteudosFormacao(formacaoSelecionada)
            }

        } while (excluirOutroConteudoFormacao.isNullOrEmpty() || !excluirOutroConteudoFormacao.any { it.isLetter() } || (!excluirOutroConteudoFormacao.equals("s") && !excluirOutroConteudoFormacao.equals("n")))

    }

    do { //Repete execução enquanto não receber valor válido: "s" ou "n"

        println("Deseja adicionar conteúdos nessa formação? Digite 's' para sim ou 'n' para não")
        val adicionarConteudoFormacao = readlnOrNull()

        if (adicionarConteudoFormacao.isNullOrEmpty() || !adicionarConteudoFormacao.any { it.isLetter() } || (!adicionarConteudoFormacao.equals("s") && !adicionarConteudoFormacao.equals("n"))) {
            println("-----Seleção inválida!-----".uppercase())
        }

        when(adicionarConteudoFormacao) {
            "s" -> selecionarConteudosFormacao(formacaoSelecionada) //Direciona para função que adiciona conteúdos
            "n" -> exibirConteudosFormacao(formacaoSelecionada)
        }

    } while (adicionarConteudoFormacao.isNullOrEmpty() || !adicionarConteudoFormacao.any { it.isLetter() } || (!adicionarConteudoFormacao.equals("s") && !adicionarConteudoFormacao.equals("n")))

}