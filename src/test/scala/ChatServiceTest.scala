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

    "calling api to get messages should return the current history of the conversation" in {
      Get("/chat/messages") ~> chatRoutes ~> check {
        entityAs[List[Message]].length must not be null
        entityAs[List[Message]].length must be 10
      }

      "calling api to get messages from a certain point should return only those messages filtered" in {
        Get("/chat/messages/?since=122324234") ~> chatRoutes ~> check {
          entityAs[List[Message]].length must not be null
          entityAs[List[Message]].length must be 5
        }
      }

    }
  }

}
