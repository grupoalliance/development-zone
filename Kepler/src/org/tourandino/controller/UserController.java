package org.tourandino.controller;

import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

import org.tourandino.model.Role;
import org.tourandino.model.User;
import org.tourandino.service.UserService;

public class UserController {
	private User user;
	private List<User> users;
	private UserService userService = new UserService();
	
	public DefaultTableModel loadUserTable(){
		users = userService.readAll();
		Object[] columns = new Object[]{"ID","Usuario","Nombre","Rol"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if (users != null){
	        for (User user: users)
	            model.addRow(new Object[]{
	            		user.getUserId(),
	            		user.getUserUsername(),
	            		user.getUserFullname(),
	            		user.getRole().getRoleName()
	            		});
	    }
		return model;
	}
	
	public DefaultTableModel readByUsername(String username){
		users = userService.readByUsername(username);
		Object[] columns = new Object[]{"ID","Usuario","Nombre","Rol"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if (users != null){
	        for (User user: users){
	        	model.addRow(new Object[]{
	        			user.getUserId(),
	            		user.getUserUsername(),
	            		user.getUserFullname(),
	            		user.getRole().getRoleName()
	            		});
	        }
	    }
		return model;
	}
	
	public DefaultTableModel readByFullname(String fullname){
		users = userService.readByFullname(fullname);
		Object[] columns = new Object[]{"ID","Usuario","Nombre","Rol"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		if (users != null){
	        for (User user: users)
	            model.addRow(new Object[]{
	            		user.getUserId(),
	            		user.getUserUsername(),
	            		user.getUserFullname(),
	            		user.getRole().getRoleName()
	            		});
	    }
		return model;
	}
	
	public Boolean validateUsername(String username){
		user = userService.checkUsername(username);
		if(user != null){
			return false;
		}
		else return true;
	}
	
	public Integer create(Object role, String username, String password, String fullname,
			Date birthdate, String address, String city, String phone, String mobile, 
			String email){
		user = new User((Role)role, username.toUpperCase(), password.toUpperCase(), fullname.toUpperCase(), 
				birthdate, address.toUpperCase(), city.toUpperCase(), phone.toUpperCase(), 
				mobile.toUpperCase(), email);
		Integer id = userService.create(user);
		return id;
	}
	
	public void update(Object role, String fullname,
			Date birthdate, String address, String city, String phone, String mobile, 
			String email){
		user.setRole((Role) role);
		user.setUserFullname(fullname);
		user.setUserBirthdate(birthdate);
		user.setUserAddress(address);
		user.setUserCity(city);
		user.setUserPhone(phone);
		user.setUserMobile(mobile);
		user.setUserEmail(email);
		userService.update(user);
	}
	
	public Object[] readUserId(Integer userId){
		user = userService.readById(userId);
		Object[] items = new Object[]{
		user.getUserUsername(),
		user.getUserPassword(),
		user.getUserFullname(),
		user.getUserBirthdate(),
		user.getUserAddress(),
		user.getUserCity(),
		user.getUserPhone(),
		user.getUserMobile(),
		user.getUserEmail(),
		user.getRole()};
		return items;
	}
	
}
