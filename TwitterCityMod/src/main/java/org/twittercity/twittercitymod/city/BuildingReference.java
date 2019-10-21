package org.twittercity.twittercitymod.city;

import java.util.ArrayList;

import org.twittercity.twittercitymod.data.db.Tweet;

/*
 * Everything the tick handlers needs to successfully build all the cities
 */
public class BuildingReference {
	// Do not need to tweetsToBuild. If is not empty it has not used to calculate additional blocks for the city. We will refetch them from the database.
	public static ArrayList<Tweet> tweetsToBuild = new ArrayList<Tweet>(); // Maybe a list to manipulate it easier
	
	public static int tweetsPerTick = 100;
	public static boolean cityPreparationActive = false;
}