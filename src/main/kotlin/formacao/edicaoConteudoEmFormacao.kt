package formacao

import aplicacao.menuFormacao
import conteudoEducacional.cadastrarConteudoEducacional
import conteudoEducacional.exibirConteudosEducacionais
import conteudoEducacional.exibirListaConteudosEducacionaisVazia
import conteudoEducacional.listaConteudosEducacionais

fun editarConteudosFormacao() {

    if (listaConteudosEducacionais.isEmpty()) exibirListaConteudosEducacionaisVazia()  //Caso a lista de conteúdos educacionais esteja vazia, executar função exibirListaConteudosEducacionaisVazia()
    if (listaFormacoes.isEmpty()) exibirListaFormacoesVazia() //Caso a lista de formações esteja vazia, executar função exibirListaFormacoesVazia()

    do { //Repete execução enquanto não receber 1, 2 ou 3

        println("----------------------------------------------------------------------------------------" +
                "\nSelecione a edição que deseja fazer informando número correspondente:" +
                "\n1 - Adicionar conteúdo(s) educacional(is) à uma formação" +
                "\n2 - Remover conteúdo(s) educacional(is) de uma formação" +
                "\n3 - Voltar" +
                "\n----------------------------------------------------------------------------------------")
        val opcao = readlnOrNull()

        when (opcao) {
            "1" -> adicionarConteudoFormacao()
            "2" -> excluirConteudoFormacao()
            "3" -> menuFormacao()
        }

        if (opcao.isNullOrEmpty() || (!opcao.equals("1") && !opcao.equals("2")  && !opcao.equals("3"))) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        }

    } while (opcao.isNullOrEmpty() || (!opcao.equals("1") && !opcao.equals("2") && !opcao.equals("3")))

}


fun adicionarConteudoFormacao() {

    if (listaConteudosEducacionais.isEmpty()) exibirListaConteudosEducacionaisVazia()  //Caso a lista de conteúdos educacionais esteja vazia, executar função exibirListaConteudosEducacionaisVazia()
    if (listaFormacoes.isEmpty()) exibirListaFormacoesVazia() //Caso a lista de formações esteja vazia, executar função exibirListaFormacoesVazia()

    exibirListaFormacoes()

    do { //Repete execução enquanto não receber valor válido: "s" ou "n"

        println("Deseja visualizar detalhes de alguma formação antes de seguir? Digite 's' para sim ou 'n' para não.")
        val visualizarDetalhes = readlnOrNull()

        if (visualizarDetalhes.isNullOrEmpty() || !visualizarDetalhes.any { it.isLetter() } || (!visualizarDetalhes.equals("s") && !visualizarDetalhes.equals("n"))) {
            println("-----Seleção inválida!-----".uppercase())
        }

        when(visualizarDetalhes) {
            "s" -> exibirFormacaoDetalhada()
            "n" -> println()
        }

    } while (visualizarDetalhes.isNullOrEmpty() || !visualizarDetalhes.any { it.isLetter() } || (!visualizarDetalhes.equals("s") && !visualizarDetalhes.equals("n")))

    val opcoesFormacao = mutableListOf<String>() //Variável opcoes recebe os valores de cada id de formação de listaFormacoes
    for (formacao in listaFormacoes) {
        val opcao = formacao.idFormacao
        opcoesFormacao.add(opcao.toString())
    }

    var selecaoFormacao : String? //Variável que vai receber escolha de formação dentre as opções acima

    do { //Repete execução enquanto não recebe um valor correspondente a algum dos valores da variável opcoes

        println("Informe o ID da formação na qual deseja adicionar conteúdo(s) educacional(is):")
        selecaoFormacao = readlnOrNull() //Recebimento do valor do ID da formação selecionada pelo usuário

        if (!opcoesFormacao.contains(selecaoFormacao)) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        }

    } while (!opcoesFormacao.contains(selecaoFormacao))

    val idFormacao = selecaoFormacao!!.toInt() //índice de Formacao na mutableList listaFormacoes
    val formacaoSelecionada = listaFormacoes.find { it.idFormacao == idFormacao } //formacaoSelecionada recebe a Formacao equivalente de listaFormacoes

    if (formacaoSelecionada != null) {
        adicionarConteudoFormacaoSelecionada(formacaoSelecionada)
    }
}

