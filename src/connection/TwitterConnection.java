package connection;



import read.PropertiesFile;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * 
 * @author oguzcanpamuk
 *
 */

public class TwitterConnection {

	protected Twitter twitter;
	
	public TwitterConnection() throws Exception{init();};
	
	public void init() throws Exception{
		PropertiesFile prop = new PropertiesFile();
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey(prop.getConsumerKey())
		  .setOAuthConsumerSecret(prop.getConsumerSecret())
		  .setOAuthAccessToken(prop.getAccessToken())
		  .setOAuthAccessTokenSecret(prop.getAccessTokenSecret());
		TwitterFactory twitterFactory = new TwitterFactory(cb.build());
		twitter = twitterFactory.getInstance();
		if(twitter==null)
			throw new NullPointerException("Twitter instance is null");
	}
	
	public Twitter getTwitter(){
		return(this.twitter);
	}

}
