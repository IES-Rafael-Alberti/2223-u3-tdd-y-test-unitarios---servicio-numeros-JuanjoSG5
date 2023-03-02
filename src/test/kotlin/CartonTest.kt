
import cartones.Carton
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeTrue

class CartonTest:DescribeSpec({
    describe("Un carton"){
        it("marca los numeros que salen"){
            var carton = Carton()
            var bombo = Bombo
            carton.creaCartones(2)
            for (id in 0..1){
                while (!carton.compruebaLineaCarton(id).first) {
                    val numero = bombo.generaNumero()
                    numero?.let { carton.marcador(id, it) }
                }
                carton.compruebaLineaCarton(id).first.shouldBeTrue()
            }
        }
    }
    describe("test"){
        it("test"){
            var carton = Carton()
            carton.creaCartones(2)
            carton.mostrarCarton(0)
            carton.mostrarCarton(1)
        }
    }
})