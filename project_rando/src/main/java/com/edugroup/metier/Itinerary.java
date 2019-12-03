package com.edugroup.metier;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name="itineraries")
public class Itinerary {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int id;
	
	private LocalDateTime creationDate;
	private LocalDateTime updateDate;
	private String creator;
	@OneToMany( mappedBy = "itinerary")
	private Set<Location> locations;

	
	public Itinerary(int id, LocalDateTime creationDate, LocalDateTime updateDate, String creator) {
		super();
		this.id = id;
		this.creationDate = creationDate;
		this.updateDate = updateDate;
		this.creator = creator;
	}
	
	@PrePersist
	private void createItinerary() {
		setCreationDate(LocalDateTime.now());
	}

	

}
