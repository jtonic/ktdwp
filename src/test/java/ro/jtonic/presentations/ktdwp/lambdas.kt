package ro.jtonic.presentations.ktdwp

import io.kotlintest.matchers.shouldBe
import io.kotlintest.matchers.shouldHave
import io.kotlintest.matchers.shouldNotBe
import io.kotlintest.matchers.substring
import org.junit.Before
import org.junit.Test

/**
 * Created by Antonel Ernest Pazargic on 17/08/2017.
 * @author Antonel Ernest Pazargic
 */

class LambdaTest {

    private lateinit var people: Set<Person>

    @Before
    fun setUp() {
    people = setOf(Person("Antonel", "Pazargic", age = 47), Person("Irina", "Stan", 27), Person("Liviu", "Pazargic"))
    }

    @Test
    fun `simple lambda test`() {

        val sum = {x: Int, y: Int -> x + y}
        sum(1, 2) shouldBe 3

        val msg = "Kotlin in action"
        {println(msg)}()
        run { println(msg) }
        run { 1 + 2 } shouldBe 3
    }

    @Test
    fun `simple lambda with collection test`() {
        people.maxBy({ p: Person -> p.age })
        people.maxBy { p: Person -> p.age }
        people.maxBy { p: Person ->
            println("age = $p.age")
            p.age
        }
        people.maxBy { p -> p.age }
        people.maxBy { it.age }
        people.maxBy(Person::age) // member reference

        val oldest: Person = people.maxBy { it.age }!!
        oldest shouldNotBe null
        oldest.firstName shouldBe "Antonel"
        oldest.lastName shouldBe "Pazargic"

        val youngest = people.minBy(Person::age)!!

        youngest shouldNotBe null
        youngest.firstName shouldBe "Irina"
        youngest.lastName shouldBe "Stan"
        youngest shouldBe Person("Irina", "Stan", 27)
    }

    @Test
    fun `joinToString with lambda example`() {
        val peopleAsString = people.joinToString(separator = "; ") { it.firstName }
        println("peopleAsString = $peopleAsString")
        peopleAsString shouldHave substring("; ")
    }

    @Test
    fun `lambda with receivers`() {
        println(peopleAsString(people))
        println(peopleToString(people))
    }

    fun peopleAsString(people: Set<Person>) = with(StringBuilder()) {
        append(people.joinToString())
        append("\nI know  all these people!")
        toString()
    }

    fun peopleToString(people: Set<Person>) = StringBuilder().apply {
        append(people.joinToString())
        append("\nI definitely know  all these people!")
    }.toString()
}