package steamer;

import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;


public class Database {
	private Connection conn = null;
	
	public void connectToDatabase(){
			String host = "sql3.freemysqlhosting.net";
			String DBName = "sql369437";
			String user = "sql369437";
			String password = "yH1%hH1*";
			String encPassword = URLEncoder.encode(password);
			try {
	            conn = DriverManager.getConnection("jdbc:mysql://" + host +"/"+ DBName +"?user=" + user + "&password=" + encPassword + "");
	            System.out.println("Database connected!");
	           
	        } catch (SQLException ex) {
	            // handle any errors
	            System.out.println("SQLException: " + ex.getMessage());
	            System.out.println("SQLState: " + ex.getSQLState());
	            System.out.println("VendorError: " + ex.getErrorCode());
	        }
		
		
	}
	
	public void insertIntoDatabase(String username, String name, String location, String language, String time, String content){
		try {
			conn.createStatement().execute("INSERT INTO Twitter(Username, Name, Location, Language, Time, Content) VALUES ('" + username + "','" + name + "','" + location + "','" + language + "','" + time + "','" + content + "')");
			System.out.println("Successfully Inserted data");
           
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
		
		
	}
	

}
