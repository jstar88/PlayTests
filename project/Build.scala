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
    	javaCore,
    	javaJdbc,
    	javaEbean
    )
  
   lazy val admin = play.Project(appName + "-admin", appVersion, adminDeps, path = file("modules/admin"))

// -------
// ------- main ------------

	val mainDeps = Seq(
    	// Add your project dependencies here,
    	javaCore,
    	javaJdbc,
    	javaEbean
  )
  lazy  val main = play.Project(appName, appVersion, mainDeps).settings(
      // Add your own project settings here      
    ).dependsOn(admin).aggregate(admin)
// -------
}
