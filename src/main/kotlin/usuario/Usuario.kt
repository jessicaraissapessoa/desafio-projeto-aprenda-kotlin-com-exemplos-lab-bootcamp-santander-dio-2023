package usuario

data class Usuario (var idUsuario: Int, var nomeUsuario: String, var tipoUsuario: String) { //Classe Usuario

    constructor() : this(0, "","") //Construtor vazio da classe

    override fun toString(): String { //Customização da exibição do Usuario instanciado
        return "ID: $idUsuario | NOME: $nomeUsuario | TIPO: $tipoUsuario"
    }

}

var listaUsuarios : MutableList<Usuario> = mutableListOf() //Lista de usuários

