package es.iesra.prog2425_ahorcado

class Juego(val palabra: Palabra, val jugador: Jugador) {


    fun iniciar() {
        var introduccion = """
                            ¡Bienvenido al juego del Ahorcado!
                            La palabra tiene ${palabra.palabraOculta.length} letras.
                            """.trimIndent()




        println(introduccion)
        while (!palabra.esCompleta() && jugador.intentosMaximos > 0) {
            println("Palabra: ${palabra.progreso}")
            println("Intentos restantes: ${jugador.intentosMaximos}")
            println("Letras usadas: ${jugador.obtenerLetrasUsadas()}")
            println("Introduce una letra")
            var letra: Char? = null
            var entrada: Char? = null
            while (entrada == null) {
                entrada = readln().lowercase().firstOrNull()
                if (entrada != null) {
                    letra = entrada
                } else {
                    println("Letra no válida o ya utilizada. Intenta otra vez.")
                }
            }
            if (!jugador.intentarLetra(letra)) {
                println("Letra no válida o ya utilizada. Intenta otra vez")
            } else {
                if (letra != null) {
                    if (letra in palabra.palabraOculta) {
                        println("¡Bien hecho! la letra $letra está en la palabra.")
                        palabra.revelarLetra(letra)
                    } else {
                        println("La letra $letra no está en la palabra")
                        jugador.fallarIntento()
                    }


                }
            }
        }
        if (palabra.esCompleta()) {
            println("\n¡Felicidades! Has adivinado la palabra: ${palabra.obtenerProgreso()}")
        } else {
            println("\nLo siento, te has quedado sin intentos. La palabra era: ${palabra.palabraOculta}")
        }
    }

    fun preguntar(msj: String): Boolean {
        do {
            print("$msj (s/n): ")
            val respuesta = readln().trim().lowercase()
            when (respuesta) {
                "s" -> return true
                "n" -> return false
                else -> println("Respuesta no válida! Inténtelo de nuevo...")
            }
        } while (true)
    }
}

