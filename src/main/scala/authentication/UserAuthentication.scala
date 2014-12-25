package authentication

import spray.routing.AuthenticationFailedRejection
import spray.routing.AuthenticationFailedRejection.CredentialsMissing
import spray.routing.authentication.{Authentication, ContextAuthenticator}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
 * Created by costin on 25.12.14.
 */

case class User(userName:String, token:String)
trait UserAuthentication {

   lazy val configusername = "costin"
   lazy val configpassword = "1pass2"

  def authenticateUser: ContextAuthenticator[User] = {
    ctx =>
    {
      //get username and password from the url
      val usr = ctx.request.uri.query.get("username").get
      val pwd = ctx.request.uri.query.get("password").get

      doAuth(usr, pwd)
    }
  }

  private def doAuth(userName: String, password: String): Future[Authentication[User]] = {
    //here you can call database or a web service to authenticate the user
    Future {
      Either.cond(password == configpassword && userName == configusername,
        User(userName = userName, token = java.util.UUID.randomUUID.toString),
        AuthenticationFailedRejection(cause = CredentialsMissing, challengeHeaders = Nil))
    }
  }

}
