name := "cask"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "3.5.0-RC7"
libraryDependencies ++= {
  lazy val twelveMonkeysVersion = "3.10.1"
  Seq(
    "com.lihaoyi" %% "cask" % "0.9.4",
    "com.lihaoyi" %% "upickle" % "4.0.0",
    "com.lihaoyi" %% "requests" % "0.8.2",
    "org.scalikejdbc" %% "scalikejdbc" % "4.3.1",
    "com.h2database" % "h2" % "2.3.230",
    "io.github.cquiroz" %% "scala-java-time" % "2.5.0",
    "com.lihaoyi" %% "scalatags" % "0.13.1",
    "com.twelvemonkeys.imageio" % "imageio-core" % twelveMonkeysVersion,
    "com.twelvemonkeys.imageio" % "imageio-bmp" % twelveMonkeysVersion,
    "com.github.blemale" %% "scaffeine" % "5.2.1",
    "com.typesafe" % "config" % "1.4.3",
    "ch.qos.logback" % "logback-classic" % "1.5.6",
    "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",
    "org.scalatest" %% "scalatest" % "3.2.19" % Test
  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)
