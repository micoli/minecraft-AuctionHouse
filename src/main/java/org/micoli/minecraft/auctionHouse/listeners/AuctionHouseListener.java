package org.micoli.minecraft.auctionHouse.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.micoli.minecraft.auctionHouse.AuctionHouse;
import org.micoli.minecraft.auctionHouse.entities.InventoryExporter;
import org.micoli.minecraft.utils.Json;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving auctionHouse events.
 * The class that is interested in processing a auctionHouse
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addAuctionHouseListener<code> method. When
 * the auctionHouse event occurs, that object's appropriate
 * method is invoked.
 *
 * @see AuctionHouseEvent
 */
public class AuctionHouseListener implements Listener{
	/** The plugin. */
	AuctionHouse plugin;
	
	/**
	 * Instantiates a new auction house listener.
	 *
	 * @param plugin the plugin
	 */
	public AuctionHouseListener(AuctionHouse plugin) {
		this.plugin = plugin;
	}

	/**
	 * On player quit.
	 *
	 * @param event the event
	 */
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event){
		Json.exportObjectToJson(plugin.getOfflineInventoriesFileName(event.getPlayer().getName()), InventoryExporter.InventoryToStacks(plugin, event.getPlayer()));
	}
}
