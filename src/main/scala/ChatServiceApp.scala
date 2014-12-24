import akka.actor.ActorSystem

/**
 * Created by costin on 23.12.14.
 */
object ChatServiceApp {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("chat-service-system")

    val hostname = Settings(system).hostName
    val port = Settings(system).port
    val timeout = Settings(system).timeOut

    system.awaitTermination()
  }
}
