import casilla.Casilla
import casilla.EstadoCasilla

object Bingo: Subscriber{
    /**
     * Comprueba si el estado de las casillas es marcada o NoMarcada y devuelve bingo si
     * todas las casillas esta o MARCADAS o NULAS
     */
    fun compruebaBingo(carton: Array<Array<Casilla>>, id: Int ): Boolean {
        var contador = 0
        carton.forEach { fila ->
            fila.forEach {
            if(it.estado == EstadoCasilla.MARCADA){
                    contador++
                    if (contador == 20 ){
                        updateBingo(carton,id)
                        return true
                    }
                }
            }
        }
        return false
    }

}
