package org.tourandino.validation;

import org.tourandino.model.User;
import org.tourandino.service.UserService;

public class LoginValidator {

	public boolean validate(String username, String password){
		UserService us = new UserService();
		User user = us.readByUsernamePassword(username, password);
		if(user != null)return true;
		else return false;
	}
}
