
import cartones.Carton
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class BingoTest: DescribeSpec( {
    describe("Un carton canta bingo cuando"){
        it("todas las casillas del carton estan marcadas"){
            val carton = Carton()
            val cartones = carton.creaCartones(2)
            val bombo = Bombo
            val bingo = Bingo
            while (!bingo.compruebaBingo(carton.conjunto)){
                val numero = bombo.generaNumero()
                numero?.let { carton.marcador(0) }
            }
            bingo.compruebaBingo(cartones).shouldBe(true )
        }
    }
})
