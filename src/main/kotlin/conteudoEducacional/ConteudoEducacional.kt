package conteudoEducacional

import enums.NivelDificuldade
import enums.TipoConteudoEducacional

data class ConteudoEducacional(var idConteudoEducacional: Int, var nomeConteudoEducacional: String, var tipoConteudoEducacional: String, var nivelDificuldadeConteudoEducacional: String, var duracaoConteudoEducacional: Int) { //Classe ConteudoEducacional

    constructor() : this(0, "", "", "", 1) //Construtor vazio da classe

    override fun toString(): String { //Customização da exibição do ConteudoEducacional instanciado
        return "ID: $idConteudoEducacional | NOME: $nomeConteudoEducacional\n\t↳ TIPO: $tipoConteudoEducacional | NÍVEL: $nivelDificuldadeConteudoEducacional | DURAÇÃO: $duracaoConteudoEducacional" + "h"
    }

}





