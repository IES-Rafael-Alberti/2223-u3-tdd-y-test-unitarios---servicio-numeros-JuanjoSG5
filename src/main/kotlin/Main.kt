

fun main() {
    println("Introduzca el minimo(el predeterminado es 0)")
    val min = readln()
    println("Introduzca el maximo(el predeterminado es 100) ")
    val max = readln()
    var servicio = ServicioNumero(min.toInt(), max.toInt())
    do {
        println("Introduzca como dese ver el servicio: random(aleatorio), resto(numeros restantes), lista(numeros " +
                "restantes hasta otro numero),nuevo(genera un nuevo servicio) y  fin (salir)")
        val tipo = readln()
        when (tipo) {
            "random" -> {
                println(servicio.devuelveNumero())
            }
            "resto" -> println(servicio.restoNumero())
            "lista"-> {
                println("Introduzca cuando desee parar para devulver la lista de numeros restantes")
                val interceptor = readln()
                try{
                    interceptor.toInt()
                }catch (e: Exception){println(
                    "Introduzca un numero ")
                }
                println(servicio.listaNnumero(interceptor.toInt()))

            }
            "nuevo"-> {
                println("Minimo(Predeterminado es 0)")
                val minimo = readln()
                println("Maximo(el predeterminado es 100) ")
                val maximo = readln()
                val serviciotest = ServicioNumero(minimo.toInt(),maximo.toInt()).nuevosNumeros()
                servicio = serviciotest
            }
        }


    }while (tipo != "fin")

}