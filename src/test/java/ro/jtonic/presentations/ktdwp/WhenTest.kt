package ro.jtonic.presentations.ktdwp

import io.kotlintest.matchers.shouldBe
import org.junit.Test

/**
 * Created by Antonel Ernest Pazargic on 16/08/2017.
 * @author Antonel Ernest Pazargic
 */
class WhenTest {

    fun asString(target: Any) =
            when(target) {
                is String -> target
                is Person -> "${target.firstName} ${target.lastName}"
                is Product -> target.label
                is Customer -> target.name
                else -> "Undefined name"
            }

    @Test
    fun `test when 1`() {
        asString(Any()) shouldBe "Undefined name"
        asString("Antonel") shouldBe "Antonel"
        asString(Product(label = "Tesla", price = 25000)) shouldBe "Tesla"
        asString(Person(firstName = "Antonel", lastName = "Pazargic")) shouldBe "Antonel Pazargic"
        asString(Customer(name = "Irina Stan", customerId = 1)) shouldBe "Irina Stan"
    }

}
