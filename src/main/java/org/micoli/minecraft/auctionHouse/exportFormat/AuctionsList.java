package org.micoli.minecraft.auctionHouse.exportFormat;

import java.util.List;

import org.bukkit.inventory.PlayerInventory;
import org.micoli.minecraft.auctionHouse.entities.Auction;
import org.micoli.minecraft.utils.Json;

public class AuctionsList {
	private List<Auction> auctionList;
	private double userBalance=0;
	PlayerInventory playerInventory;
	public AuctionsList(List<Auction> auctionList,double userBalance, PlayerInventory playerInventory){
		this.setAuctionList(auctionList);
		this.setUserBalance(userBalance);
		this.setPlayerInventory(playerInventory);
	}
	public String toString(){
		return Json.exportObjectToJson(this);
	}
	/**
	 * @return the auctionList
	 */
	public List<Auction> getAuctionList() {
		return auctionList;
	}
	/**
	 * @param auctionList the auctionList to set
	 */
	public void setAuctionList(List<Auction> auctionList) {
		this.auctionList = auctionList;
	}
	/**
	 * @return the userBalance
	 */
	public double getUserBalance() {
		return userBalance;
	}
	/**
	 * @param userBalance the userBalance to set
	 */
	public void setUserBalance(double userBalance) {
		this.userBalance = userBalance;
	}
	
	/**
	 * @return the playerInventory
	 */
	public final PlayerInventory getPlayerInventory() {
		return playerInventory;
	}
	/**
	 * @param playerInventory the playerInventory to set
	 */
	public final void setPlayerInventory(PlayerInventory playerInventory) {
		this.playerInventory = playerInventory;
	}
}
