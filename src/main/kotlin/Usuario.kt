data class Usuario (var idUsuario: Int ,var nome: String, var tipoUsuario: TipoUsuario) {
    //TODO: Inserir 1 ou +. Encaminhar para menu inicial (ou loop para inserir mais?).  Verificação se usuário já existe (ver POO /equals personalizado (compara id):)

    class GerenciamentoUsuarios {

        var id = 0
        val listaUsuarios : MutableSet<Usuario> = mutableSetOf() //Lista de todos os usuários

        companion object { //Solicitando ao usuário os valores que vão preencher os argumentos dessa classe

            fun cadastrarUsuario(): Usuario {

                fun preencherNomeUsuario(): String {

                    println("Insira o nome do usuário:")
                    val nomeUsuario = readlnOrNull()

                    if (nomeUsuario.isNullOrEmpty() || nomeUsuario.any { it.isDigit() }) {
                        println("-----Nome inválido!-----".uppercase())
                        preencherNomeUsuario() // Recursivo da função em caso de resposta inválida
                    }

                    return nomeUsuario.toString()
                }

                fun definirTipoUsuario(): TipoUsuario {

                    println("Defina o tipo de usuário de usuário informando o número correspondente ao tipo:" +
                            "\n1 - Instrutor(a)\n2 - Aluno(a)")
                    val selecaoTipoUsuario = readlnOrNull()

                    return when (selecaoTipoUsuario) {
                        "1" -> TipoUsuario.INSTRUTOR
                        "2" -> TipoUsuario.ALUNO
                        "" -> definirTipoUsuario() // Recursivo da função em caso de resposta inválida
                        else -> {
                            println("-----Seleção inválida!-----".uppercase())
                            definirTipoUsuario() // Recursivo da função em caso de resposta inválida
                        }
                    }
                }

                /*TODO: Comparação com existentes fun
                //Sobrescrita da função equals: não quer fazer comparação de todas as propriedades. Quer comparar apenar id
        override fun equals (other: Any?) =
            other is User && other.id == this.id //Novo usuário (other) = User? id de other = ir de usuário?
                 */

                //Preenchendo os argumentos de Usuario com os retornos das funções
                val nomeUsuario = preencherNomeUsuario()
                val tipoUsuario = definirTipoUsuario()

                val gerenciador = GerenciamentoUsuarios() //Instanciando a classe GerenciamentoUsuario para poder gerenciar listaUsuarios
                val novoUsuario = Usuario(gerenciador.id++, nomeUsuario, tipoUsuario) //Compondo novo usuário
                gerenciador.listaUsuarios.add(novoUsuario) //Adicionando novo usuário à listaUsuarios

                //Retornando o preenchimento dos argumentos
                return novoUsuario

            }

        }

        fun exibirUsuarios() {
            listaUsuarios.sortedBy { id }
        }
        fun excluirUsuario() {
            println("___ LISTA DE USUÁRIOS ---")
            println(exibirUsuarios())
            println("--------------------")
            println("Informe o id do usuário que deseja excluir:")
        }

    }





}

