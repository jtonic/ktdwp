package ro.jtonic.presentations.ktdwp.sboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder

/**
 * Created by Antonel Ernest Pazargic on 16/08/2017.
 * @author Antonel Ernest Pazargic
 */
@SpringBootApplication
class Application {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplicationBuilder().sources(Application::class.java).build().run(*args)
        }
    }
}