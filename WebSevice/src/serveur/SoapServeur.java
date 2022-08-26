package serveur;

import javax.xml.ws.Endpoint;

import service.Authentification;
import service.UserManagement;

public class SoapServeur {
	
	 public static void main(String[] args) throws Exception {
	        String url1 = "http://localhost:8080/UserManagement?wsdl";
	        String url2 = "http://localhost:8080/Authentification?wsdl";
	        Endpoint.publish(url1, new UserManagement());
	        Endpoint.publish(url2, new Authentification());
			System.out.println("\nServer For User Management Up and Running at : " + url1);
			System.out.println("\nServer For User Auhtentication Up and Running at : " + url2);
			UserManagement u= new UserManagement();


	 }
}
