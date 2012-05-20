package org.micoli.minecraft.auctionHouse;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.micoli.minecraft.auctionHouse.entities.Auction;
import org.micoli.minecraft.auctionHouse.entities.InventoryExporter;
import org.micoli.minecraft.auctionHouse.listeners.AuctionHouseListener;
import org.micoli.minecraft.auctionHouse.managers.AuctionHouseCommandManager;
import org.micoli.minecraft.bukkit.QDBukkitPlugin;
import org.micoli.minecraft.bukkit.QDCommand;

import com.alecgorge.minecraft.jsonapi.JSONAPI;
import com.alecgorge.minecraft.jsonapi.api.APIMethodName;
import com.alecgorge.minecraft.jsonapi.api.JSONAPICallHandler;

/**
 * The Class LocalPlan.
 */
public class AuctionHouse extends QDBukkitPlugin implements ActionListener, JSONAPICallHandler {

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
			jsonapi.registerAPICallHandler(this);
		}
		getPm().registerEvents(new AuctionHouseListener(this),this);

		executor = new AuctionHouseCommandManager(this, new Class[] { getClass() });

		for (int i = 1; i < 2; i++) {
			Auction auction = new Auction();
			auction.setSeller(String.format("seller %d", i));
			auction.setItemId(i);
			auction.save();
		}
	}

	/*
	 * 
	 * @see org.micoli.minecraft.bukkit.QDBukkitPlugin#getDatabaseORMClasses()
	 */
	protected java.util.List<Class<?>> getDatabaseORMClasses() {
		List<Class<?>> list = new ArrayList<Class<?>>();
		list.add(Auction.class);
		return list;
	};

	public boolean willHandle(APIMethodName methodName) {
		if(methodName.matches("listAllAuctions")) {
			return true;
		}
		if(methodName.matches("getPlayerInventory")) {
			return true;
		}
		return false;
	}

	public Object handle(APIMethodName methodName, Object[] args) {
		if(methodName.matches("listAllAuctions")) {
			return Auction.getAllAuction();
		}
		if(methodName.matches("getPlayerInventory")) {
			InventoryExporter playerInventory = new InventoryExporter(this,(String)args[0]);
			logger.log("-------%s",playerInventory.toString());
			return playerInventory;
		}
		return "";
	}

	public String getOfflineInventoriesFileName(String userName){
		File path = new File(getDataFolder(),"inventories");
		if (!path.exists()) {
			path.mkdir();
		}
		return path.getAbsolutePath()+'/'+userName+".json";
	}
	/**
	 * Cmd_list.
	 * 
	 * @param sender
	 *            the sender
	 * @param command
	 *            the command
	 * @param label
	 *            the label
	 * @param args
	 *            the args
	 * @throws Exception
	 */
	@QDCommand(aliases = "list", permissions = { "test.list" }, usage = "", description = "list test")
	public void cmd_list(CommandSender sender, Command command, String label, String[] args) throws Exception {
	}
}