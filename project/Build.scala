import sbt._
import Keys._

object AkkaLedBuild extends Build {

    lazy val core = Project(id = "core",
                           base = file("core"))

    lazy val pie = Project(id = "pie",
                           base = file("pie")) dependsOn(core)

    lazy val server = Project(id = "server",
                           base = file("server")) dependsOn(core)
}
