/**
 * @author Jéssica Raissa Pessoa
 * Desafio de projeto - Bootcamp Santander 2023 - Mobile Android com Kotlin
 * Tema: Abstração das Formações DIO
 */

fun main() {

    cadastrarUsuario()
    cadastrarUsuario()
    println(exibirUsuarios())
    //excluirUsuario()

    //println("---")
    //println(exibirUsuarios())

    println("---")
    editarUsuario()
    println("---")
    println(exibirUsuarios())

    /*
    val gerenciador = Usuario.GerenciamentoUsuarios()
    val usuario = Usuario.GerenciamentoUsuarios.cadastrarUsuario()
    println(usuario.toString())

    val conteudo = ConteudoEducacional.cadastrarConteudoEducacional()
    println(conteudo.toString())

    //para imprimir enum -> NivelDificuldade.valueOf("INTERMEDIARIO")

     */

}