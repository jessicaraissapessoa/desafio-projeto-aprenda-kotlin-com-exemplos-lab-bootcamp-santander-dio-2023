import javax.print.attribute.standard.MediaSize.Other

data class ConteudoEducacional(var idConteudoEducacional: Int, var nomeConteudoEducacional: String, var tipoConteudoEducacional: String, var nivelDificuldadeConteudoEducacional: String, var duracaoConteudoEducacional: Int) { //Classe ConteudoEducacional

    constructor() : this(0, "", "", "", 1) //Construtor vazio da classe

    override fun toString(): String { //Customização da exibição do ConteudoEducacional instanciado
        return "ID: $idConteudoEducacional | NOME: $nomeConteudoEducacional\n\t↳ TIPO: $tipoConteudoEducacional | NÍVEL: $nivelDificuldadeConteudoEducacional | DURAÇÃO: $duracaoConteudoEducacional" + "h"
    }

}

var listaConteudosEducacionais : MutableList<ConteudoEducacional> = mutableListOf() //Lista de conteúdos educacionais


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


fun ConteudoEducacional.equalsIgnoringID(other: ConteudoEducacional) : Boolean { //Função para comparar qualquer conteúdo educacional novo aos já cadastrados

    return nomeConteudoEducacional == other.nomeConteudoEducacional &&
            tipoConteudoEducacional == other.tipoConteudoEducacional &&
            nivelDificuldadeConteudoEducacional == other.nivelDificuldadeConteudoEducacional &&
            duracaoConteudoEducacional == other.duracaoConteudoEducacional

}


