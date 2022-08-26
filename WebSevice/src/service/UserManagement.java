package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import metier.Connexion;
import metier.User;
@WebService(serviceName = "UserManagementWS")
public class UserManagement {
// *********READ ALL*********
		@WebMethod
		public  List<User> getUsers() {
			List<User> et = new ArrayList<>();
			try {
				Connection myCon = Connexion.getCon();
				PreparedStatement myStmt = myCon.prepareStatement("SELECT * FROM users  ORDER BY id");
				ResultSet resultat = myStmt.executeQuery();
				while (resultat.next()) {
					et.add(new User(resultat.getInt("id"), resultat.getString("email"), resultat.getString("password"),resultat.getString("role")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return et;
		}

		
// *********READ ALL*********
//********* FIND BY ID*******
		@WebMethod
	    public  User getUserById(int id){
			User user=null;
	        try {

	        	Connection myCon = Connexion.getCon();
	            PreparedStatement myStmt = myCon.prepareStatement("SELECT * FROM users WHERE id = ?");
	            myStmt.setInt(1, id);
	            ResultSet resultat = myStmt.executeQuery();
	            if (resultat.next()) {
	                 user = new User(resultat.getInt("id"), resultat.getString("email"), resultat.getString("password"),resultat.getString("role"));
	                return user;
	            }
	        } catch (SQLException e) {
	        	e.printStackTrace();
		                System.out.println("Utilisateur introuvable");
		                
	        }
	        return user;
	    }
//********FIND BY ID*******		
		
		
//	AJOUT D'UN NOUVEL USER
	@WebMethod
    public  String addUser(String email, String password,String role) {

    		try {

    			String req = "INSERT INTO users(email,password,role)" + "VALUES (?, ?,?)";
    			Connection myCon = Connexion.getCon();
    			PreparedStatement preparedStatement = myCon.prepareStatement(req);
    			preparedStatement.setString(1, email);
    			preparedStatement.setString(2, password);
    			preparedStatement.setString(3,role);

    			preparedStatement.executeUpdate();
    			return "Insertion Reussie";
    		} catch (SQLException e) {
    			e.printStackTrace();
    			return "Echec de l'insertion";
    		}

    }
	
	// // *********UPDATE*********
	@WebMethod
	public   String Update(String email, String password, String role,int id) {
		try {
			String req = "UPDATE users set email=?,password=?,role=? where id=?";
			Connection myCon = Connexion.getCon();
			PreparedStatement preparedStatement = myCon.prepareStatement(req);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, role);
			preparedStatement.setInt(4, id);

			preparedStatement.executeUpdate();
			return "Mise a jour effectue";
		} catch (SQLException e) {
			e.printStackTrace();
			return "Echec MAJ";
		}

	}

	// *********UPDATE*********
	// *********DELETE*********
	@WebMethod
	public  String Delete(int id) {
		try {
			String req = "DELETE FROM users WHERE  id=?";
			Connection myCon = Connexion.getCon();
			PreparedStatement preparedStatement = myCon.prepareStatement(req);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
			return "Suppression Effectuee avec succes";
		} catch (SQLException e) {
			e.printStackTrace();
			return "Echec de la supression";
		}

	}
//	Find user by email and password
	@WebMethod
    public   User getUser(String email,String password){
        User user = null;
        try {
        	Connection myCon = Connexion.getCon();
            PreparedStatement myStmt = myCon.prepareStatement("SELECT * FROM users WHERE email = ? and password=?");
            myStmt.setString(1, email);
            myStmt.setString(2, password);
            ResultSet resultat = myStmt.executeQuery();
            if (resultat.next()) {
//                user = new User(emai,result.getString("userPassword"),(result.getInt("role_id") == 1) ? "admin" : "editor");
                user = new User(resultat.getInt("id"), resultat.getString("email"), resultat.getString("password"),resultat.getString("role"));
                return user;
            }
//            return user;
        } catch (SQLException e) {
        	e.printStackTrace();
            System.out.println("Utilisateur introuvable");
            
        }
        return user;
    }
}