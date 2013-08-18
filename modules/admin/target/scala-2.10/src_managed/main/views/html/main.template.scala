
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object main extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Html,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(title: String)(content: Html):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.32*/("""

<!DOCTYPE html>

<html>
    <head>
        <title>"""),_display_(Seq[Any](/*7.17*/title)),format.raw/*7.22*/("""</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*8.54*/controllers/*8.65*/.admin.Assets.delegate.at("stylesheets/main.css"))),format.raw/*8.114*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*9.59*/controllers/*9.70*/.admin.Assets.delegate.at("images/favicon.png"))),format.raw/*9.117*/("""">
        <script src=""""),_display_(Seq[Any](/*10.23*/controllers/*10.34*/.admin.Assets.delegate.at("javascripts/jquery-1.9.0.min.js"))),format.raw/*10.94*/("""" type="text/javascript"></script>
    </head>
    <body>
        """),_display_(Seq[Any](/*13.10*/content)),format.raw/*13.17*/("""
    </body>
</html>
"""))}
    }
    
    def render(title:String,content:Html): play.api.templates.Html = apply(title)(content)
    
    def f:((String) => (Html) => play.api.templates.Html) = (title) => (content) => apply(title)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Aug 18 20:54:30 CEST 2013
                    SOURCE: C:/Users/nicola/git/heroku/MyApp/modules/admin/app/views/main.scala.html
                    HASH: ca94d76d7ee5b9c63da997d44fec7e69207baebf
                    MATRIX: 727->1|834->31|922->84|948->89|1045->151|1064->162|1135->211|1231->272|1250->283|1319->330|1380->355|1400->366|1482->426|1585->493|1614->500
                    LINES: 26->1|29->1|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|41->13|41->13
                    -- GENERATED --
                */
            