package objektwerks.router

import cask.main.Routes

import scalatags.Text.all.*

/**
 * See Refined Text Tags [ 232 ]
 * https://github.com/com-lihaoyi/scalatags/commit/47f8f7fbe0d865c6a25aecbf924b41b061829a97
 * for missing doctype("html")( ... )
*/
case class WebRouter() extends Routes:
  @cask.get("/")
  def hello() =
    html(
      body(
        h1("Hello, Cask and Scalatags!")
      )
    ).render

  initialize()