package com.edugroup.metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vividsolutions.jts.geom.Point;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name="locations")
public class Location {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int id;
	
	private Point point;

	public Location(int id, Point point) {
		super();
		this.id = id;
		this.point = point;
	}
	
}
