name := """barterli-play"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  javaJpa,
  cache,
  javaWs
)

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.36"
libraryDependencies += "org.hibernate" % "hibernate-entitymanager" % "5.0.0.Final"
libraryDependencies += "org.elasticsearch" % "elasticsearch" % "1.6.2"
libraryDependencies += "com.rabbitmq" % "amqp-client" % "2.4.1"
libraryDependencies += "org.apache.commons" % "commons-io" % "1.3.2"
libraryDependencies += "ws.securesocial" % "securesocial_2.11" % "3.0-M3"
libraryDependencies += evolutions

// for jpa deployment. exclude conf contents in classpath
PlayKeys.externalizeResources := false





// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator


fork in run := true