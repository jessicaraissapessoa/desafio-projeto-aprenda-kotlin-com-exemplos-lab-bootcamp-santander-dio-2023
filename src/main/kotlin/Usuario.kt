
class Usuario (var idUsuario: Int, var nomeUsuario: String, var tipoUsuario: String) {

    var id = 0
    var listaUsuarios : MutableSet<Usuario> = mutableSetOf()

    constructor() : this(0, "","")

    fun cadastrarUsuario() {

        var tecladoNomeUsuario : String?
        var tecladoTipoUsuario : String?

        do {
            println("Insira nome completo do usuário:")
            tecladoNomeUsuario = readlnOrNull()

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


        cadastroUsuario(nomeUsuario, tipoUsuario)

    }

    fun cadastroUsuario(nomeUsuario: String, tipoUsuario: String) {

        var usuario = Usuario()

        usuario.nomeUsuario = nomeUsuario
        usuario.tipoUsuario = tipoUsuario
        usuario.id++

        listaUsuarios.add(usuario)

        if (listaUsuarios.isNotEmpty()) println("xuxuzinho beleza")

    }

}