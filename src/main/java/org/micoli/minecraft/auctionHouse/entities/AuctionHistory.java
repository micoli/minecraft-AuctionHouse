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
@Table(name = "morgah_auh_auction_item_history")
public class AuctionHistory {

	/** The plugin. */
	transient static AuctionHouse plugin;
	
	/** The id. */
	@Id
	int id;
	
	int auctionId=0;
	
	/** The quantity. */
	int quantity = 1;
	
	String buyer = "";

	/** The event date. */
	Date eventDate = new Date();
	
	double price=0;
	
	String comment="";;
	
	/**
	 * Instantiates a new auction.
	 */
	public AuctionHistory(int auctionId){
		plugin = AuctionHouse.getInstance();
		setAuctionId(auctionId);
		setEventDate(new Date());
	}
	
	/**
	 * Gets the all auction.
	 *
	 * @return the all auction
	 */
	public static List<AuctionHistory> getAllAuctionHistory(int auctionId) {
		return plugin.getStaticDatabase().find(AuctionHistory.class).where().eq("auctionId",auctionId).orderBy("eventDate desc").findList();
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
	 * @return the id
	 */
	public final int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public final void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the auctionId
	 */
	public final int getAuctionId() {
		return auctionId;
	}

	/**
	 * @param auctionId the auctionId to set
	 */
	public final void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
	}

	/**
	 * @return the quantity
	 */
	public final int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public final void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the buyer
	 */
	public final String getBuyer() {
		return buyer;
	}

	/**
	 * @param buyer the buyer to set
	 */
	public final void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	/**
	 * @return the eventDate
	 */
	public final Date getEventDate() {
		return eventDate;
	}

	/**
	 * @param eventDate the eventDate to set
	 */
	public final void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	/**
	 * @return the price
	 */
	public final double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public final void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the comment
	 */
	public final String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public final void setComment(String comment) {
		this.comment = comment;
	}
}
