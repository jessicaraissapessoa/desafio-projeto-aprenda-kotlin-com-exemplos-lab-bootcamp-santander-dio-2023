data class Usuario (var nome: String) {
    //TODO: Exibição de usuários. Inserir 1 ou +. Encaminhar para menu inicial (ou loop para inserir mais?)
    companion object { //Solicitando ao usuário os valores que vão preencher os argumentos dessa classe

        fun preencherNomeUsuario(): String? {

            println("Insira o nome do usuário:")
            val nomeUsuario = readlnOrNull()

            if (nomeUsuario.isNullOrEmpty() || nomeUsuario.any { it.isDigit() }) {
                println("-----Nome inválido!-----".uppercase())
                preencherNomeUsuario()
            }

            return nomeUsuario

        }

    }

}

