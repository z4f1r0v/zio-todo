val Ver = new {
  val circe      = "0.13.0"
  val doobie     = "0.10.0"
  val http4s     = "0.21.19"
  val log4j      = "2.14.0"
  val zio        = "1.0.4-2"
  val zioLogging = "0.5.6"
}

lazy val root = (project in file("."))
  .settings(
    scalaVersion     := "2.13.5",
    version          := "0.1.0-SNAPSHOT",
    organization     := "com.github.todo",
    organizationName := "todo",
    name := "zio-todo",
    libraryDependencies ++= Seq(
      "org.http4s"                   %% "http4s-blaze-server" % Ver.http4s,
      "org.http4s"                   %% "http4s-circe"        % Ver.http4s,
      "org.http4s"                   %% "http4s-dsl"          % Ver.http4s,
      "io.circe"                     %% "circe-core"          % Ver.circe,
      "io.circe"                     %% "circe-generic"       % Ver.circe,
      "io.circe"                     %% "circe-literal"       % Ver.circe   % "test",
      "org.tpolecat"                 %% "doobie-core"         % Ver.doobie,
      "org.tpolecat"                 %% "doobie-h2"           % Ver.doobie,
      "org.tpolecat"                 %% "doobie-hikari"       % Ver.doobie,
      "org.typelevel"                %% "jawn-parser"         % "1.0.1" % "test",
      "dev.zio"                      %% "zio"                 % Ver.zio,
      "dev.zio"                      %% "zio-test"            % Ver.zio     % "test",
      "dev.zio"                      %% "zio-test-sbt"        % Ver.zio     % "test",
      "dev.zio"                      %% "zio-interop-cats"    % "2.3.1.0",
      "dev.zio"                      %% "zio-logging"         % Ver.zioLogging,
      "dev.zio"                      %% "zio-logging-slf4j"   % Ver.zioLogging,
      "org.flywaydb"                  % "flyway-core"         % "7.5.3",
      "com.h2database"                % "h2"                  % "1.4.200",
      "org.apache.logging.log4j"      % "log4j-api"           % Ver.log4j,
      "org.apache.logging.log4j"      % "log4j-core"          % Ver.log4j,
      "org.apache.logging.log4j"      % "log4j-slf4j-impl"    % Ver.log4j,
      "com.github.pureconfig"        %% "pureconfig"          % "0.14.0",
      compilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1"),
      compilerPlugin(("org.typelevel" % "kind-projector"      % "0.11.3").cross(CrossVersion.full))
    ),
    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-explaintypes",
      "-unchecked",
      "-encoding",
      "UTF-8",
      "-language:higherKinds",
      "-language:existentials",
      "-Xfatal-warnings",
      "-Xlint:-byname-implicit,_",
      "-Ywarn-value-discard",
      "-Ywarn-numeric-widen",
      "-Ywarn-extra-implicit",
      "-Ywarn-unused"
    ),
    testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")
  )