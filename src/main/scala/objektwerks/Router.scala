package objektwerks

import cask.endpoints.postJson
import cask.main.MainRoutes
import cask.model.Request
import objektwerks.entity.{Command, Serializers}
import objektwerks.service.*
import upickle.default.{read, write}

trait Router extends MainRoutes:
  val store = Store()
  val service = Service(store)
  val authorizer = Authorizer(service)
  val handler = Handler(service)
  val validator = Validator(handler)
  val dispatcher = Dispatcher(authorizer, validator)

  override def port: Int = 7272
  override def host: String = "localhost"
  override def main(args: Array[String]): Unit = ()

  @postJson("/command")
  def onCommand(request: Request) =
    println(s"*** Request: $request")

    val command = read[Command](request.bytes)(using Serializers.commandRW)
    println(s"*** Command: $command")

    val event = dispatcher.dispatch(command)
    println(s"*** Event: $event")
    write(event)(using Serializers.eventRW)

  initialize()