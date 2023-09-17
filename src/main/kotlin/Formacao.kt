data class Formacao(var idFormacao: Int, var nomeFormacao: String) {

    constructor() : this(0, "")

    var inscritosFormacao = mutableListOf<Usuario>()
    var conteudosFormacao = mutableListOf<ConteudoEducacional>()
    var dificuldadeFormacao : String = ""
    var duracaoFormacao : String? = ""

    override fun toString(): String {
        return "ID: $idFormacao | NOME: $nomeFormacao | NÍVEL: $dificuldadeFormacao | DURAÇÃO: $duracaoFormacao" + "h\n\n" +
                "LISTA DE CONTEÚDOS:\n$conteudosFormacao\n\n" +
                "LISTA DE INSCRITOS:\n$inscritosFormacao"
    }

}

var listaFormacoes : MutableList<Formacao> = mutableListOf()


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


fun cadastrarFormacao() {

    println("nome formação:")
    val nome = readln()

    val id = listaFormacoes.count() + 1

    val novaFormacao = Formacao()

    novaFormacao.idFormacao = id
    novaFormacao.nomeFormacao = nome

    if (listaFormacoes.add(novaFormacao)) {
        println("Formação adicionada: $novaFormacao")
    }

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

