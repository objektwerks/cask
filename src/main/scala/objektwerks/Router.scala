package objektwerks

import cask.endpoints.postJson
import cask.main.Routes
import cask.model.Request
import com.typesafe.scalalogging.LazyLogging

import objektwerks.entity.{Command, Event}
import objektwerks.entity.Serializers.given
import objektwerks.service.*

import upickle.default.*

case class Router(dispatcher: Dispatcher) extends Routes with LazyLogging:
  @cask.post("/command")
  def command(request: Request) =
    val command = read[Command](request.text())
    logger.debug(s"*** Command: $command")

    val event = dispatcher.dispatch(command)
    logger.debug(s"*** Event: $event")
    write[Event](event)

  initialize()