/**
 * @author Jéssica Raissa Pessoa
 * Desafio de projeto - Bootcamp Santander 2023 - Mobile Android com Kotlin
 * Tema: Abstração das Formações DIO
 */

//Classes:

data class Usuario (var nome: String) //TODO

enum class NivelDificuldade { BASICO, INTERMEDIARIO, AVANCADO } //TODO

data class ConteudoEducacional (var nome: String, val duracao: Int = 1) //TODO

data class Formacao (val nome: String, var conteudos: List<ConteudoEducacional>) { //TODO

    val inscritos = mutableListOf<Usuario>()

    fun matricular (usuario: Usuario) {
        TODO("$usuario")
    }

}

//Aplicação na main:
fun main() {
    TODO("Testes")
}