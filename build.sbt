name := "cask"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "3.3.1-RC3"
libraryDependencies ++= {
  lazy val twelveMonkeysVersion = "3.9.4"
  Seq(
    "com.lihaoyi" %% "cask" % "0.9.1",
    "com.lihaoyi" %% "upickle" % "3.1.0",
    "com.lihaoyi" %% "requests" % "0.8.0",
    "org.scalikejdbc" %% "scalikejdbc" % "4.0.0",
    "com.h2database" % "h2" % "2.1.214",
    "io.github.cquiroz" %% "scala-java-time" % "2.5.0",
    "com.lihaoyi" %% "scalatags" % "0.12.0",
    "com.twelvemonkeys.imageio" % "imageio-core" % twelveMonkeysVersion,
    "com.twelvemonkeys.imageio" % "imageio-bmp" % twelveMonkeysVersion,
    "com.github.blemale" %% "scaffeine" % "5.2.1",
    "com.typesafe" % "config" % "1.4.2",
    "ch.qos.logback" % "logback-classic" % "1.4.8",
    "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",
    "org.scalatest" %% "scalatest" % "3.2.16" % Test
  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)
