package application;

import java.sql.*;


public class LoginModel {
	
	Connection conector;
	
	public LoginModel(){
		
		conector = SQLiteConnection.conectar();
		
		if(conector == null) System.exit(1); 
	}
		public boolean isDbConnected(){
			
			try{
			conector.isClosed();
			}catch(Exception e){
			
				e.printStackTrace();
				return false;		
		}
}
}
}