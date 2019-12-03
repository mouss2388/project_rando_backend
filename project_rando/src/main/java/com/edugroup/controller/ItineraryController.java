package com.edugroup.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edugroup.metier.Itinerary;
import com.edugroup.metier.Location;
import com.edugroup.repositories.ItineraryRepository;

@Controller
@RequestMapping("/list-of-itineraries")
@CrossOrigin("http://localhost:4200")
public class ItineraryController {

	@Autowired
	private ItineraryRepository itineraryRepository;
	
	@GetMapping(value="", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Page<Itinerary> findAll(@PageableDefault(page = 0, size = 8) Pageable page){
		return itineraryRepository.findAll(page);
	}
	
	@PostMapping(value="/insert",
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<Itinerary> createItinerary(
			@RequestBody Itinerary itinerary){
		itinerary = itineraryRepository.save(itinerary);
		return new ResponseEntity<Itinerary>(itinerary, HttpStatus.CREATED);
	}

}
