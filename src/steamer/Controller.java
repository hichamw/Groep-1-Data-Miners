package steamer;

public class Controller {
	//this starts the dataminer program, it makes a database object that connects to the database
	public static void main(String[] args) {
		Database database = new Database();
		StreamTweets streamer = new StreamTweets();
		streamer.authenticate();
		streamer.stream(database);

		

	}

}
