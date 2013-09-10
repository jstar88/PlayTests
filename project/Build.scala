import sbt._
import scala._
import sbt.Keys._
import play.Project._
import com.typesafe.sbteclipse.core.EclipsePlugin.EclipseKeys

object ApplicationBuild extends Build {

  override def settings = super.settings ++ Seq(
    EclipseKeys.skipParents in ThisBuild := false)

  /*  
  val appName         = "HostApp"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    javaCore,
    javaJdbc,
    javaEbean
  )
  
  
  val testAppDependencies = Seq(
    // Add your project dependencies here,
    javaCore,
    javaJdbc,
    javaEbean
  )
  
   val commonDependencies = Seq(
    // Add your project dependencies here,
    javaCore,
    javaJdbc,
    javaEbean
  )
  val common = play.Project("common", "0.2", commonDependencies, path = file("common"))
  val module1 = play.Project("module1", "0.2", testAppDependencies, path = file("modules/TestApp")).dependsOn(
    common).aggregate(
    common)
 
 
  val main = play.Project(appName, appVersion, appDependencies).settings(
  ).dependsOn(
    module1
  ).aggregate(
    module1
  )
*/
  val appName = "HostApp"
  val appVersion = "1.0-SNAPSHOT"

  val commonDependencies = Seq(
    // Add your project dependencies here,
      "commons-io" % "commons-io" % "2.3",
    javaCore,
    javaJdbc,
    javaEbean)
  val common = play.Project("common", appVersion, commonDependencies, path = file("common"))

  val excludes = Seq()

  def discoverModules(base: File, dir: String): Seq[Project] = {
    val dirs: Seq[sbt.File] = if ((base / dir).listFiles != null) (base / dir).listFiles else Seq.empty[sbt.File]
    for (x <- dirs if x.isDirectory && !excludes.contains(x.getName)) yield play.Project(x.getName, appVersion, commonDependencies, path = x).dependsOn(common)
  }

  def modules(base: File): Seq[Project] = discoverModules(base, "modules") ++ discoverModules(base, "additionalModules")
  def module(base: File, id: String): Project = modules(base).find(_.id == id).get
  def allModules(base: File) = Seq(common) ++ modules(base)
  def allModuleReferences(base: File) = allModules(base).map { x => x: ProjectReference }
  override def projectDefinitions(baseDirectory: File): Seq[Project] = allModules(baseDirectory) ++ Seq(root(baseDirectory))

  def root(base: File): Project = play.Project(appName, appVersion, commonDependencies).settings().dependsOn(
    allModules(base) map { x => x % "test->test;compile->compile" }: _*).aggregate(
      allModuleReferences(base) map { x => x }: _*)
}
