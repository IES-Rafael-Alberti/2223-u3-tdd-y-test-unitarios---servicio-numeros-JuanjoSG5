import generadorCartones.GeneradorCartones
import io.kotest.core.spec.style.DescribeSpec

class ResumenTest: DescribeSpec( {
    describe("Al conseguir una linea debe:"){
        it("test"){
            val generador = GeneradorCartones
            val bombo = Bombo
            val carton = generador.creaCarton(0)
            while (!generador.comprobadorLineaVertical(carton)) {
                val numero = bombo.generaNumero()
                generador.marcador(numero, 0)
            }
            generador.resumen(0)
        }
    }
})