
import generadorCartones.GeneradorCartones
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.maps.shouldContainKeys
import io.kotest.matchers.shouldBe
import io.mockk.mockk
import io.mockk.mockkObject

class GeneradorCartonesTest : DescribeSpec({

    describe("Inicializacion generador cartones") {
        it("es un singleton"){
            val generador = mockk<GeneradorCartones>()
            println(generador.creaCarton(0))

        }
        describe("que permite") {
            it("crear un carton") {
                mockkObject(GeneradorCartones)
                val generador = mockk<GeneradorCartones>()

                generador.creaCarton(0).shouldBe {
                    Array(5) { Array(5) { 0 } }
                }
            }
            it("Crear un conjunto de cartones ") {
                mockkObject(GeneradorCartones)
                val generador = mockk<GeneradorCartones>()
                generador.conjuntoCartones(5).shouldContainKeys(0,1,2,3,4)
            }
            describe(
                "Comprobar que cuando sale un numero del bombo este se encuentra o no en los" +
                        " distintos cartones ") {

                //val generador = Generad


            }
        }
    }
})
