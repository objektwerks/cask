package objektwerks

import cask.main.Main

import io.undertow.Undertow

import objektwerks.service.*

import scala.io.StdIn

object Server extends Main:
  val store = Store()
  val service = Service(store)
  val authorizer = Authorizer(service)
  val handler = Handler(service)
  val validator = Validator(handler)
  val dispatcher = Dispatcher(authorizer, validator)
  
  val allRoutes = Seq(Router(dispatcher))

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