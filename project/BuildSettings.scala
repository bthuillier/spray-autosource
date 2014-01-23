import sbt._
import Keys._
import spray.revolver.RevolverPlugin.Revolver

object BuildSettings {

lazy val basicSettings = seq(
    version               := "0.1.0-SNAPSHOT",
    organization          := "fr.bthuillier",
    startYear             := Some(2014),
    licenses              := Seq("Apache 2" -> new URL("http://www.apache.org/licenses/LICENSE-2.0.txt")),
    scalaVersion          := "2.10.3",
    resolvers             ++= Dependencies.resolutionRepos,
    scalacOptions         := Seq(
      "-encoding", "utf8",
      "-feature",
      "-unchecked",
      "-deprecation",
      "-target:jvm-1.6",
      "-language:_",
      "-Xlog-reflective-calls"
    )
  )

lazy val exampleSettings = basicSettings ++ Revolver.settings 

}

 