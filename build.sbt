name := "cask"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "3.6.4-RC1"
libraryDependencies ++= {
  lazy val twelveMonkeysVersion = "3.12.0"
  Seq(
    "com.lihaoyi" %% "cask" % "0.9.7",
    "com.lihaoyi" %% "upickle" % "4.1.0",
    "com.lihaoyi" %% "requests" % "0.9.0",
    "org.scalikejdbc" %% "scalikejdbc" % "4.3.2",
    "com.h2database" % "h2" % "2.3.232",
    "io.github.cquiroz" %% "scala-java-time" % "2.5.0",
    "com.lihaoyi" %% "scalatags" % "0.13.1",
    "com.twelvemonkeys.imageio" % "imageio-core" % twelveMonkeysVersion,
    "com.twelvemonkeys.imageio" % "imageio-bmp" % twelveMonkeysVersion,
    "com.github.blemale" %% "scaffeine" % "5.3.0",
    "com.typesafe" % "config" % "1.4.3",
    "ch.qos.logback" % "logback-classic" % "1.5.16",
    "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",
    "org.scalatest" %% "scalatest" % "3.2.19" % Test
  )
}
scalacOptions ++= Seq(
  "-Wall"
)
