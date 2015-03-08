package steamer;

import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;


public class Database {
	private Connection conn = null;
	private int insertCounter = 0;
	
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
	
	public String makeCompatible(String importedString){
		String exportString;
		exportString = importedString.replace("'", "''");
		return exportString;
		
	}
	
	public void insertIntoDatabase(String username, String name, String location, String language, String time, String content){
		try {
			conn.createStatement().execute("INSERT INTO Twitter(Username, Name, Location, Language, Time, Content) VALUES ('" + username + "','" + name + "','" + location + "','" + language + "','" + time + "','" + content + "')");
			insertCounter++;
			System.out.println(insertCounter + " sessions inserted into the Database.");
			
           
        } catch (SQLException ex) {
            // handle any errors
        	System.out.println("username: " + username);
        	System.out.println("name: " + username);
        	System.out.println("location: " + location);
        	System.out.println("language: " + language);
        	System.out.println("time: " + time);
        	System.out.println("content: " + content + "\n");
        	
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            
        }
		
		
	}
	

}
