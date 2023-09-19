package formacao.ConteudoEmFormacao

import formacao.*

fun editarConteudosFormacao(formacaoSelecionada: Formacao) {

    if (listaFormacoes.isEmpty()) exibirListaFormacoesVazia() //Caso a lista de formações esteja vazia, executar função exibirListaFormacoesVazia()

    println("ID: ${formacaoSelecionada.idFormacao} | NOME: ${formacaoSelecionada.nomeFormacao}\n\t↳ NÍVEL: ${formacaoSelecionada.nivelDificuldadeFormacao}\n")
    exibirConteudosFormacao(formacaoSelecionada)

    do { //Repete execução enquanto não recebe 1, 2 ou 3
        println("Selecione ação que deseja fazer informando o número correspondente:" +
                "\n1 - Adicionar conteúdo à formação\n2 - Excluir conteúdo da formação\n3 - Nenhum dos dois")
        var tecladoEditarConteudosFormacao = readlnOrNull() //Recebe escolha do usuário entre as opções


        when (tecladoEditarConteudosFormacao) {
            "1" -> selecionarConteudosFormacao(formacaoSelecionada) //Segue para seleção de conteúdos que passa parâmetro
            "2" -> excluirConteudosFormacao(formacaoSelecionada) //Segue para seleção de usuários para remoção passando parâmetro
            "3" -> println() //Encerra editarConteudosFormacao(formacaoSelecionada: Formacao)

        }

        if (tecladoEditarConteudosFormacao.isNullOrEmpty() || (!tecladoEditarConteudosFormacao.equals("1") && !tecladoEditarConteudosFormacao.equals("2") && !tecladoEditarConteudosFormacao.equals("3"))) {
            println("-----Seleção inválida!-----".uppercase()) //Imprime em caso de não passar na validação
        }

    } while (tecladoEditarConteudosFormacao.isNullOrEmpty() || (!tecladoEditarConteudosFormacao.equals("1") && !tecladoEditarConteudosFormacao.equals("2") && !tecladoEditarConteudosFormacao.equals("3")))

}