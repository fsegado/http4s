name := "http4s"

version := "0.1"

scalaVersion := "2.12.4"

val http4sVersion = "0.17.5"
val circeVersion = "0.8.0"
val journalVersion = "3.0.18"

libraryDependencies ++= Seq(
  "org.http4s" %% "http4s-dsl" % http4sVersion,
  "org.http4s" %% "http4s-blaze-server" % http4sVersion,
  "org.http4s" %% "http4s-blaze-client" % http4sVersion,
  "org.http4s" %% "http4s-circe" % http4sVersion,
  // Optional for auto-derivation of JSON codecs
  "io.circe" %% "circe-generic" % circeVersion,
  // Optional for string interpolation to JSON model
  "io.circe" %% "circe-literal" % circeVersion,
  "io.circe" %% "circe-parser" % circeVersion,
  "io.verizon.journal" %% "core" % journalVersion,
  "com.typesafe.slick" %% "slick" % "3.2.0"
)