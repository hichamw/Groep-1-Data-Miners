package steamer;

public class Controller {

	public static void main(String[] args) {
		Database database = new Database();
		StreamTweets streamer = new StreamTweets();
		streamer.authenticate();
		streamer.stream(database);

		

	}

}
