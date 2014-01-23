import sbt._
import Keys._

object Build extends Build {
  import Dependencies._
  import BuildSettings._
  override lazy val settings = super.settings :+ {
    shellPrompt := { s => Project.extract(s).currentProject.id + " > " }
  }

  lazy val root = Project("root", file(".")).aggregate(sprayAutosources, sprayAutosourcesExamples).settings(basicSettings: _*)

  lazy val sprayAutosources = Project("spray-autosources", file("spray-autosources"))
    .settings(basicSettings: _*)
    .settings(libraryDependencies ++=
      provided(akkaActor, sprayCan, sprayRouting, playJson) ++
      test(specs2)
  )


  lazy val sprayAutosourcesExamples = Project("spray-autosources-examples", file("spray-autosources-examples"))
    .dependsOn(sprayAutosources)
    .settings(exampleSettings: _*)
    .settings(libraryDependencies ++=
      compile(sprayCan, sprayRouting, akkaActor, playJson) 
  )

  
}