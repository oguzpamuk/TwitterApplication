package app;

import operation.TwitterOperations;

public class Run {

	public static void main(String[] args) throws Exception {
		TwitterOperations twitterOp = new TwitterOperations();
		
		for(String str : twitterOp.getHomeTimeline()){
			System.out.println(str);
		}
	}
}
