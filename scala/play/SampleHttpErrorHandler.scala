import play.api.http.HttpErrorHandler
import play.api.mvc.Results._
import play.api.mvc._

import scala.concurrent.Future

class SampleHttpErrorHandler extends HttpErrorHandler {

  override def onClientError(request: RequestHeader, statusCode: Int, message: String) = {
    Future.successful(
      // ここでstatusCodeみてよしなに
      Status(statusCode)("A client error occurred")
    )
  }

  override def onServerError(request: RequestHeader, exception: Throwable) = {
    Future.successful(
      // 開発ならexceptionのメッセージだすようにするとかもここでよしなに
      InternalServerError("A server error occurred")
    )
  }

}
