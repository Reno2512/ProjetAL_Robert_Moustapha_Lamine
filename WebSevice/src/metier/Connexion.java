package metier;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {
	
	public static 	Connection getCon() {
		Connection myCon=null;
		 try {
	            myCon= DriverManager.getConnection("jdbc:mysql://localhost:3306/mglsi_news","root","");
//	           
	        } catch (Exception e) {
//	          
	            e.printStackTrace();
	        }
		 return myCon;
	}

}
