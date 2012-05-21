package org.micoli.minecraft.auctionHouse;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.micoli.minecraft.auctionHouse.entities.Auction;
import org.micoli.minecraft.auctionHouse.listeners.AuctionHouseJSONAPIListener;
import org.micoli.minecraft.auctionHouse.listeners.AuctionHouseListener;
import org.micoli.minecraft.auctionHouse.managers.AuctionHouseCommandManager;
import org.micoli.minecraft.bukkit.QDBukkitPlugin;
import org.micoli.minecraft.bukkit.QDCommand;

import com.alecgorge.minecraft.jsonapi.JSONAPI;

// TODO: Auto-generated Javadoc
/**
 * The Class LocalPlan.
 */
public class AuctionHouse extends QDBukkitPlugin implements ActionListener {

	/** The my executor. */
	protected AuctionHouseCommandManager executor;

	/** The instance. */
	private static AuctionHouse instance;

	/**
	 * Gets the single instance of LocalPlan.
	 * 
	 * @return the instance
	 */
	public static AuctionHouse getInstance() {
		return instance;
	}

	/**
	 * On enable.
	 *
	 * @see org.micoli.minecraft.bukkit.QDBukkitPlugin#onEnable()
	 */
	@Override
	public void onEnable() {
		instance = this;
		withDatabase = true;

		commandString = "ah";
		super.onEnable();
		logger.log("%s version enabled", this.pdfFile.getName(), this.pdfFile.getVersion());

		//configFile.set("Test.param1", configFile.getString("Test.param1", getTestParam()));
		//setTestParam(configFile.getString("Test.param1"));

		saveConfig();

		Plugin checkplugin = this.getServer().getPluginManager().getPlugin("JSONAPI");

		if (checkplugin != null) {
			JSONAPI jsonapi = (JSONAPI) checkplugin;
			jsonapi.registerAPICallHandler(new AuctionHouseJSONAPIListener(this));
		}
		getPm().registerEvents(new AuctionHouseListener(this),this);
		
		executor = new AuctionHouseCommandManager(this, new Class[] { getClass() });
	}

	/*
	 * 
	 * @see org.micoli.minecraft.bukkit.QDBukkitPlugin#getDatabaseORMClasses()
	 */
	/* (non-Javadoc)
	 * @see org.micoli.minecraft.bukkit.QDBukkitPlugin#getDatabaseORMClasses()
	 */
	protected java.util.List<Class<?>> getDatabaseORMClasses() {
		List<Class<?>> list = new ArrayList<Class<?>>();
		list.add(Auction.class);
		return list;
	};

	/**
	 * Cmd_list.
	 *
	 * @param sender the sender
	 * @param command the command
	 * @param label the label
	 * @param args the args
	 * @throws Exception the exception
	 */
	@QDCommand(aliases = "list", permissions = { "test.list" }, usage = "", description = "list test")
	public void cmd_list(CommandSender sender, Command command, String label, String[] args) throws Exception {
	}
}