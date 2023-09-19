package conteudoEducacional

import aplicacao.menuConteudoEducacional
import enums.NivelDificuldade
import enums.TipoConteudoEducacional

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
                        "1" -> selecaoNovoTipoConteudoEducacional = TipoConteudoEducacional.CURSO.toString() //muda o valor de selecaoNovoTipoConteudoEducacional para o valor do enum enums.TipoConteudoEducacional
                        "2" -> selecaoNovoTipoConteudoEducacional = TipoConteudoEducacional.DESAFIOCODIGO.toString()  //muda o valor de selecaoNovoTipoConteudoEducacional para o valor do enum enums.TipoConteudoEducacional
                        "3" -> selecaoNovoTipoConteudoEducacional = TipoConteudoEducacional.DESAFIOPROJETO.toString() //muda o valor de selecaoNovoTipoConteudoEducacional para o valor do enum enums.TipoConteudoEducacional

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
                        "1" -> selecaoNovoNivelDificuldadeConteudoEducacional = NivelDificuldade.BASICO.toString() //muda o valor de selecaoNovoNivelDificuldadeConteudoEducacional para o valor do enum enums.NivelDificuldade
                        "2" -> selecaoNovoNivelDificuldadeConteudoEducacional = NivelDificuldade.INTERMEDIARIO.toString()  //muda o valor de selecaoNovoNivelDificuldadeConteudoEducacional para o valor do enum enums.NivelDificuldade
                        "3" -> selecaoNovoNivelDificuldadeConteudoEducacional = NivelDificuldade.AVANCADO.toString() //muda o valor de selecaoNovoNivelDificuldadeConteudoEducacional para o valor do enum enums.NivelDificuldade

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

    menuConteudoEducacional()
}