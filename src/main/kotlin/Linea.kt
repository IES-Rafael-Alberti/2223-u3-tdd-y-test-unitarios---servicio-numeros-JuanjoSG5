open class Linea {
    private var lineas = 0
    fun comprobadorLinea(carton: Array<Array<Int?>>):Int{
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
    fun comprobadorLineaHorizontal(carton: Array<Array<Int?>>): Boolean {
        lineas = 0
        val tamano = (carton.size - 1)
        var contador: Int
        for (fila in 0 .. tamano) {
            contador = 0
            for ( columna in 0 .. tamano) {
                if (carton[columna][fila] == 0) {
                    contador++
                }
            }
            if (contador == tamano) {
                lineas++
                return true
            }
        }
        return false
    }

    fun comprobadorLineaVertical(carton: Array<Array<Int?>>):Boolean{
        lineas = 0
        val tamano = (carton.size - 1)
        var contador: Int
        for (columna in 0 .. tamano) {
            contador = 0
            for (fila in 0 .. tamano) {
                if (carton[columna][fila] == 0 ) {
                    contador++
                }
            }
            if (contador == tamano) {
                lineas++
                println("Linea Vertical $lineas encontrada en la columna ${columna + 1}")
                return true
            }
        }
        return false
    }
    fun comprobadorLineaDiagonalID(carton: Array<Array<Int?>>): Boolean {
        val tamano = (carton.size - 1 )
        var contador = 0
        for (fila in 0 until tamano) {
            if (carton[fila + 1][fila] == 0) {
                contador++
            }
        }
        if (contador == tamano) {
            lineas++
            return true
        }
        contador = 0
        for (fila in 0 until tamano) {
            if (carton[fila ][fila + 1 ] == 0) {
                contador++
            }
        }
        if (contador == tamano) {
            lineas++
            return true
        }
        return false
    }
    fun comprobadorLineaDiagonalDI(carton: Array<Array<Int?>>): Boolean{
        val tamano = (carton.size - 1 )
        var contador = 0
        for (fila in 0 until tamano) {
            if (carton[fila][tamano - fila - 1] == 0) {
                contador++
            }
        }
        if (contador == tamano) {
            lineas++
            return true
        }
        contador = 0
        for (fila in 0 until tamano) {
            if (carton[fila + 1][tamano - fila ] == 0) {
                contador++
            }
        }
        if (contador == tamano) {
            lineas++
            return true
        }
        contador = 0
        for (fila in 0 until tamano) {

            if (carton[fila][tamano - fila] == 0) {
                contador++
            }
        }
        if (contador == tamano) {
            lineas++
            return true
        }
        return false
    }
}
