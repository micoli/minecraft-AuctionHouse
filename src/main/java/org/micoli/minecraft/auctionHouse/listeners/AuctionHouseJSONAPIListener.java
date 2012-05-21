package org.micoli.minecraft.auctionHouse.listeners;

import org.micoli.minecraft.auctionHouse.AuctionHouse;
import org.micoli.minecraft.auctionHouse.entities.Auction;
import org.micoli.minecraft.auctionHouse.entities.InventoryExporter;
import org.micoli.minecraft.auctionHouse.managers.AuctionHouseManager;

import com.alecgorge.minecraft.jsonapi.api.APIMethodName;
import com.alecgorge.minecraft.jsonapi.api.JSONAPICallHandler;

public class AuctionHouseJSONAPIListener implements JSONAPICallHandler{
	AuctionHouse plugin;
	public AuctionHouseJSONAPIListener(AuctionHouse plugin) {
		this.plugin = plugin;
	}
	/* (non-Javadoc)
	 * @see com.alecgorge.minecraft.jsonapi.api.JSONAPICallHandler#willHandle(com.alecgorge.minecraft.jsonapi.api.APIMethodName)
	 */
	public boolean willHandle(APIMethodName methodName) {
		if(methodName.matches("auctionHouse.listAllAuctions")) {
			return true;
		}
		if(methodName.matches("auctionHouse.getPlayerInventory")) {
			return true;
		}
		if(methodName.matches("auctionHouse.bid")) {
			return true;
		}
		if(methodName.matches("auctionHouse.buy")) {
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.alecgorge.minecraft.jsonapi.api.JSONAPICallHandler#handle(com.alecgorge.minecraft.jsonapi.api.APIMethodName, java.lang.Object[])
	 */
	public Object handle(APIMethodName methodName, Object[] args) {
		if(methodName.matches("auctionHouse.listAllAuctions")) {
			return Auction.getAllAuction();
		}
		if(methodName.matches("auctionHouse.getPlayerInventory")) {
			return new InventoryExporter(plugin, (String)args[0]);
		}
		if(methodName.matches("auctionHouse.bid")) {
			return AuctionHouseManager.bid(Integer.parseInt((String)args[0]), (String)args[1], Integer.parseInt((String)args[2]), Double.parseDouble((String)args[3]));
		}
		if(methodName.matches("auctionHouse.buy")) {
			return AuctionHouseManager.buy(Integer.parseInt((String)args[0]), (String)args[1], Double.parseDouble((String)args[2]));
		}
		
		return "";
	}
}
