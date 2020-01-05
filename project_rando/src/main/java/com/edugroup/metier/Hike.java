package com.edugroup.metier;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name="hikes")
public class Hike {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int id;

	private LocalDateTime creationDate;
	private String name;
	private LocalDateTime hikeDate;
	private String description;
	private String organizer;
	
	@OneToMany(mappedBy = "hike")
	private Set<Itinerary> itinaries;
	
	@OneToMany(mappedBy = "hike")
	private Set<Image> images;
	
	private int note;

}
