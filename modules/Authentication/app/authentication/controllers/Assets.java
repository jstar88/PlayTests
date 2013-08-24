package authentication.controllers;

import play.api.mvc.Action;
import play.api.mvc.AnyContent;
import controllers.AssetsBuilder;

public class Assets {
	private static AssetsBuilder delegate = new AssetsBuilder();

    public static Action<AnyContent> at(String path, String file) {
        return delegate.at(path, file);
    }

}
