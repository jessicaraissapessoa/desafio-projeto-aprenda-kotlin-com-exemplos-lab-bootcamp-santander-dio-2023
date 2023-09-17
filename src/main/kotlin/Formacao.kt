data class Formacao(var idFormacao: Int, var nomeFormacao: String, var dificuldadeFormacao : String) {

    constructor() : this(0, "", "")

    var inscritosFormacao = mutableListOf<Usuario>()
    var conteudosFormacao = mutableListOf<ConteudoEducacional>()
    var duracaoFormacao : Int = 1

    override fun toString(): String { //Customização da exibição da formação pelo método toString()

        val builder = StringBuilder()


        builder.append("--------------------------------------------------\n")
        builder.append("ID: $idFormacao | NOME: $nomeFormacao\n↳ NÍVEL: $dificuldadeFormacao | DURAÇÃO: $duracaoFormacao")
        builder.append("\n")
        builder.append("\nLISTA DE CONTEÚDOS:\n")
        conteudosFormacao.forEach { conteudoEducacional -> builder.append("\t$conteudoEducacional\n") }
        builder.append("\nLISTA DE INSCRITOS:\n")
        inscritosFormacao.forEach { usuario -> builder.append("\t$usuario\n") }
        builder.append("--------------------------------------------------")


        return builder.toString()
    }

}

var listaFormacoes : MutableList<Formacao> = mutableListOf()


