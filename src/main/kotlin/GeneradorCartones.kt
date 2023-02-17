import cartones.Carton
import casilla.Casilla

/**
 * Singleton con la funcionalidad de generar un carton
 */
object GeneradorCartones{
    fun creaCarton(id: Int): Array<Array<Casilla>> {
        val carton =  Carton(id)
        val cartonPendiente = carton.creaCartonVacio()
        val cartonRelleno = carton.rellenaCarton(cartonPendiente)
        carton.conjunto[id] = carton.marcarVacios(cartonRelleno)
        return carton.marcarVacios(cartonRelleno)
    }
}