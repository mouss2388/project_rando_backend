package com.edugroup.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.edugroup.metier.Hike;

public interface HikeRepository extends PagingAndSortingRepository<Hike,Integer> {

}
