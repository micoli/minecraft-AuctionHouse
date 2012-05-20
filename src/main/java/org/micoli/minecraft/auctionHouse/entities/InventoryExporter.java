package org.micoli.minecraft.auctionHouse.entities;

import java.io.File;
import java.util.HashSet;

import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.micoli.minecraft.auctionHouse.AuctionHouse;
import org.micoli.minecraft.utils.Json;

import com.google.gson.reflect.TypeToken;

/**
 * The Class InventoryExporter.
 */
public class InventoryExporter {
	
	/** The item stacks. */
	@SuppressWarnings("unused")
	private HashSet<ItemStack> itemStacks = new HashSet<ItemStack>();

	/**
	 * Instantiates a new inventory exporter.
	 *
	 * @param plugin the plugin
	 * @param userName the user name
	 */
	@SuppressWarnings("unchecked")
	public InventoryExporter(AuctionHouse plugin, String userName) {
		try {
			Server server = plugin.getServer();
			Player player = server.getPlayer(userName);
			if (player == null) {
				OfflinePlayer offlinePlayer = null;
				offlinePlayer = server.getOfflinePlayer(userName);
				if (offlinePlayer == null) {
					return;
				}
				File jsonFile = new File(InventoryExporter.getOfflineInventoriesFileName(userName));
				if(jsonFile.exists()){
					itemStacks = (HashSet<ItemStack>) Json.importFromJson(jsonFile, new TypeToken<HashSet<ItemStack>>() {}.getType());
				}
				return;
			}
			itemStacks = InventoryToStacks(plugin,player);
		} catch (Exception e) {
			plugin.logger.dumpStackTrace(e);
		}
	}
	
	/**
	 * Inventory to stacks.
	 *
	 * @param plugin the plugin
	 * @param player the player
	 * @return the hash set
	 */
	public static HashSet<ItemStack> InventoryToStacks(AuctionHouse plugin,Player player){
		HashSet<ItemStack> iStacks = new HashSet<ItemStack>();
		for (ItemStack itemStack : player.getInventory().getContents()) {
			if(itemStack!=null){
				iStacks.add(itemStack);
			}
		}
		return iStacks;
	}
	
	/**
	 * Gets the offline inventories file name.
	 *
	 * @param userName the user name
	 * @return the offline inventories file name
	 */
	public static String getOfflineInventoriesFileName(String userName){
		File path = new File(AuctionHouse.getInstance().getDataFolder(),"inventories");
		if (!path.exists()) {
			path.mkdir();
		}
		return path.getAbsolutePath()+'/'+userName+".json";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return Json.exportObjectToJson(this);
	}
}
