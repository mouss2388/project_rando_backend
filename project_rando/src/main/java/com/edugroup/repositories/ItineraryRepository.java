package com.edugroup.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.edugroup.metier.Itinerary;

public interface ItineraryRepository extends PagingAndSortingRepository<Itinerary,Integer> {

}
