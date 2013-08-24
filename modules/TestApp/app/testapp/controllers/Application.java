package testapp.controllers;

import play.*;
import play.mvc.*;

import controllers.AssetsBuilder;
import play.api.mvc.AnyContent;
import play.api.mvc.Action;
import common.actions.BasicAuth;
import testapp.views.html.*;

public class Application extends Controller {
    
    @BasicAuth(1)
    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
  
}
