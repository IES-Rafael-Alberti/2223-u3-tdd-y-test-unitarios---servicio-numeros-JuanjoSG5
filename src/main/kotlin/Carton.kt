package cartones

import GeneradorCartones
import Linea
import LineaCantada
import Subscriber
import casilla.Casilla
import casilla.EstadoCasilla


open class Carton : Subscriber {

    private val conjuntoNumeros = mutableListOf<Int>()
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

    fun marcador(idCarton: Int, numero: Int) {
        var carton = conjunto[idCarton]
        carton?.forEach { fila ->
            fila.forEach {
                if (numero == it.numeroC && it.estado != EstadoCasilla.NULL) {
                    it.estado = EstadoCasilla.MARCADA

                }
            }
        }
        conjuntoNumeros.add(numero)
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
            for (fila in 0 until dimension) {
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

    //TODO añdir una manera de que subscriber pueda acceder al conjunto de cartones, parano tener que usar carton
    // en la funcion de abajo
    fun compruebaLineaCarton(id:Int): Pair<Boolean, Int> {
        var contador = 0
        val lineas = estadoLineasPorCarton[id]
        lineas?.forEach { linea ->
            linea.linea.forEach {
                if (it.estado == EstadoCasilla.MARCADA) {
                    contador++
                    if (contador == 20) {
                        updateLinea()
                        linea.cantada = LineaCantada.SI
                        return Pair(true, linea.idCarton)
                    }
                }
            }
        }

        return Pair(false, -1)
    }
}

