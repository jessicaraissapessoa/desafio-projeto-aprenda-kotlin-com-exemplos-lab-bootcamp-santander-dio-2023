/**
 * @author Jéssica Raissa Pessoa
 * Desafio de projeto - Bootcamp Santander 2023 - Mobile Android com Kotlin
 * Tema: Abstração das Formações DIO
 */

fun main() {


    println("----------------------")
    cadastrarFormacao()
    println("PASSANDO PARA USUARIO!!!")
    cadastrarUsuarioFormacao()
    println("PASSANDO PARA EDITARFORMACAO!!!")
    editarFormacao()

    println("----------------------")





    cadastrarUsuario()

    println("\nSAINDO DE CADASTRARUSUARIO E INDO PARA CADASTRARCONTEUDOEDUCACIONAL\n")

    cadastrarConteudoEducacional()

    println("\nSAINDO DE CADASTRARCONTEUDOEDUCACIONAL E INDO PARA CADASTRARFORMACAO\n")

    cadastrarFormacao()

    println("\nSAINDO DE CADASTRARFORMACAO E INDO PARA CADASTRARUSUARIOFORMACAO\n")

    cadastrarUsuarioFormacao()

    println("\nSAINDO DE CADASTRARUSUARIOFORMACAO E INDO PARA EXIBIR CADASTRARCONTEUDOFORMACAO\n")

    cadastrarConteudoFormacao()

    println("\nSAINDO DE CADASTRARCONTEUDOFORMACAO E INDO PARA EXIBIR EXIBIRFORMACAODETALHADA\n")

    exibirFormacaoDetalhada()

    println("\nSAINDO DE FORMACAODETALHADA E INDO PARA EXIBIRLISTAFORMACOES\n")


    exibirListaFormacoes()

    println("\nSAINDO DE EXIBIRLISTAFORMACOES\n")



    println("\n\n\n")

    //var formacao = Formacao(1, "a", )
    //var teste = ConteudoEducacional(1, "a", "a",  "a",  1)
    //formacao.conteudosFormacao
    //println(formacao)

    cadastrarUsuario()
    cadastrarConteudoEducacional()
    cadastrarFormacao()
    exibirListaFormacoes()



    println("\n\n\n\n\n")

    cadastrarConteudoEducacional()
    editarConteudoEducacional()
    excluirConteudoEducacional()

    exibirUsuarios()

    cadastrarUsuario()
    //cadastrarUsuario()
    println("---------------------------------------------------------")

    exibirUsuarios()
    //println("---------------------------------------------------------")
    editarUsuario()
    //excluirUsuario()
    println("---------------------------------------------------------")


    //cadastrarConteudoEducacional()
    //var teste = ConteudoEducacional(1, "a", "a",  "a",  1)

    //println(listaConteudosEducacionais.add(teste))
    println(listaConteudosEducacionais)

    println("\n\n")

    exibirConteudosEducacionais()
    //println(listaConteudosEducacionais)
    //exibirConteudosEducacionais()

//    exibirConteudosEducacionais()
//    println("-----------------------------------------------------------------------------------------------------")
//    println("de exibir para cadastrar")
//    println("-----------------------------------------------------------------------------------------------------")
//    cadastrarConteudoEducacional()
//    println("-----------------------------------------------------------------------------------------------------")
//    println("de cadastrar para exibir")
//    println("-----------------------------------------------------------------------------------------------------")
//    exibirConteudosEducacionais()
//    println("-----------------------------------------------------------------------------------------------------")
//    println("de exibir para editar")
//    println("-----------------------------------------------------------------------------------------------------")
//    editarConteudoEducacional()
//    println("-----------------------------------------------------------------------------------------------------")
//    println("de editar para exibir")
//    println("-----------------------------------------------------------------------------------------------------")
//    exibirConteudosEducacionais()
//    println("-----------------------------------------------------------------------------------------------------")
//    println("de exibir para excluir")
//    println("-----------------------------------------------------------------------------------------------------")
//    excluirConteudoEducacional()
//    println("-----------------------------------------------------------------------------------------------------")
//    println("de excluir para exibir")
//    println("-----------------------------------------------------------------------------------------------------")
//    exibirConteudosEducacionais()
//    println("-----------------------------------------------------------------------------------------------------")
//    println("-----------------------------------------------------------------------------------------------------")




    //println(exibirUsuarios())
    //var teste = ConteudoEducacional(1, "a", "a",  "a",  1)
    //println(teste)



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