package net.caoticode.futurastic

import org.elasticsearch.action.ActionRequestBuilder
import org.elasticsearch.action.ActionResponse
import org.elasticsearch.action.ActionListener

import scala.concurrent.{ Promise, Future }
import scala.util.Try

/**
 * @author Daniel Camarda (maniacal.dread@gmail.com)
 *
 */
object Futurastic {

  def execute[T, R <: ActionResponse](builder: ActionRequestBuilder[_, R, _])(action: (R) => Try[T]): Future[T] = {
    val prom = Promise[T]()

    builder.execute(new ActionListener[R] {
      def onResponse(res: R) = prom.complete(action(res))
      def onFailure(exception: Throwable) = prom.failure(exception)
    })

    prom.future
  }

}
