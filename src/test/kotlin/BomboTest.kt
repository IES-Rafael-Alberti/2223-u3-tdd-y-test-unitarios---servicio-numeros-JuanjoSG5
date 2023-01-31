import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.ints.shouldBeBetween

class BomboTest : DescribeSpec({
    describe("El bombo ") {
        it("genera un numero "){
            val bombo = Bombo
            val numero = bombo.generaNumero()
            numero.shouldBeBetween(1,76)
        }
    }
})