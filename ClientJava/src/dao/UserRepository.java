package dao;

import exception.WebServiceException;
import service.AddUser;
import service.AddUserResponse;
import service.Delete;
import service.DeleteResponse;
import service.GetUser;
import service.GetUserById;
import service.GetUserByIdResponse;
import service.GetUserResponse;
import service.GetUsers;
import service.GetUsersResponse;
import service.Update;
import service.UpdateResponse;
import service.UserManagement;
import stub.Stub;

public class UserRepository {
	
	 private static Stub stubManager = Stub.getStubInstance();
	    private static UserManagement stub;
	    private static UserRepository instance = new UserRepository();

	    private UserRepository() {
	        try {
	            stub = stubManager.getMgtStubInstance();          
	        } catch (ExceptionInInitializerError e) {
	            System.out.println("WebService de gestion users indisponible !! :" + e.getMessage());
	        }
	    }

	    public static UserRepository getUserRepoInstance() throws WebServiceException {        
	        if (stub != null) {
	            return instance;
	        } else {    
	            throw new WebServiceException("WebService de gestion users indisponible !");
	        }
	    }

	    public AddUserResponse addUser(AddUser request) {
	        AddUserResponse response = new AddUserResponse();
	        response.setReturn(stub.addUser(request.getArg0(),request.getArg1(),request.getArg2()));
	        return response;
	    }

	    public GetUsersResponse getUsers(GetUsers request) {
	        GetUsersResponse response = new GetUsersResponse();
	        response.setReturn(stub.getUsers());
	        return response;
	    }

	    public GetUserResponse getUser(GetUser request) {
	        GetUserResponse response = new GetUserResponse();
	        response.setReturn(stub.getUser(request.getArg0(),request.getArg1()));
	        return response;
	    }
	    public GetUserByIdResponse getUserById(GetUserById request) {
	        GetUserByIdResponse response = new GetUserByIdResponse();
	        response.setReturn(stub.getUserById(request.getArg0()));
	        return response;
	    }

	    public UpdateResponse update(Update request) {
	        UpdateResponse response = new UpdateResponse();
	        response.setReturn(stub.update(request.getArg0(),request.getArg1(),request.getArg2(),request.getArg3()));
	        return response;
	    }


	    public DeleteResponse deleteUser(Delete request) {
	        DeleteResponse response = new DeleteResponse();
	        response.setReturn(stub.delete(request.getArg0()));
	        return response;
	    }


}
