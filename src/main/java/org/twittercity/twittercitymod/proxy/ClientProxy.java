package org.twittercity.twittercitymod.proxy;

import org.twittercity.twittercitymod.Reference;
import org.twittercity.twittercitymod.blocks.TCBlockColor;
import org.twittercity.twittercitymod.data.db.Tweet;
import org.twittercity.twittercitymod.gui.TCGuiTweet;
import org.twittercity.twittercitymod.gui.TCGuiTweetLoading;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

/**
 * Code executes only in Client Side
 */
public class ClientProxy extends CommonProxy {

	@Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
        
        //Register block color
        TCBlockColor.registerBlockColors();
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }
    
    @Override
	public void serverStarting(FMLServerStartingEvent e)
	{
		super.serverStarting(e);
	}
    
    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
    	ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Reference.MOD_ID + ":" + id, "inventory"));
    }

	@Override
	public Runnable openTweetGUI(Tweet tweet) {
		return new Runnable() {
			@Override
			public void run() {
				Minecraft.getMinecraft().displayGuiScreen(new TCGuiTweet(tweet));
			}
		};
	}
    
	@Override
	public void openTweetLoadingGUI(int tweetID) {
		Minecraft.getMinecraft().displayGuiScreen(new TCGuiTweetLoading(tweetID));
	}
    
}
