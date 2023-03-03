
import cartones.Carton
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe

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
        it("permite crear tablas para mostrar la informacion de los cartones"){
            var carton = Carton()
            carton.creaCartones(1)
            var test = Kformat.table
            carton.creaTabla().shouldBe(Kformat.table)
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