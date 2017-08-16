package ro.jtonic.presentations.ktdwp

/**
 * Created by Antonel Ernest Pazargic on 16/08/2017.
 * @author Antonel Ernest Pazargic
 */

data class Customer(val name: String, val customerId: Int)

data class Person(val firstName: String, val lastName: String, val age: Int = 30)

data class Product(val label: String, val price: Int)

