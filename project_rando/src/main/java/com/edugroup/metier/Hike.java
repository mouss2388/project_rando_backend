package com.edugroup.metier;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@OneToOne
	private Itinerary mapItinerary;
	private int note;

}
