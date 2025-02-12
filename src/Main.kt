/**
 * Intro to OOP looking at the creation
 * and use of classes and objects
 */


/**
 * The main() method is the entry point for
 * any Kotlin program
 */
fun main() {
    // Let's make some cats
    val cat1 = Cat("Jimmy")
    val cat2 = Cat("Dave", 1)
    val cat3 = Cat("Nigel")

    println(cat1)
    println(cat2)
    println(cat3)

    // Play with the cats
    cat1.poke()
    cat1.stroke()
    cat1.stroke()
    cat1.poke()

    // Manipulate the cat friendships
    println(cat1)
    cat1.makeFriends(cat3)
    println(cat1)
    println(cat3)

    //-----------------------------------------

    // Let's make a few rooms
    val bedroom = Room("Bedroom", 3, 4, 5)
    val kitchen = Room("Kitchen", 3, 5, 6)

    bedroom.info()
    kitchen.info()
}


/**
 * Cat class, tracking name and other key data
 * Cats can be woken, stroked, make friends, etc.
 */
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


/**
 * Room class defining a physical room with h, w, d
 */
class Room(
    val name: String,
    val height: Int,
    val width: Int,
    val depth: Int
) {

    fun volume(): Int {
        // Return the volume of the room = h*w*l
        return height * width * depth
    }

    fun area(): Int {
        val walls = width * height * 2 + depth * height * 2
        val floor = width * depth
        val ceiling = floor
        return walls + floor + ceiling
    }

    fun info() {
        println("----------------------------")
        println("Room: $name")
        println("Dimensions: ${height}m tall, ${width}m wide, ${depth}m deep")
        println("Volume: ${volume()}m³")
        println("Area: ${area()}m²")
    }
}