package objektwerks.service

import objektwerks.entity.{Command, Event, Unauthorized}

class Dispatcher(authorizer: Authorizer, validator: Validator):
  def dispatch(command: Command): Event =
    authorizer.authorize(command) match
      case unauthorized: Unauthorized => unauthorized
      case _ => validator.validate(command)