package casilla
data class Casilla(var fila:Int, var columna : Int, var numeroC:Int , var estado : EstadoCasilla )

enum class EstadoCasilla{
    NULL,MARCADA,NOMARCADA
}