data class ConteudoEducacional (val tipoConteudoEducacional: TipoConteudoEducacional, val nivelDificuldade: NivelDificuldade, val nome: String, val duracao: Int) { //Conteúdo educacional -> curso / desafio de código / desafio de projeto
    //TODO: Função de exibição ou criar um read-only dos conteúdos. Encaminhamento para menu (ou loop para mais criações?)
    companion object { //Solicitando ao usuário os valores que vão preencher os argumentos dessa classe
        fun cadastrarConteudoEducacional(): ConteudoEducacional {

            fun selecionarTipoConteudoEducacional(): TipoConteudoEducacional { //Função para seleção do tipo de conteúdo educacional
                println("Selecione o tipo do conteúdo educacional informando o número correspondente à esse:" +
                        "\n1 - Curso\n2 - Desafio de código\n3 - Desafio de projeto")
                val selecaoTipoConteudoEducacional = readlnOrNull() //Recebe seleção digitada por usuário

                return when (selecaoTipoConteudoEducacional) { //Seleção a partir dos itens da enum class TipoConteudoEducacional
                    "1" -> TipoConteudoEducacional.CURSO
                    "2" -> TipoConteudoEducacional.DESAFIOCODIGO
                    "3" -> TipoConteudoEducacional.DESAFIOPROJETO
                    "" -> selecionarTipoConteudoEducacional()
                    else -> {
                        println("-----Seleção inválida!-----".uppercase())
                        selecionarTipoConteudoEducacional() // Recursivo da função em caso de resposta inválida
                    }
                }
            }

            fun selecionarDificuldade (): NivelDificuldade { //Função para seleção de dificuldade a partir da enum class NivelDificuldade

                println("Selecione o nível de dificuldade informando o número correspondente à dificuldade:" +
                        "\n1 - Básico\n2 - Intermediário\n3 - Avançado")
                val selecaoDificuldade = readlnOrNull() //Recebe seleção digitada por usuário


                return when (selecaoDificuldade) { //Seleção a partir dos itens da enum class NivelDificuldade
                    "1" -> NivelDificuldade.BASICO
                    "2" -> NivelDificuldade.INTERMEDIARIO
                    "3" -> NivelDificuldade.AVANCADO
                    "" -> selecionarDificuldade() // Recursivo da função em caso de resposta inválida
                    else -> {
                        println("-----Seleção inválida!-----".uppercase())
                        selecionarDificuldade() // Recursivo da função em caso de resposta inválida
                    }
                }
            }

            fun preencherNomeConteudoEducacional(): String { //Função para preenchimento do título/nome do conteúdo educacional
                println("Informe o título/nome do conteúdo educacional:")
                val nomeTituloConteudoEducacional = readlnOrNull() //Recebe seleção digitada por usuário

                if (nomeTituloConteudoEducacional.isNullOrEmpty() || !nomeTituloConteudoEducacional.any { it.isLetterOrDigit() }) {
                    println("-----Nome inválido!-----".uppercase())
                    preencherNomeConteudoEducacional() // Recursivo da função em caso de resposta inválida
                }

                return nomeTituloConteudoEducacional.toString()
            }

            fun informarDuracaoConteudoEducacional(): Int? { //Função para informar duração em horas do conteúdo educacional
                println("Informe a duração do conteúdo em horas inteiras (Ex: 1):")
                val valorDuracaoConteudoEducacional = try {
                    readlnOrNull()?.toInt()
                } catch (e: NumberFormatException) { //Tratamento de exceção em caso de não estar no formato numérico
                    println("-----Duração inválida!-----".uppercase())
                    informarDuracaoConteudoEducacional() // Recursivo da função em caso de resposta inválida
                }

                if (readlnOrNull().isNullOrEmpty()) {
                    println("-----Preenchimento inválido!-----".uppercase())
                    informarDuracaoConteudoEducacional() // Recursivo da função em caso de resposta inválida
                }

                return valorDuracaoConteudoEducacional

            }

            //Preenchendo os argumentos de ConteudoEducacional com os retornos das funções
            val tipoConteudoEducacional = selecionarTipoConteudoEducacional()
            val dificuldadeConteudoEducacional = selecionarDificuldade()
            val nomeConteudoEducacional = preencherNomeConteudoEducacional()
            val duracaoConteudoEducacional = informarDuracaoConteudoEducacional() ?: 1

            //Retornando o preenchimento dos argumentos
            return ConteudoEducacional(tipoConteudoEducacional, dificuldadeConteudoEducacional,nomeConteudoEducacional, duracaoConteudoEducacional)

        }
    }

}
