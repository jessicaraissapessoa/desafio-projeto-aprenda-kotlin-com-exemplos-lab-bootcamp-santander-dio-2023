package formacao

import aplicacao.menuFormacao
import enums.NivelDificuldade

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

        if (tecladoNomeFormacao.isNullOrEmpty() || !tecladoNomeFormacao.any { it.isLetter() }) {
            println("-----Nome inválido!-----".uppercase())
        }
    } while (tecladoNomeFormacao.isNullOrEmpty() || !tecladoNomeFormacao.any { it.isLetter() })

    do { //Repete execução enquanto não recebe 1 ou 2 ou 3
        println("Selecione o nível de dificuldade da formação informando o número correspondente:" +
                "\n1 - Básico\n2 - Intermediário\n3 - Avançado")
        tecladoNivelDificuldadeFormacao = readlnOrNull() //Recebe escolha do usuário entre as opções
        selecaoNivelDificuldadeFormacao = tecladoNivelDificuldadeFormacao.toString() //recebe o valor de tecladoNivelDificuldadeFormacao

        when (tecladoNivelDificuldadeFormacao) {
            "1" -> selecaoNivelDificuldadeFormacao = NivelDificuldade.BASICO.toString() //muda o valor de selecaoNivelDificuldadeFormacaoselecaoNivelDificuldadeFormacao para o valor do enum enums.enums.NivelDificuldade
            "2" -> selecaoNivelDificuldadeFormacao = NivelDificuldade.INTERMEDIARIO.toString() //muda o valor de selecaoNivelDificuldadeFormacao para o valor do enum enums.enums.NivelDificuldade
            "3" -> selecaoNivelDificuldadeFormacao = NivelDificuldade.AVANCADO.toString() //muda o valor de selecaoNivelDificuldadeFormacao para o valor do enum enums.enums.NivelDificuldade
        }

        if (tecladoNivelDificuldadeFormacao.isNullOrEmpty() || (!tecladoNivelDificuldadeFormacao.equals("1") && !tecladoNivelDificuldadeFormacao.equals("2")  && !tecladoNivelDificuldadeFormacao.equals("3"))) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        }

    } while (tecladoNivelDificuldadeFormacao.isNullOrEmpty() || (!tecladoNivelDificuldadeFormacao.equals("1") && !tecladoNivelDificuldadeFormacao.equals("2") && !tecladoNivelDificuldadeFormacao.equals("3")))

    val id = (listaFormacoes.maxByOrNull { it.idFormacao }?.idFormacao ?: 0) + 1 //Autoincremento de id soma +1 ao maior id da lista
    val novaFormacao = Formacao()

    novaFormacao.idFormacao = id
    novaFormacao.nomeFormacao = tecladoNomeFormacao
    novaFormacao.nivelDificuldadeFormacao = selecaoNivelDificuldadeFormacao

    //Verificação se a formação já não está cadastrado no sistema. Se não estiver cadastrado, é feito cadastro:
    if (listaFormacoes.any { it.equalsIgnoringID(novaFormacao) }) {
        println("Cadastro de formação falhou: formação já está cadastrada no sistema")
    } else {
        listaFormacoes.add(novaFormacao) //Cadastro/Adição de formação
        println("Adição de formação bem sucedida:\n$novaFormacao\n") //Feedback da adição

        do { //Pode começar a adicionar usuários à formação

            println("Gostaria de começar a cadastrar usuários à formação? Digite 's' para sim ou 'n' para não")
            val desejaAdicionaUsuariosFormacao = readlnOrNull() //Recebimento do valor pelo teclado

            when(desejaAdicionaUsuariosFormacao) {
                "s" -> adicionarUsuarioFormacao() //Segue para função adicionarUsuarioFormacao()
                "n" -> println()
            }

            if (desejaAdicionaUsuariosFormacao.isNullOrEmpty() || !desejaAdicionaUsuariosFormacao.any { it.isLetter() } || (!desejaAdicionaUsuariosFormacao.equals("s") && !desejaAdicionaUsuariosFormacao.equals("n"))) {
                println("-----Seleção inválida!-----".uppercase())
            }

        } while (desejaAdicionaUsuariosFormacao.isNullOrEmpty() || !desejaAdicionaUsuariosFormacao.any { it.isLetter() } || (!desejaAdicionaUsuariosFormacao.equals("s") && !desejaAdicionaUsuariosFormacao.equals("n")))

        do { //Pode começar a adicionar usuários à formação

            println("Gostaria de começar a cadastrar conteúdos educacionais à formação? Digite 's' para sim ou 'n' para não")
            val desejaAdicionaConteudosFormacao = readlnOrNull() //Recebimento do valor pelo teclado

            when(desejaAdicionaConteudosFormacao) {
                "s" -> adicionarConteudoFormacao() //Segue para função adicionarConteudoFormacao()
                "n" -> println()
            }

            if (desejaAdicionaConteudosFormacao.isNullOrEmpty() || !desejaAdicionaConteudosFormacao.any { it.isLetter() } || (!desejaAdicionaConteudosFormacao.equals("s") && !desejaAdicionaConteudosFormacao.equals("n"))) {
                println("-----Seleção inválida!-----".uppercase())
            }

        } while (desejaAdicionaConteudosFormacao.isNullOrEmpty() || !desejaAdicionaConteudosFormacao.any { it.isLetter() } || (!desejaAdicionaConteudosFormacao.equals("s") && !desejaAdicionaConteudosFormacao.equals("n")))

    }

    //"Loop" de cadastrarFormacao()
    do { //Repete execução enquanto desejaAdicionarOutraFormacao não receber um valor que não seja nulo, vazio, sem letras ou diferente de "s" e "n"

        println("Gostaria de cadastrar outra formação? Digite 's' para sim ou 'n' para não")
        val desejaAdicionarOutraFormacao = readlnOrNull() //Recebimento do valor pelo teclado

        when(desejaAdicionarOutraFormacao) {
            "s" -> cadastrarFormacao() //Segue para função cadastrarFormacao()
            "n" -> menuFormacao()
        }

        if (desejaAdicionarOutraFormacao.isNullOrEmpty() || !desejaAdicionarOutraFormacao.any { it.isLetter() } || (!desejaAdicionarOutraFormacao.equals("s") && !desejaAdicionarOutraFormacao.equals("n"))) {
            println("-----Seleção inválida!-----".uppercase())
        }

    } while (desejaAdicionarOutraFormacao.isNullOrEmpty() || !desejaAdicionarOutraFormacao.any { it.isLetter() } || (!desejaAdicionarOutraFormacao.equals("s") && !desejaAdicionarOutraFormacao.equals("n")))

}