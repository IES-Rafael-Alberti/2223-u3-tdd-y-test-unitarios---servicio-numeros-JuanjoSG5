
import generadorCartones.GeneradorCartones
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class BingoTest: DescribeSpec( {
    describe("Un carton canta bingo cuando"){
        it("todas las casillas del carton estan marcadas"){
            val generador  = GeneradorCartones
            val carton = generador.creaCarton(0)
            val bombo = Bombo
            val bingo = Bingo
            while (!bingo.compruebaBingo(carton)){
                val numero = bombo.generaNumero()
                generador.marcador(numero,0)
            }
            bingo.compruebaBingo(carton).shouldBe(true )
        }
    }
})