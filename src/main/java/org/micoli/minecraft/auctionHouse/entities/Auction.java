package org.micoli.minecraft.auctionHouse.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.micoli.minecraft.auctionHouse.AuctionHouse;
import org.micoli.minecraft.utils.Json;


// TODO: Auto-generated Javadoc
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
	
	/**
	 * Instantiates a new auction.
	 */
	public Auction(){
		plugin = AuctionHouse.getInstance();
	}
	
	/**
	 * Gets the all auction.
	 *
	 * @return the all auction
	 */
	public static List<Auction> getAllAuction() {
		return plugin.getStaticDatabase().find(Auction.class).findList();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
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
	 * Gets the plugin.
	 *
	 * @return the plugin
	 */
	public static AuctionHouse getPlugin() {
		return plugin;
	}

	/**
	 * Sets the plugin.
	 *
	 * @param plugin the plugin to set
	 */
	public static void setPlugin(AuctionHouse plugin) {
		Auction.plugin = plugin;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the item id.
	 *
	 * @return the itemId
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * Sets the item id.
	 *
	 * @param itemId the itemId to set
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	/**
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Sets the quantity.
	 *
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Gets the seller.
	 *
	 * @return the seller
	 */
	public String getSeller() {
		return seller;
	}

	/**
	 * Sets the seller.
	 *
	 * @param seller the seller to set
	 */
	public void setSeller(String seller) {
		this.seller = seller;
	}

	/**
	 * Gets the start date.
	 *
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 *
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Gets the min price auction.
	 *
	 * @return the minPriceAuction
	 */
	public double getMinPriceAuction() {
		return minPriceAuction;
	}

	/**
	 * Sets the min price auction.
	 *
	 * @param minPriceAuction the minPriceAuction to set
	 */
	public void setMinPriceAuction(double minPriceAuction) {
		this.minPriceAuction = minPriceAuction;
	}

	/**
	 * Gets the min price sale.
	 *
	 * @return the minPriceSale
	 */
	public double getMinPriceSale() {
		return minPriceSale;
	}

	/**
	 * Sets the min price sale.
	 *
	 * @param minPriceSale the minPriceSale to set
	 */
	public void setMinPriceSale(double minPriceSale) {
		this.minPriceSale = minPriceSale;
	}

	/**
	 * Gets the expiration date.
	 *
	 * @return the expirationDate
	 */
	public Date getExpirationDate() {
		return expirationDate;
	}

	/**
	 * Sets the expiration date.
	 *
	 * @param expirationDate the expirationDate to set
	 */
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 * Checks if is auction open.
	 *
	 * @return the open
	 */
	public boolean isAuctionOpen() {
		return auctionOpen;
	}

	/**
	 * Sets the auction open.
	 *
	 * @param auctionOpen the new auction open
	 */
	public void setAuctionOpen(boolean auctionOpen) {
		this.auctionOpen = auctionOpen;
	}
}
