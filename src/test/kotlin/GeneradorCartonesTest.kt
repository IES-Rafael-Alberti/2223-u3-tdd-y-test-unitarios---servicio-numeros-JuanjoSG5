
import cartones.Carton
import casilla.Casilla
import casilla.EstadoCasilla
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.ints.shouldBeBetween
import io.kotest.matchers.maps.shouldContainKeys
import io.kotest.matchers.types.shouldBeInstanceOf

class GeneradorCartonesTest : DescribeSpec({
    describe("Inicializacion generador cartones") {
        describe("que permite ") {
            it("crear un carton") {
                val generador = GeneradorCartones
                val carton = generador.creaCarton(0).shouldBeInstanceOf<Array<Array<Casilla>>>()
                carton.forEach { fila ->
                    fila.forEach {
                        it.fila.shouldBeBetween(0, 4)
                        it.columna.shouldBeBetween(0, 4)

                    }
                }
            }
            it("Crear un conjunto de cartones ") {
                val carton = Carton(0)
                carton.creaConjuntoCartones(5).shouldContainKeys(0, 1, 2, 3, 4)
            }


            it("Cada casilla esta sin marcar") {
                val generador = GeneradorCartones
                val carton = generador.creaCarton(0)
                carton.forEach { fila ->
                    fila.forEach {
                        it.estado.shouldBeInstanceOf<EstadoCasilla>()

                    }
                }
            }
            it("Los numeros en el carton son los solicitados") {
                val generador = GeneradorCartones
                val carton = generador.creaCarton(0)
                carton.forEach { fila ->
                    fila.forEach {
                        it.numeroC.shouldBeBetween(0, 75)
                    }
                }
            }
        }
    }
})
