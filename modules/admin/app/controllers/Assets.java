package controllers.admin;

import play.api.mvc.*;

public class Assets {
	// can be referenced as `controllers.my.Assets.delegate.at` in the route
	// file
	public static controllers.AssetsBuilder delegate = new controllers.AssetsBuilder();

	public static Action<AnyContent> at(String path, String file) {
		return delegate.at(path, file);
	}

	public static Action<AnyContent> at(String file) {
		return delegate.at("", file);
	}
	public static Action<AnyContent> atMain(String path, String file) {
		return controllers.Assets.at(path, file);
	}

	public static Action<AnyContent> atMain(String file) {
		return controllers.Assets.at("", file);
	}
}