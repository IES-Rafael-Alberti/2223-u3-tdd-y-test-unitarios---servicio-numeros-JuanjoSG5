import io.kotest.core.spec.style.DescribeSpec

class CartonTest:DescribeSpec({
    describe("Un carton"){
        it("marca los numeros que salen"){
            var generador = GeneradorCartones
            generador.creaCarton(0)
        }
    }
})