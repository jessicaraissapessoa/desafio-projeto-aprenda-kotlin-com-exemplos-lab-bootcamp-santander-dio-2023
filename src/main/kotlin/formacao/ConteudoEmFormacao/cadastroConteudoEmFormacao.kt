package formacao.ConteudoEmFormacao

import conteudoEducacional.cadastrarConteudoEducacional
import conteudoEducacional.exibirConteudosEducacionais
import conteudoEducacional.exibirListaConteudosEducacionaisVazia
import conteudoEducacional.listaConteudosEducacionais
import formacao.*

fun cadastrarConteudoFormacao() {

    if (listaConteudosEducacionais.isEmpty()) exibirListaConteudosEducacionaisVazia() //Caso a lista de conteúdos educacionais esteja vazia, executar função exibirListaConteudosEducacionaisVazia()
    if (listaFormacoes.isEmpty()) exibirListaFormacoesVazia() //Caso a lista de formações esteja vazia, executar função exibirListaFormacoesVazia()

    println("----- Lista de formações cadastrados -----\n".uppercase())
    exibirListaFormacoes()

    val opcoesFormacao = mutableListOf<String>() //Variável opcoes recebe os valores de cada id de formação de listaFormacoes
    for (formacao in listaFormacoes) {
        val opcao = formacao.idFormacao
        opcoesFormacao.add(opcao.toString())
    }

    var selecaoFormacao : String? //Variável que vai receber escolha de formação dentre as opções acima

    do { //Repete execução enquanto não recebe um valor correspondente a algum dos valores da variável opcoes

        println("Informe o ID da formação na qual deseja cadastrar conteúdo(s) educacional(is):")
        selecaoFormacao = readlnOrNull() //Recebimento do valor do ID da formação selecionada pelo usuário

        if (!opcoesFormacao.contains(selecaoFormacao)) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        }

    } while (!opcoesFormacao.contains(selecaoFormacao))

    val indexFormacao = selecaoFormacao!!.toInt() - 1 //índice da formação na mutableList listaFormacoes
    val formacaoSelecionada = listaFormacoes[indexFormacao] //formaçãoSelecionada recebe a Formacao equivalente de listaFormações

    selecionarConteudosFormacao(formacaoSelecionada) //Passando formação selecionada para selecionarConteudosFormacao()

}


