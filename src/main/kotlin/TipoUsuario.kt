enum class TipoUsuario() {

    INSTRUTOR,
    ALUNO;

    override fun toString(): String {
        return when (this) {
            INSTRUTOR -> "Instrutor(a)"
            ALUNO -> "Aluno(a)"
        }
    }

}