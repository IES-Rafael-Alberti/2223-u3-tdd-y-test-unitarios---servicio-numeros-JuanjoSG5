import casilla.Casilla

interface Subscriber{
    fun updateLinea(){

    }
    fun updateBingo(carton: Array<Array<Casilla>>, id: Int): Boolean {
        return Bingo.compruebaBingo(carton,id)
    }
    fun updateBombo(): Int? {
        return Bombo.generaNumero()
    }
}

interface Updater{

    val observers: ArrayList<Subscriber>
    fun add(observer: Subscriber) {
        observers.add(observer)
    }

    fun remove(observer: Subscriber) {
        observers.remove(observer)
    }

    fun sendUpdateNumber(numero: Int) {
        observers.forEach { it.updateBombo() }
    }/*
    fun sendNewNumber(numero: Int) {
        observers.forEach{it.update() }
    }*/
}