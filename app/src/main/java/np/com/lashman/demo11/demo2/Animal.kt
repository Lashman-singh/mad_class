package np.com.lashman.demo11.demo2

open class Animal(
    val name: String,
    val sound: String
){
    fun makeSound(){
        println("The $name  says $sound")
    }
}

fun main(){
    val dog = Animal(name = "dog", sound = "waoo")
    dog.makeSound()
    val cat = Animal(name = "cat", sound = "meow")
    cat.makeSound()
}