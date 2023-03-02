import servicio.ServicioNumero
object Bombo: Subscriber  {
    private val generador = ServicioNumero(1,76)
    private val numeros = generador.restoNumero()
    init{
        numeros.shuffle()
    }
    fun generaNumero(): Int? {
        if (numeros.isEmpty()){
            println("ha ocurrido un error ")
            return null
        }
        return numeros.removeFirst()
    }

}
