data class Formacao(var idFormacao: Int, var nomeFormacao: String, var nivelDificuldadeFormacao: String, var duracaoFormacao: Int) { //Classe Formacao

    val inscritosFormacao = mutableListOf<Usuario>()
    val conteudosFormacao = mutableListOf<ConteudoEducacional>()

    constructor() : this(0, "", "", 0) //Construtor vazio da classe

    override fun toString(): String { //Customização da exibição do
        return "ID: $idFormacao | NOME: $nomeFormacao | NÍVEL: $nivelDificuldadeFormacao | DURAÇÃO: $duracaoFormacao" +
                "\n\t↳" //TODO: mostrar n de inscritos e de conteúdos
    }

}

var listaFormacoes : MutableList<Formacao> = mutableListOf() //Lista de formações


fun exibirListaFormacoesVazia() {

    do { //Repete execução enquanto desejaAdicionarFormacaoTeclado não receber um valor que não seja nulo, vazio, sem letras ou diferente de "s" e "n"

        println("Sua lista de formações está vazia. Deseja adicionar uma formação? Digite 's' para sim ou 'n' para não")
        val desejaAdicionarFormacaoTeclado = readlnOrNull() //Recebimento do valor pelo teclado

        if (desejaAdicionarFormacaoTeclado.isNullOrEmpty() || !desejaAdicionarFormacaoTeclado.any { it.isLetter() } || (!desejaAdicionarFormacaoTeclado.equals("s") && !desejaAdicionarFormacaoTeclado.equals("n"))) {
            println("-----Seleção inválida!-----".uppercase())
        } else if (desejaAdicionarFormacaoTeclado == "s") cadastrarFormacao() //Segue para o cadastro de formacao
        else println("Lista de formações vazia")

    } while (desejaAdicionarFormacaoTeclado.isNullOrEmpty() || !desejaAdicionarFormacaoTeclado.any { it.isLetter() } || (!desejaAdicionarFormacaoTeclado.equals("s") && !desejaAdicionarFormacaoTeclado.equals("n")))
}


fun toStringFormacoes() : String {

    if (listaFormacoes.isEmpty()) exibirListaFormacoesVazia() //Caso a lista de formações esteja vazia, executar função exibirListaFormacoesVazia()

    val builder = StringBuilder()

    for (formacao in listaFormacoes) {
        builder.append(formacao.toString()) //Adiciona o toString() de cada formação
        builder.append("\n") //Adicionar uma quebra de linha entre cada formação
    }

    return builder.toString()
}


fun exibirFormacoes() : String {
    return toStringFormacoes() //Impressão do toString da lista
}


fun cadastrarFormacao() {

    //"ID: $idFormacao | NOME: $nomeFormacao | NÍVEL: $nivelDificuldadeFormacao | DURAÇÃO: $duracaoFormacao"

    var tecladoNomeFormacao : String? //Variável de nome da formação que será recebido
    var tecladoRelacionarConteudosEducacionais : String? //Variável de seleção para opções sobre conteúdos educacionais na formação

    do { //Repete execução enquanto tecladoNomeFormacao não receber um valor que não seja nulo, vazio, sem letras ou com números
        println("Insira título da formação:")
        tecladoNomeFormacao = readlnOrNull() //Recebimento do valor pelo teclado

        if (tecladoNomeFormacao.isNullOrEmpty() || !tecladoNomeFormacao.any { it.isLetter() } || tecladoNomeFormacao.any { it.isDigit() }) {
            println("-----Nome inválido!-----".uppercase())
        }
    } while (tecladoNomeFormacao.isNullOrEmpty() || !tecladoNomeFormacao.any { it.isLetter() }|| tecladoNomeFormacao.any { it.isDigit() })

    do { //Repete execução enquanto não recebe 1 ou 2 ou 3

        println("Selecione entre as opções informando o número correspondente:" +
                "\n1 - Selecionar conteúdos educacionais para a formação dentre os já cadastrados" +
                "\n2 - Cadastrar novos conteúdos educacionais para essa formação" +
                "\n3 - Cadastrar formação sem conteúdos educacionais")
        tecladoRelacionarConteudosEducacionais = readlnOrNull() //Recebimento do valor pelo teclado

        when (tecladoRelacionarConteudosEducacionais) {
            "1" -> {
                //TODO
            }
            "2" -> {
                //TODO
            }
            "3" -> println()
        }

        if (tecladoRelacionarConteudosEducacionais.isNullOrEmpty() || (!tecladoRelacionarConteudosEducacionais.equals("1") && !tecladoRelacionarConteudosEducacionais.equals("2")  && !tecladoRelacionarConteudosEducacionais.equals("3"))) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        }

    } while (tecladoRelacionarConteudosEducacionais.isNullOrEmpty() || (!tecladoRelacionarConteudosEducacionais.equals("1") && !tecladoRelacionarConteudosEducacionais.equals("2")  && !tecladoRelacionarConteudosEducacionais.equals("3")))


    TODO("dificuldade")

    TODO("duracao")

    var novaFormacao = Formacao() //Instância de Formacao

    val id = listaFormacoes.count() + 1 //id = quantidade de formações já inseridos em listaFormacoes + 1
    novaFormacao.idFormacao = id //idFormacao da instância de Formacao (novaFormacao) = id

    novaFormacao.nomeFormacao = tecladoNomeFormacao //nomeFormacao da instância de Formacao (novaFormacao) = tecladoNomeFormacao

    TODO("Recebimento das outras variáveis")

}


fun excluirFormacao() { //Função para remover formação

    if (listaFormacoes.isEmpty()) exibirListaFormacoesVazia() //Caso a lista de formações esteja vazia, executar função exibirListaFormacoesVazia()

    println("----- Lista de formações cadastradas -----\n".uppercase()  + exibirFormacoes())

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

    val conteudoEducacionalRemovido = listaFormacoes.removeAt(index = (selecaoRemocaoFormacao?.toInt()!! - 1)) //Remoção da formação

    println("Remoção de formação bem sucedida:\n$conteudoEducacionalRemovido\n") //Mensagem de feedback da remoção

    if (listaFormacoes.isNotEmpty()) {

        //"Loop" de excluirFormacao()
        do { //Repete execução enquanto desejaExcluirOutraFormacao não receber um valor que não seja nulo, vazio, sem letras ou diferente de "s" e "n"

            println("Gostaria de excluir outra formação? Digite 's' para sim ou 'n' para não")
            val desejaExcluirOutraFormacao = readlnOrNull() //Recebimento do valor pelo teclado

            when(desejaExcluirOutraFormacao) {
                "s" -> excluirFormacao() //Segue para função excluirConteudoEducacional()
                "n" -> println("")
            }

            if (desejaExcluirOutraFormacao.isNullOrEmpty() || !desejaExcluirOutraFormacao.any { it.isLetter() } || (!desejaExcluirOutraFormacao.equals("s") && !desejaExcluirOutraFormacao.equals("n"))) {
                println("-----Seleção inválida!-----".uppercase())
            } else println("")

        } while (desejaExcluirOutraFormacao.isNullOrEmpty() || !desejaExcluirOutraFormacao.any { it.isLetter() } || (!desejaExcluirOutraFormacao.equals("s") && !desejaExcluirOutraFormacao.equals("n")))

    }

}