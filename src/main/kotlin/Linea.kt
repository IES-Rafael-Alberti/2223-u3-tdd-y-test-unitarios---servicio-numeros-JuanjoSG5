import casilla.Casilla

enum class LineaCantada {
    SI, NO
}

/**
 * Representa una línea del cartón y su estado, y su estado. Estructura util para saber si hay o no línea,.
 */
data class Linea(val idCarton: Int, val linea: MutableList<Casilla> =mutableListOf(), var cantada:LineaCantada=LineaCantada.NO)

/*
open class Linea(carton: Array<Array<Casilla>>){


    lateinit var lineasHorizontales : MutableList<Array<Casilla>>
    lateinit var lineasVerticales : MutableList<Array<Casilla>>
    lateinit var lineasDiagonales : MutableList<Array<Casilla>>



    fun comprobadorLinea(carton: Array<Array<Casilla>>):Int{
        return if (comprobadorLineaHorizontal(carton)){
            0
        }else if (comprobadorLineaVertical(carton)){
            1
        } else if (comprobadorLineaDiagonalID(carton)){
            2
        }else if (comprobadorLineaDiagonalDI(carton)){
            3
        }else -1
    }
    internal fun comprobadorLineaHorizontal(carton: Array<Array<Casilla>>): Boolean {
        val tamano = (carton.size - 1)
        var contador: Int
        carton.forEach {fila ->
            contador = 0
            lineasHorizontales.add(fila)
            fila.forEach{
                if (it.estado == EstadoCasilla.MARCADA) {
                    contador++
                }
            }
            if (contador == tamano) {
                return true
            }
        }
        return false

    }

    internal fun comprobadorLineaVertical(carton: Array<Array<Casilla>>):Boolean{
        val tamano = (carton.size - 1)
        var contador: Int
        for (columna in 0 .. tamano) {
            contador = 0
            for (fila in 0 .. tamano) {
                if (carton[columna][fila].estado == EstadoCasilla.MARCADA ) {
                    contador++
                }
            }
            if (contador == tamano) {
                return true
            }
        }
        return false
    }
    internal fun comprobadorLineaDiagonalID(carton: Array<Array<Casilla>>): Boolean {
        return if (diagonalID1(carton)){
            true
        }else if (diagonalID2(carton )){
            true
        }else return false
    }
    internal fun diagonalID1(carton: Array<Array<Casilla>>): Boolean {
        val tamano = (carton.size - 1 )
        var contador = 0
        for (fila in 0 until tamano) {
            if (carton[fila + 1][fila].estado == EstadoCasilla.MARCADA) {
                contador++
            }
        }
        if (contador == tamano) {

            return true
        }
        return false
    }
    internal fun diagonalID2(carton: Array<Array<Casilla>>): Boolean {
        val tamano = (carton.size - 1 )
        var contador = 0
        for (fila in 0 until tamano) {
            if (carton[fila][fila + 1].estado == EstadoCasilla.MARCADA) {
                contador++
            }
        }
        if (contador == tamano) {
            return true
        }
        return false

    }
    internal fun comprobadorLineaDiagonalDI(carton: Array<Array<Casilla>>): Boolean  {
        return if (diagonalDI1(carton)){
            true
        }else if (diagonalDI2(carton )){
            true
        }else diagonalDI3(carton)

    }
    private fun diagonalDI1(carton: Array<Array<Casilla>>):Boolean {
        val tamano = (carton.size - 1 )
        var contador = 0
        for (fila in 0 until tamano) {
            if (carton[fila][tamano - fila - 1].estado == EstadoCasilla.MARCADA) {
                contador++
            }
        }
        if (contador == tamano) {

            return true
        }
        return false
    }
    private fun diagonalDI2(carton: Array<Array<Casilla>>): Boolean{
        val tamano = (carton.size - 1 )
        var contador = 0
        for (fila in 0 until tamano) {
            if (carton[fila][tamano - fila].estado == EstadoCasilla.MARCADA) {
                contador++
            }
        }
        if (contador == tamano) {

            return true
        }
        return false
    }
    private fun diagonalDI3(carton: Array<Array<Casilla>>):Boolean{
        var tamano = (carton.size - 1 )
        var contador = 0
        for (fila in 0 until tamano) {
            if (carton[fila + 1][tamano - fila ].estado == EstadoCasilla.MARCADA) {
                carton[fila + 1][tamano - fila ]
                contador++
            }
        }
        if (contador == tamano) {
            return true
        }
        return false
    }
*/