fun exibirListaFormacoes() { //Impressão de listaFormações

    if (listaFormacoes.isEmpty()) exibirListaFormacoesVazia() //Caso a lista de formações esteja vazia, executar função exibirListaFormacoesVazia()

    val builder = StringBuilder()

    for (formacao in listaFormacoes) {
        builder.append("ID: ${formacao.idFormacao} | NOME: ${formacao.nomeFormacao}\n\t↳ NÍVEL: ${formacao.dificuldadeFormacao} | DURAÇÃO: ${formacao.duracaoFormacao}")
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


fun cadastrarFormacao() {

    var tecladoNomeFormacao : String? //Variável de nome da formação que será recebido

    var tecladoNivelDificuldadeFormacao : String? //Variável de seleção para opções na definição do nível de dificuldade que será recebida
    var selecaoNivelDificuldadeFormacao : String //Variável de nivelDificuldade que será definido

    do { //Repete execução enquanto tecladoNomeFormacao não receber um valor que não seja nulo, vazio, sem letras ou com números
        println("Insira título da formação:")
        tecladoNomeFormacao = readlnOrNull() //Recebimento do valor pelo teclado

        if (tecladoNomeFormacao.isNullOrEmpty() || !tecladoNomeFormacao.any { it.isLetter() } || tecladoNomeFormacao.any { it.isDigit() }) {
            println("-----Nome inválido!-----".uppercase())
        }
    } while (tecladoNomeFormacao.isNullOrEmpty() || !tecladoNomeFormacao.any { it.isLetter() }|| tecladoNomeFormacao.any { it.isDigit() })

    do { //Repete execução enquanto não recebe 1 ou 2 ou 3
        println("Selecione o nível de dificuldade da formação informando o número correspondente:" +
                "\n1 - Básico\n2 - Intermediário\n3 - Avançado")
        tecladoNivelDificuldadeFormacao = readlnOrNull() //Recebe escolha do usuário entre as opções
        selecaoNivelDificuldadeFormacao = tecladoNivelDificuldadeFormacao.toString() //recebe o valor de tecladoNivelDificuldadeFormacao

        when (tecladoNivelDificuldadeFormacao) {
            "1" -> selecaoNivelDificuldadeFormacao = NivelDificuldade.BASICO.toString() //muda o valor de selecaoNivelDificuldadeFormacaoselecaoNivelDificuldadeFormacao para o valor do enum NivelDificuldade
            "2" -> selecaoNivelDificuldadeFormacao = NivelDificuldade.INTERMEDIARIO.toString() //muda o valor de selecaoNivelDificuldadeFormacao para o valor do enum NivelDificuldade
            "3" -> selecaoNivelDificuldadeFormacao = NivelDificuldade.AVANCADO.toString() //muda o valor de selecaoNivelDificuldadeFormacao para o valor do enum NivelDificuldade
        }

        if (tecladoNivelDificuldadeFormacao.isNullOrEmpty() || (!tecladoNivelDificuldadeFormacao.equals("1") && !tecladoNivelDificuldadeFormacao.equals("2")  && !tecladoNivelDificuldadeFormacao.equals("3"))) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        }

    } while (tecladoNivelDificuldadeFormacao.isNullOrEmpty() || (!tecladoNivelDificuldadeFormacao.equals("1") && !tecladoNivelDificuldadeFormacao.equals("2") && !tecladoNivelDificuldadeFormacao.equals("3")))

    val id = listaFormacoes.count() + 1

    val novaFormacao = Formacao()

    novaFormacao.idFormacao = id
    novaFormacao.nomeFormacao = tecladoNomeFormacao
    novaFormacao.dificuldadeFormacao = selecaoNivelDificuldadeFormacao

    if (listaFormacoes.add(novaFormacao)) {
        println("ADIÇÃO DE FORMAÇÃO BEM SUCEDIDA!\n" + listaFormacoes[id - 1])
    }

    //"Loop" de cadastrarFormacao()
    do { //Repete execução enquanto desejaAdicionarOutraFormacao não receber um valor que não seja nulo, vazio, sem letras ou diferente de "s" e "n"

        println("Gostaria de cadastrar outra formação? Digite 's' para sim ou 'n' para não")
        val desejaAdicionarOutraFormacao = readlnOrNull() //Recebimento do valor pelo teclado

        when(desejaAdicionarOutraFormacao) {
            "s" -> cadastrarFormacao() //Segue para função cadastrarFormacao()
            "n" -> println("")
        }

        if (desejaAdicionarOutraFormacao.isNullOrEmpty() || !desejaAdicionarOutraFormacao.any { it.isLetter() } || (!desejaAdicionarOutraFormacao.equals("s") && !desejaAdicionarOutraFormacao.equals("n"))) {
            println("-----Seleção inválida!-----".uppercase())
        } else println("")

    } while (desejaAdicionarOutraFormacao.isNullOrEmpty() || !desejaAdicionarOutraFormacao.any { it.isLetter() } || (!desejaAdicionarOutraFormacao.equals("s") && !desejaAdicionarOutraFormacao.equals("n")))

}


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

    val formacaoRemovida = listaFormacoes.removeAt(index = (selecaoRemocaoFormacao?.toInt()!! - 1)) //Remoção da formação

    println("Remoção de formação bem sucedida:\n$formacaoRemovida\n") //Mensagem de feedback da remoção

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


fun cadastrarUsuarioFormacao() {

    if (listaUsuarios.isEmpty()) exibirListaUsuariosVazia() //Caso a lista de usuários esteja vazia, executar função exibirListaUsuariosVazia()
    if (listaFormacoes.isEmpty()) exibirListaFormacoesVazia() //Caso a lista de formações esteja vazia, executar função exibirListaFormacoesVazia()

    println("----- Lista de formações cadastrados -----\n".uppercase())
    exibirListaFormacoes()
    val opcoesFormacao = mutableListOf<String>() //Variável opcoes recebe os valores de cada id de formação de listaFormacoes
    for (formacao in listaFormacoes) {
        val opcao = formacao.idFormacao
        opcoesFormacao.add(opcao.toString())
    }

    var selecaoFormacao : String?

    do { //Repete execução enquanto não recebe um valor correspondente a algum dos valores da variável opcoes

        println("Informe o ID da formação na qual deseja cadastrar usuário(s):")
        selecaoFormacao = readlnOrNull() //Recebimento do valor do ID informado pelo usuário

        if (!opcoesFormacao.contains(selecaoFormacao)) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        }

    } while (!opcoesFormacao.contains(selecaoFormacao))

    val indexFormacao = selecaoFormacao!!.toInt() - 1
    val formacaoSelecionada = listaFormacoes[indexFormacao]

    var outroUsuarioParaFormacao : String?

    do {

        println("----- Lista de usuários cadastrados -----\n".uppercase()  + exibirUsuarios())
        val opcoesUsuario = mutableListOf<String>() //Variável opcoes recebe os valores de cada id de usuário de listaUsuarios
        for (usuario in listaUsuarios) {
            val opcao = usuario.idUsuario
            opcoesUsuario.add(opcao.toString())
        }

        var usuarioParaFormacao : String?

        do { //Repete execução enquanto não recebe um valor correspondente a algum dos valores da variável opcoes

            println("Informe o ID do usuário que deseja inscrever na formação:")
            usuarioParaFormacao = readlnOrNull() //Recebimento do valor do ID informado pelo usuário

            if (!opcoesUsuario.contains(usuarioParaFormacao)) {
                println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
            }

        } while (!opcoesUsuario.contains(usuarioParaFormacao))

        val indexUsuario = usuarioParaFormacao!!.toInt() - 1 //Índice do usuário selecionado em listaUsuarios

        if (formacaoSelecionada.inscritosFormacao.add(listaUsuarios[indexUsuario])) { //Feedback da inscrição
            println("ADIÇÃO DE FORMAÇÃO BEM SUCEDIDA DO USUÁRIO DE ID " + listaUsuarios[indexUsuario].idUsuario + " A FORMAÇÃO DE ID " + formacaoSelecionada.idFormacao)
            println("LISTA ATUAIS DE INSCRITOS EM ${formacaoSelecionada.nomeFormacao}:\n${formacaoSelecionada.inscritosFormacao}")
        } else println("Inscrição falhou")

        println("Deseja inscrever outro usuário nessa formação?")
        outroUsuarioParaFormacao = readlnOrNull()

        when(outroUsuarioParaFormacao) {
            "s" -> cadastrarUsuarioFormacao() //"Loop" que permite seguir cadastrando mais usuários à formação selecionada
            "n" -> println("")
        }

        if (outroUsuarioParaFormacao.isNullOrEmpty() || !outroUsuarioParaFormacao.any { it.isLetter() } || (!outroUsuarioParaFormacao.equals("s") && !outroUsuarioParaFormacao.equals("n"))) {
            println("-----Seleção inválida!-----".uppercase())
        } else println("")

    } while (outroUsuarioParaFormacao.isNullOrEmpty() || !outroUsuarioParaFormacao.any { it.isLetter() } || (!outroUsuarioParaFormacao.equals("s") && !outroUsuarioParaFormacao.equals("n")))

}

fun cadastrarConteudoFormacao() {



}



