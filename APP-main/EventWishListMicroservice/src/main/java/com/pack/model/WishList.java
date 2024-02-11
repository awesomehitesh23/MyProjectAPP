package com.pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Wishlist")
public class WishList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "wishlist_id")
	private int wishlistId;
	
	@Column(name = "event_id")
	private long eventId;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "event_type")
	private String eventType;

	@Column(name = "datetime_utc")
	private String datetime_utc;

	@Column(name = "venue_name")
	private String venueName;

	@Column(name = "venue_capacity")
	private String venueCapacity;

	@Column(name = "performer_name")
	private String performerName;

	public int getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(int wishlistId) {
		this.wishlistId = wishlistId;
	}

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getDatetime_utc() {
		return datetime_utc;
	}

	public void setDatetime_utc(String datetime_utc) {
		this.datetime_utc = datetime_utc;
	}

	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	public String getVenueCapacity() {
		return venueCapacity;
	}

	public void setVenueCapacity(String venueCapacity) {
		this.venueCapacity = venueCapacity;
	}

	public String getPerformerName() {
		return performerName;
	}

	public void setPerformerName(String performerName) {
		this.performerName = performerName;
	}

	public WishList(int wishlistId, long eventId, int userId, String eventType, String datetime_utc, String venueName,
			String venueCapacity, String performerName) {
		super();
		this.wishlistId = wishlistId;
		this.eventId = eventId;
		this.userId = userId;
		this.eventType = eventType;
		this.datetime_utc = datetime_utc;
		this.venueName = venueName;
		this.venueCapacity = venueCapacity;
		this.performerName = performerName;
	}

	public WishList() {
		
	}

	
	
	
}
