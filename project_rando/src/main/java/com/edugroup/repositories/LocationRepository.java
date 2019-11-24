package com.edugroup.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.edugroup.metier.Location;

public interface LocationRepository extends PagingAndSortingRepository<Location,Integer> {

}
