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
	
	/** The seller. */
	String seller = "";

	/** The buyer. */
	String buyer = "";

	/** The start date. */
	Date startDate = new Date();
	
	/** The expiration date. */
	Date expirationDate = new Date();

	/** The quantity. */
	int quantity = 1;
	
	/** The remaining quantity. */
	int remainingQuantity = 1;
	
	/** The min price auction. */
	double bidPrice=0;
	
	/** The remaining min price sale. */
	double remainingBidPrice=0;

	/** The min price sale. */
	double salePrice=0;
	
	/** The remaining min price sale. */
	double remainingSalePrice=0;
	
	/** The open. */
	boolean auctionOpen = true;
	
	/** The splitable. */
	boolean splitable = true; 
	
	/**
	 * Instantiates a new auction.
	 */
	public Auction(){
		setPlugin(AuctionHouse.getInstance());
	}
	
	/**
	 * Gets the all auction.
	 *
	 * @return the all auction
	 */
	public static List<Auction> getAllAuction() {
		return plugin.getStaticDatabase().find(Auction.class).where().eq("auction_open", true).findList();
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
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the item id.
	 *
	 * @return the item id
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * Sets the item id.
	 *
	 * @param itemId the new item id
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
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
	 * @param seller the new seller
	 */
	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	/**
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 *
	 * @param startDate the new start date
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Gets the expiration date.
	 *
	 * @return the expiration date
	 */
	public Date getExpirationDate() {
		return expirationDate;
	}

	/**
	 * Sets the expiration date.
	 *
	 * @param expirationDate the new expiration date
	 */
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
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
	 * @param quantity the new quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Gets the remaining quantity.
	 *
	 * @return the remaining quantity
	 */
	public int getRemainingQuantity() {
		return remainingQuantity;
	}

	/**
	 * Sets the remaining quantity.
	 *
	 * @param remainingQuantity the new remaining quantity
	 */
	public void setRemainingQuantity(int remainingQuantity) {
		this.remainingQuantity = remainingQuantity;
	}

	/**
	 * Gets the bid price.
	 *
	 * @return the bid price
	 */
	public double getBidPrice() {
		return bidPrice;
	}

	/**
	 * Sets the bid price.
	 *
	 * @param bidPrice the new bid price
	 */
	public void setBidPrice(double bidPrice) {
		this.bidPrice = bidPrice;
	}

	/**
	 * Gets the remaining bid price.
	 *
	 * @return the remaining bid price
	 */
	public double getRemainingBidPrice() {
		return remainingBidPrice;
	}

	/**
	 * Sets the remaining bid price.
	 *
	 * @param remainingBidPrice the new remaining bid price
	 */
	public void setRemainingBidPrice(double remainingBidPrice) {
		this.remainingBidPrice = remainingBidPrice;
	}

	/**
	 * Gets the sale price.
	 *
	 * @return the sale price
	 */
	public double getSalePrice() {
		return salePrice;
	}

	/**
	 * Sets the sale price.
	 *
	 * @param salePrice the new sale price
	 */
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	/**
	 * Gets the remaining sale price.
	 *
	 * @return the remaining sale price
	 */
	public double getRemainingSalePrice() {
		return remainingSalePrice;
	}

	/**
	 * Sets the remaining sale price.
	 *
	 * @param remainingSalePrice the new remaining sale price
	 */
	public void setRemainingSalePrice(double remainingSalePrice) {
		this.remainingSalePrice = remainingSalePrice;
	}

	/**
	 * Checks if is auction open.
	 *
	 * @return true, if is auction open
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

	/**
	 * Checks if is splitable.
	 *
	 * @return true, if is splitable
	 */
	public boolean isSplitable() {
		return splitable;
	}

	/**
	 * Sets the splitable.
	 *
	 * @param splitable the new splitable
	 */
	public void setSplitable(boolean splitable) {
		this.splitable = splitable;
	}
}
