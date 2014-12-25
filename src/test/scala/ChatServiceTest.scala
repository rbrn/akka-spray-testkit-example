import org.specs2.mutable.Specification
import spray.testkit.Specs2RouteTest

/**
 * Created by costin on 24.12.14.
 */
class ChatServiceTest extends Specification with Specs2RouteTest  with ChatService{
  def actorRefFactory = system
  "The service" should {

    "return a greeting for GET requests to the root path" in {
      Get() ~> chatRoutes ~> check {
        entityAs[String] must contain("Please login")
      }
    }

    "calling login should login the user and return the login" in {
      Get("/login?username=costin&password=1pass2") ~> chatRoutes ~> check {
        entityAs[String] must be contain ("costin")
        entityAs[String] must contain ("and pass is 1pass2")

      }
    }
  }

}
