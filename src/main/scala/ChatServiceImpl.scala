
import akka.actor.{Actor, ActorLogging}
import authentication.UserAuthentication
import spray.routing.HttpService
import spray.routing.authentication.UserPass

/**
 * Created by costin on 23.12.14.
 */
class ChatServiceImpl extends Actor with ChatService with ActorLogging {
  def receive = runRoute(chatRoutes)

  def actorRefFactory = context
}

trait ChatService extends HttpService with UserAuthentication {

  implicit def executionContext = actorRefFactory.dispatcher

  val chatRoutes = {
    get {
      pathSingleSlash {
        complete(index)
      } ~
        path("login") {
          parameters('username.as[String], 'password.as[String])
            .as(UserPass) { loggedUser => authenticate(authenticateUser) { user =>
            complete("user is authenticated as " + loggedUser.user + " and pass is " + loggedUser.pass)
          }
          }
        }
    }
  }

  val index =
    <html>
      <body>
        <h1>Please login!</h1>
        <p>Defined resources:</p>
        <ul>
          <li>
            <a href="/login?username=costin">/login</a>
          </li>
        </ul>
      </body>
    </html>
}
