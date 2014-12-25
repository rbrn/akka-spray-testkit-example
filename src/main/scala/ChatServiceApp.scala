import akka.actor.{ActorSystem, Props}
import akka.io.IO
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration._
import spray.can.Http

/**
 * Created by costin on 23.12.14.
 */
object ChatServiceApp extends App {

  // we need an ActorSystem to host our application in
  implicit val system = ActorSystem("on-spray-can")

  // create and start our service actor
  /*val service = system.actorOf(Props[MyServiceActor], "demo-service")*/
  val secondService  = system.actorOf(Props[ChatServiceImpl], "route-demo-service")
  implicit val timeout = Timeout(5.seconds)
  // start a new HTTP server on port 8080 with our service actor as the handler
  /* IO(Http) ? Http.Bind(service, interface = "localhost", port = 8080)*/
  IO(Http) ? Http.Bind(secondService, interface = "localhost", port = 8081)
}