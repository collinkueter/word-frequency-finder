name := "john-deere-interview"

version := "0.1"

scalaVersion := "2.13.7"

libraryDependencies ++= {
  Seq(
    "org.typelevel" %% "cats-core"   % "2.6.1",
    "org.typelevel" %% "cats-effect" % "3.2.9",
    "org.scalactic" %% "scalactic"   % "3.2.10",
    "org.scalatest" %% "scalatest"   % "3.2.10" % "test"
  )
}