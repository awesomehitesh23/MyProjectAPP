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

}
