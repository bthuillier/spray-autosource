package fr.bthuillier.spray.autosources.examples

/**
 *
 * User: benjaminthuillier
 * Date: 23/01/14
 * Time: 22:06
 *
 */
import spray.routing.SimpleRoutingApp
import akka.actor.ActorSystem
import fr.bthuillier.spray.autosources.directives.AutosourcesDirectives
import play.api.libs.json.{Format, Json}

object Main extends App with SimpleRoutingApp with AutosourcesDirectives {
  implicit val system = ActorSystem("my-system")


  startServer(interface = "localhost", port = 8080) {
    autosource("user", User(1, "name"))
  }
}


case class User(id: Int, name: String)

object User {
  implicit val userFormat: Format[User] = Json.format[User]
}
