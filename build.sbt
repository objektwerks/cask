name := "cask"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "3.2.1-RC2"
libraryDependencies ++= {
  lazy val twelveMonkeysVersion = "3.8.2"
  Seq(
    "com.lihaoyi" %% "cask" % "0.8.3",
    "com.lihaoyi" %% "upickle" % "2.0.0",
    "com.lihaoyi" %% "requests" % "0.7.0",
    "org.scalikejdbc" %% "scalikejdbc" % "4.0.0",
    "com.h2database" % "h2" % "2.1.214",
    "io.github.cquiroz" %% "scala-java-time" % "2.3.0",
    "com.lihaoyi" %% "scalatags" % "0.11.1",
    "com.twelvemonkeys.imageio" % "imageio-core" % twelveMonkeysVersion,
    "com.twelvemonkeys.imageio" % "imageio-bmp" % twelveMonkeysVersion,
    "com.github.blemale" %% "scaffeine" % "5.2.0",
    "com.typesafe" % "config" % "1.4.2",
    "ch.qos.logback" % "logback-classic" % "1.4.3",
    "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",
    "org.scalatest" %% "scalatest" % "3.2.14" % Test
  )
}
