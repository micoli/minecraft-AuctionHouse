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
	
	private static void allocateAuctionToPlayer(String buyerName,int itemId,int quantity){
		AuctionHouse.getInstance().logger.log("Allocation %d*%d to %s",quantity,itemId,buyerName);
	}
	
	public static String bid(int auctionId, String buyerName, double price){
		Economy economy = PluginEnvironment.getVaultEconomy(AuctionHouse.getInstance());
		Auction auction = AuctionHouse.getInstance().getStaticDatabase().find(Auction.class).where().eq("id", auctionId).findUnique();

		if(auction==null){
			return "unknown auction";
		}
		
		if(!auction.isAuctionOpen()){
			return "auction already closed";
		}

		if(price<auction.getRemainingBidPrice()){
			return "price inferior to price auction";
		}

		auction.setAuctionOpen(true);
		auction.setBuyer(buyerName);
		auction.setRemainingBidPrice(price);
		
		AuctionHistory auctionHistory = new AuctionHistory(auction.getId());
		auctionHistory.setBuyer(buyerName);
		auctionHistory.setQuantity(auction.getQuantity());
		auctionHistory.setPrice(auction.getRemainingBidPrice());
		
		auction.save();
		auctionHistory.save();
		economy.withdrawPlayer(buyerName,price);

		return "ok";
	}
	
	public static String buy(int auctionId,String buyerName, double price,int quantity){
		Auction auction = AuctionHouse.getInstance().getStaticDatabase().find(Auction.class).where().eq("id", auctionId).findUnique();
		Economy economy = PluginEnvironment.getVaultEconomy(AuctionHouse.getInstance());
		if(auction==null){
			return "unknown auction";
		}
		
		if(!auction.isAuctionOpen()){
			return "auction already closed";
		}

		if(price<auction.getStackPrice()*quantity){
			return "price inferior to sale price";
		}

		if(economy.getBalance(buyerName)<price){
			return "balance inferior to sale price";
		}

		if(economy.getBalance(buyerName)<price){
			return "balance inferior to sale price";
		}

		if(!auction.isSplitable() && quantity !=auction.getRemainingQuantity()){
			return "item not splitable, quantity different to remaining quantity";
		}
		
		if(quantity >auction.getRemainingQuantity()){
			return "not more stacks for requested quantity";
		}
		
		auction.setRemainingQuantity(auction.getQuantity()-quantity);
		auction.setRemainingSalePrice(auction.getRemainingSalePrice()-price);
		auction.setBuyer(buyerName);
		auction.setRemainingBidPrice(auction.getRemainingBidPrice()-auction.getStackPrice()*quantity);
		auction.setAuctionOpen(auction.getRemainingQuantity()>0);
		
		AuctionHistory auctionHistory = new AuctionHistory(auction.getId());
		auctionHistory.setBuyer(buyerName);
		auctionHistory.setQuantity(auction.getQuantity());
		auctionHistory.setPrice(auction.getRemainingSalePrice());
		
		auction.save();
		auctionHistory.save();
		economy.withdrawPlayer(buyerName,price);
		allocateAuctionToPlayer(buyerName,auction.getItemId(),quantity);

		return "ok";
	}
}