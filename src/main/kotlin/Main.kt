/**
 * @author Jéssica Raissa Pessoa
 * Desafio de projeto - Bootcamp Santander 2023 - Mobile Android com Kotlin
 * Tema: Abstração das Formações DIO
 */

fun main() {


    val usuario = Usuario.GerenciamentoUsuarios.cadastrarUsuario()
    println(Usuario.GerenciamentoUsuarios)
    println(Usuario.GerenciamentoUsuarios)
    val conteudo = ConteudoEducacional.cadastrarConteudoEducacional()
    println(conteudo)


    //para imprimir enum -> NivelDificuldade.valueOf("INTERMEDIARIO")

}