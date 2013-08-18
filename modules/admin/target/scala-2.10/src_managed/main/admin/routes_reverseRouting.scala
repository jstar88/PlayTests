// @SOURCE:C:/Users/nicola/git/heroku/MyApp/modules/admin/conf/admin.routes
// @HASH:c936661a053fc59ba800bc3aff763068032d8483
// @DATE:Sun Aug 18 20:43:06 CEST 2013

import admin.Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:3
// @LINE:1
package controllers.admin {

// @LINE:1
class ReverseApplication {
    

// @LINE:1
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "index")
}
                                                
    
}
                          

// @LINE:3
class ReverseAssets {
    

// @LINE:3
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          
}
                  


// @LINE:3
// @LINE:1
package controllers.admin.javascript {

// @LINE:1
class ReverseApplication {
    

// @LINE:1
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.admin.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "index"})
      }
   """
)
                        
    
}
              

// @LINE:3
class ReverseAssets {
    

// @LINE:3
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.admin.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              
}
        


// @LINE:3
// @LINE:1
package controllers.admin.ref {

// @LINE:1
class ReverseApplication {
    

// @LINE:1
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.admin.Application.index(), HandlerDef(this, "controllers.admin.Application", "index", Seq(), "GET", """""", _prefix + """index""")
)
                      
    
}
                          

// @LINE:3
class ReverseAssets {
    

// @LINE:3
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.admin.Assets.at(path, file), HandlerDef(this, "controllers.admin.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          
}
                  
      