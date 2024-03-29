package objektwerks

import cask.main.Main
import com.typesafe.config.ConfigFactory
import com.typesafe.scalalogging.LazyLogging

import io.undertow.Undertow
import io.undertow.server.handlers.BlockingHandler

import objektwerks.handler.CorsHandler
import objektwerks.router.Router
import objektwerks.service.*

import scala.io.StdIn

object Server extends Main with LazyLogging:
  val store = SqlStore(ConfigFactory.load("store.conf"))
  val service = Service(store)
  val authorizer = Authorizer(service)
  val handler = Handler(service)
  val validator = Validator()
  val dispatcher = Dispatcher(authorizer, validator, handler)
  
  override val allRoutes = Seq(Router(dispatcher))

  override def port: Int = 7272

  override def host: String = "localhost"

  override def defaultHandler: BlockingHandler =
    new BlockingHandler( CorsHandler(dispatchTrie,
                                     mainDecorators,
                                     debugMode = false,
                                     handleNotFound,
                                     handleMethodNotAllowed,
                                     handleEndpointError) )
 
  override def main(args: Array[String]): Unit =
    Main.silenceJboss()
    val server = Undertow.builder
      .addHttpListener(port, host)
      .setHandler(defaultHandler)
      .build

    server.start()
    val started = s"*** Server started at http://$host:$port/\nPress RETURN to stop..."
    println(started)
    logger.info(started)

    StdIn.readLine()
    server.stop()
    val stopped = s"*** Server stopped!"
    println(stopped)
    logger.info(stopped)