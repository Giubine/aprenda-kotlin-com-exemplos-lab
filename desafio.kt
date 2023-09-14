enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel = calcularNivel(duracao))

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
    
}
    
    fun calcularNivel(duracao: Int): Nivel {
    return when {
        duracao <= 60 -> Nivel.BASICO
        duracao <= 120 -> Nivel.INTERMEDIARIO
        else -> Nivel.DIFICIL
    }
    }

fun main() {
  
    val conteudo1 = ConteudoEducacional("Introdução à Programação", 90) 
    val conteudo2 = ConteudoEducacional("Banco de Dados SQL", 120)
    val conteudo3 = ConteudoEducacional("Desenvolvimento Web", 150)

    val formacao1 = Formacao("Desenvolvedor Web Full-Stack", listOf(conteudo1, conteudo2, conteudo3))
    val formacao2 = Formacao("Analista de Dados", listOf(conteudo2))

    val usuario1 = Usuario()
    val usuario2 = Usuario()


    formacao1.matricular(usuario1)
    formacao1.matricular(usuario2)
    formacao2.matricular(usuario1)
    
    formacao1.conteudos.forEach { conteudo ->
        println("${conteudo.nome} - Nível: ${conteudo.nivel}")
    }
    formacao2.conteudos.forEach { conteudo ->
        println("${conteudo.nome} - Nível: ${conteudo.nivel}")
    }

    println("Inscritos na Formação 1: ${formacao1.inscritos}, nível")
    println("Inscritos na Formação 2: ${formacao2.inscritos}, nível")
}
