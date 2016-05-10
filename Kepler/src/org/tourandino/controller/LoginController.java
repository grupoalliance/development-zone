package org.tourandino.controller;

import org.tourandino.model.User;
import org.tourandino.service.UserService;

public class LoginController {
	private User user;
	private UserService userService;
	
	
	public LoginController(){
		userService = new UserService();
	}
	public boolean authenticate(String username, String password){
		user = userService.readByUsernamePassword(username, password);
		if(user != null)return true;
		else return false;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
