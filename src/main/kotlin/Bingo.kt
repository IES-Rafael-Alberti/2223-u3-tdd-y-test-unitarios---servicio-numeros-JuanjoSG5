import casilla.Casilla
import casilla.EstadoCasilla

object Bingo{
    /**
     * Comprueba si el estado de las casillas es marcada o NoMarcada y devuelve bingo si
     * todas las casillas esta o MARCADAS o NULAS
     */
    fun compruebaBingo(conjuntoCartones: MutableMap<Int, Array<Array<Casilla>>>): Boolean {
        var contador = 0
        var id = 0
        conjuntoCartones.values.forEach { carton ->
            carton.forEach {fila ->
                fila.forEach { casilla ->
                if( casilla.estado == EstadoCasilla.MARCADA){
                        contador++
                        if (contador == 20 ){
                            println("Ha cantado Bingo el carton $id")
                            return true
                        }
                    }
                }
            }
            contador = 0
            id++
        }
        return false
    }

}
