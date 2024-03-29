package objektwerks.service

import objektwerks.entity.*

class Authorizer(service: Service):
  def authorize(command: Command): Event =
    command match
      case license: License => service.authorize(license.license)
      case _ => Authorized("")