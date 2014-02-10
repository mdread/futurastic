import sbt._
import sbt.Keys._

object FuturasticBuild extends Build {

  lazy val futurastic = Project(
    id = "futurastic",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "futurastic",
      organization := "net.caoticode.futurastic",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.10.3",
      // add other settings here
      
      libraryDependencies ++= Seq(
        "org.elasticsearch" % "elasticsearch" % "0.90.3",
        "net.liftweb" %% "lift-json" % "2.5"
      )
    )
  )
}
