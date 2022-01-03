package objektwerks.router

import cask.main.Routes

import scalatags.Text.all.*

case class WebRouter() extends Routes:
  @cask.get("/")
  def hello() =
    html(
      body(
        h1("Hello, Cask and Scalatags!")
      )
    ).render

  initialize()