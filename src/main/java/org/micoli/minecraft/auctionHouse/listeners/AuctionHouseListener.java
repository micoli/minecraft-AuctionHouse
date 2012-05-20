package org.micoli.minecraft.auctionHouse.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.micoli.minecraft.auctionHouse.AuctionHouse;
import org.micoli.minecraft.auctionHouse.entities.InventoryExporter;
import org.micoli.minecraft.utils.Json;

public class AuctionHouseListener implements Listener{
	/** The plugin. */
	AuctionHouse plugin;
	
	public AuctionHouseListener(AuctionHouse plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event){
		Json.exportObjectToJson(plugin.getOfflineInventoriesFileName(event.getPlayer().getName()), InventoryExporter.InventoryToStacks(plugin, event.getPlayer()));
	}
}
