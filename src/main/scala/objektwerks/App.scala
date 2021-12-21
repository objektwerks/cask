package objektwerks

object App:
  @main def greeting(first: String, last: String): Unit =
    println(">>>")
    println(s"@main greetings(first: String, last: String) => Greetings, $first $last!")
    println("<<<")