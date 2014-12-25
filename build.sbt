version := "1.0.0"

scalaVersion := "2.11.4"

resolvers ++= Seq(
  "snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
  "releases" at "http://oss.sonatype.org/content/repositories/releases",
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  "spray repo" at "http://repo.spray.io",
   "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases",
  "mvnrepository" at "http://mvnrepository.com/artifact/",
  "central" at "http://repo1.maven.org/maven2/"
)

name := "chatakka"

testOptions += Tests.Argument(TestFrameworks.JUnit, "-q", "-v", "-s", "-a")

parallelExecution in Test := false

logBuffered := false

libraryDependencies ++= {
  val sprayVersion = "1.3.2"
  val akkaVersion = "2.3.8"
  Seq(
            "io.spray" %% "spray-can" % sprayVersion,
            "io.spray" %% "spray-routing" % sprayVersion,
            "io.spray" %% "spray-testkit" % sprayVersion,
            "io.spray" %% "spray-httpx" % sprayVersion,
            "io.spray" %% "spray-client" % sprayVersion,
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-remote" % akkaVersion,
    "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
            "org.specs2" %% "specs2" % "2.4.15" % "provided",
     "com.typesafe.akka" %% "akka-testkit" % akkaVersion % "test",
              "io.spray" %% "spray-testkit" % "1.3.1" % "test",
        "org.slf4j" 			% "slf4j-api" 			% "1.7.9",
        "org.slf4j" 			% "log4j-over-slf4j" 	% "1.7.9",
        "ch.qos.logback" 	% "logback-classic" 	% "1.1.2"
  )
}