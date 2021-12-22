package objektwerks

import objektwerks.entity.Serializers.given
import objektwerks.entity.{Register, Registered}

import upickle.default.*

object Client:
  def main(args: Array[String]): Unit =
    val register = Register("live@live.com")
    println(s"*** Register: $register")

    val registerJson = write[Register](register)
    println(s"*** Register json: $registerJson")

    val response = requests.post("http://localhost:7272/command", data = registerJson)
    println(s"*** Response: $response")
    
    val registered = read[Registered](response.text())
    println(s"*** Registered: $registered")