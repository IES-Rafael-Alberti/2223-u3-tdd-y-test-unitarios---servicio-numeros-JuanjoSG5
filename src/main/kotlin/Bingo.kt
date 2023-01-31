object Bingo {
    fun compruebaBingo(carton: Array<Array<Int?>>): Boolean {
        var contador = 0
        for (fila in carton.indices){
            for (columna in carton.indices){
                if (carton[fila][columna] == 0 ){
                    contador ++
                    if (contador == 20){
                        return true
                    }
                }
            }
        }
        return false
    }

}
