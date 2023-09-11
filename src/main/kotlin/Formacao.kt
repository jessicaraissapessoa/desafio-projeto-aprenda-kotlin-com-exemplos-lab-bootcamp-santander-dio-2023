data class Formacao (val nome: String, var conteudos: List<ConteudoEducacional>, val dificuldade: NivelDificuldade) {
//TODO: dificuldade, matricular (1 ou +), inserir conteúdo(1 ou +)
    val inscritos = mutableListOf<Usuario>()

    fun matricular (usuario: Usuario) {
        println("$usuario")
    }

}