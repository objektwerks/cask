package objektwerks.router

import cask.main.Routes

import scalatags.Text.all.*

case class WebRouter() extends Routes:
  @cask.get("/scalatags")
  def scalatags() =
    val page = doctype("html") (
      html(
        body(
          h1("Hello, Cask and Scalatags!")
        )
      )
    ).render
    cask.Response(page, 200, Seq("Content-Type" -> "text/html; charset=UTF-8"))

  initialize()