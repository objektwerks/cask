package objektwerks.service

import objektwerks.entity.{Authorized, Command, Event, License}

class Authorizer(service: Service):
  def authorize(command: Command): Event =
    command match
      case license: License => service.authorize(license.license)
      case _ => Authorized("")