package org.micoli.minecraft.auctionHouse.exportFormat;

import java.util.List;

import org.bukkit.inventory.PlayerInventory;
import org.micoli.minecraft.auctionHouse.entities.Auction;
import org.micoli.minecraft.utils.Json;

// TODO: Auto-generated Javadoc
/**
 * The Class AuctionsList.
 */
public class AuctionsList {
	
	/** The auction list. */
	private List<Auction> auctionList;
	
	/** The user balance. */
	private double userBalance=0;
	
	/** The player inventory. */
	PlayerInventory playerInventory;
	
	/**
	 * Instantiates a new auctions list.
	 *
	 * @param auctionList the auction list
	 * @param userBalance the user balance
	 * @param playerInventory the player inventory
	 */
	public AuctionsList(List<Auction> auctionList,double userBalance, PlayerInventory playerInventory){
		this.setAuctionList(auctionList);
		this.setUserBalance(userBalance);
		this.setPlayerInventory(playerInventory);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return Json.exportObjectToJson(this);
	}
	
	/**
	 * Gets the auction list.
	 *
	 * @return the auctionList
	 */
	public List<Auction> getAuctionList() {
		return auctionList;
	}
	
	/**
	 * Sets the auction list.
	 *
	 * @param auctionList the auctionList to set
	 */
	public void setAuctionList(List<Auction> auctionList) {
		this.auctionList = auctionList;
	}
	
	/**
	 * Gets the user balance.
	 *
	 * @return the userBalance
	 */
	public double getUserBalance() {
		return userBalance;
	}
	
	/**
	 * Sets the user balance.
	 *
	 * @param userBalance the userBalance to set
	 */
	public void setUserBalance(double userBalance) {
		this.userBalance = userBalance;
	}
	
	/**
	 * Gets the player inventory.
	 *
	 * @return the playerInventory
	 */
	public final PlayerInventory getPlayerInventory() {
		return playerInventory;
	}
	
	/**
	 * Sets the player inventory.
	 *
	 * @param playerInventory the playerInventory to set
	 */
	public final void setPlayerInventory(PlayerInventory playerInventory) {
		this.playerInventory = playerInventory;
	}
}
