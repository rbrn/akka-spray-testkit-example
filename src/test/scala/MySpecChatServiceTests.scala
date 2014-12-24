/**
 * Created by costin on 23.12.14.
 */

import org.specs2.mutable.Specification
import spray.routing.HttpService
import spray.testkit.Specs2RouteTest

class MySpecChatServiceTests extends Specification with Specs2RouteTest with HttpService{
  def actorRefFactory = system // connect the DSL to the test ActorSystem

  val smallRoute =
    get {
      path("") {
        complete {
          <html>
            <body>
              <h1>Say hello to <i>spray</i>!</h1>
            </body>
          </html>
        }
      } ~
        path("ping") {
          complete("PONG!")
        }
    }

  "The service" should {

    "return a greeting for GET requests to the root path" in {
      Get() ~> smallRoute ~> check {
        entityAs[String] must contain("Say hello")
      }
    }
  }

}
