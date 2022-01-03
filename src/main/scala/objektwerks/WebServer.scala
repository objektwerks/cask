package objektwerks

import cask.main.MainRoutes

import scalatags.Text.all.*

object WebServer extends MainRoutes:
  @cask.get("/")
  def hello() =
    html(
      body(
        h1("Hello, Cask and Scalatags!")
      )
    ).render

  initialize()