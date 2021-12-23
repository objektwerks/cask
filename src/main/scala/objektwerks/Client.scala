package objektwerks

import com.typesafe.scalalogging.LazyLogging

import objektwerks.entity.Serializers.given
import objektwerks.entity.{Register, Registered}

import upickle.default.*

object Client extends LazyLogging:
  def main(args: Array[String]): Unit =
    val register = Register("live@live.com")
    logger.info(s"*** Register: $register")

    val registerJson = write[Register](register)
    logger.info(s"*** Register json: $registerJson")

    val response = requests.post("http://localhost:7272/command", data = registerJson)
    logger.info(s"*** Response: $response")
    
    val registered = read[Registered](response.text())
    logger.info(s"*** Registered: $registered")