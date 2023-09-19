package conteudoEducacional

import aplicacao.menuConteudoEducacional
import enums.NivelDificuldade
import enums.TipoConteudoEducacional

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
            "1" -> selecaoTipoConteudoEducacional = TipoConteudoEducacional.CURSO.toString() //muda o valor de selecaoTipoConteudoEducacional para o valor do enum enums.TipoConteudoEducacional
            "2" -> selecaoTipoConteudoEducacional = TipoConteudoEducacional.DESAFIOCODIGO.toString() //muda o valor de selecaoTipoConteudoEducacional para o valor do enum enums.TipoConteudoEducacional
            "3" -> selecaoTipoConteudoEducacional = TipoConteudoEducacional.DESAFIOPROJETO.toString() //muda o valor de selecaoTipoConteudoEducacional para o valor do enum enums.TipoConteudoEducacional
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
            "1" -> selecaoNivelDificuldadeConteudoEducacional = NivelDificuldade.BASICO.toString() //muda o valor de selecaoNivelDificuldadeConteudoEducacional para o valor do enum enums.NivelDificuldade
            "2" -> selecaoNivelDificuldadeConteudoEducacional = NivelDificuldade.INTERMEDIARIO.toString() //muda o valor de selecaoNivelDificuldadeConteudoEducacional para o valor do enum enums.NivelDificuldade
            "3" -> selecaoNivelDificuldadeConteudoEducacional = NivelDificuldade.AVANCADO.toString() //muda o valor de selecaoNivelDificuldadeConteudoEducacional para o valor do enum enums.NivelDificuldade
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

    menuConteudoEducacional()
}