fun cadastrarConteudoEducacional() {

    var tecladoNomeConteudoEducacional : String? //Variável de nome de conteúdo educacional que será recebido
    var tecladoTipoConteudoEducacional : String? //Variável de seleção para opções na definição do tipo de conteúdo educacional que será recebida
    var selecaoTipoConteudoEducacional : String //Variável de tipoConteudoEducacional que será definido
    var tecladoNivelDificuldadeConteudoEducacional : String? //Variável de seleção para opções na definição do nível de dificuldade que será recebida
    var selecaoNivelDificuldadeConteudoEducacional : String //Variável de nivelDificuldade que será definido
    var tecladoDuracaoConteudoEducacional : String?  //Variável de duração em horas de conteúdo educacional que será recebido

    do { //Repete execução enquanto tecladoNomeConteudoEducacional não receber um valor que não seja nulo, vazio, sem letras ou com números
        println("Insira título do conteúdo educacional:")
        tecladoNomeConteudoEducacional = readlnOrNull() //Recebimento do valor pelo teclado

        if (tecladoNomeConteudoEducacional.isNullOrEmpty() || !tecladoNomeConteudoEducacional.any { it.isLetter() } || tecladoNomeConteudoEducacional.any { it.isDigit() }) {
            println("-----Nome inválido!-----".uppercase())
        }
    } while (tecladoNomeConteudoEducacional.isNullOrEmpty() || !tecladoNomeConteudoEducacional.any { it.isLetter() }|| tecladoNomeConteudoEducacional.any { it.isDigit() })

    do { //Repete execução enquanto não recebe 1 ou 2 ou 3
        println("Selecione o tipo do conteúdo educacional informando o número correspondente:" +
                "\n1 - Curso\n2 - Desafio de código\n3 - Desafio de projeto")
        tecladoTipoConteudoEducacional = readlnOrNull() //Recebe escolha do usuário entre as opções
        selecaoTipoConteudoEducacional = tecladoTipoConteudoEducacional.toString() //recebe o valor de tecladoTipoConteudoEducacional


        when (tecladoTipoConteudoEducacional) {
            "1" -> selecaoTipoConteudoEducacional = TipoConteudoEducacional.CURSO.toString() //muda o valor de selecaoTipoConteudoEducacional para o valor do enum TipoConteudoEducacional
            "2" -> selecaoTipoConteudoEducacional = TipoConteudoEducacional.DESAFIOCODIGO.toString() //muda o valor de selecaoTipoConteudoEducacional para o valor do enum TipoConteudoEducacional
            "3" -> selecaoTipoConteudoEducacional = TipoConteudoEducacional.DESAFIOPROJETO.toString() //muda o valor de selecaoTipoConteudoEducacional para o valor do enum TipoConteudoEducacional
        }

        if (tecladoTipoConteudoEducacional.isNullOrEmpty() || (!tecladoTipoConteudoEducacional.equals("1") && !tecladoTipoConteudoEducacional.equals("2")  && !tecladoTipoConteudoEducacional.equals("3"))) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        }

    } while (tecladoTipoConteudoEducacional.isNullOrEmpty() || (!tecladoTipoConteudoEducacional.equals("1") && !tecladoTipoConteudoEducacional.equals("2") && !tecladoTipoConteudoEducacional.equals("3")))

    do { //Repete execução enquanto não recebe 1 ou 2 ou 3
        println("Selecione o nível de dificuldade do conteúdo educacional informando o número correspondente:" +
                "\n1 - Básico\n2 - Intermediário\n3 - Avançado")
        tecladoNivelDificuldadeConteudoEducacional = readlnOrNull() //Recebe escolha do usuário entre as opções
        selecaoNivelDificuldadeConteudoEducacional = tecladoNivelDificuldadeConteudoEducacional.toString() //recebe o valor de tecladoNivelDificuldadeConteudoEducacional


        when (tecladoNivelDificuldadeConteudoEducacional) {
            "1" -> selecaoNivelDificuldadeConteudoEducacional = NivelDificuldade.BASICO.toString() //muda o valor de selecaoNivelDificuldadeConteudoEducacional para o valor do enum NivelDificuldade
            "2" -> selecaoNivelDificuldadeConteudoEducacional = NivelDificuldade.INTERMEDIARIO.toString() //muda o valor de selecaoNivelDificuldadeConteudoEducacional para o valor do enum NivelDificuldade
            "3" -> selecaoNivelDificuldadeConteudoEducacional = NivelDificuldade.AVANCADO.toString() //muda o valor de selecaoNivelDificuldadeConteudoEducacional para o valor do enum NivelDificuldade
        }

        if (tecladoNivelDificuldadeConteudoEducacional.isNullOrEmpty() || (!tecladoNivelDificuldadeConteudoEducacional.equals("1") && !tecladoNivelDificuldadeConteudoEducacional.equals("2")  && !tecladoNivelDificuldadeConteudoEducacional.equals("3"))) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        }

    } while (tecladoNivelDificuldadeConteudoEducacional.isNullOrEmpty() || (!tecladoNivelDificuldadeConteudoEducacional.equals("1") && !tecladoNivelDificuldadeConteudoEducacional.equals("2") && !tecladoNivelDificuldadeConteudoEducacional.equals("3")))

    do {  //Repete execução enquanto tecladoDuracaoConteudoEducacional não receber um valor que não seja nulo, vazio ou nao composto inteiramente por números

        println("Informe a duração em horas inteiras do conteúdo educacional:")
        tecladoDuracaoConteudoEducacional = readlnOrNull() //Recebimento do valor pelo teclado

        if (tecladoDuracaoConteudoEducacional.isNullOrEmpty() || !tecladoDuracaoConteudoEducacional.all { it.isDigit() }) {
            println("-----Duração inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        }

    } while (tecladoDuracaoConteudoEducacional.isNullOrEmpty() || !tecladoDuracaoConteudoEducacional.all { it.isDigit() })

    var novoConteudoEducacional = ConteudoEducacional() //Instância de ConteudoEducacional

    val id = listaConteudosEducacionais.count() + 1  //id = quantidade de conteúdos educacionais já inseridos em listaConteudosEducacionais + 1

    novoConteudoEducacional.idConteudoEducacional = id //idConteudoEducacional da instância de ConteudoEducacional (novoConteudoEducacional) = id
    novoConteudoEducacional.nomeConteudoEducacional = tecladoNomeConteudoEducacional //nomeConteudoEducacional da instância de ConteudoEducacional (novoConteudoEducacional) = tecladoNomeConteudoEducacional
    novoConteudoEducacional.tipoConteudoEducacional = selecaoTipoConteudoEducacional //tipoConteudoEducacional da instância de ConteudoEducacional (novoConteudoEducacional) = tecladoTipoConteudoEducacional
    novoConteudoEducacional.nivelDificuldadeConteudoEducacional = selecaoNivelDificuldadeConteudoEducacional //nivelDificuldadeConteudoEducacional da instância de ConteudoEducacional (novoConteudoEducacional) = tecladoNivelDificuldadeConteudoEducacional
    novoConteudoEducacional.duracaoConteudoEducacional = tecladoDuracaoConteudoEducacional.toInt() //duracaoConteudoEducacional da instância de ConteudoEducacional (novoConteudoEducacional) = tecladoDuracaoConteudoEducacional

    //Verificação se o conteúdo educacional já não está cadastrado no sistema. Se não estiver cadastrado, é feito cadastro:
    if (listaConteudosEducacionais.any { it.equalsIgnoringID(novoConteudoEducacional) }) {
        println("Cadastro de conteúdo educacional falhou: conteúdo educacional já está cadastrado no sistema")
    } else {
        listaConteudosEducacionais.add(novoConteudoEducacional) //Cadastro/Adição de conteúdo educacional
        println("Adição de conteúdo educacional bem sucedida:\n$novoConteudoEducacional\n") //Feedback da adição
    }

    //"Loop" de cadastrarConteudoEducacional()
    do { //Repete execução enquanto desejaAdicionarOutroConteudoEducacional não receber um valor que não seja nulo, vazio, sem letras ou diferente de "s" e "n"

        println("Gostaria de cadastrar outro conteúdo educacional? Digite 's' para sim ou 'n' para não")
        val desejaAdicionarOutroConteudoEducacional = readlnOrNull() //Recebimento do valor pelo teclado

        when(desejaAdicionarOutroConteudoEducacional) {
            "s" -> cadastrarConteudoEducacional() //Segue para função cadastrarConteudoEducacional()
            "n" -> println("")
        }

        if (desejaAdicionarOutroConteudoEducacional.isNullOrEmpty() || !desejaAdicionarOutroConteudoEducacional.any { it.isLetter() } || (!desejaAdicionarOutroConteudoEducacional.equals("s") && !desejaAdicionarOutroConteudoEducacional.equals("n"))) {
            println("-----Seleção inválida!-----".uppercase())
        } else println("")

    } while (desejaAdicionarOutroConteudoEducacional.isNullOrEmpty() || !desejaAdicionarOutroConteudoEducacional.any { it.isLetter() } || (!desejaAdicionarOutroConteudoEducacional.equals("s") && !desejaAdicionarOutroConteudoEducacional.equals("n")))

}


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

    val conteudoEducacionalRemovido = listaConteudosEducacionais.removeAt(index = (selecaoRemocaoConteudoEducacional?.toInt()!! - 1)) //Remoção do conteúdo educacional

    println("Remoção de usuário bem sucedida:\n$conteudoEducacionalRemovido\n") //Mensagem de feedback da remoção

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

    }

}


