import com.typesafe.sbt.packager.Keys.{dockerBaseImage, dockerRepository}

name := "word-frequency-finder"

version := "0.1"

scalaVersion := "2.13.7"

libraryDependencies ++= {
  Seq(
    "org.scalactic" %% "scalactic"   % "3.2.10",
    "org.scalatest" %% "scalatest"   % "3.2.10" % "test"
  )
}

dockerBaseImage := "java:8-jre"
Docker/packageName := "your-project-id/api"
Docker/maintainer := "collinkueter@gmail.com"
dockerRepository := Some("us.gcr.io")

enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)