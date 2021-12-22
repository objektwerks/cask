package objektwerks

import cask.main.Main

import io.undertow.Undertow

import scala.io.StdIn

object Server extends Main:
  val allRoutes = Seq(Router())

  override def port: Int = 7272
  override def host: String = "localhost"

  override def main(args: Array[String]): Unit =
    if (!verbose) Main.silenceJboss()
    val server = Undertow.builder
      .addHttpListener(port, host)
      .setHandler(defaultHandler)
      .build

    server.start()
    println(s"*** Server started at http://$host:$port/\nPress RETURN to stop...")

    StdIn.readLine()
    server.stop()
    println(s"*** Server stopped!")