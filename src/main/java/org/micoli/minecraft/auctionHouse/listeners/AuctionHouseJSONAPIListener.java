package org.micoli.minecraft.auctionHouse.listeners;

import java.util.List;

import org.micoli.minecraft.auctionHouse.AuctionHouse;
import org.micoli.minecraft.auctionHouse.entities.Auction;
import org.micoli.minecraft.auctionHouse.entities.InventoryExporter;
import org.micoli.minecraft.auctionHouse.managers.AuctionHouseManager;

import com.alecgorge.minecraft.jsonapi.dynamic.API_Method;
import com.alecgorge.minecraft.jsonapi.dynamic.JSONAPIMethodProvider;

public class AuctionHouseJSONAPIListener implements JSONAPIMethodProvider{
	AuctionHouse plugin;
	public AuctionHouseJSONAPIListener() {
		this.plugin = AuctionHouse.getInstance();
	}
	
	
	@API_Method(
		namespace = "auctionHouse",
		name="bid",
		argumentDescriptions = {
			"auctionId",
			"buyerName",
			"price"
		
		}
	)
	public String bid(String auctionId,String buyerName,String price ){
		return AuctionHouseManager.bid(Integer.parseInt(auctionId), buyerName, Double.parseDouble(price));
	}
		
	@API_Method(
		namespace = "auctionHouse",
		name="buy",
		argumentDescriptions = {
			"auctionId",
			"buyerName",
			"price",
			"quantity"
		}
	)
	public String bid(String auctionId,String buyerName,String price, String quantity){
		return AuctionHouseManager.buy(Integer.parseInt(auctionId), buyerName, Double.parseDouble(price),Integer.parseInt(quantity));
	}
		
	@API_Method(
		namespace = "auctionHouse",
		name="getPlayerInventory",
		argumentDescriptions = {
			"userName"
		}
	)
	public InventoryExporter getPlayerInventory(String username) {
		return new InventoryExporter(plugin, username);
	}

	@API_Method(
		namespace = "auctionHouse",
		name="listAllAuctions",
		argumentDescriptions = {
				"userName"
			}
	)
	public List<Auction> listAllAuctions(String userName) {
		return Auction.getAllAuction();
	}

}
