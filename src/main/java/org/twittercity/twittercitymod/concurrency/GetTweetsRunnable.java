package org.twittercity.twittercitymod.concurrency;

import net.minecraft.world.WorldServer;
import org.twittercity.twittercitymod.TwitterCity;
import org.twittercity.twittercitymod.city.BuildingReference;
import org.twittercity.twittercitymod.data.db.Tweet;
import org.twittercity.twittercitymod.data.db.TweetManager;

import java.util.ArrayList;

public class GetTweetsRunnable implements Runnable {
	private int id;
	private WorldServer server;
	private ITaskBlocker taskBlocker;
	
	public GetTweetsRunnable(ITaskBlocker taskBlocker, WorldServer worldServer, int id) {
		this.id = id;
		this.server = worldServer;
		this.taskBlocker = taskBlocker;
	}
	
	@Override
	public void run() {
		taskBlocker.acquire();
		try {
			if(!BuildingReference.tweetsToBuild.isEmpty()) {
				return;
			}
			ArrayList<Tweet> tweets = (ArrayList<Tweet>)TweetManager.getInstance().getTweetsAfter(id, 10000);
			TwitterCity.logger.info("Taking tweets after id: {}, the Tweets list size is: {}", id, tweets.size());
			server.addScheduledTask(new Runnable() {
				@Override
				public void run() {
					BuildingReference.tweetsToBuild.addAll(tweets);
				}
			});
		}
		finally {
			taskBlocker.release();
		}
	}
}
