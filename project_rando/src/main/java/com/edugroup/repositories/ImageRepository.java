package com.edugroup.repositories;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.edugroup.metier.Image;


public interface ImageRepository 
		extends PagingAndSortingRepository<Image, Integer>,
				ImageRepositoryCustom {

}
