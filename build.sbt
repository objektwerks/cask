name := "cask"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "3.1.1-RC1"
libraryDependencies ++= {
  Seq(
    "com.lihaoyi" %% "cask" % "0.8.0",
    "com.lihaoyi" %% "upickle" % "1.4.3",
    "com.lihaoyi" %% "requests" % "0.7.0",
    "io.github.cquiroz" %% "scala-java-time" % "2.3.0",
    "ch.qos.logback" % "logback-classic" % "1.2.9",
    "com.typesafe.scala-logging" %% "scala-logging" % "3.9.4",
    "org.scalatest" %% "scalatest" % "3.2.10" % Test
  )
}