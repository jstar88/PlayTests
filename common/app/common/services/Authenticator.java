package common.services;

import play.cache.Cache;
import play.mvc.*;
import play.mvc.Http.Context;
import common.models.*;
import common.interfaces.Loginable;

public class Authenticator {
	/**
	 * Return true if the current user is logged 
	 */
	public static boolean isCurrentUserLogged() {
		return Context.current().args.containsKey("id_user") || Controller.session("id_user") != null;
	}
	
	/**
	 * Login the current visitor and return its User object or null on insuccess 
	 */
	public static User loginCurrentUser(Loginable men) {
		User user = User.findByIdAndPassword(men.getName(),men.getPassword());
		if (user == null)
			return null;
		Controller.session("id_user", user.id+"");
		Cache.set("User:" + user.id, user);
		Context.current().args.put("id_user", user.id);
		return user;
	}
	
	/**
	 * Logout the current user 
	 */
	public static void logoutCurrentUser() {
		Cache.remove("User:"+Controller.session("id_user"));
		Controller.session().clear();
		Context.current().args.remove("id_user");
		return;
	}

	/**
	 * Return the current user from cache and return its User object or null if user is not logged
	 */
	public static User getCurrentUser() {
		String idUser = "";
		if(Context.current().args.containsKey("id_user"))
		{
			idUser = (String) Context.current().args.get("id_user");
		}
		else
		{
			idUser = Controller.session("id_user");
			if (idUser  == null)
			{
				return null;
			}
		}
		
		Object user = Cache.get("User:" + idUser);
		if (user == null) {
			user = User.findById(Long.valueOf(idUser));
			Cache.set("User:" + idUser, (User)user);
		}
		return (User)user;
	}
}