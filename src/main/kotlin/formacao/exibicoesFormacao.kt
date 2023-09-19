package formacao

fun exibirListaFormacoes() { //Impressão de listaFormações -> Exibição enxuta que exclui inscritos e conteúdos das formações

    if (listaFormacoes.isEmpty()) exibirListaFormacoesVazia() //Caso a lista de formações esteja vazia, executar função exibirListaFormacoesVazia()

    val builder = StringBuilder()

    for (formacao in listaFormacoes) {
        builder.append("ID: ${formacao.idFormacao} | NOME: ${formacao.nomeFormacao}\n\t↳ NÍVEL: ${formacao.nivelDificuldadeFormacao} | DURAÇÃO: ${formacao.duracaoFormacao}h")
        builder.append("\n") //Adicionar uma quebra de linha entre cada formação
    }

    println(builder.toString())
}


fun exibirListaFormacoesVazia() { //Exibição em caso de listaFormações estar vazia

    do { //Repete execução enquanto desejaAdicionarFormacaoTeclado não receber um valor que não seja nulo, vazio, sem letras ou diferente de "s" e "n"

        println("Sua lista de formações está vazia. Deseja adicionar uma formação? Digite 's' para sim ou 'n' para não")
        val desejaAdicionarFormacaoTeclado = readlnOrNull() //Recebimento do valor pelo teclado

        if (desejaAdicionarFormacaoTeclado.isNullOrEmpty() || !desejaAdicionarFormacaoTeclado.any { it.isLetter() } || (!desejaAdicionarFormacaoTeclado.equals("s") && !desejaAdicionarFormacaoTeclado.equals("n"))) {
            println("-----Seleção inválida!-----".uppercase())
        } else if (desejaAdicionarFormacaoTeclado == "s") cadastrarFormacao() //Segue para o cadastro de formacao
        else println("Lista de formações vazia")

    } while (desejaAdicionarFormacaoTeclado.isNullOrEmpty() || !desejaAdicionarFormacaoTeclado.any { it.isLetter() } || (!desejaAdicionarFormacaoTeclado.equals("s") && !desejaAdicionarFormacaoTeclado.equals("n")))
}


fun exibirFormacaoDetalhada() { //Exibe detalhadamente uma formação, incluindo inscritos e conteúdos dessa

    println("----- Lista de formações cadastradas -----\n".uppercase())
    exibirListaFormacoes()

    //Variável opcoes recebe os valores de cada id de formação de listaFormacoes
    val opcoes = mutableListOf<String>()
    for (formacao in listaFormacoes) {
        val opcao = formacao.idFormacao
        opcoes.add(opcao.toString())
    }

    var selecaoExibirFormacao : String? //Variável que receberá opção informada por teclado em do/while seguinte

    do { //Repete execução enquanto não recebe um valor correspondente a algum dos valores da variável opcoes

        println("Informe o id da formação acerca da qual quer visualizar mais detalhes:")
        selecaoExibirFormacao = readlnOrNull() //Recebimento do valor pelo teclado

        if (!opcoes.contains(selecaoExibirFormacao)) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        }

    } while (!opcoes.contains(selecaoExibirFormacao))

    val index = selecaoExibirFormacao!!.toInt() - 1
    println(listaFormacoes[index])

    //"Loop" de exibirFormacaoDetalhada()
    do { //Repete execução enquanto excluirOutroUsuario não receber um valor que não seja nulo, vazio, sem letras ou diferente de "s" e "n"

        println("Gostaria de visualizar outra formação com mais detalhes? Digite 's' para sim ou 'n' para não")
        val exibirOutraFormacaoDetalhada = readlnOrNull() //Recebimento do valor pelo teclado

        when(exibirOutraFormacaoDetalhada) {
            "s" -> exibirFormacaoDetalhada() //Repete exibirFormacaoDetalhada()
            "n" -> println("")
        }

        if (exibirOutraFormacaoDetalhada.isNullOrEmpty() || !exibirOutraFormacaoDetalhada.any { it.isLetter() } || (!exibirOutraFormacaoDetalhada.equals("s") && !exibirOutraFormacaoDetalhada.equals("n"))) {
            println("-----Seleção inválida!-----".uppercase())
        } else println("")

    } while (exibirOutraFormacaoDetalhada.isNullOrEmpty() || !exibirOutraFormacaoDetalhada.any { it.isLetter() } || (!exibirOutraFormacaoDetalhada.equals("s") && !exibirOutraFormacaoDetalhada.equals("n")))

}


fun exibirInscritosFormacao(formacaoSelecionada: Formacao) { //Exibição da lista de inscritos de uma formação

    val builder = StringBuilder()

    builder.append("ID: ${formacaoSelecionada.idFormacao} | NOME: ${formacaoSelecionada.nomeFormacao}\n" +
            "\t↳ NÍVEL: ${formacaoSelecionada.nivelDificuldadeFormacao} | DURAÇÃO: ${formacaoSelecionada.duracaoFormacao}h")
    for (usuario in formacaoSelecionada.inscritosFormacao) {
        builder.append(usuario.toString())
        builder.append("\n") //Adicionar uma quebra de linha entre cada usuário inscrito na formação exibido
    }

    println(builder.toString())
}


fun exibirConteudosFormacao(formacaoSelecionada: Formacao) {  //Exibição da lista de conteúdos de uma formação

    val builder = StringBuilder()

    builder.append("ID: ${formacaoSelecionada.idFormacao} | NOME: ${formacaoSelecionada.nomeFormacao}\n" +
            "\t↳ NÍVEL: ${formacaoSelecionada.nivelDificuldadeFormacao} | DURAÇÃO: ${formacaoSelecionada.duracaoFormacao}h")
    for (conteudo in formacaoSelecionada.conteudosFormacao) {
        builder.append(conteudo.toString())
        builder.append("\n") //Adicionar uma quebra de linha entre cada conteúdo cadastrado na formação exibido
    }

    println(builder.toString())
}