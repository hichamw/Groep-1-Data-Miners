package twittertest;

import twitter4j.conf.*;
import twitter4j.*;
import twitter4j.auth.*;
import twitter4j.api.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

public class Twittermain {
	static String searchString = "Euromast";
	
	public static void main(String[] args) throws TwitterException, IOException
	{
		
	    ConfigurationBuilder cb = new ConfigurationBuilder();
	    cb.setDebugEnabled(true);
		cb.setOAuthConsumerKey("7XiGR9ZyIS4k8aTy3mhPndlJ6");
		cb.setOAuthConsumerSecret("kaiU1bqcYNnktvkAnwGKQpCE7y6lzI8CtG4B7VjZPZvHSkZzTE");
		cb.setOAuthAccessToken("180104042-fZnJkN2p6Q2MGXJueOFU8sf6GYP6QMLvQm9883pR");
		cb.setOAuthAccessTokenSecret("QSHx5g3kUSs2DnH4XRZ2T6zRu9aXwKMZP0fAZdl38FyrU");
		
		TwitterFactory tf = new TwitterFactory(cb.build());
		
		Twitter twitter = tf.getInstance();
		try {
			FileOutputStream fos = new FileOutputStream("output.txt"); 
            Query query = new Query("Amsterdam");
            QueryResult result;
            result = twitter.search(query);
            List<Status> tweets = result.getTweets();
            for (Status tweet : tweets) {
                System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
                System.out.println(tweet.getUser().getLocation());
             StreamOutput streamoutput = new StreamOutput(fos, System.out);
             System.setOut(streamoutput);
                
                    
            }
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
           
        }
	}
 }


