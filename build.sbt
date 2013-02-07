scalaVersion := "2.10.0"


scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")


libraryDependencies += "org.scala-lang" % "scala-reflect" % "2.10.0"

libraryDependencies += "org.scala-lang" % "scala-compiler" % "2.10.0"

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.0.M5b" % "test"


addCommandAlias("p1-1", "test-only p1_1*")

addCommandAlias("p1-2", "test-only p1_2*")

addCommandAlias("p2", "test-only p2*")

addCommandAlias("p3", "test-only p3*")
