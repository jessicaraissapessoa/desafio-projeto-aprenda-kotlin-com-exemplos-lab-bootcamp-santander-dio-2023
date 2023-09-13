enum class TipoConteudoEducacional() { //Tipos de conteúdo educacional
    CURSO,
    DESAFIOCODIGO,
    DESAFIOPROJETO;

    override fun toString(): String {
        return when (this) {
            CURSO -> "Curso"
            DESAFIOCODIGO -> "Desafio de código"
            DESAFIOPROJETO -> "Desafio de projeto"
        }
    }
}