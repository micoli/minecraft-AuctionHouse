package org.micoli.minecraft.auctionHouse.managers;

import net.milkbowl.vault.economy.Economy;

import org.micoli.minecraft.auctionHouse.AuctionHouse;
import org.micoli.minecraft.auctionHouse.entities.Auction;
import org.micoli.minecraft.auctionHouse.entities.AuctionHistory;
import org.micoli.minecraft.utils.PluginEnvironment;

/**
 * @author o.michaud
 *
 */
public class AuctionHouseManager {
	public static String bid(int auctionId,String buyerName,int quantity,double price){
		Auction auction = AuctionHouse.getInstance().getStaticDatabase().find(Auction.class).where().eq("id", auctionId).findUnique();
		if(auction==null){
			return "unknown auction";
		}
		
		if(!auction.isAuctionOpen()){
			return "auction already closed";
		}

		if(price<auction.getMinPriceAuction()){
			return "price inferior to price auction";
		}

		return "1";
	}
	
	public static String buy(int auctionId,String buyerName,double price){
		Auction auction = AuctionHouse.getInstance().getStaticDatabase().find(Auction.class).where().eq("id", auctionId).findUnique();
		Economy economy = PluginEnvironment.getVaultEconomy(AuctionHouse.getInstance());
		if(auction==null){
			return "unknown auction";
		}
		
		if(!auction.isAuctionOpen()){
			return "auction already closed";
		}

		if(price<auction.getMinPriceSale()){
			return "price inferior to sale price";
		}

		if(economy.getBalance(buyerName)<price){
			return "balance inferior to sale price";
		}
		
		auction.setAuctionOpen(false);
		auction.setRemainingQuantity(0);
		auction.setRemainingMinPriceSale(0.0);
		
		AuctionHistory auctionHistory = new AuctionHistory(auction.getId());
		auctionHistory.setBuyer(buyerName);
		auctionHistory.setQuantity(auction.getQuantity());
		auctionHistory.setPrice(auction.getMinPriceSale());
		
		auction.save();
		auctionHistory.save();
		economy.withdrawPlayer(buyerName,price);

		return "ok";
	}
}
