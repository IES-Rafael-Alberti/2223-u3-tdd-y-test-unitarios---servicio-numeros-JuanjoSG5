package cartones

import GeneradorCartones
import Linea
import casilla.Casilla
import casilla.EstadoCasilla
import servicio.ServicioNumero

data class NumerosCarton(val idCarton: String, val numeros: List<MutableList<Casilla>> = List(5){ mutableListOf() })

open class Carton(id: Int){
    private val numerosCarton = mutableListOf<Int>()
    private val conjuntoNumeros = mutableListOf<Int>()
    internal val conjunto = mutableMapOf<Int,Array<Array<Casilla>>>()
    private lateinit var estadoLineas : MutableList<Linea>
    internal val cartones = mutableMapOf<Int,Array<Array<Casilla>>>()



    /**
     * Crea un carton con valores predeterminados de 0 y sin marcar ninguna casilla
     */
    internal fun creaCartonVacio(): Array<Array<Casilla>> {
        val tamano = 5
        return Array(tamano) { Array(tamano) { Casilla(0, 0, 0, EstadoCasilla.NOMARCADA) } }
    }
    /**
     * Rellena el carton con las condiciones establecidas: numeros por columna y establece la diagonal
     * pricipal del carton ocmo nula
     */
    internal fun rellenaCarton(cartonVacio: Array<Array<Casilla>>): Array<Array<Casilla>> {
        val num1 = ServicioNumero(1, 16).restoNumero()
        val num2 = ServicioNumero(16,31).restoNumero()
        val num3 = ServicioNumero(31, 46).restoNumero()
        val num4 = ServicioNumero(46, 61).restoNumero()
        val num5 = ServicioNumero(61, 76).restoNumero()
        for (fila in cartonVacio.indices) {
            for (columna in cartonVacio.indices){
                when (fila) {
                    0 -> cartonVacio[fila][columna] = Casilla(fila,columna,num1[columna],EstadoCasilla.NOMARCADA)
                    1 -> cartonVacio[fila][columna] = Casilla(fila,columna,num2[columna],EstadoCasilla.NOMARCADA)
                    2 -> cartonVacio[fila][columna] = Casilla(fila,columna,num3[columna],EstadoCasilla.NOMARCADA)
                    3 -> cartonVacio[fila][columna] = Casilla(fila,columna,num4[columna],EstadoCasilla.NOMARCADA)
                    4 -> cartonVacio[fila][columna] = Casilla(fila,columna,num5[columna],EstadoCasilla.NOMARCADA)
                }
            }
        }
        return cartonVacio
    }
    internal fun marcarVacios(cartonRelleno: Array<Array<Casilla>>):Array<Array<Casilla>> {
        cartonRelleno.forEach { filas ->
            filas.forEach {
                if (it.columna == it.fila) {
                    it.estado = EstadoCasilla.NULL
                    it.numeroC = 0
                }
            }
        }

        return cartonRelleno
    }
    fun creaConjuntoCartones(cantidad :Int ): MutableMap<Int,Array<Array<Casilla>>> {
        var numero = 0
        while (numero < cantidad){
            val carton = GeneradorCartones.creaCarton(numero)
            cartones[numero] = carton
            numero++
        }
        return cartones
    }
    fun marcador(carton: Array<Array<Casilla>>, numero: Int){
        carton.forEach{ fila ->
            fila.forEach {
                if (numero == it.numeroC){
                    it.estado = EstadoCasilla.MARCADA
                }
            }
        }
        conjuntoNumeros.add(numero)
    }


    fun mostrarCarton(id: Int){
        var carton = conjunto[id]
        if (carton != null) {
            for (fila in carton ){
                println(fila.joinToString("   "))
                println()
            }
        }
    }
    private fun montaLineas(carton:Array<Array<Casilla>>,id: Int) {
        var indiceEstadoLinea = 0
        estadoLineas = MutableList(carton.size * 3) {
            Linea(id)
        }
        //Lineas Horizontales
        carton.forEach { filaCasillas ->
            filaCasillas.filter { it.estado != EstadoCasilla.NULL }.forEach { casilla ->
                estadoLineas[indiceEstadoLinea].linea.add(casilla)
            }
            indiceEstadoLinea++
        }
        //Lineas Verticales
        val dimension = carton.size
        for (indiceCasilla in 0 until dimension) {
            for (indiceLista in 0 until dimension)
                if (carton[indiceLista][indiceCasilla].estado != EstadoCasilla.NULL)
                    estadoLineas[indiceEstadoLinea].linea.add(carton[indiceLista][indiceCasilla])
            indiceEstadoLinea++
        }

        //Diagonales I-D\
        for (indice in 0 until dimension - 1) {
            estadoLineas[indiceEstadoLinea].linea.add(carton[indice][indice + 1])
            estadoLineas[indiceEstadoLinea + 1].linea.add(carton[indice + 1][indice])
        }
        // Diagonal
        for (indice in 0 until dimension - 1) {
            estadoLineas[indiceEstadoLinea].linea.add(carton[indice][indice + 1])
            estadoLineas[indiceEstadoLinea + 1].linea.add(carton[indice + 1][indice])
        }

    }
}
