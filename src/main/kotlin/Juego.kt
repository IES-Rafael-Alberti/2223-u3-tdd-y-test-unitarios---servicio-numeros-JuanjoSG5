import cartones.Carton

object Juego {
    fun partida(){
        var game = true
        val carton = Carton()
        val bombo = Bombo
        val bingo = Bingo
        carton.creaCartones(5)
        while (game){
            val numero = bombo.generaNumero()
            carton.marcador(numero)
            carton.compruebaLineaCarton()
            val fin = bingo.compruebaBingo(carton.conjunto)
            if (fin){
                game = false
            }
        }
    }
}
