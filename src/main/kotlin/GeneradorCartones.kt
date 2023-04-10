
import cartones.Carton
import casilla.Casilla
import casilla.EstadoCasilla
import servicio.ServicioNumero

/**
 * Singleton con la funcionalidad de generar un carton
 */
object GeneradorCartones{

    fun creaCarton(id: Int): Array<Array<Casilla>> {
        val carton = Carton()
        val cartonVacio = creaCartonVacio()
        val cartonRelleno = rellenaCarton(cartonVacio)
        val cartonFinalizado = marcarVacios(cartonRelleno)

        carton.conjunto[id] = cartonFinalizado
        return cartonFinalizado
    }


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
                    0 -> cartonVacio[columna][fila] = Casilla(fila,columna,num1[columna], EstadoCasilla.NOMARCADA)
                    1 -> cartonVacio    [columna][fila] = Casilla(fila,columna,num2[columna], EstadoCasilla.NOMARCADA)
                    2 -> cartonVacio[columna][fila] = Casilla(fila,columna,num3[columna], EstadoCasilla.NOMARCADA)
                    3 -> cartonVacio[columna][fila] = Casilla(fila,columna,num4[columna], EstadoCasilla.NOMARCADA)
                    4 -> cartonVacio[columna][fila] = Casilla(fila,columna,num5[columna], EstadoCasilla.NOMARCADA)
                }
            }
        }
        return cartonVacio
    }

    /**
     * Marca la diagonal principal del carton con un estado de nulo
     */
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

}