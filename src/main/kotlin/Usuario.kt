data class Usuario (var idUsuario: Int, var nomeUsuario: String, var tipoUsuario: String) { //Classe Usuario

    constructor() : this(0, "","") //Contrutor vazio da classe

    override fun toString(): String { //Customização da exibição do Usuario instanciado
        return "ID: $idUsuario | NOME: $nomeUsuario | TIPO: $tipoUsuario"
    }

}

var listaUsuarios : MutableList<Usuario> = mutableListOf() //Lista de usuários


fun exibirListaUsuariosVazia() {

    do { //Repete execução enquanto desejaAdicionarUsuarioTeclado não receber um valor que não seja nulo, vazio, sem letras ou diferente de "s" e "n"

        println("Sua lista de usuários está vazia. Deseja adicionar um usuário? Digite 's' para sim ou 'n' para não")
        val desejaAdicionarUsuarioTeclado = readlnOrNull() //Recebimento do valor pelo teclado

        when(desejaAdicionarUsuarioTeclado) {
            "s" -> cadastrarUsuario() //Segue para função cadastrarUsuario()
            "n" -> println("")
        }

        if (desejaAdicionarUsuarioTeclado.isNullOrEmpty() || !desejaAdicionarUsuarioTeclado.any { it.isLetter() } || (!desejaAdicionarUsuarioTeclado.equals("s") && !desejaAdicionarUsuarioTeclado.equals("n"))) {
            println("-----Seleção inválida!-----".uppercase())
        } else if (desejaAdicionarUsuarioTeclado == "s") cadastrarUsuario() //Segue para o cadastro de usuário
        else println("Lista de conteúdos educacionais vazia")

    } while (desejaAdicionarUsuarioTeclado.isNullOrEmpty() || !desejaAdicionarUsuarioTeclado.any { it.isLetter() } || (!desejaAdicionarUsuarioTeclado.equals("s") && !desejaAdicionarUsuarioTeclado.equals("n")))

}

fun toStringListaUsuarios() : String { //Função para exibir lista de usuários (listaUsuarios)

    if (listaUsuarios.isEmpty()) exibirListaUsuariosVazia() //Caso a lista de usuários esteja vazia, executar função exibirListaUsuariosVazia()

    val builder = StringBuilder() //Usando StringBuilder para construir a string

    for (usuario in listaUsuarios) {
        builder.append(usuario.toString()) //Adiciona o toString() de cada usuário
        builder.append("\n") //Adicionar uma quebra de linha entre cada usuário
    }

    return builder.toString() //Retorna a lista em uma única String customizada
}


fun exibirUsuarios() : String {
    return toStringListaUsuarios() //Impressão do toString da lista
}


fun cadastrarUsuario() { //Função para cadastrar usuário

    var tecladoNomeUsuario : String? //Variável de nomeUsuario que será recebida
    var tecladoTipoUsuario : String? //Variável de seleção para opções na definição do tipo de usuário que será recebida
    var selecaoTipoUsuario: String //Variável de tipoUsuario que será definido

    do { //Repete execução enquanto tecladoNomeUsuario não receber um valor que não seja nulo, vazio, sem letras ou com números
        println("Insira nome completo do usuário:")
        tecladoNomeUsuario = readlnOrNull() //Recebimento do valor pelo teclado

        if (tecladoNomeUsuario.isNullOrEmpty() || !tecladoNomeUsuario.any { it.isLetter() } || tecladoNomeUsuario.any { it.isDigit() }) {
            println("-----Nome inválido!-----".uppercase())
        }
    } while (tecladoNomeUsuario.isNullOrEmpty() || !tecladoNomeUsuario.any { it.isLetter() }|| tecladoNomeUsuario.any { it.isDigit() })

    do { //Repete execução enquanto não recebe 1 ou 2
        println("Selecione o tipo do usuário informando o número correspondente:" +
                "\n1 - Instrutor(a)\n2 - Aluno(a)")
        tecladoTipoUsuario = readlnOrNull() //Recebe escolha do usuário entre as opções
        selecaoTipoUsuario = tecladoTipoUsuario.toString() //recebe o valor de tecladoTipoUsuario


        when (tecladoTipoUsuario) {
            "1" -> selecaoTipoUsuario = TipoUsuario.INSTRUTOR.toString() //muda o valor de selecaoTipoUsuario para o valor do enum TipoUsuario
            "2" -> selecaoTipoUsuario = TipoUsuario.ALUNO.toString() //muda o valor de selecaoTipoUsuario para o valor do enum TipoUsuario
        }

        if (tecladoTipoUsuario.isNullOrEmpty() || (!tecladoTipoUsuario.equals("1") && !tecladoTipoUsuario.equals("2"))) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        }

    } while (tecladoTipoUsuario.isNullOrEmpty() || (!tecladoTipoUsuario.equals("1") && !tecladoTipoUsuario.equals("2")))

    var novoUsuario = Usuario() //Instância de Usuário

    val id = listaUsuarios.count() + 1 //id = quantidade de usuários já inseridos em listaUsuarios + 1

    novoUsuario.idUsuario = id //idUsuario da instância de Usuario (novoUsuario) = id
    novoUsuario.nomeUsuario = tecladoNomeUsuario //nomeUsuario da instância de Usuario (novoUsuario) = tecladoNomeUsuario
    novoUsuario.tipoUsuario = selecaoTipoUsuario //tipoUsuario da instância de Usuario (novoUsuario) = selecaoTipoUsuario

    if (listaUsuarios.add(novoUsuario)) { //Adiciona/retorna feedback da adição do novoUsuario
        println("Adição de usuário bem sucedida:\n$novoUsuario\n")
    } else println("Adição de usuário falhou")
}


