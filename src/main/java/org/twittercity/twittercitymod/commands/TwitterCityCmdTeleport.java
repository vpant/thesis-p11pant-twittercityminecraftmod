package org.twittercity.twittercitymod.commands;

import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import org.apache.commons.lang3.ArrayUtils;
import org.twittercity.twittercitymod.city.City;
import org.twittercity.twittercitymod.data.world.CityWorldData;
import org.twittercity.twittercitymod.teleport.TeleportationTools;
import org.twittercity.twittercitymod.worldgen.TwitterCityWorldGenReference;

public class TwitterCityCmdTeleport extends AbstractTwitterCityCommand {
	@Override
	public String getName() {
		return "tc";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "Teleports you to Twitter City dimension if you are not there and two overworld if you are there.";
	}	


	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
		return true;
	}

	// Maybe add twitter city id you want to teleport and defaulting to 1
	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) {
		boolean forceStayInTwitterCityDimension = args.length > 0 && args[0] != null;
		int cityID = fetchInt(sender, args, 0, 0);
		final World world = DimensionManager.getWorld(TwitterCityWorldGenReference.DIM_ID);
		final City city = CityWorldData.get(world).getCity(cityID);
		if (sender instanceof EntityPlayer) {			
			EntityPlayer player = (EntityPlayer) sender;
			if(city != null) {
				teleportPlayerToCity(player, city, forceStayInTwitterCityDimension);
			}
			else if(cityID >= 0) {
				ITextComponent comp;
				if(ArrayUtils.isEmpty(args)) {
					comp = new TextComponentTranslation("twittercity.teleport.nocityexists");
				}
				else {
					comp = new TextComponentTranslation("twittercity.teleport.nosuchcity").appendText(" " + cityID);
				}
				player.sendMessage(comp);
			}
		}
	}
	
	private void teleportPlayerToCity(EntityPlayer player, City city, boolean forceStayToTwitterCityDimension) {
		int currentId = player.getEntityWorld().provider.getDimension();
		int twitterCityDim = TwitterCityWorldGenReference.DIM_ID;
		BlockPos cityStartingPos = city.getSettings().getStartingPos();
		if (currentId != twitterCityDim || forceStayToTwitterCityDimension) {
			// Maybe teleport to first town coordinates
			TeleportationTools.teleportToDimension(player, twitterCityDim, cityStartingPos.add(2, 2, 2), EnumFacing.EAST); 
			if (currentId != twitterCityDim) {
				player.sendMessage(new TextComponentTranslation("twittercity.teleport.welcome"));
			}
		} else {
			BlockPos spawnPoint = player.getBedLocation(0); //Teleport to players spawn point
			if(spawnPoint != null) {
				TeleportationTools.teleportToDimension(player, 0, spawnPoint);
			} else {
				TeleportationTools.teleportToDimension(player, 0, new BlockPos(0, 63, 0));
				BlockPos worldSpawn = player.getEntityWorld().getSpawnPoint();
				player.setPositionAndUpdate(worldSpawn.getX(), 70, worldSpawn.getZ());
			}
		}
	}


}
