package com.pack.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Event {
	 private String type;
     private long id;
     private String datetime_utc;
     private Venue venue;
     private List<Performer> performers;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDatetime_utc() {
		return datetime_utc;
	}
	public void setDatetime_utc(String datetime_utc) {
		this.datetime_utc = datetime_utc;
	}
	public Venue getVenue() {
		return venue;
	}
	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	public List<Performer> getPerformers() {
		return performers;
	}
	public void setPerformers(List<Performer> performers) {
		this.performers = performers;
	}
	public Event(String type, long id, String datetime_utc, Venue venue, List<Performer> performers) {
		super();
		this.type = type;
		this.id = id;
		this.datetime_utc = datetime_utc;
		this.venue = venue;
		this.performers = performers;
	}
	public Event() {
		
	}

     
}
