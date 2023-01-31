package generadorCartones
import Linea
import servicio.ServicioNumero

object GeneradorCartones: Linea()   {


    private val conjunto = mutableMapOf<Int,Array<Array<Int?>>>()
    private val copiaConjunto = mutableListOf<Array<Array<Int?>>>()
    private val conjuntoNumeros = mutableListOf<Int>()
    private val numerosCarton = mutableListOf<Int>()

    fun creaCarton(id: Int): Array<Array<Int?>> {
        fun creaCartonVacio(): Array<Array<Int?>> {
            val filas = 5
            val columnas = 5
            return Array(filas) { Array(columnas) { 0 } }
        }
        fun rellenaCarton(cartonVacio: Array<Array<Int?>>): Array<Array<Int?>> {
            val num1 = ServicioNumero(1, 16).restoNumero()
            val num2 = ServicioNumero(16,31).restoNumero()
            val num3 = ServicioNumero(31, 46).restoNumero()
            val num4 = ServicioNumero(46, 61).restoNumero()
            val num5 = ServicioNumero(61, 76).restoNumero()
            for (fila in cartonVacio.indices) {
                for (columna in cartonVacio.indices){
                    when (fila) {
                        0 -> cartonVacio[fila][columna] = num1[columna]
                        1 -> cartonVacio[fila][columna] = num2[columna]
                        2 -> cartonVacio[fila][columna] = num3[columna]
                        3 -> cartonVacio[fila][columna] = num4[columna]
                        4 -> cartonVacio[fila][columna] = num5[columna]
                    }
                    if (columna == fila){
                        cartonVacio[fila][columna] = null
                    }
                }
            }

            return cartonVacio
        }
        val cartonPendiente = creaCartonVacio()
        val carton =  rellenaCarton(cartonPendiente)
        val copiaCarton = carton.map { it.copyOf() }.toTypedArray()
        copiaConjunto.add(copiaCarton)
        conjunto[id] = carton
        return carton
    }

    fun conjuntoCartones(cantidad :Int ): MutableMap<Int, Array<Array<Int?>>> {
        var numero = 0
        while (numero < cantidad){
            conjunto[numero] = creaCarton(numero)
            numero++
        }
        return conjunto
    }
    fun marcador(numero: Int,id: Int){
        val carton = conjunto[id]
        if (carton != null) {
            for (fila in carton.indices) {
                for (columna in carton.indices ) {
                    if (carton[fila][columna] == numero) {
                        numerosCarton.add(numero)
                        copiaConjunto
                        carton[fila][columna] = 0
                    }
                }
            }
        }
        conjuntoNumeros.add(numero)
    }


    fun mostrarCarton(id: Int){
        val carton = conjunto[id]
        if (carton != null) {
            for (fila in carton ){
                println(fila.joinToString("   "))
                println()
            }
        }
    }
    fun resumen(id: Int): String {
        val carton = copiaConjunto[id]
        for (numero in conjuntoNumeros) {
            for (fila  in carton.indices) {
                for (columna in carton.indices) {
                    if (carton[fila][columna] == numero) {
                        carton[fila][columna] = 0
                        println("Ha salido el numero $numero en la fila: ${fila + 1} y en la columna ${columna+1}")
                        when (comprobadorLinea(carton)){
                            0 -> println("El numero $numero ha completado una linea en el carton $id, en la fila ${columna +1}")
                            1 -> println("El numero $numero ha completado una linea en el carton $id, en la columna ${fila+1}")
                            2 -> println("El numero $numero ha completado una linea en el carton $id, en la diagonal " +
                                    " de izquierda a derecha que empieza en la fila ${fila+1}, columna ${columna+1} y " +
                                    "termina en la fila ${columna+1} y en la columna ${fila+1}")
                            3 -> println("El numero $numero ha completado una linea en el carton $id, en la diagonal " +
                                    " de derecha a izquierda que empieza en la fila ${fila+1}, columna ${columna+1} y " +
                                    "termina en la fila ${columna+1} y en la columna ${fila+1}")

                            else -> println("No ha salido ninguna linea con el numero: $numero en el carton $id")
                        }
                    }
                }
            }
        }
    return "Fin "
    }
}