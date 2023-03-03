package cartones

import GeneradorCartones
import Linea
import LineaCantada
import casilla.Casilla
import casilla.EstadoCasilla


open class Carton {

    internal val conjuntoNumeros = mutableListOf<Int>()
    internal val conjunto = mutableMapOf<Int, Array<Array<Casilla>>>()
    private var estadoLineas = mutableListOf<Linea>()
    private val estadoLineasPorCarton = mutableMapOf<Int, MutableList<Linea>>()



    fun creaCartones(cantidad: Int): MutableMap<Int, Array<Array<Casilla>>> {
        var numero = 0
        while (numero < cantidad) {
            val carton = GeneradorCartones.creaCarton(numero)
            montaLineas(carton, numero)
            conjunto[numero] = carton
            estadoLineasPorCarton[numero] = estadoLineas.toMutableList()
            estadoLineas.clear()
            numero++
        }
        return conjunto
    }

    fun marcador(numero: Int?) {
        var id = 0
        conjunto.values.forEach{carton->
            carton.forEach { fila ->
                fila.forEach {
                    if (numero == it.numeroC && it.estado != EstadoCasilla.NULL) {
                        it.estado = EstadoCasilla.MARCADA
                        println("El numero $numero se encuentra en el carton: $id")
                    }
                }
            }
            id++
        }
        numero?.let { conjuntoNumeros.add(it) }
    }


    fun mostrarCarton(id: Int) {
        val carton = conjunto[id]
        carton?.forEach { fila ->
            fila.forEach { casilla ->
                print("${casilla.numeroC} ")
            }
            println()
        }
    }

    open fun montaLineas(carton: Array<Array<Casilla>>, id: Int): MutableList<Linea> {
        val dimension = (carton.size - 1)
        montarLineasHorizontales(carton, id, dimension)
        montaLineasVerticales(dimension, carton, id)
        montaLineasID(dimension, carton, id)
        montaDiagonalesDI(dimension, carton, id)
        return estadoLineas
    }

    private fun montaLineasID(dimension: Int, carton: Array<Array<Casilla>>, id: Int) {
        fun diagonalID1() {
            val casillasLinea = mutableListOf<Casilla>()
            for (fila in 0 until dimension) {
                if (carton[fila + 1][fila].estado != EstadoCasilla.NULL) {
                    casillasLinea.add(carton[fila + 1][fila])
                }
            }
            estadoLineas.add(Linea(id, casillasLinea))
        }

        fun diagonalID2() {
            val casillasLinea = mutableListOf<Casilla>()
            for (fila in 0 until dimension) {
                if (carton[fila][fila + 1].estado != EstadoCasilla.NULL) {
                    casillasLinea.add(carton[fila][fila + 1])
                }
            }
            estadoLineas.add(Linea(id, casillasLinea))
        }
        diagonalID1()
        diagonalID2()

    }

    fun creaTabla() {

    }

    private fun montaDiagonalesDI(dimension: Int, carton: Array<Array<Casilla>>, id: Int) {
        fun diagonalDI1() {
            val casillasLinea = mutableListOf<Casilla>()
            for (fila in 0 until dimension) {
                if (carton[fila][dimension - fila - 1].estado != EstadoCasilla.NULL) {
                    casillasLinea.add(carton[fila][dimension - fila - 1])
                }
            }
            estadoLineas.add(Linea(id, casillasLinea))
        }

        fun diagonalDI2() {
            val casillasLinea = mutableListOf<Casilla>()
            for (fila in 0 .. dimension) {
                if (carton[fila][dimension - fila].estado != EstadoCasilla.NULL) {
                    casillasLinea.add(carton[fila][dimension - fila])
                }
            }
            estadoLineas.add(Linea(id, casillasLinea))

        }

        fun diagonalDI3() {
            val casillasLinea = mutableListOf<Casilla>()
            for (fila in 0 until dimension) {
                if (carton[fila + 1][dimension - fila].estado != EstadoCasilla.NULL) {
                    casillasLinea.add(carton[fila + 1][dimension - fila])
                }
            }
            estadoLineas.add(Linea(id, casillasLinea))
        }
        diagonalDI1()
        diagonalDI2()
        diagonalDI3()
    }

    private fun montarLineasHorizontales(carton: Array<Array<Casilla>>, id: Int, dimension: Int) {
        for (indiceCasilla in 0..dimension) {
            val casillasLinea = mutableListOf<Casilla>()
            for (indiceLista in 0..dimension) {
                if (carton[indiceCasilla][indiceLista].estado != EstadoCasilla.NULL) {

                    casillasLinea.add(carton[indiceCasilla][indiceLista])
                }
            }
            estadoLineas.add(Linea(id, casillasLinea))
        }
    }

    private fun montaLineasVerticales(dimension: Int, carton: Array<Array<Casilla>>, id: Int) {
        for (indiceCasilla in 0..dimension) {
            val casillasLinea = mutableListOf<Casilla>()
            for (indiceLista in 0..dimension) {
                if (carton[indiceLista][indiceCasilla].estado != EstadoCasilla.NULL) {
                    casillasLinea.add(carton[indiceLista][indiceCasilla])
                }

            }
            estadoLineas.add(Linea(id, casillasLinea))
        }
    }

    fun compruebaLineaCarton() {
        var contador = 0
        estadoLineasPorCarton.values.forEach { conjuntoLineas ->
            conjuntoLineas.forEach {
                it.linea.forEach { casilla ->
                    if (casilla.estado == EstadoCasilla.MARCADA) {
                        contador++
                        if (contador == 4 ) {
                            it.cantada = LineaCantada.SI
                            println("Ha cantado la linea ${it.linea} en el carton ${it.idCarton}")

                        }
                    }

                }
                contador = 0
            }
        }

    }
}

