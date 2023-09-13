var listaUsuarios : MutableList<Usuario> = mutableListOf() //Lista de usuários

fun exibirUsuarios(): String { //Função para exibir lista de usuários (listaUsuarios)

    val builder = StringBuilder() //Usando StringBuilder para construir a string

    for (usuario in listaUsuarios) {
        builder.append(usuario.toString()) //Adiciona o toString() de cada usuário
        builder.append("\n") //Adicionar uma quebra de linha entre cada usuário
    }

    return builder.toString() //Retorna a exibição da lista em uma String
}

fun cadastrarUsuario() {

    var tecladoNomeUsuario : String? //Variável de nomeUsuario que será recebida
    var tecladoTipoUsuario : String?
    var selecaoTipoUsuario: String

    do { //Repete execução enquanto tecladoNomeUsuario não receber um valor que não seja nulo, vazio ou com números
        println("Insira nome completo do usuário:")
        tecladoNomeUsuario = readlnOrNull() //Recebimento do valor pelo teclado

        if (tecladoNomeUsuario.isNullOrEmpty() || tecladoNomeUsuario.any { it.isDigit() }) {
            println("-----Nome inválido!-----".uppercase())
        }
    } while (tecladoNomeUsuario.isNullOrEmpty() || tecladoNomeUsuario.any { it.isDigit() })

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

data class Usuario (var idUsuario: Int, var nomeUsuario: String, var tipoUsuario: String) { //Classe Usuario

    constructor() : this(0, "","") //Contrutor vazio da classe

    override fun toString(): String { //Customização da exibição do Usuario instanciado

        return "ID: $idUsuario | NOME: $nomeUsuario | TIPO: $tipoUsuario"
    }

}