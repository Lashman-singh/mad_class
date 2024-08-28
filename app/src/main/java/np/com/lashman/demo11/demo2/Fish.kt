package np.com.lashman.demo11.demo2

class Fish(name: String, sound: String) : Animal(name, sound){

    init {
        println("Fish make $sound sound")
    }
    fun main(){
        println("$name is swimming")
    }
}
