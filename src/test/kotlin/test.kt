
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class Testing : DescribeSpec({
    describe("Un servicio de numeros"){

        describe("se inicializa con un maximo y un minimo") {
            it("si el maximo es menor o igual al minimo lanza excepcion ") {
                shouldThrow<Exception> {
                    ServicioNumero(2, 1)
                }
            }
        }
        describe("Solicita un unico numero ") {
            val servicio = ServicioNumero(0,1)
            it("devuelve un numero aleatorio entre ellos") {
                servicio.devuelveNumero().shouldBe(0)
                servicio.devuelveNumero().shouldNotBe(1)
            }
        }
        describe("solicitar los numeros restantes de la lista."){
            val serviciotest = ServicioNumero(0,10)
            it("Devuelve una lista con el resto de numeros restantes en un orden aleatorio"){
                serviciotest.restoNumero().shouldContainExactlyInAnyOrder(0,1,2,3,4,5,6,7,8,9)

            }
        }
        describe("Solicitar el resto de numeros en la lista"){
            val servicio = ServicioNumero(0,2)
            it("devolviendo la lista con el resto de numeros"){

                servicio.listaNnumero(1).shouldContainExactlyInAnyOrder(0,1)
            }
        }
    }
})