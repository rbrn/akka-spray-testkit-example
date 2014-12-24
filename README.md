akka-spray-testkit-example
==========================

Akka Spray testkit SBt Service testing example

Dependencies

 "io.spray" %% "spray-can" % sprayVersion,
            "io.spray" %% "spray-routing" % sprayVersion,
            "io.spray" %% "spray-testkit" % sprayVersion,
            "io.spray" %% "spray-httpx" % sprayVersion,
            "io.spray" %% "spray-client" % sprayVersion,
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-remote" % akkaVersion,
    "com.typesafe.akka" %% "akka-slf4j" % akkaVersion % "test",
            "org.specs2" %% "specs2" % "2.4.15" % "provided",
     "com.typesafe.akka" %% "akka-testkit" % akkaVersion % "test",
              "io.spray" %% "spray-testkit" % "1.3.1" % "test",
        "org.slf4j" 			% "slf4j-api" 			% "1.7.9" % "test",
        "org.slf4j" 			% "log4j-over-slf4j" 	% "1.7.9" % "test",
        "ch.qos.logback" 	% "logback-classic" 	% "1.1.2" % "test"
        
      To run: sbt compile and sbt test
