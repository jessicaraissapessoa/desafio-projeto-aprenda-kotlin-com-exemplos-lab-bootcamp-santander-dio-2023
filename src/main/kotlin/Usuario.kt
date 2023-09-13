var listaUsuarios : MutableSet<Usuario> = mutableSetOf()

fun cadastrarUsuario() {

    var tecladoNomeUsuario : String? //Variável de nomeUsuario que será recebida
    var tecladoTipoUsuario : String?

    do { // Executa enquanto não passar por validação que impede vazio, nulo ou numérico
        println("Insira nome completo do usuário:")
        tecladoNomeUsuario = readlnOrNull() //Recebimento do valor pelo teclado

        if (tecladoNomeUsuario.isNullOrEmpty() || tecladoNomeUsuario.any { it.isDigit() }) {
            println("-----Nome inválido!-----".uppercase())
        }
    } while (tecladoNomeUsuario.isNullOrEmpty() || tecladoNomeUsuario.any { it.isDigit() })

    do {
        println("Informe o tipo de usuário")
        tecladoTipoUsuario = readlnOrNull()

        if (tecladoTipoUsuario.isNullOrEmpty()) {
            println("-----Nome inválido!-----".uppercase())
        }

    } while (tecladoTipoUsuario.isNullOrEmpty())

    var novoUsuario = Usuario() //Instância de Usuário

    val id = listaUsuarios.count() + 1 //id = quantidade de usuários já inseridos em listaUsuarios + 1

    novoUsuario.idUsuario = id //idUsuario da instância de Usuario (novoUsuario) = id
    novoUsuario.nomeUsuario = tecladoNomeUsuario //nomeUsuario da instância de Usuario (novoUsuario) = tecladoNomeUsuario
    novoUsuario.tipoUsuario = tecladoTipoUsuario //tipoUsuario da instância de Usuario (novoUsuario) = tecladoTipoUsuario

    listaUsuarios.add(novoUsuario) //Adicionando novoUsuario à lista listaUsuarios


}

data class Usuario (var idUsuario: Int, var nomeUsuario: String, var tipoUsuario: String) {

    constructor() : this(0, "","")

}