package usuario

import aplicacao.menuUsuario
import enums.TipoUsuario

fun Usuario.equalsIgnoringID(other: Usuario) : Boolean { //Função para comparar qualquer usuário novo aos já cadastrados
    return nomeUsuario == other.nomeUsuario && tipoUsuario == other.tipoUsuario
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
    } while (tecladoNomeUsuario.isNullOrEmpty() || !tecladoNomeUsuario.any { it.isLetter() } || tecladoNomeUsuario.any { it.isDigit() })

    do { //Repete execução enquanto não recebe 1 ou 2
        println("Selecione o tipo do usuário informando o número correspondente:" +
                "\n1 - Instrutor(a)\n2 - Aluno(a)")
        tecladoTipoUsuario = readlnOrNull() //Recebe escolha do usuário entre as opções
        selecaoTipoUsuario = tecladoTipoUsuario.toString() //recebe o valor de tecladoTipoUsuario


        when (tecladoTipoUsuario) {
            "1" -> selecaoTipoUsuario = TipoUsuario.INSTRUTOR.toString() //muda o valor de selecaoTipoUsuario para o valor do enum enums.TipoUsuario
            "2" -> selecaoTipoUsuario = TipoUsuario.ALUNO.toString() //muda o valor de selecaoTipoUsuario para o valor do enum enums.TipoUsuario
        }

        if (tecladoTipoUsuario.isNullOrEmpty() || (!tecladoTipoUsuario.equals("1") && !tecladoTipoUsuario.equals("2"))) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        }

    } while (tecladoTipoUsuario.isNullOrEmpty() || (!tecladoTipoUsuario.equals("1") && !tecladoTipoUsuario.equals("2")))

    var novoUsuario = Usuario() //Instância de Usuário

    val id = (listaUsuarios.maxByOrNull { it.idUsuario }?.idUsuario ?: 0) + 1  //Autoincremento de id soma +1 ao maior id da lista

    novoUsuario.idUsuario = id //idUsuario da instância de Usuario (novoUsuario) = id
    novoUsuario.nomeUsuario = tecladoNomeUsuario //nomeUsuario da instância de Usuario (novoUsuario) = tecladoNomeUsuario
    novoUsuario.tipoUsuario = selecaoTipoUsuario //tipoUsuario da instância de Usuario (novoUsuario) = selecaoTipoUsuario


    //Verificação se o usuário já não está cadastrado no sistema. Se não estiver cadastrado, é feito cadastro:
    if (listaUsuarios.any { it.equalsIgnoringID(novoUsuario) }) {
        println("Cadastro de usuário falhou: usuário já está cadastrado no sistema")
    } else {
        listaUsuarios.add(novoUsuario) //Cadastro/Adição de usuário
        println("Adição de usuário bem sucedida:\n$novoUsuario\n") //Feedback da adição
    }

    //"Loop" de cadastrarUsuario()
    do { //Repete execução enquanto desejaAdicionarOutroUsuario não receber um valor que não seja nulo, vazio, sem letras ou diferente de "s" e "n"

        println("Gostaria de cadastrar outro usuário? Digite 's' para sim ou 'n' para não")
        val desejaAdicionarOutroUsuario = readlnOrNull() //Recebimento do valor pelo teclado

        when(desejaAdicionarOutroUsuario) {
            "s" -> cadastrarUsuario() //Segue para função cadastrarUsuario()
            "n" -> println("")
        }

        if (desejaAdicionarOutroUsuario.isNullOrEmpty() || !desejaAdicionarOutroUsuario.any { it.isLetter() } || (!desejaAdicionarOutroUsuario.equals("s") && !desejaAdicionarOutroUsuario.equals("n"))) {
            println("-----Seleção inválida!-----".uppercase())
        } else println("")

    } while (desejaAdicionarOutroUsuario.isNullOrEmpty() || !desejaAdicionarOutroUsuario.any { it.isLetter() } || (!desejaAdicionarOutroUsuario.equals("s") && !desejaAdicionarOutroUsuario.equals("n")))

    menuUsuario()
}