import generadorCartones.GeneradorCartones
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LineasTest:DescribeSpec({
    describe("Un carton comprueba si ha salido una linea"){
        val generador  = GeneradorCartones
        val carton = generador.creaCarton(0)
        val bombo = Bombo
        it("vertical"){
            while (!generador.comprobadorLineaVertical(carton)) {
                val numero = bombo.generaNumero()
                generador.marcador(numero, 0)
            }
            generador.comprobadorLineaVertical(carton).shouldBe(true)
        }
        it("horizontal"){
            while (!generador.comprobadorLineaHorizontal(carton)){
                val numero = bombo.generaNumero()
                generador.marcador(numero,0)
            }
            generador.comprobadorLineaHorizontal(carton).shouldBe(true)
        }
        it("diagonal de izquierda a derecha") {
            while (!generador.comprobadorLineaDiagonalID(carton)) {
                val numero = bombo.generaNumero()
                generador.marcador(numero, 0)
            }
            generador.comprobadorLineaDiagonalID(carton ).shouldBe(true )
        }
        it("diagonal de derecha a izquierda"){
            while (!generador.comprobadorLineaDiagonalDI(carton)) {
                val numero = bombo.generaNumero()
                generador.marcador(numero, 0)
            }
            generador.comprobadorLineaDiagonalDI(carton ).shouldBe(true )
        }
    }
})