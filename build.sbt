import com.typesafe.sbt.packager.Keys.{dockerBaseImage, dockerRepository}

name := "word-frequency-finder"

version := "0.1"

scalaVersion := "2.13.7"

libraryDependencies ++= {
  Seq(
    "co.fs2"        %% "fs2-core"                      % "3.2.2",
    "co.fs2"        %% "fs2-io"                        % "3.2.2",
    "org.typelevel" %% "cats-effect-testing-scalatest" % "1.3.0"  % Test,
    "org.scalactic" %% "scalactic"                     % "3.2.10",
    "org.scalatest" %% "scalatest"                     % "3.2.10" % "test"
  )
}

dockerBaseImage      := "java:8-jre"
Docker / packageName := "your-project-id/api"
Docker / maintainer  := "collinkueter@gmail.com"
dockerRepository     := Some("us.gcr.io")

enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)
