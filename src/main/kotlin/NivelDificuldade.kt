enum class NivelDificuldade() { //Níveis de dificuldade
    BASICO,
    INTERMEDIARIO,
    AVANCADO;

    override fun toString() : String {
        return when (this) {
            BASICO -> "Básico"
            INTERMEDIARIO -> "Intermediário"
            AVANCADO -> "Avançado"
        }
    }

}