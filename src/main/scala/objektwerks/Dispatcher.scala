package objektwerks

import objektwerks.entity.{Command, Event, Unauthorized}
import objektwerks.service.{Authorizer, Validator}

class Dispatcher(authorizer: Authorizer, validator: Validator):
  def dispatch(command: Command): Event =
    authorizer.authorize(command) match
      case unauthorized: Unauthorized => unauthorized
      case _ => validator.validate(command)