fun excluirUsuario() { //Função para remover usuário

    if (listaUsuarios.isEmpty()) exibirListaUsuariosVazia() //Caso a lista de usuários esteja vazia, executar função exibirListaUsuariosVazia()

    println("----- Lista de usuários cadastrados -----\n".uppercase()  + exibirUsuarios())

    //Variável opcoes recebe os valores de cada id de usuário de listaUsuarios
    val opcoes = mutableListOf<String>()
    for (usuario in listaUsuarios) {
        val opcao = usuario.idUsuario
        opcoes.add(opcao.toString())
    }

    var selecaoRemocaoUsuario : String? //Variável que receberá opção informada por teclado em do/while seguinte

    do { //Repete execução enquanto não recebe um valor correspondente a algum dos valores da variável opcoes

        println("Informe o ID do usuário que deseja excluir:")
        selecaoRemocaoUsuario = readlnOrNull() //Recebimento do valor pelo teclado

        if (!opcoes.contains(selecaoRemocaoUsuario)) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        }

    } while (!opcoes.contains(selecaoRemocaoUsuario))

    val usuarioRemovido = listaUsuarios.removeAt(index = (selecaoRemocaoUsuario?.toInt()!! - 1)) //Remoção do usuário

    println("Remoção de usuário bem sucedida:\n$usuarioRemovido\n") //Mensagem de feedback da remoção
}


