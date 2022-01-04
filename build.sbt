name := "cask"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "3.1.0"
libraryDependencies ++= {
  Seq(
    "com.lihaoyi" %% "cask" % "0.8.0",
    "com.lihaoyi" %% "upickle" % "1.4.3",
    "com.lihaoyi" %% "requests" % "0.7.0",
    "org.scalikejdbc" %% "scalikejdbc" % "4.0.0",
    "com.h2database" % "h2" % "2.0.204",
    "io.github.cquiroz" %% "scala-java-time" % "2.3.0",
    "com.lihaoyi" %% "scalatags" % "0.11.0",
    "com.typesafe" % "config" % "1.4.1",
    "ch.qos.logback" % "logback-classic" % "1.2.10",
    "com.typesafe.scala-logging" %% "scala-logging" % "3.9.4",
    "org.scalatest" %% "scalatest" % "3.2.10" % Test
  )
}