fun adicionarConteudoFormacaoSelecionada(formacaoSelecionada: Formacao) {

    println("ID: ${formacaoSelecionada.idFormacao} | NOME: ${formacaoSelecionada.nomeFormacao}\n\t↳ NÍVEL: ${formacaoSelecionada.nivelDificuldadeFormacao}\n")

    println("----- Lista de conteúdos educacionais cadastrados na formação -----\n".uppercase())
    exibirConteudosFormacao(formacaoSelecionada)

    println("\n----- Lista de conteúdos educacionais no sistema -----\n".uppercase())
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

    val idConteudo = selecaoConteudo!!.toInt() //índice de Conteudo na mutableList listaConteudo
    val conteudoSelecionado = listaConteudosEducacionais.find { it.idConteudoEducacional == idConteudo } //conteudoSelecionado recebe o Conteudo equivalente de listaConteudo

    //Verificação se o conteúdo já não está cadastrado na formação. Se não estiver cadastrado, é feito cadastro:
    if (formacaoSelecionada.conteudosFormacao.any { it.idConteudoEducacional == conteudoSelecionado!!.idConteudoEducacional }) {
        println("Inscrição falhou: conteúdo educacional já está cadastrado na formação selecionada")
    } else {

        //Adição do conteúdo à formação:
        formacaoSelecionada.conteudosFormacao.add(conteudoSelecionado!!)

        //Acrescenta a duração do conteúdo educacional à duração da formação:
        formacaoSelecionada.duracaoFormacao += conteudoSelecionado.duracaoConteudoEducacional

        println("Adição bem sucedida: conteúdo de ID " + conteudoSelecionado.idConteudoEducacional + " cadastrada em formação de ID " + formacaoSelecionada.idFormacao)
        println(formacaoSelecionada)
    }

    do { //Repete execução enquanto não receber valor válido: "s" ou "n"

        println("Deseja cadastrar outro conteúdo educacional nessa formação? Digite 's' para sim ou 'n' para não")
        val adicionarOutroConteudoFormacao = readlnOrNull()

        if (adicionarOutroConteudoFormacao.isNullOrEmpty() || !adicionarOutroConteudoFormacao.any { it.isLetter() } || (!adicionarOutroConteudoFormacao.equals("s") && !adicionarOutroConteudoFormacao.equals("n"))) {
            println("-----Seleção inválida!-----".uppercase())
        }

        when(adicionarOutroConteudoFormacao) {
            "s" -> adicionarConteudoFormacaoSelecionada(formacaoSelecionada) //"Loop" de adicionarConteudoFormacaoSelecionada() -> Segue cadastrando conteúdos na mesma formação
            "n" -> {
                println("Cadastro de conteúdos educacionais em formação de ID ${formacaoSelecionada.idFormacao} concluída\n")
                println(formacaoSelecionada)
            }
        }

    } while (adicionarOutroConteudoFormacao.isNullOrEmpty() || !adicionarOutroConteudoFormacao.any { it.isLetter() } || (!adicionarOutroConteudoFormacao.equals("s") && !adicionarOutroConteudoFormacao.equals("n")))

    menuFormacao()
}


fun excluirConteudoFormacao() {

    if (listaConteudosEducacionais.isEmpty()) exibirListaConteudosEducacionaisVazia()  //Caso a lista de conteúdos educacionais esteja vazia, executar função exibirListaConteudosEducacionaisVazia()
    if (listaFormacoes.isEmpty()) exibirListaFormacoesVazia() //Caso a lista de formações esteja vazia, executar função exibirListaFormacoesVazia()

    exibirListaFormacoes()

    do { //Repete execução enquanto não receber valor válido: "s" ou "n"

        println("Deseja visualizar detalhes de alguma formação antes de seguir? Digite 's' para sim ou 'n' para não.")
        val visualizarDetalhes = readlnOrNull()

        if (visualizarDetalhes.isNullOrEmpty() || !visualizarDetalhes.any { it.isLetter() } || (!visualizarDetalhes.equals("s") && !visualizarDetalhes.equals("n"))) {
            println("-----Seleção inválida!-----".uppercase())
        }

        when(visualizarDetalhes) {
            "s" -> exibirFormacaoDetalhada()
            "n" -> println()
        }

    } while (visualizarDetalhes.isNullOrEmpty() || !visualizarDetalhes.any { it.isLetter() } || (!visualizarDetalhes.equals("s") && !visualizarDetalhes.equals("n")))

    val opcoesFormacao = mutableListOf<String>() //Variável opcoes recebe os valores de cada id de formação de listaFormacoes
    for (formacao in listaFormacoes) {
        val opcao = formacao.idFormacao
        opcoesFormacao.add(opcao.toString())
    }

    var selecaoFormacao : String? //Variável que vai receber escolha de formação dentre as opções acima

    do { //Repete execução enquanto não recebe um valor correspondente a algum dos valores da variável opcoes

        println("Informe o ID da formação da qual deseja remover conteúdo(s) educacional(is):")
        selecaoFormacao = readlnOrNull() //Recebimento do valor do ID da formação selecionada pelo usuário

        if (!opcoesFormacao.contains(selecaoFormacao)) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        }

    } while (!opcoesFormacao.contains(selecaoFormacao))

    val idFormacao = selecaoFormacao!!.toInt() //índice de Formacao na mutableList listaFormacoes
    val formacaoSelecionada = listaFormacoes.find { it.idFormacao == idFormacao } //formacaoSelecionada recebe a Formacao equivalente de listaFormacoes

    if (formacaoSelecionada != null) {
        excluirConteudoFormacaoSelecionada(formacaoSelecionada)
    }
}


