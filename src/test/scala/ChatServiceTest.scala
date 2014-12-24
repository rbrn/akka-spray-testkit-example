import org.specs2.mutable.Specification
import spray.testkit.Specs2RouteTest

/**
 * Created by costin on 24.12.14.
 */
class ChatServiceTest extends Specification with Specs2RouteTest  with ChatService{
  def actorRefFactory = system
  "The service" should {

    "return a greeting for GET requests to the root path" in {
      Get() ~> demoRoute ~> check {
        entityAs[String] must contain("Say hello")
      }
    }

    "return some thing from somethinelse" in {
      Get("/ping") ~> demoRoute ~> check {
        entityAs[String] must be matching ("PONG!")
      }
    }
  }

}
