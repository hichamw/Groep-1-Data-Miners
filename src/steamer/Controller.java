package steamer;

public class Controller {

	public static void main(String[] args) {
		Database database = new Database();
		StreamTweets streamer = new StreamTweets();
		database.connectToDatabase();
		streamer.authenticate();
		streamer.stream(database);

		

	}

}
