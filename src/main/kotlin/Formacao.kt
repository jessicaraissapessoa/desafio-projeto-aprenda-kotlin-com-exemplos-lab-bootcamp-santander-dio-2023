import javax.print.attribute.standard.MediaSize.Other

data class Formacao(var idFormacao: Int, var nomeFormacao: String, var nivelDificuldadeFormacao : String) {

    constructor() : this(0, "", "")

    var inscritosFormacao = mutableListOf<Usuario>()
    var conteudosFormacao = mutableListOf<ConteudoEducacional>()
    var duracaoFormacao : Int = 0

    override fun toString(): String { //Customização da exibição da formação pelo método toString()

        val builder = StringBuilder()


        builder.append("--------------------------------------------------\n")
        builder.append("ID: $idFormacao | NOME: $nomeFormacao\n↳ NÍVEL: $nivelDificuldadeFormacao | DURAÇÃO: $duracaoFormacao")
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

fun exibirFormacaoDetalhada() {

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


fun Formacao.equalsIgnoringID(other: Formacao) : Boolean {
    return nomeFormacao == other.nomeFormacao && nivelDificuldadeFormacao == other.nivelDificuldadeFormacao
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
    novaFormacao.nivelDificuldadeFormacao = selecaoNivelDificuldadeFormacao

    //Verificação se a formação já não está cadastrado no sistema. Se não estiver cadastrado, é feito cadastro:
    if (listaFormacoes.any { it.equalsIgnoringID(novaFormacao) }) {
        println("Cadastro de formação falhou: formação já está cadastrada no sistema")
    } else {
        listaFormacoes.add(novaFormacao) //Cadastro/Adição de formação
        println("Adição de formação bem sucedida:\n" + listaFormacoes[id - 1]) //Feedback da adição
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

    var selecaoFormacao : String? //Variável que vai receber escolha de formação dentre as opções acima

    do { //Repete execução enquanto não recebe um valor correspondente a algum dos valores da variável opcoes

        println("Informe o ID da formação na qual deseja cadastrar usuário(s):")
        selecaoFormacao = readlnOrNull() //Recebimento do valor do ID da formação selecionada pelo usuário

        if (!opcoesFormacao.contains(selecaoFormacao)) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        }

    } while (!opcoesFormacao.contains(selecaoFormacao))

    val indexFormacao = selecaoFormacao!!.toInt() - 1 //índice da formação na mutableList listaFormacoes
    val formacaoSelecionada = listaFormacoes[indexFormacao] //formaçãoSelecionada recebe a Formacao equivalente de listaFormações

    selecionarUsuariosFormacao(formacaoSelecionada)

}


fun selecionarUsuariosFormacao(formacaoSelecionada: Formacao) {

    println("----- Lista de usuários no sistema -----\n".uppercase())
    exibirUsuarios()

    //Se quiser inscrever usuário que não está ainda no sistema
    println("Para adicionar usuário(s) novo(s) antes de seguir, digite 'add'. Senão, digite qualquer outra coisa.")
    val addUsuarioAntes = readlnOrNull()
    if (addUsuarioAntes == "add") {
        cadastrarUsuario()
        exibirUsuarios()
    } else println()

    val opcoesUsuario = mutableListOf<String>() //Variável opcoes recebe os valores de cada id de usuário de listaUsuarios
    for (usuario in listaUsuarios) {
        val opcao = usuario.idUsuario
        opcoesUsuario.add(opcao.toString())
    }

    var selecaoUsuario : String? //Variável que vai receber escolha de usuário dentre as opções acima

    do { //Repete execução enquanto não recebe um valor correspondente a algum dos valores da variável opcoes

        println("Informe o ID do usuário que deseja inscrever na formação:")
        selecaoUsuario = readlnOrNull() //Recebimento do valor do ID do usuário selecionado

        if (!opcoesUsuario.contains(selecaoUsuario)) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        }

    } while (!opcoesUsuario.contains(selecaoUsuario))

    val indexUsuario = selecaoUsuario!!.toInt() - 1 //índice de Usuário na mutableList listaUsuarios
    val usuarioSelecionado = listaUsuarios[indexUsuario] //usuarioSelecionado recebe o Usuário equivalente de listaUsuarios

    //Verificação se o usuário já não está inscrito na formação. Se não estiver inscrito, é feita inscrição:
    if (formacaoSelecionada.inscritosFormacao.any { it.idUsuario == usuarioSelecionado.idUsuario }) {
        println("Inscrição falhou: usuário já está inscrito na formação selecionada")
    } else {
        formacaoSelecionada.inscritosFormacao.add(listaUsuarios[indexUsuario])
        println("Adição bem sucedida: usuário de ID " + listaUsuarios[indexUsuario].idUsuario + " inscrito em formação de ID " + formacaoSelecionada.idFormacao)
    }

    do { //Repete execução enquanto não receber valor válido: "s" ou "n"

        println("Deseja inscrever outro usuário nessa formação? Digite 's' para sim ou 'n' para não")
        val adicionarOutroUsuarioFormacao = readlnOrNull()

        if (adicionarOutroUsuarioFormacao.isNullOrEmpty() || !adicionarOutroUsuarioFormacao.any { it.isLetter() } || (!adicionarOutroUsuarioFormacao.equals("s") && !adicionarOutroUsuarioFormacao.equals("n"))) {
            println("-----Seleção inválida!-----".uppercase())
        }

        when(adicionarOutroUsuarioFormacao) {
            "s" -> selecionarUsuariosFormacao(formacaoSelecionada) //"Loop" de selecionarUsuariosFormacao() -> Segue cadastrando usuários na mesma formação
            "n" -> {
                println("Inscrição de usuários em formação de ID ${formacaoSelecionada.idFormacao} concluída\n")
                println(formacaoSelecionada)


                do { //Repete execução enquanto não receber valor válido: "s" ou "n"

                    println("Deseja inscrever usuários em outra formação? Digite 's' para sim ou 'n' para não")
                    val adicionarUsuariosEmOutraFormacao = readlnOrNull()

                    if (adicionarUsuariosEmOutraFormacao.isNullOrEmpty() || !adicionarUsuariosEmOutraFormacao.any { it.isLetter() } || (!adicionarUsuariosEmOutraFormacao.equals("s") && !adicionarUsuariosEmOutraFormacao.equals("n"))) {
                        println("-----Seleção inválida!-----".uppercase())
                    }

                    when (adicionarUsuariosEmOutraFormacao) {
                        "s" -> cadastrarUsuarioFormacao() //"Loop" de cadastrarUsuarioFormacao() -> Segue cadastrando usuários, mas em outra formação
                        "n" -> println()
                    }

                } while (adicionarUsuariosEmOutraFormacao.isNullOrEmpty() || !adicionarUsuariosEmOutraFormacao.any { it.isLetter() } || (!adicionarUsuariosEmOutraFormacao.equals("s") && !adicionarUsuariosEmOutraFormacao.equals("n")))

            }
        }

    } while (adicionarOutroUsuarioFormacao.isNullOrEmpty() || !adicionarOutroUsuarioFormacao.any { it.isLetter() } || (!adicionarOutroUsuarioFormacao.equals("s") && !adicionarOutroUsuarioFormacao.equals("n")))

}


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

    println("----- Lista de conteúdos educacionais cadastrados -----\n".uppercase())
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

}