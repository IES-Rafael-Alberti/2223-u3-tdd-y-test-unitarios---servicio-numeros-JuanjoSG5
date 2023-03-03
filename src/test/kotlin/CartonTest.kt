
import cartones.Carton
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContain

class CartonTest:DescribeSpec({
    describe("Un carton"){
        it("marca los numeros que salen"){
            var carton = Carton()
            var bombo = Bombo
            carton.creaCartones(1)
            val cartones = carton.conjunto
            val numero = bombo.generaNumero()
            carton.marcador(numero)
            carton.conjuntoNumeros.shouldContain(numero)
        }
    }

})
