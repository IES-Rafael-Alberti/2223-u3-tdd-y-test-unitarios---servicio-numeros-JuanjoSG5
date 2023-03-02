
import cartones.Carton
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class BingoTest: DescribeSpec( {
    describe("Un carton canta bingo cuando"){
        it("todas las casillas del carton estan marcadas"){
            val generador  = GeneradorCartones
            val cartonRelleno = generador.creaCarton(0)
            val carton = Carton()
            val bombo = Bombo
            val bingo = Bingo
            while (!bingo.compruebaBingo(cartonRelleno,0)){
                val numero = bombo.generaNumero()
                numero?.let { carton.marcador(0, it) }
            }
            bingo.compruebaBingo(cartonRelleno,0).shouldBe(true )
        }
    }
})