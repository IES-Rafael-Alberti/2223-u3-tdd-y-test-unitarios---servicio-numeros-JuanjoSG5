import servicio.ServicioNumero
object Bombo {
    private val generador = ServicioNumero(1,76)
    private val numeros = generador.restoNumero()
    fun generaNumero(): Int {
        numeros.shuffle()
        return numeros.removeFirst()
    }

}
