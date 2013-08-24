package common.actions;

import common.models.User;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;
import common.services.Authenticator;

public class BasicAuthAction extends Action<BasicAuth> {

	@Override
	public Result call(Http.Context ctx) throws Throwable {

		User user = Authenticator.getCurrentUser();
		int requiredType = configuration.value();

		if (user != null) {
			if (user.type >= requiredType) {
				return delegate.call(ctx);
			}
			return unauthorized("unauthorized: you don't have enought rights");

		} else if (requiredType == 0) {
			return delegate.call(ctx);
		}
		return unauthorized("unauthorized: account doesn't exist");
	}
}