fun editarUsuario() { //Função para editar usuário

    if (listaUsuarios.isEmpty()) exibirListaUsuariosVazia() //Caso a lista de usuários esteja vazia, executar função exibirListaUsuariosVazia()

    println("----- Lista de usuários cadastrados -----\n".uppercase()  + exibirUsuarios())

    //Variável opcoes recebe os valores de cada id de usuário de listaUsuarios
    val opcoes = mutableListOf<String>()
    for (usuario in listaUsuarios) {
        val opcao = usuario.idUsuario
        opcoes.add(opcao.toString())
    }

    var selecaoEdicaoUsuario : String? //Variável que receberá opção informada por teclado em do/while seguinte
    var usuarioParaEdicao : Usuario?

    do { //Repete execução enquanto não recebe um valor correspondente a algum dos valores da variável opcoes

        println("Informe o ID do usuário que deseja editar:")
        selecaoEdicaoUsuario = readlnOrNull() //Recebimento do valor do ID informado pelo usuário

        if (!opcoes.contains(selecaoEdicaoUsuario)) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        }

    } while (!opcoes.contains(selecaoEdicaoUsuario))

    val index = selecaoEdicaoUsuario?.toInt()!! - 1 //Variável que recebe valor do que será o índice do elemento de listaUsuarios
    usuarioParaEdicao = listaUsuarios[index] //Usuário a ser editado é o elemento listaUsuarios[<índice do elemento dentro do array>]

    //Edição do nome do usuário
    do { //Repete execução enquanto não recebe um valor correspondente a "s" ou "n"
        println("Deseja editar o nome do usuário? Digite 's' para sim ou 'n' para não")
        val respostaEditarNomeUsuario = readlnOrNull() //Recebimento do valor pelo teclado

        if (respostaEditarNomeUsuario.isNullOrEmpty() || ((respostaEditarNomeUsuario != "s") && (respostaEditarNomeUsuario != "n"))) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        } else {
            var tecladoNovoNomeUsuario : String? //Variável de novoNomeUsuario que preencherá nomeUsuario após ediçao

            if (respostaEditarNomeUsuario == "s") { //Se recebeu "s", segue para alteração do nome do usuário
                do { //Repete execução enquanto tecladoNovoNomeUsuario não receber um valor que não seja nulo, vazio, sem letras ou com números
                    println("Insira novo nome completo do usuário:")
                    tecladoNovoNomeUsuario = readlnOrNull() //Recebimento do valor pelo teclado

                    if (tecladoNovoNomeUsuario.isNullOrEmpty() || !tecladoNovoNomeUsuario.any { it.isLetter() } || tecladoNovoNomeUsuario.any { it.isDigit() }) {
                        println("-----Nome inválido!-----".uppercase())
                    }
                } while (tecladoNovoNomeUsuario.isNullOrEmpty() || !tecladoNovoNomeUsuario.any { it.isLetter() } || tecladoNovoNomeUsuario.any { it.isDigit() })

                usuarioParaEdicao.nomeUsuario = tecladoNovoNomeUsuario //Atribuição de novo nome ao usuário do ID informado

                println("Alteração do nome do usuário bem sucedida:\n$usuarioParaEdicao\n") //Mensagem de feedback da edição do nome do usuário
            }
        }
    } while (respostaEditarNomeUsuario.isNullOrEmpty() || ((respostaEditarNomeUsuario != "s") && (respostaEditarNomeUsuario != "n")))

    //Edição do tipo do usuário
    do {  //Repete execução enquanto não recebe um valor correspondente a "s" ou "n"

        println("Deseja editar o tipo do usuário? Digite 's' para sim ou 'n' para não")
        val respostaEditarTipoUsuario = readlnOrNull() //Recebimento do valor pelo teclado

        if (respostaEditarTipoUsuario.isNullOrEmpty() || ((respostaEditarTipoUsuario != "s") && (respostaEditarTipoUsuario != "n"))) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        } else {
            var selecaoNovoTipoUsuario : String //Variável de novoTipoUsuario que preencherá nomeUsuario após edição

            if (respostaEditarTipoUsuario == "s") { //Se recebeu "s", segue para alteração do tipo do usuário

                do { //Repete execução enquanto não recebe 1 ou 2
                    println("Selecione o novo tipo do usuário informando o número correspondente:" +
                            "\n1 - Instrutor(a)\n2 - Aluno(a)")
                    var tecladoNovoTipoUsuario = readlnOrNull() //Recebe escolha do usuário entre as opções
                    selecaoNovoTipoUsuario = tecladoNovoTipoUsuario.toString() //recebe o valor de tecladoTipoUsuario


                    when (tecladoNovoTipoUsuario) {
                        "1" -> selecaoNovoTipoUsuario = TipoUsuario.INSTRUTOR.toString() //muda o valor de selecaoNovoTipoUsuario para o valor do enum TipoUsuario
                        "2" -> selecaoNovoTipoUsuario = TipoUsuario.ALUNO.toString() //muda o valor de selecaoNovoTipoUsuario para o valor do enum TipoUsuario
                    }

                    if (tecladoNovoTipoUsuario.isNullOrEmpty() || (!tecladoNovoTipoUsuario.equals("1") && !tecladoNovoTipoUsuario.equals("2"))) {
                        println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
                    }

                } while (tecladoNovoTipoUsuario.isNullOrEmpty() || (!tecladoNovoTipoUsuario.equals("1") && !tecladoNovoTipoUsuario.equals("2")))

                usuarioParaEdicao.tipoUsuario = selecaoNovoTipoUsuario //Alteração do tipo do usuário do ID informado

                println("Alteração do tipo do usuário bem sucedida:\n$usuarioParaEdicao\n") //Mensagem de feedback da edição do tipo do usuário
            }
        }
    } while (respostaEditarTipoUsuario.isNullOrEmpty() || ((respostaEditarTipoUsuario != "s") && (respostaEditarTipoUsuario != "n")))

    println("Edição do usuário de ID $selecaoEdicaoUsuario concluída") //Feedback da conclusão da edição do usuário
}