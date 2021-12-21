package objektwerks.service

import objektwerks.command.{Command, License}
import objektwerks.event.{Authorized, Event}

class Authorizer(service: Service):
  def authorize(command: Command): Event =
    command match
      case license: License => service.authorize(license.license)
      case _ => Authorized("")