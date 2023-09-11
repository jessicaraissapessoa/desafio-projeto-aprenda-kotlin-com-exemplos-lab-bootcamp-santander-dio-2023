/**
 * @author Jéssica Raissa Pessoa
 * Desafio de projeto - Bootcamp Santander 2023 - Mobile Android com Kotlin
 * Tema: Abstração das Formações DIO
 */

//CLASSES DIO

data class Usuario (var nome: String)

enum class NivelDificuldade() { //Níveis de dificuldade
    BASICO, INTERMEDIARIO, AVANCADO
}

enum class TipoConteudoEducacional() { //Tipos de conteúdo educacional
    CURSO, DESAFIOCODIGO, DESAFIOPROJETO
}

data class ConteudoEducacional (val tipoConteudoEducacional: TipoConteudoEducacional, val nome: String, val duracao: Int) { //Conteúdo educacional -> curso / desafio de código / desafio de projeto

    companion object { //Solicitando ao usuário os valores que vão preencher os argumentos dessa classe
        fun cadastrarConteudoEducacional(): ConteudoEducacional {

            fun selecionarTipoConteudoEducacional(): TipoConteudoEducacional { //Função para seleção do tipo de conteúdo educacional
                println("Selecione o tipo do conteúdo educacional informando o número correspondente à esse:" +
                        "\n1 - Curso\n2 - Desafio de código\n3 - Desafio de projeto")
                val selecaoTipoConteudoEducacional = readlnOrNull()

                return when (selecaoTipoConteudoEducacional) {
                    "1" -> TipoConteudoEducacional.CURSO
                    "2" -> TipoConteudoEducacional.DESAFIOCODIGO
                    "3" -> TipoConteudoEducacional.DESAFIOPROJETO
                    "" -> selecionarTipoConteudoEducacional()
                    else -> {
                        println("-----Seleção inválida!-----".uppercase())
                        selecionarTipoConteudoEducacional()
                    }
                }
            }

            fun preencherNomeConteudoEducacional(): String { //Função para preenchimento do título/nome do conteúdo educacional
                println("Informe o título/nome do conteúdo educacional:")
                val nomeTituloConteudoEducacional = readlnOrNull() //TODO: Está aceitando quando preenche com space+enter

                if (nomeTituloConteudoEducacional.isNullOrEmpty()) {
                    println("-----Nome inválido!-----".uppercase())
                    preencherNomeConteudoEducacional()
                }

                return nomeTituloConteudoEducacional.toString()
            }

            fun informarDuracaoConteudoEducacional(): Int? { //Função para informar duração em horas do conteúdo educacional
                println("Informe a duração do conteúdo em horas inteiras (Ex: 1):")
                val valorDuracaoConteudoEducacional = readlnOrNull()?.toInt() //TODO: está quebrando quando póe letra

                if (readlnOrNull()?.isEmpty() == true) {
                    println("-----Preenchimento inválido!-----".uppercase())
                    informarDuracaoConteudoEducacional()
                }

                return valorDuracaoConteudoEducacional

            }

            val tipoConteudoEducacional = selecionarTipoConteudoEducacional()
            val nomeConteudoEducacional = preencherNomeConteudoEducacional()
            val duracaoConteudoEducacional = informarDuracaoConteudoEducacional() ?: 1

            return ConteudoEducacional(tipoConteudoEducacional, nomeConteudoEducacional, duracaoConteudoEducacional)

        }
    }
}

data class Formacao (val nome: String, var conteudos: List<ConteudoEducacional>, val dificuldade: NivelDificuldade) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular (usuario: Usuario) {
        println("$usuario")
    }

}



//CLASSES E FUNÇÕES INTERFACE

fun selecionarDificuldade (): NivelDificuldade { //Função para seleção de dificuldade a partir da enum class NivelDificuldade

    TODO("Inserir em conteudos")

    println("Selecione o nível de dificuldade informando o número correspondente à dificuldade:" +
            "\n1 - Básico\n2 - Intermediário\n3 - Avançado")
    val selecaoDificuldade = readlnOrNull()


    return when (selecaoDificuldade) {
        "1" -> NivelDificuldade.BASICO
        "2" -> NivelDificuldade.INTERMEDIARIO
        "3" -> NivelDificuldade.AVANCADO
        "" -> selecionarDificuldade()
        else -> {
            println("-----Seleção inválida!-----".uppercase())
            selecionarDificuldade()
        }
    }
}



//APLICAÇÃO NA MAIN

fun main() {

    TODO("Ajeitar")
    selecionarDificuldade()
    val conteudo = ConteudoEducacional.cadastrarConteudoEducacional()

    //para imprimir enum -> NivelDificuldade.valueOf("INTERMEDIARIO")

}