package formacao

import conteudoEducacional.ConteudoEducacional
import usuario.Usuario

data class Formacao(var idFormacao: Int, var nomeFormacao: String, var nivelDificuldadeFormacao : String) {

    constructor() : this(0, "", "")

    var inscritosFormacao = mutableListOf<Usuario>()
    var conteudosFormacao = mutableListOf<ConteudoEducacional>()
    var duracaoFormacao : Int = 0

    override fun toString(): String { //Customização da exibição da formação pelo método toString()

        val builder = StringBuilder()


        builder.append("--------------------------------------------------\n")
        builder.append("ID: $idFormacao | NOME: $nomeFormacao\n↳ NÍVEL: $nivelDificuldadeFormacao | DURAÇÃO: ${duracaoFormacao}h")
        builder.append("\n")
        builder.append("\nLISTA DE CONTEÚDOS:\n")
        conteudosFormacao.forEach { conteudoEducacional -> builder.append("\t$conteudoEducacional\n") }
        builder.append("\nLISTA DE INSCRITOS:\n")
        inscritosFormacao.forEach { usuario -> builder.append("\t$usuario\n") }
        builder.append("--------------------------------------------------")


        return builder.toString()
    }

}






























