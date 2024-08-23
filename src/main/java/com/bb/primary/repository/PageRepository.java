package com.bb.primary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bb.primary.model.Pages;

public interface PageRepository extends JpaRepository<Pages, Long> {

	List<Pages> findBySiteId(Long id);

	Object findByProjectIdAndSiteIdAndStatus(Integer projectId, Long siteId, Integer status);

	List<Pages> findBySiteIdAndStatus(Long siteId, Integer status);

	List<Pages> findBySiteIdAndSeoName(Long siteId, String seoName);



	

}
