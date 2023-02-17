/*
class Resumen {
    fun resumen(id: Int): String {
        val carton = GeneradorCartones.copiaConjunto[id]
        for (numero in GeneradorCartones.conjuntoNumeros) {
            for (fila  in carton.indices) {
                for (columna in carton.indices) {
                    if (carton[fila][columna] == numero) {
                        carton[fila][columna] = 0
                        println("Ha salido el numero $numero en la fila: ${fila + 1} y en la columna ${columna+1}")
                        when (comprobadorLinea(carton)){
                            0 -> {
                                println("El numero $numero ha completado una linea en el carton $id, en la fila ${columna + 1}")
                                marcadorLineas(carton,fila,columna)
                            }
                            1 -> {
                                println("El numero $numero ha completado una linea en el carton $id, en la columna ${fila + 1}")
                                marcadorLineas(carton, fila, columna)
                            }
                            2 -> { if (diagonalID1(carton)){
                                println("El numero $numero ha completado una linea en el carton $id, siendo esta " +
                                        "la diagonal que ocupa las casillas 1,2 - 2,3 - 3,4 y 4,5")
                            }else if (diagonalID2(carton )){
                                println("El numero $numero ha completado una linea en el carton $id, siendo esta " +
                                        "la diagonal que ocupa las casillas 2,1 - 3,2 - 4,3 y 5,4")
                            }
                            }
                            3 -> {
                                if (diagonalDI1(carton)){
                                    println("El numero $numero ha completado una linea en el carton $id, siendo esta " +
                                            "la diagonal que ocupa las casillas 4,1 - 3,2 - 2,3 y 1,4")
                                }else if (diagonalDI2(carton )){
                                    println("El numero $numero ha completado una linea en el carton $id, siendo esta " +
                                            "la diagonal que ocupa las casillas 5,1 - 4,2 - 2,4 y 5,1")
                                }else if (diagonalDI3(carton)){
                                    println("El numero $numero ha completado una linea en el carton $id, siendo esta " +
                                            "la diagonal que ocupa las casillas 5,2 - 4,3 - 3,4 y 2,5")
                                }
                            }

                            else -> println("No ha salido ninguna linea con el numero: $numero en el carton $id")
                        }
                    }
                }
            }
        }
        return "Fin "
    }
}
*/