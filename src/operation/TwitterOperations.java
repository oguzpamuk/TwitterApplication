package operation;

import java.util.ArrayList;
import java.util.List;

import connection.TwitterConnection;
import twitter4j.Status;
import twitter4j.TwitterException;

public class TwitterOperations extends TwitterConnection{
	
	public TwitterOperations() throws Exception {
		super();
	}

	public void postTweet(String message){
		try {
			twitter.updateStatus(message);
		} catch (TwitterException e) {
			System.out.println("Exception: " + e);
		}
	}
	
	public List<String> getHomeTimeline(){
	    List<Status> statuses;
	    List<String> tweetList = new ArrayList<String>();
		try {
			statuses = twitter.getHomeTimeline();

		    for (Status status : statuses) {
		        tweetList.add(status.getUser().getName() + ":" +
                        	  status.getText());
		    }
		    
		} catch (TwitterException e) {
			System.out.println("Exception: " + e);
		}
		
		return tweetList;
	}
}
