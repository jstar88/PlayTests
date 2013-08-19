import sbt._
import Keys._
import play.Project._
import com.typesafe.sbteclipse.core.EclipsePlugin.EclipseKeys

object ApplicationBuild extends Build {

	override def settings = super.settings ++ Seq(
      EclipseKeys.skipParents in ThisBuild := false
  )

  val appName         = "MyApp"
  val appVersion      = "1.0-SNAPSHOT"
  
  
// ------- admin ------------

    val adminDeps = Seq(
      // Add your project dependencies here,
       "mysql" % "mysql-connector-java" % "5.1.18",
      jdbc,
      anorm
    )
    
    lazy val admin = play.Project(appName + "-admin", appVersion, adminDeps, path = file("modules/admin"))

  

// ------- main ------------

	val appDependencies  = Seq(
    	// Add your project dependencies here,
    	javaCore,
    	javaJdbc,
    	javaEbean
  )
 lazy val main = play.Project(appName, appVersion, appDependencies).settings(
  ).dependsOn(admin).aggregate(admin)
// -------

}
