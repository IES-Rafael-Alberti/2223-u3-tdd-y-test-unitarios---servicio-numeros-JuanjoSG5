import casilla.Casilla

enum class LineaCantada {
    SI, NO
}

/**
 * Representa una línea del cartón y su estado, y su estado. Estructura util para saber si hay o no línea,.
 */
data class Linea(var idCarton: Int, val linea: MutableList<Casilla> =mutableListOf(), var cantada:LineaCantada=LineaCantada.NO)

