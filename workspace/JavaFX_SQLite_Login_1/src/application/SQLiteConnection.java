package application;
import java.sql.*;

public class SQLiteConnection {
	
	public static Connection conectar(){
		
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\dev\\javafx\\workspace\\JavaFX_SQLiteManager_1e");
			return con;
		} catch (Exception e) {
			
			return null;			
		
		}	
	}
}
