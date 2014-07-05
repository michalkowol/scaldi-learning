name := "scaldi-learning"

version := "1.0"

scalaVersion := "2.11.1"

fork in run := true

incOptions := incOptions.value.withNameHashing(true)

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")

Seq(com.github.retronym.SbtOneJar.oneJarSettings: _*)

org.scalastyle.sbt.ScalastylePlugin.Settings

instrumentSettings

libraryDependencies ++= Seq(
  "com.google.guava" % "guava" % "17.0",
  "com.google.code.findbugs" % "jsr305" % "2.0.3",
  "org.scaldi" %% "scaldi" % "0.4",
  "ch.qos.logback" % "logback-classic" % "1.1.2",
  "com.typesafe.scala-logging" %% "scala-logging-slf4j" % "2.1.2",
  "org.scalatest" %% "scalatest" % "2.2.0" % "test",
  "org.mockito" % "mockito-all" % "1.9.5" % "test"
)