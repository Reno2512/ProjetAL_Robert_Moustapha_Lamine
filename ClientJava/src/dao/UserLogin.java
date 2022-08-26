package dao;




import exception.WebServiceException;
import service.Authentification;

import service.AuthentificationResponse;
import service.Authentification_Type;
//import service.UserAuthWS;
import stub.Stub;

public class UserLogin {
	
	 private static Stub stubManagement = Stub.getStubInstance();
	    private static Authentification stub;
	    private static UserLogin instance = new UserLogin();

	    private UserLogin() {
	        try {
	            stub = stubManagement.getAuthStubInstance();
	        } catch (ExceptionInInitializerError e) {
	            System.out.println("WebService d'Authentication indisponible ! :" + e.getMessage());
	        }
	    }

	    public static UserLogin getUserLoginInstance() throws WebServiceException {
	        if (stub != null) {
	            return instance;
	        } else {
	            throw new WebServiceException("WebService d'Authentication indisponible !!");
	        }
	    }
	    
	    public AuthentificationResponse login(Authentification_Type request) {
	    	AuthentificationResponse response = new AuthentificationResponse();
	        response.setReturn(stub.authentification(request.getEmail(), request.getPassword()));
	        return response;
	    }

}