fun excluirConteudoFormacaoSelecionada(formacaoSelecionada: Formacao) {

    if (formacaoSelecionada.conteudosFormacao.isEmpty()) {
        println("Não há conteúdos educacionais para excluir da formação.")
        menuFormacao()
    } else {

        println("ID: ${formacaoSelecionada.idFormacao} | NOME: ${formacaoSelecionada.nomeFormacao}\n\t↳ NÍVEL: ${formacaoSelecionada.nivelDificuldadeFormacao}\n")

        println("----- Lista de conteúdos educacionais cadastrados na formação -----\n".uppercase())
        exibirConteudosFormacao(formacaoSelecionada)

        val opcoesConteudo = mutableListOf<String>() //Variável opcoes recebe os valores de cada id de conteúdo educacional de listaConteudosEducacionais
        for (conteudo in listaConteudosEducacionais) {
            val opcao = conteudo.idConteudoEducacional
            opcoesConteudo.add(opcao.toString())
        }

        var selecaoConteudo : String? //Variável que vai receber escolha de conteúdo educacional dentre as opções acima

        do { //Repete execução enquanto não recebe um valor correspondente a algum dos valores da variável opcoes

            println("Informe o ID do conteúdo educacional que deseja remover da formação:")
            selecaoConteudo = readlnOrNull() //Recebimento do valor do ID do conteúdo educacional selecionado

            if (!opcoesConteudo.contains(selecaoConteudo)) {
                println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
            }

        } while (!opcoesConteudo.contains(selecaoConteudo))

        val idConteudo = selecaoConteudo!!.toInt() //índice de Conteudo na mutableList listaConteudo
        val conteudoSelecionado = listaConteudosEducacionais.find { it.idConteudoEducacional == idConteudo } //conteudoSelecionado recebe o Conteudo equivalente de listaConteudo

        //Remoção do conteúdo da formação:
        formacaoSelecionada.conteudosFormacao.remove(conteudoSelecionado!!)

        //Decrementa tempo do conteúdo educacional removido da duração da formação:
        formacaoSelecionada.duracaoFormacao -= conteudoSelecionado.duracaoConteudoEducacional

        println("Remoção bem sucedida: conteúdo de ID " + conteudoSelecionado.idConteudoEducacional + " da formação de ID " + formacaoSelecionada.idFormacao)
        println(formacaoSelecionada)

        do { //Repete execução enquanto não receber valor válido: "s" ou "n"

            println("Deseja remover outro conteúdo educacional dessa formação? Digite 's' para sim ou 'n' para não")
            val excluirOutroConteudoFormacao = readlnOrNull()

            if (excluirOutroConteudoFormacao.isNullOrEmpty() || !excluirOutroConteudoFormacao.any { it.isLetter() } || (!excluirOutroConteudoFormacao.equals("s") && !excluirOutroConteudoFormacao.equals("n"))) {
                println("-----Seleção inválida!-----".uppercase())
            }

            when(excluirOutroConteudoFormacao) {
                "s" -> excluirConteudoFormacaoSelecionada(formacaoSelecionada) //"Loop" de excluirConteudosFormacao() -> Segue excluindo conteúdos na mesma formação
                "n" -> {
                    println("Remoção de conteúdos educacionais em formação de ID ${formacaoSelecionada.idFormacao} concluída\n")
                    println(formacaoSelecionada)
                }
            }

        } while (excluirOutroConteudoFormacao.isNullOrEmpty() || !excluirOutroConteudoFormacao.any { it.isLetter() } || (!excluirOutroConteudoFormacao.equals("s") && !excluirOutroConteudoFormacao.equals("n")))

        menuFormacao()
    }
}