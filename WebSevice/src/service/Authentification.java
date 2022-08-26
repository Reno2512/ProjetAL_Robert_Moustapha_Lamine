package service;

import javax.jws.WebParam;
import javax.jws.WebService;

import metier.User;

@WebService
public class Authentification {
	private UserManagement userManag = new UserManagement();
	  public User Authentification(@WebParam(name = "email")String email,@WebParam(name = "Password") String password) {
	      User user=null;  
		  try {
	            user = userManag.getUser(email, password);
	            if (user.getPassword().equalsIgnoreCase(password)) {
//	            	if (user.getPassword().equalsIgnoreCase(Crypt.encrypt(password))) {
	                return user;
	            }
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	            
	        }
		  return user;
	    }

}
