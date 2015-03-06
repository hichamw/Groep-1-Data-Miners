package steamer;

import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

import java.text.SimpleDateFormat;
import java.util.*;

public class StreamTweets {
	 private ConfigurationBuilder cb = new ConfigurationBuilder();
	 
	 public void authenticate(){
	        cb.setDebugEnabled(true);
	        cb.setOAuthConsumerKey("1HX1bJPnulPUUePvGXv1m4pyg");
	        cb.setOAuthConsumerSecret("PJlfjB0LHRyjgoShDn3qDwQj4PVpSOpPwHCAo4usjq1JRYT2UH");
	        cb.setOAuthAccessToken("118344135-qmUl1sKs0xDP0ek7e5SJ4MSL3TmN8IoRHUdDj6KV");
	        cb.setOAuthAccessTokenSecret("Shmwd9wBQY5890kITQnaHbna1Kmcgh7ZVNUeua1KdogLO");
	        	 
	 }
	 
	 public void stream(Database database){
		 TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
		 StatusListener listener = new StatusListener() {
	        	
	            @Override
	            public void onException(Exception arg0) {
	                // TODO Auto-generated method stub

	            }

	            @Override
	            public void onDeletionNotice(StatusDeletionNotice arg0) {
	                // TODO Auto-generated method stub

	            }

	            @Override
	            public void onScrubGeo(long arg0, long arg1) {
	                // TODO Auto-generated method stub

	            }

	            @Override
	            public void onStatus(Status status) {
	            	
	                User user = status.getUser();
	                String name = user.getName();
	                System.out.println(name);
	                String username = status.getUser().getScreenName();
	                System.out.println(username);
	                String profileLocation = user.getLocation();
	                System.out.println(profileLocation);
	                String language = user.getLang();
	                System.out.println(language);
	                long tweetId = status.getId(); 
	                System.out.println(tweetId);
	                Date dateTime = status.getCreatedAt();
	                SimpleDateFormat sdf = new SimpleDateFormat();
	                sdf.applyPattern("dd/MM/yyyy HH:mm z");
	                String time = sdf.format(dateTime);   
	                System.out.println(time);
	                String content = status.getText();
	                System.out.println(content +"\n");
	                System.out.println("-------------------------");
	                database.insertIntoDatabase(username, name, profileLocation, language, time, content);

	            }

	            @Override
	            public void onTrackLimitationNotice(int arg0) {
	                // TODO Auto-generated method stub

	            }

				@Override
				public void onStallWarning(StallWarning warning) {
					// TODO Auto-generated method stub
					
				}

	        };
	        FilterQuery fq = new FilterQuery();
	    
	        String keywords[] = {"swag"};

	        fq.track(keywords);

	        twitterStream.addListener(listener);
	        twitterStream.filter(fq);  
		 
	 }
}
