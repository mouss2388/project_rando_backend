package com.edugroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edugroup.metier.Hike;
import com.edugroup.metier.Itinerary;
import com.edugroup.repositories.HikeRepository;
import com.edugroup.repositories.ItineraryRepository;

@Controller
@RequestMapping("/hikes")
@CrossOrigin("http://localhost:4200")
public class HikeController {

	@Autowired
	private HikeRepository hikeRepository;
	
	@GetMapping(value="", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Page<Hike> findAll(@PageableDefault(page = 0, size = 8) Pageable page){
		return hikeRepository.findAll(page);
	}
	
	@GetMapping(value = "/hike-detail/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<Hike> findById(@PathVariable("id") int id) {
		return hikeRepository.findById(id)
								.map(h -> new ResponseEntity<>(h, HttpStatus.OK))
								.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	
	@PostMapping(value="/insert",
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<Hike> createHike(
			@RequestBody Hike hike){
		hike = hikeRepository.save(hike);
		return new ResponseEntity<Hike>(hike, HttpStatus.CREATED);
	}
	
	
}



