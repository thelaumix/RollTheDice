package com.github.r0306.RollTheDice;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import pgDev.bukkit.DisguiseCraft.DisguiseCraft;
import pgDev.bukkit.DisguiseCraft.api.DisguiseCraftAPI;

import com.github.r0306.RollTheDice.DiceHandlers.Arena;
import com.github.r0306.RollTheDice.DiceHandlers._1;
import com.github.r0306.RollTheDice.DiceHandlers._10;
import com.github.r0306.RollTheDice.DiceHandlers._11;
import com.github.r0306.RollTheDice.DiceHandlers._12;
import com.github.r0306.RollTheDice.DiceHandlers._13;
import com.github.r0306.RollTheDice.DiceHandlers._14;
import com.github.r0306.RollTheDice.DiceHandlers._16;
import com.github.r0306.RollTheDice.DiceHandlers._17;
import com.github.r0306.RollTheDice.DiceHandlers._18;
import com.github.r0306.RollTheDice.DiceHandlers._19;
import com.github.r0306.RollTheDice.DiceHandlers._2;
import com.github.r0306.RollTheDice.DiceHandlers._20;
import com.github.r0306.RollTheDice.DiceHandlers._21;
import com.github.r0306.RollTheDice.DiceHandlers._22;
import com.github.r0306.RollTheDice.DiceHandlers._23;
import com.github.r0306.RollTheDice.DiceHandlers._24;
import com.github.r0306.RollTheDice.DiceHandlers._25;
import com.github.r0306.RollTheDice.DiceHandlers._26;
import com.github.r0306.RollTheDice.DiceHandlers._27;
import com.github.r0306.RollTheDice.DiceHandlers._28;
import com.github.r0306.RollTheDice.DiceHandlers._29;
import com.github.r0306.RollTheDice.DiceHandlers._3;
import com.github.r0306.RollTheDice.DiceHandlers._30;
import com.github.r0306.RollTheDice.DiceHandlers._31;
import com.github.r0306.RollTheDice.DiceHandlers._32;
import com.github.r0306.RollTheDice.DiceHandlers._34;
import com.github.r0306.RollTheDice.DiceHandlers._35;
import com.github.r0306.RollTheDice.DiceHandlers._36;
import com.github.r0306.RollTheDice.DiceHandlers._37;
import com.github.r0306.RollTheDice.DiceHandlers._4;
import com.github.r0306.RollTheDice.DiceHandlers._5;
import com.github.r0306.RollTheDice.DiceHandlers._7;
import com.github.r0306.RollTheDice.DiceHandlers._8;
import com.github.r0306.RollTheDice.DiceHandlers._9;
import com.github.r0306.RollTheDice.Disguise.DisguiseListeners;
import com.github.r0306.RollTheDice.Handlers.PlayerHandlers;
import com.github.r0306.RollTheDice.KillStreaks.CarePackage;
import com.github.r0306.RollTheDice.Util.Colors;
import com.github.r0306.RollTheDice.Util.Plugin;
import com.github.r0306.RollTheDice.Util.Util;

public class RollTheDice extends JavaPlugin implements Colors
{
	
	public static String version = "";
	public static String website = "";
	private Executor myExecutor;
	public static Plugin p;
	public static DisguiseCraftAPI disguiseAPI;
	
	public void onEnable()
	{
		
		loadConfig();
		version = getDescription().getVersion();
		website = getDescription().getWebsite();
    	myExecutor = new Executor(this);
		getCommand("rtd").setExecutor(myExecutor);
		p = new Plugin(this);
		setUpAPI();
		getServer().getPluginManager().registerEvents(new PlayerHandlers(this), this);
		getServer().getPluginManager().registerEvents(new DisguiseListeners(), this);
		registerAllDiceEvents(getServer().getPluginManager());
		registerAllKillStreaks(getServer().getPluginManager());
		System.out.println("RollTheDice version [" + getDescription().getVersion() + "] loaded.");
		
	}
		
	public void onDisable()
	{
		
		restoreInventories();
		System.out.println("RollTheDice version [" + getDescription().getVersion() + "] unloaded.");
		
	}
	
	public void loadConfig()
	{
		
		List<String> list = new ArrayList<String>();
		
		FileConfiguration cfg = this.getConfig();
		FileConfigurationOptions cfgOptions = cfg.options();
		cfg.addDefault("RTD.World", Bukkit.getServer().getWorlds().get(0).getName());
		cfg.addDefault("RTD.Enabled", true);
		cfg.addDefault("RTD.Minimum", 5);
		cfg.addDefault("RTD.Delay", 60);
		cfg.addDefault("RTD.Time-Limit", 10);
		cfg.createSection("Data");
		cfg.addDefault("Players.List", list);
		cfgOptions.copyDefaults(true);
		cfgOptions.header("This is the RollTheDice configuration file.");
		cfgOptions.copyHeader(true);
		saveConfig();
		
	}
	
	public void restoreInventories()
	{
		
		for (String name : Arena.inMatch)
		{
			
			Player p = Bukkit.getPlayerExact(name);
			
			Util.restoreEverything(p);
			p.sendMessage(gold + pluginName + daqua + "The match has ended because of a server reload.");
			
		}
		
	}
	
	
	public void registerAllDiceEvents(PluginManager pm)
	{
		
		pm.registerEvents(new _1(), this);
		pm.registerEvents(new _2(), this);
		pm.registerEvents(new _3(), this);
		pm.registerEvents(new _4(), this);
		pm.registerEvents(new _5(), this);
		pm.registerEvents(new _7(), this);
		pm.registerEvents(new _8(), this);
		pm.registerEvents(new _9(), this);
		pm.registerEvents(new _10(), this);
		pm.registerEvents(new _11(), this);
		pm.registerEvents(new _12(), this);
		pm.registerEvents(new _13(), this);
		pm.registerEvents(new _14(), this);
		pm.registerEvents(new _16(), this);
		pm.registerEvents(new _17(), this);
		pm.registerEvents(new _18(), this);
		pm.registerEvents(new _19(), this);
		pm.registerEvents(new _20(), this);
		pm.registerEvents(new _21(), this);
		pm.registerEvents(new _22(), this);
		pm.registerEvents(new _23(), this);
		pm.registerEvents(new _24(), this);
		pm.registerEvents(new _25(), this);
		pm.registerEvents(new _26(), this);
		pm.registerEvents(new _27(), this);
		pm.registerEvents(new _28(), this);
		pm.registerEvents(new _29(), this);
		pm.registerEvents(new _30(), this);
		pm.registerEvents(new _31(), this);
		pm.registerEvents(new _32(), this);
		pm.registerEvents(new _34(), this);
		pm.registerEvents(new _35(), this);
		pm.registerEvents(new _36(), this);
		pm.registerEvents(new _37(), this);
		
	}
	
	public void registerAllKillStreaks(PluginManager pm)
	{
		
		pm.registerEvents(new CarePackage(), this);
		
	}
	
	public void setUpAPI()
	{
		
		if (getServer().getPluginManager().getPlugin("DisguiseCraft") != null)
		{
			
			disguiseAPI = DisguiseCraft.getAPI();
			
		}
		
	}

}
