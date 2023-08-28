// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel {
        BASICO,
        INTERMEDIARIO,
        AVANCADO
}

data class Usuario(
        val nome: String
)

data class ConteudoEducacional(
        val nome: String,
        val duracao: Int = 60
)

data class Formacao(
        val nome: String,
        val conteudos: List<ConteudoEducacional>,
        val nivel: Nivel
) {

        val inscritos = mutableListOf<Usuario>()

        fun matricular(usuario: Usuario) {
                inscritos.add(usuario)
        }

        fun listarInscritos(space: Int): String {
				val spaces = " ".repeat(space)
            	return inscritos.map {
                		"$spaces- ${it.nome}"
                }.joinToString("\n")
        }

        fun listarConteudos(space: Int): String {
            	val spaces = " ".repeat(space)
            	return conteudos.map {
                		"$spaces- ${it.nome}\n$spaces  duração: ${it.duracao}"
            	}.joinToString("\n")
        }
}




fun main() {

    	print("criando usuários... ")
        val andre = Usuario("André")
        val joao = Usuario("João")
        val paula = Usuario("Paula")

        println("OK")



        print("criando formações e matriculando usuários... ")
        val formacao1 = Formacao(
                nome = "Princípios do desenvolvimento de software",
                nivel = Nivel.BASICO,
                conteudos = listOf(
                        ConteudoEducacional(
                                nome = "Organizando seus estudos com os Roadmaps DIO e o Notion",
                                duracao = 120
                        ),
                        ConteudoEducacional(
                                nome = "Versionamento de código com Git e Github",
                                duracao = 120
                        ),
                        ConteudoEducacional(
                                nome = "Desafios de projetos: Crie um portfólio vencedor"
                        )
                )
        ).also {
                it.matricular(joao)
                it.matricular(paula)
        }


        val formacao2 = Formacao(
                nome = "Conhecendo a linguagem de programação Kotlin",
                nivel = Nivel.BASICO,
                conteudos = listOf(
                        ConteudoEducacional(
                                nome = "Conhecendo o Kotlin e sua documentação oficial"
                        ),
                        ConteudoEducacional(
                                nome = "Introdução prática à linguagen de programação Kotlin",
                                duracao = 120
                        ),
                        ConteudoEducacional(
                                nome = "Estruturas de controle de fluxo e coleções em Kotlin",
                                duracao = 120
                        ),
                        ConteudoEducacional(
                                nome = "Orientação a objetos e tipos de classes na prática com Kotlin",
                                duracao = 120
                        ),
                ),
        ).also {
                it.matricular(andre)
        }

        println("OK")



        print("criando lista de formações... ")
        val formacoes = mutableListOf(
                formacao1,
                formacao2
        )

        println("OK")



        println("Usuários matriculados!")
        println()
        println()

        println("Relatório final")
        println("--------------------------------")

    	formacoes.forEach { formacao ->
            	println(formacao.nome)
                println("nível: ${formacao.nivel}")
                println("--------------------------------")
                println("conteúdos")

                println(formacao.listarConteudos(4))

                println("--------------------------------")
                println("inscritos")
                println(formacao.listarInscritos(4))

                println("================================")
                println()
        }
}
