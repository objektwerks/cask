package objektwerks

import objektwerks.command.Register
import objektwerks.event.Registered
import objektwerks.entity.Serializers.{registerRW, registeredRW}

import upickle.default.*

object Client:
  def main(args: Array[String]): Unit =
    val command = Register(email = "live@live.com")
    println(s"Command: $command")
    val response = requests.post("http://localhost:7272/command", data = write[Register](command))
    val event = read[Registered](response)
    println(s"Event: $event")