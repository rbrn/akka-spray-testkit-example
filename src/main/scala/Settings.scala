import akka.actor.{Extension, ExtendedActorSystem, ExtensionKey}

import scala.concurrent.duration._

/**
 * Created by costin on 23.12.14.
 */
object Settings extends ExtensionKey[Settings]
class Settings(system:ExtendedActorSystem) extends Extension{

    val hostName = system.settings.config  getString "chatapp.hostname"
    val port = system.settings.config getInt "chatapp.port"
    val timeOut:FiniteDuration =
      Duration(system.settings.config.getDuration("chatapp.duration", MILLISECONDS), MILLISECONDS)

}

