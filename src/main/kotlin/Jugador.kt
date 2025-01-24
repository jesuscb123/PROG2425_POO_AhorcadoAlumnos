package es.iesra.prog2425_ahorcado

class Jugador(intentosMaximos: Int) {
    var intentosMaximos = intentosMaximos
        private set(value) {
            field = value
        }

    private val letrasUsadas = mutableSetOf<Char?>()


    fun intentarLetra(letra: Char?): Boolean {
        if (letra !in letrasUsadas) {
            letrasUsadas.add(letra)
            return true
        } else {
            return false
        }
    }

    fun fallarIntento(){
        intentosMaximos -= 1
    }

   fun obtenerLetrasUsadas(): String{
       var letrasSeparadas = ""
       for(letra in letrasUsadas){
           letrasSeparadas = letra.toString() + " "
       }
       return letrasSeparadas
   }
}