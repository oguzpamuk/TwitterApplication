package read;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * @author oguzcanpamuk
 *
 */

public class PropertiesFile {
	
	private final static String PROP_FILE_NAME = "resources/config.properties";
	private final static String CONSUMER_KEY="consumerKey";
	private final static String CONSUMER_SECRET="consumerSecret";
	private final static String ACCESS_TOKEN="accessToken";
	private final static String ACCESS_TOKEN_SECRET="accessTokenSecret";
	
	private InputStream inputStream;
	private String consumerKey,consumerSecret,accessToken,accessTokenSecret;
	
	public PropertiesFile() throws IOException{setProperties();};
	
	public void setProperties() throws IOException {
		
		try {
			Properties prop = new Properties();

			inputStream = new FileInputStream(PROP_FILE_NAME);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("Property file '" + PROP_FILE_NAME + "' not found in the classpath");
			}
			
			setAccessToken(prop.getProperty(ACCESS_TOKEN));
			setAccessTokenSecret(prop.getProperty(ACCESS_TOKEN_SECRET));
			setConsumerKey(prop.getProperty(CONSUMER_KEY));
			setConsumerSecret(prop.getProperty(CONSUMER_SECRET));

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}

	}

	public String getAccessTokenSecret() {
		return accessTokenSecret;
	}

	public void setAccessTokenSecret(String accessTokenSecret) {
		this.accessTokenSecret = accessTokenSecret;
	}

	public String getConsumerSecret() {
		return consumerSecret;
	}

	public void setConsumerSecret(String consumerSecret) {
		this.consumerSecret = consumerSecret;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getConsumerKey() {
		return consumerKey;
	}

	public void setConsumerKey(String consumerKey) {
		this.consumerKey = consumerKey;
	}
	
    @Override public String toString() {
        return     " Access Token      : "+getAccessToken() +
				   "\n AccessTokenSecret : "+getAccessTokenSecret() +
				   "\n ConsumerKey       : "+getConsumerKey() +
				   "\n ConsumerSecret    : "+getConsumerSecret();
    }
    
/*	public static void main(String[] args) throws IOException{
		PropertiesFile propFile = new PropertiesFile(); 
		System.out.println(propFile.toString());
	}*/
}
