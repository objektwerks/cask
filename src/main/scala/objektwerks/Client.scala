package objektwerks

import objektwerks.entity.Serializers.given
import objektwerks.entity.{Register, Registered}

import upickle.default.*

object Client:
  def main(args: Array[String]): Unit =
    val register = Register(email = "live@live.com")
    println(s"Register: $register")
    val response = requests.post("http://localhost:7272/command", data = write[Register](register))
    val registered = read[Registered](response.text())
    println(s"Registered: $registered")