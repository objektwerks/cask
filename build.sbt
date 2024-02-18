name := "cask"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "3.4.0"
libraryDependencies ++= {
  lazy val twelveMonkeysVersion = "3.10.1"
  Seq(
    "com.lihaoyi" %% "cask" % "0.9.2",
    "com.lihaoyi" %% "upickle" % "3.2.0",
    "com.lihaoyi" %% "requests" % "0.8.0",
    "org.scalikejdbc" %% "scalikejdbc" % "4.1.0",
    "com.h2database" % "h2" % "2.2.224",
    "io.github.cquiroz" %% "scala-java-time" % "2.5.0",
    "com.lihaoyi" %% "scalatags" % "0.12.0",
    "com.twelvemonkeys.imageio" % "imageio-core" % twelveMonkeysVersion,
    "com.twelvemonkeys.imageio" % "imageio-bmp" % twelveMonkeysVersion,
    "com.github.blemale" %% "scaffeine" % "5.2.1",
    "com.typesafe" % "config" % "1.4.3",
    "ch.qos.logback" % "logback-classic" % "1.4.14",
    "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",
    "org.scalatest" %% "scalatest" % "3.2.17" % Test
  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)
