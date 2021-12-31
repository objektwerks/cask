package objektwerks

import com.typesafe.scalalogging.LazyLogging

import objektwerks.entity.Serializers.given
import objektwerks.entity.{Login, LoggedIn, Register, Registered}

import upickle.default.*

object Client extends LazyLogging:
  def main(args: Array[String]): Unit =
    val url = "http://localhost:7272/command"
    logger.info(s"*** Server url: $url")

    val register = Register("live@live.com")
    logger.info(s"*** Register: $register")

    val registerJson = write[Register](register)
    logger.info(s"*** Register json: $registerJson")

    val registerResponse = requests.post(url, data = registerJson)
    logger.info(s"*** Register response: $registerResponse")
    
    val registered = read[Registered](registerResponse.text())
    logger.info(s"*** Registered: $registered")

    val account = registered.account
    logger.info(s"*** Account: $account")

    val login = Login(account.emailAddress, account.pin)
    logger.info(s"*** Login: $login")

    val loginJson = write[Login](login)
    logger.info(s"*** Login json: $loginJson")

    val loginResponse = requests.post(url, data = loginJson)
    logger.info(s"*** Login response: $loginResponse")

    val loggedIn = read[LoggedIn](loginResponse.text())
    logger.info(s"*** LoggedIn: $loggedIn")

    require(account == loggedIn.account, "Account not equal to LoggedIn account.")