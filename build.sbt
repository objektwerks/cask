name := "cask"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "3.8.0-RC1"
libraryDependencies ++= {
  lazy val twelveMonkeysVersion = "3.12.0"
  Seq(
    "com.lihaoyi" %% "cask" % "0.11.0",
    "com.lihaoyi" %% "upickle" % "4.4.1",
    "com.lihaoyi" %% "requests" % "0.9.0",
    "org.scalikejdbc" %% "scalikejdbc" % "4.3.5",
    "com.h2database" % "h2" % "2.4.240",
    "io.github.cquiroz" %% "scala-java-time" % "2.6.0",
    "com.lihaoyi" %% "scalatags" % "0.13.1",
    "com.twelvemonkeys.imageio" % "imageio-core" % twelveMonkeysVersion,
    "com.twelvemonkeys.imageio" % "imageio-bmp" % twelveMonkeysVersion,
    "com.github.blemale" %% "scaffeine" % "5.3.0",
    "com.typesafe" % "config" % "1.4.3",
    "ch.qos.logback" % "logback-classic" % "1.5.21",
    "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",
    "org.scalatest" %% "scalatest" % "3.2.19" % Test
  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)
