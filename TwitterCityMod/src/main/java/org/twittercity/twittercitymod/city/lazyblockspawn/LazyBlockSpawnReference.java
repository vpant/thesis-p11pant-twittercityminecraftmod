package org.twittercity.twittercitymod.city.lazyblockspawn;

import java.util.LinkedList;

import org.twittercity.twittercitymod.util.BlockData;

public class LazyBlockSpawnReference {
	
	public static LinkedList<BlockData> toSpawn = new LinkedList<>();
	
	public static Integer blocksPerTick = 10;
	
	public static int startingSize = 0;

	public static int updateDelay = 1000;
	
	public static boolean isLazySpawnPaused = false;
}