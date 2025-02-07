fun main() {
    val cat1 = Cat("Jimmy")
    val cat2 = Cat("Dave", 1)
    val cat3 = Cat("Nigel")

    println(cat1)
    println(cat2)
    println(cat3)

    cat1.poke()
    cat1.stroke()
    cat1.stroke()
    cat1.poke()

    println(cat1)
    cat1.makeFriends(cat3)
    println(cat1)
    println(cat3)
}

class Cat(val name: String, var legs: Int = 4) {
    var isSleeping: Boolean = false;
    var isHungry: Boolean = false;
    var bff: Cat? = null

    // Method that updates state
    fun poke() {
        if (isSleeping) {
            isSleeping = false
            println("You woke up $name!")
        }
        else {
            println("$name is angry and scratches you")
        }
    }

    // Method that updates state
    fun stroke() {
        println("$name purrrrrrrrrrs...")

        if (!isSleeping) {
            isSleeping = true
            println("$name falls asleep")
        }
    }

    // Method where data is supplied
    fun makeFriends(newFriend: Cat) {
        bff = newFriend         // Connect to them from us
        newFriend.bff = this    // Connect back to us ('this')

        println("$name is now friends with ${newFriend.name}")
    }






    // This method is run when an object is created
    init {
        println("Creating a new cat")
    }

    // This replaces the default function that prints
    // the object's ID with something more useful
    override fun toString(): String {
        var info: String = ""

        info += "Name: $name\n"
        info += "Legs: $legs\n"
        info += "Hungry: $isHungry\n"
        info += "Sleeping: $isSleeping\n"
        if (bff != null) {
            info += "Bff: ${bff!!.name}"
        }
        else {
            info += "No BFF!"
        }


        return info
    }
}









/* NOTES **************************************

    More data fields
    1. As class parameters
        - val/var
        - Some with defaults
    2. Created upon instantiation

    Constructor - init function

    Printable via toString function

    Methods for behaviour:
    - Updating data fields
    - Conditionally updating data (e.g. based on state)

    Dynamic creation
    - User input
    - Dynamic list

    Relationships between objects

 */