fun editarConteudoEducacional() {

    if (listaConteudosEducacionais.isEmpty()) exibirListaConteudosEducacionaisVazia()  //Caso a lista de conteúdos educacionais esteja vazia, executar função exibirListaConteudosEducacionaisVazia()

    println("----- Lista de conteúdos educacionais cadastrados -----\n".uppercase())
    exibirConteudosEducacionais()

    //Variável opcoes recebe os valores de cada id de conteúdo educacional de listaConteudosEducacionais
    val opcoes = mutableListOf<String>()
    for (conteudoEducacional in listaConteudosEducacionais) {
        val opcao = conteudoEducacional.idConteudoEducacional
        opcoes.add(opcao.toString())
    }

    var selecaoEdicaoConteudoEducacional : String? //Variável que receberá opção informada por teclado em do/while seguinte
    var conteudoEducacionalParaEdicao : ConteudoEducacional?

    do { //Repete execução enquanto não recebe um valor correspondente a algum dos valores da variável opcoes

        println("Informe o ID do conteúdo educacional que deseja editar:")
        selecaoEdicaoConteudoEducacional = readlnOrNull() //Recebimento do valor do ID informado pelo usuário

        if (!opcoes.contains(selecaoEdicaoConteudoEducacional)) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        }

    } while (!opcoes.contains(selecaoEdicaoConteudoEducacional))

    val index = selecaoEdicaoConteudoEducacional?.toInt()!! - 1 //Variável que recebe valor do que será o índice do elemento de listaConteudosEducacionais
    conteudoEducacionalParaEdicao = listaConteudosEducacionais[index] //ConteudoEducacional a ser editado é o elemento listaConteudosEducacionais[<índice do elemento dentro do array>]

    //Edição do nome do conteúdo educacional
    do { //Repete execução enquanto não recebe um valor correspondente a "s" ou "n"
        println("Deseja editar o título do conteúdo educacional? Digite 's' para sim ou 'n' para não")
        val respostaEditarNomeConteudoEducacional = readlnOrNull() //Recebimento do valor pelo teclado

        if (respostaEditarNomeConteudoEducacional.isNullOrEmpty() || ((respostaEditarNomeConteudoEducacional != "s") && (respostaEditarNomeConteudoEducacional != "n"))) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        } else {
            var tecladoNovoNomeConteudoEducacional : String? //Variável de novoNomeConteudoEducacional que preencherá nomeConteudoEducacional após edição

            if (respostaEditarNomeConteudoEducacional == "s") { //Se recebeu "s", segue para alteração do nome do conteúdo educacional
                do { //Repete execução enquanto tecladoNovoNomeConteudoEducacional não receber um valor que não seja nulo, vazio, sem letras ou com números
                    println("Insira novo título do conteúdo educacional:")
                    tecladoNovoNomeConteudoEducacional = readlnOrNull() //Recebimento do valor pelo teclado

                    if (tecladoNovoNomeConteudoEducacional.isNullOrEmpty() || !tecladoNovoNomeConteudoEducacional.any { it.isLetter() } || tecladoNovoNomeConteudoEducacional.any { it.isDigit() }) {
                        println("-----Título inválido!-----".uppercase())
                    }
                } while (tecladoNovoNomeConteudoEducacional.isNullOrEmpty() || !tecladoNovoNomeConteudoEducacional.any { it.isLetter() } || tecladoNovoNomeConteudoEducacional.any { it.isDigit() })

                conteudoEducacionalParaEdicao.nomeConteudoEducacional = tecladoNovoNomeConteudoEducacional //Atribuição de novo nome ao conteúdo educacional do ID informado

                println("Alteração do nome do conteúdo educacional bem sucedida:\n$conteudoEducacionalParaEdicao\n") //Mensagem de feedback da edição do nome do conteúdo educacional
            }
        }
    } while (respostaEditarNomeConteudoEducacional.isNullOrEmpty() || ((respostaEditarNomeConteudoEducacional != "s") && (respostaEditarNomeConteudoEducacional != "n")))

    //Edição do tipo do conteúdo educacional
    do {  //Repete execução enquanto não recebe um valor correspondente a "s" ou "n"

        println("Deseja editar o tipo do conteúdo educacional? Digite 's' para sim ou 'n' para não")
        val respostaEditarTipoConteudoEducacional = readlnOrNull() //Recebimento do valor pelo teclado

        if (respostaEditarTipoConteudoEducacional.isNullOrEmpty() || ((respostaEditarTipoConteudoEducacional != "s") && (respostaEditarTipoConteudoEducacional != "n"))) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        } else {
            var selecaoNovoTipoConteudoEducacional : String //Variável de novoTipoConteudoEducacional que preencherá tipoConteudoEducacional após edição

            if (respostaEditarTipoConteudoEducacional == "s") { //Se recebeu "s", segue para alteração do tipo do conteúdo educacional

                do { //Repete execução enquanto não recebe 1, 2 ou 3
                    println("Selecione o novo tipo do conteúdo educacional informando o número correspondente:" +
                            "\n1 - Curso\n2 - Desafio de código\n3 - Desafio de projeto")
                    var tecladoNovoTipoConteudoEducacional = readlnOrNull() //Recebe escolha do usuário entre as opções
                    selecaoNovoTipoConteudoEducacional = tecladoNovoTipoConteudoEducacional.toString() //recebe o valor de tecladoNovoTipoConteudoEducacional


                    when (tecladoNovoTipoConteudoEducacional) {
                        "1" -> selecaoNovoTipoConteudoEducacional = TipoConteudoEducacional.CURSO.toString() //muda o valor de selecaoNovoTipoConteudoEducacional para o valor do enum TipoConteudoEducacional
                        "2" -> selecaoNovoTipoConteudoEducacional = TipoConteudoEducacional.DESAFIOCODIGO.toString()  //muda o valor de selecaoNovoTipoConteudoEducacional para o valor do enum TipoConteudoEducacional
                        "3" -> selecaoNovoTipoConteudoEducacional = TipoConteudoEducacional.DESAFIOPROJETO.toString() //muda o valor de selecaoNovoTipoConteudoEducacional para o valor do enum TipoConteudoEducacional

                    }

                    if (tecladoNovoTipoConteudoEducacional.isNullOrEmpty() || (!tecladoNovoTipoConteudoEducacional.equals("1") && !tecladoNovoTipoConteudoEducacional.equals("2") && !tecladoNovoTipoConteudoEducacional.equals("3"))) {
                        println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
                    }

                } while (tecladoNovoTipoConteudoEducacional.isNullOrEmpty() || (!tecladoNovoTipoConteudoEducacional.equals("1") && !tecladoNovoTipoConteudoEducacional.equals("2") && !tecladoNovoTipoConteudoEducacional.equals("3")))

                conteudoEducacionalParaEdicao.tipoConteudoEducacional = selecaoNovoTipoConteudoEducacional //Alteração do tipo do conteúdo educacional do ID informado

                println("Alteração do tipo do conteúdo educacional bem sucedida:\n$conteudoEducacionalParaEdicao\n") //Mensagem de feedback da edição do tipo do conteúdo educacional
            }
        }
    } while (respostaEditarTipoConteudoEducacional.isNullOrEmpty() || ((respostaEditarTipoConteudoEducacional != "s") && (respostaEditarTipoConteudoEducacional != "n")))

    // Edição do nível de dificuldade do conteúdo educacional
    do {  //Repete execução enquanto não recebe um valor correspondente a "s" ou "n"

        println("Deseja editar o nível de dificuldade do conteúdo educacional? Digite 's' para sim ou 'n' para não")
        val respostaEditarNivelDificuldadeConteudoEducacional = readlnOrNull() //Recebimento do valor pelo teclado

        if (respostaEditarNivelDificuldadeConteudoEducacional.isNullOrEmpty() || ((respostaEditarNivelDificuldadeConteudoEducacional != "s") && (respostaEditarNivelDificuldadeConteudoEducacional != "n"))) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        } else {
            var selecaoNovoNivelDificuldadeConteudoEducacional : String //Variável de novoNivelDificuldadeConteudoEducacional que preencherá NivelDificuldadeConteudoEducacional após edição

            if (respostaEditarNivelDificuldadeConteudoEducacional == "s") { //Se recebeu "s", segue para alteração do nível de dificuldade do conteúdo educacional

                do { //Repete execução enquanto não recebe 1, 2 ou 3
                    println("\"Selecione o novo nível de dificuldade do conteúdo educacional informando o número correspondente:" +
                            "\n1 - Básico\n2 - Intermediário\n3 - Avançado")
                    var tecladoNivelDificuldadeEducacional = readlnOrNull() //Recebe escolha do usuário entre as opções
                    selecaoNovoNivelDificuldadeConteudoEducacional = tecladoNivelDificuldadeEducacional.toString() //recebe o valor de tecladoNovoTipoConteudoEducacional


                    when (tecladoNivelDificuldadeEducacional) {
                        "1" -> selecaoNovoNivelDificuldadeConteudoEducacional = NivelDificuldade.BASICO.toString() //muda o valor de selecaoNovoNivelDificuldadeConteudoEducacional para o valor do enum NivelDificuldade
                        "2" -> selecaoNovoNivelDificuldadeConteudoEducacional = NivelDificuldade.INTERMEDIARIO.toString()  //muda o valor de selecaoNovoNivelDificuldadeConteudoEducacional para o valor do enum NivelDificuldade
                        "3" -> selecaoNovoNivelDificuldadeConteudoEducacional = NivelDificuldade.AVANCADO.toString() //muda o valor de selecaoNovoNivelDificuldadeConteudoEducacional para o valor do enum NivelDificuldade

                    }

                    if (tecladoNivelDificuldadeEducacional.isNullOrEmpty() || (!tecladoNivelDificuldadeEducacional.equals("1") && !tecladoNivelDificuldadeEducacional.equals("2") && !tecladoNivelDificuldadeEducacional.equals("3"))) {
                        println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
                    }

                } while (tecladoNivelDificuldadeEducacional.isNullOrEmpty() || (!tecladoNivelDificuldadeEducacional.equals("1") && !tecladoNivelDificuldadeEducacional.equals("2") && !tecladoNivelDificuldadeEducacional.equals("3")))

                conteudoEducacionalParaEdicao.nivelDificuldadeConteudoEducacional = selecaoNovoNivelDificuldadeConteudoEducacional //Alteração do nível de dificuldade do conteúdo educacional do ID informado

                println("Alteração do tipo do conteúdo educacional bem sucedida:\n$conteudoEducacionalParaEdicao\n") //Mensagem de feedback da edição do nível de dificuldade do conteúdo educacional
            }
        }
    } while (respostaEditarNivelDificuldadeConteudoEducacional.isNullOrEmpty() || ((respostaEditarNivelDificuldadeConteudoEducacional != "s") && (respostaEditarNivelDificuldadeConteudoEducacional != "n")))

    //Edição da duração em horas do conteúdo educacional
    do { //Repete execução enquanto não recebe um valor correspondente a "s" ou "n"
        println("Deseja editar a duração em horas inteiras do conteúdo educacional? Digite 's' para sim ou 'n' para não")
        val respostaEditarDuracaoConteudoEducacional = readlnOrNull() //Recebimento do valor pelo teclado

        if (respostaEditarDuracaoConteudoEducacional.isNullOrEmpty() || ((respostaEditarDuracaoConteudoEducacional != "s") && (respostaEditarDuracaoConteudoEducacional != "n"))) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        } else {
            var tecladoNovaDuracaoConteudoEducacional : String? //Variável de novaDuracaoConteudoEducacional que preencherá duracaoConteudoEducacional após edição

            if (respostaEditarDuracaoConteudoEducacional == "s") { //Se recebeu "s", segue para alteração da duração do conteúdo educacional
                do { //Repete execução enquanto tecladoNovaDuracaoConteudoEducacional não receber um valor que não seja nulo, vazio ou que não seja inteiramente composto por números
                    println("Insira a nova duração em horas do conteúdo educacional:")
                    tecladoNovaDuracaoConteudoEducacional = readlnOrNull() //Recebimento do valor pelo teclado

                    if (tecladoNovaDuracaoConteudoEducacional.isNullOrEmpty() || !tecladoNovaDuracaoConteudoEducacional.all { it.isDigit() }) {
                        println("-----Duração inválida!-----".uppercase())
                    }
                } while (tecladoNovaDuracaoConteudoEducacional.isNullOrEmpty() || !tecladoNovaDuracaoConteudoEducacional.all { it.isDigit() })

                conteudoEducacionalParaEdicao.duracaoConteudoEducacional = tecladoNovaDuracaoConteudoEducacional.toInt() //Atribuição de nova duração ao conteúdo educacional do ID informado

                println("Alteração da duração em horas do conteúdo educacional bem sucedida:\n$conteudoEducacionalParaEdicao\n") //Mensagem de feedback da edição da duração do conteúdo educacional
            }
        }
    } while (respostaEditarDuracaoConteudoEducacional.isNullOrEmpty() || ((respostaEditarDuracaoConteudoEducacional != "s") && (respostaEditarDuracaoConteudoEducacional != "n")))

    println("Edição do conteúdo educacional de ID $selecaoEdicaoConteudoEducacional concluída") //Feedback da conclusão da edição do conteúdo educacional

    if (listaConteudosEducacionais.isNotEmpty()) {

        //"Loop" de editarConteudoEducacional()
        do { //Repete execução enquanto editarOutroConteudoEducacional não receber um valor que não seja nulo, vazio, sem letras ou diferente de "s" e "n"

            println("Gostaria de editar outro conteúdo educacional? Digite 's' para sim ou 'n' para não")
            val editarOutroConteudoEducacional = readlnOrNull() //Recebimento do valor pelo teclado

            when(editarOutroConteudoEducacional) {
                "s" -> editarConteudoEducacional() //Segue para função exibirConteudosEducacionais()
                "n" -> println("")
            }

            if (editarOutroConteudoEducacional.isNullOrEmpty() || !editarOutroConteudoEducacional.any { it.isLetter() } || (!editarOutroConteudoEducacional.equals("s") && !editarOutroConteudoEducacional.equals("n"))) {
                println("-----Seleção inválida!-----".uppercase())
            } else println("")

        } while (editarOutroConteudoEducacional.isNullOrEmpty() || !editarOutroConteudoEducacional.any { it.isLetter() } || (!editarOutroConteudoEducacional.equals("s") && !editarOutroConteudoEducacional.equals("n")))

    }

}





