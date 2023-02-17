
import cartones.Carton
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class BingoTest: DescribeSpec( {
    describe("Un carton canta bingo cuando"){
        it("todas las casillas del carton estan marcadas"){
            val generador  = GeneradorCartones
            val cartonRelleno = generador.creaCarton(0)
            val carton = Carton(0)
            val bombo = Bombo
            val bingo = Bingo
            while (!bingo.compruebaBingo(cartonRelleno)){
                val numero = bombo.generaNumero()
                carton.marcador(cartonRelleno, numero)
            }
            bingo.compruebaBingo(cartonRelleno).shouldBe(true )
        }
    }
})