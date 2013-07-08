import AssemblyKeys._

organization := "com.github.dragisak"

name := "server"

version := "0.1.0"

scalaVersion := "2.10.2"

libraryDependencies ++= Seq(
        "com.typesafe.akka" %%  "akka-actor"       % "2.2.0-RC2",
        "com.typesafe.akka" %%  "akka-cluster"     % "2.2.0-RC2",
        "com.typesafe.akka" %%  "akka-slf4j"       % "2.2.0-RC2" ,
        "ch.qos.logback"    %   "logback-classic"  % "1.0.12",
        "com.typesafe.akka" %%  "akka-testkit"     % "2.2.0-RC2"    % "test",
        "org.scalatest"     %%  "scalatest"        % "1.9.1"        % "test"
)

assemblySettings
