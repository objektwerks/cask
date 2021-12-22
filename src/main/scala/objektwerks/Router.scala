package objektwerks

import cask.endpoints.postJson
import cask.main.Routes
import cask.model.Request

import objektwerks.entity.{Command, Event}
import objektwerks.entity.Serializers.given
import objektwerks.service.*

import upickle.default.*

case class Router(dispatcher: Dispatcher) extends Routes:
  @cask.postJson("/command")
  def command(request: Request) =
    println(s"*** Request: $request")

    val command = read[Command](request.text())
    println(s"*** Command: $command")

    val event = dispatcher.dispatch(command)
    println(s"*** Event: $event")
    write[Event](event)

  initialize()