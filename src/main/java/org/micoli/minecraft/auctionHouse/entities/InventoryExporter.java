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

public class InventoryExporter {

	@SuppressWarnings("unused")
	private HashSet<ItemStack> itemStacks = new HashSet<ItemStack>();

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
				File jsonFile = new File(plugin.getOfflineInventoriesFileName(userName));
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
	
	public static HashSet<ItemStack> InventoryToStacks(AuctionHouse plugin,Player player){
		HashSet<ItemStack> iStacks = new HashSet<ItemStack>();
		for (ItemStack itemStack : player.getInventory().getContents()) {
			if(itemStack!=null){
				iStacks.add(itemStack);
			}
		}
		return iStacks;
	}

	public String toString() {
		return Json.exportObjectToJson(this);
	}
}