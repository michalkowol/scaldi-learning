name := "scaldi-learning"

version := "1.0"

scalaVersion := "2.10.4"

fork := true

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")

Seq(com.github.retronym.SbtOneJar.oneJarSettings: _*)

org.scalastyle.sbt.ScalastylePlugin.Settings

ScoverageSbtPlugin.instrumentSettings

libraryDependencies ++= Seq(
  "com.google.guava" % "guava" % "16.0.1",
  "com.google.code.findbugs" % "jsr305" % "2.0.3",
  "ch.qos.logback" % "logback-classic" % "1.1.1",
  "com.typesafe" %% "scalalogging-slf4j" % "1.1.0",
  "org.scalatest" %% "scalatest" % "2.1.3" % "test",
  "org.mockito" % "mockito-all" % "1.9.5" % "test"
)

libraryDependencies += "org.scaldi" %% "scaldi" % "0.3"
