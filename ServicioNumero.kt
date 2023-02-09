class ServicioNumero(private var min: Int = 0, private var max: Int = 100) {

    private var lista = mutableListOf<Int>()
    init{
        require(min < max){"El parametro maximo no puede ser mayor que el "}
        for (numero in min .. max){
            lista.add(numero)
        }
        lista.removeLast()
        lista.shuffle()
    }
    fun devuelveNumero():Int? =lista.removeFirstOrNull()


    fun listaNnumero(interceptor: Int):MutableList<Int> {
        return if (interceptor >= lista.size){
            val listado: MutableList<Int> = lista
            lista.clear()
            listado
        }else {
            val list: MutableList<Int> = mutableListOf()
            while ( list.size <= interceptor) {
                list.add(lista[0])
                lista.removeAt(0)
            }
            list
        }
    }
    fun restoNumero(): MutableList<Int> {
        val contenedor = mutableListOf<Int>()
        while (contenedor.size < (max-min)) {
            contenedor.add(lista[0])
            lista.removeAt(0)

        }
        return contenedor
    }
    fun nuevosNumeros(): ServicioNumero {
        return ServicioNumero(min, max)
    }
}