fun selecionarConteudosFormacao(formacaoSelecionada: Formacao) { //Recebe formação selecionada ao final de cadastrarConteudoFormacao()

    if (listaFormacoes.isEmpty()) exibirListaFormacoesVazia() //Caso a lista de formações esteja vazia, executar função exibirListaFormacoesVazia()

    println("----- Lista de conteúdos cadastrados na formação -----\n".uppercase())
    exibirConteudosFormacao(formacaoSelecionada)

    println("----- Lista de conteúdos educacionais no sistema -----\n".uppercase())
    exibirConteudosEducacionais()

    //Se quiser cadastrar conteúdo que não está ainda no sistema
    println("Para adicionar conteúdo(s) educacional(is) novo(s) antes de seguir, digite 'add'. Senão, digite qualquer outra coisa.")
    val addConteudoAntes = readlnOrNull()
    if (addConteudoAntes == "add") {
        cadastrarConteudoEducacional()
        exibirConteudosEducacionais()
    } else println()

    val opcoesConteudo = mutableListOf<String>() //Variável opcoes recebe os valores de cada id de conteúdo educacional de listaConteudosEducacionais
    for (conteudo in listaConteudosEducacionais) {
        val opcao = conteudo.idConteudoEducacional
        opcoesConteudo.add(opcao.toString())
    }

    var selecaoConteudo : String? //Variável que vai receber escolha de conteúdo educacional dentre as opções acima

    do { //Repete execução enquanto não recebe um valor correspondente a algum dos valores da variável opcoes

        println("Informe o ID do conteúdo educacional que deseja cadastrar na formação:")
        selecaoConteudo = readlnOrNull() //Recebimento do valor do ID do conteúdo educacional selecionado

        if (!opcoesConteudo.contains(selecaoConteudo)) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        }

    } while (!opcoesConteudo.contains(selecaoConteudo))

    val indexConteudo = selecaoConteudo!!.toInt() - 1 //índice de ConteudoEducacional na mutableList listaConteudosEducacionais
    val conteudoSelecionado = listaConteudosEducacionais[indexConteudo] //conteudoSelecionado recebe o Usuário equivalente de listaConteudosEducacionais

    //Verificação se o conteúdo já não está cadastrado na formação. Se não estiver cadastrado, é feito cadastro:
    if (formacaoSelecionada.conteudosFormacao.any { it.idConteudoEducacional == conteudoSelecionado.idConteudoEducacional }) {
        println("Inscrição falhou: conteúdo educacional já está cadastrado na formação selecionada")
    } else {

        //Adição do conteúdo à formação:
        formacaoSelecionada.conteudosFormacao.add(listaConteudosEducacionais[indexConteudo])

        //Acrescenta a duração do conteúdo educacional à duração da formação:
        formacaoSelecionada.duracaoFormacao += listaConteudosEducacionais[indexConteudo].duracaoConteudoEducacional

        println("Adição bem sucedida: conteúdo de ID " + listaConteudosEducacionais[indexConteudo].idConteudoEducacional + " cadastrada em formação de ID " + formacaoSelecionada.idFormacao)
    }

    do { //Repete execução enquanto não receber valor válido: "s" ou "n"

        println("Deseja cadastrar outro conteúdo educacional nessa formação? Digite 's' para sim ou 'n' para não")
        val adicionarOutroConteudoFormacao = readlnOrNull()

        if (adicionarOutroConteudoFormacao.isNullOrEmpty() || !adicionarOutroConteudoFormacao.any { it.isLetter() } || (!adicionarOutroConteudoFormacao.equals("s") && !adicionarOutroConteudoFormacao.equals("n"))) {
            println("-----Seleção inválida!-----".uppercase())
        }

        when(adicionarOutroConteudoFormacao) {
            "s" -> selecionarConteudosFormacao(formacaoSelecionada) //"Loop" de selecionarConteudosFormacao() -> Segue cadastrando conteúdos na mesma formação
            "n" -> {
                println("Cadastro de conteúdos educacionais em formação de ID ${formacaoSelecionada.idFormacao} concluída\n")
                println(formacaoSelecionada)

                do { //Repete execução enquanto não receber valor válido: "s" ou "n"

                    println("Deseja cadastrar conteúdos educacionais em outra formação? Digite 's' para sim ou 'n' para não")
                    val adicionarConteudosEmOutraFormacao = readlnOrNull()

                    if (adicionarConteudosEmOutraFormacao.isNullOrEmpty() || !adicionarConteudosEmOutraFormacao.any { it.isLetter() } || (!adicionarConteudosEmOutraFormacao.equals("s") && !adicionarConteudosEmOutraFormacao.equals("n"))) {
                        println("-----Seleção inválida!-----".uppercase())
                    }

                    when (adicionarConteudosEmOutraFormacao) {
                        "s" -> cadastrarConteudoFormacao() //"Loop" de cadastrarConteudoFormacao() -> Segue cadastrando conteúdos, mas em outra formação
                        "n" -> println()
                    }

                } while (adicionarConteudosEmOutraFormacao.isNullOrEmpty() || !adicionarConteudosEmOutraFormacao.any { it.isLetter() } || (!adicionarConteudosEmOutraFormacao.equals("s") && !adicionarConteudosEmOutraFormacao.equals("n")))

            }
        }

    } while (adicionarOutroConteudoFormacao.isNullOrEmpty() || !adicionarOutroConteudoFormacao.any { it.isLetter() } || (!adicionarOutroConteudoFormacao.equals("s") && !adicionarOutroConteudoFormacao.equals("n")))

    //Se deseja remover conteúdos
    do { //Repete execução enquanto não receber valor válido: "s" ou "n"

        println("Deseja remover conteúdos dessa formação? Digite 's' para sim ou 'n' para não")
        val removerConteudoDaFormacao = readlnOrNull()

        if (removerConteudoDaFormacao.isNullOrEmpty() || !removerConteudoDaFormacao.any { it.isLetter() } || (!removerConteudoDaFormacao.equals("s") && !removerConteudoDaFormacao.equals("n"))) {
            println("-----Seleção inválida!-----".uppercase())
        }

        when(removerConteudoDaFormacao) {
            "s" -> excluirConteudosFormacao(formacaoSelecionada) //Direciona para função de remoção de conteúdos da formação
            "n" -> exibirConteudosFormacao(formacaoSelecionada) //Exibe conteúdos da formação
        }

    } while (removerConteudoDaFormacao.isNullOrEmpty() || !removerConteudoDaFormacao.any { it.isLetter() } || (!removerConteudoDaFormacao.equals("s") && !removerConteudoDaFormacao.equals("n")))

}