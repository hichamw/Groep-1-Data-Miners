package steamer;

import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {
	private Connection conn = null;
	private int insertCounter = 0;

	//connection to database
	public void connectToDatabase(){
			String host = "145.24.222.208:8124";
			String DBName = "dataminers";
			String user = "server";
			String password = "dataminer";
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
	

	//this method inserts the data into the database using queries that contain the information that is gathered in the streamtweets class
	public void insertIntoDatabase(String username, String name, String location, String language, String time, String content, double tweetLatitude, double tweetLongitude){
		try {
			
			conn.createStatement().execute("INSERT INTO twitter_user(Username, Name, Location, Lang) VALUES ('" + username + "','" + name + "','" + location + "','" + language + "') ON DUPLICATE KEY UPDATE Username='" + username + "'");
			conn.createStatement().execute("INSERT INTO message(Date, Content, TWITTER_USER_Username, Latitude, Longitude) VALUES ('" + time + "','" + content + "','" + username + "','" + tweetLatitude + "','" + tweetLongitude + "')");
			conn.close();
			insertCounter++;	
			System.out.println(insertCounter + " sessions inserted into the Database.");
			
			
        //error catching
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
