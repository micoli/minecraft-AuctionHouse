package org.micoli.minecraft.auctionHouse.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.micoli.minecraft.auctionHouse.AuctionHouse;
import org.micoli.minecraft.utils.Json;


/**
 * The Class Auction.
 */
@Entity
@Table(name = "morgah_aui_auction_item")
public class Auction {

	/** The plugin. */
	transient static AuctionHouse plugin;
	
	/** The id. */
	@Id
	int id;
	
	/** The item id. */
	int itemId = 1;
	
	/** The quantity. */
	int quantity = 1;
	
	/** The seller. */
	String seller = "";
	
	/** The start date. */
	Date startDate = new Date();
	
	/** The min price auction. */
	double minPriceAuction=0;
	
	/** The min price sale. */
	double minPriceSale=0;
	
	/** The expiration date. */
	Date expirationDate = new Date();
	
	/** The open. */
	boolean auctionOpen = true;
	
	public Auction(){
		plugin = AuctionHouse.getInstance();
	}
	public static List<Auction> getAllAuction() {
		return plugin.getStaticDatabase().find(Auction.class).findList();
	}
	
	public String toString(){
		return Json.exportObjectToJson(this);
	}

	/**
	 * Save.
	 */
	public void save() {
		plugin.getStaticDatabase().save(this);
	}

	/**
	 * Delete.
	 */
	public void delete() {
		plugin.getStaticDatabase().delete(this);
	}


	/**
	 * @return the plugin
	 */
	public static AuctionHouse getPlugin() {
		return plugin;
	}

	/**
	 * @param plugin the plugin to set
	 */
	public static void setPlugin(AuctionHouse plugin) {
		Auction.plugin = plugin;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the itemId
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the seller
	 */
	public String getSeller() {
		return seller;
	}

	/**
	 * @param seller the seller to set
	 */
	public void setSeller(String seller) {
		this.seller = seller;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the minPriceAuction
	 */
	public double getMinPriceAuction() {
		return minPriceAuction;
	}

	/**
	 * @param minPriceAuction the minPriceAuction to set
	 */
	public void setMinPriceAuction(double minPriceAuction) {
		this.minPriceAuction = minPriceAuction;
	}

	/**
	 * @return the minPriceSale
	 */
	public double getMinPriceSale() {
		return minPriceSale;
	}

	/**
	 * @param minPriceSale the minPriceSale to set
	 */
	public void setMinPriceSale(double minPriceSale) {
		this.minPriceSale = minPriceSale;
	}

	/**
	 * @return the expirationDate
	 */
	public Date getExpirationDate() {
		return expirationDate;
	}

	/**
	 * @param expirationDate the expirationDate to set
	 */
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 * @return the open
	 */
	public boolean isAuctionOpen() {
		return auctionOpen;
	}

	/**
	 * @param open the open to set
	 */
	public void setAuctionOpen(boolean auctionOpen) {
		this.auctionOpen = auctionOpen;
	}
}
