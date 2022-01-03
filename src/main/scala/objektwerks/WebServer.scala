package objektwerks

import cask.main.Main
import cask.main.MainRoutes
import com.typesafe.scalalogging.LazyLogging

import io.undertow.Undertow

import objektwerks.router.WebRouter

import scala.io.StdIn

object WebServer extends Main with LazyLogging:
  val allRoutes = Seq(WebRouter())

  override def port: Int = 7070
  override def host: String = "localhost"

  override def main(args: Array[String]): Unit =
    if (!verbose) Main.silenceJboss()
    val server = Undertow.builder
      .addHttpListener(port, host)
      .setHandler(defaultHandler)
      .build

    server.start()
    val started = s"*** Web Server started at http://$host:$port/\nPress RETURN to stop..."
    println(started)
    logger.info(started)

    StdIn.readLine()
    server.stop()
    val stopped = s"*** Web Server stopped!"
    println(stopped)
    logger.info(stopped)