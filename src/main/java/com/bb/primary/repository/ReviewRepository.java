package com.bb.primary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bb.primary.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

	List<Review> findBySiteId(Integer id);
	List<Review>  findBySiteIdAndStatus(Integer siteId, Integer i);
	List<Review> findBySiteIdAndCategoryAndStatus(Integer siteId, String cat, Integer status);
	List<Review> findBySiteIdAndCategoryAndEntityIdAndStatus(Integer siteId, String cat, Integer id, Integer status);


}
