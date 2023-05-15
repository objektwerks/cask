package objektwerks

import cask.main.Main
import com.typesafe.scalalogging.LazyLogging

import io.undertow.Undertow

import scala.io.StdIn

import objektwerks.router.ResourceRouter

object ResourceServer extends Main with LazyLogging:
  val allRoutes = Seq(ResourceRouter())

  override def port: Int = 7070

  override def host: String = "localhost"

  override def main(args: Array[String]): Unit =
    if (!verbose) Main.silenceJboss()
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