package com.bb.primary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bb.primary.model.MCountry;

public interface MCountryRepository extends JpaRepository<MCountry, Long> {

	List<MCountry> findBySiteId(Integer siteId);

	List<MCountry> findBySiteIdAndMenu(Long siteId, int i);

	List<MCountry> findBySiteId(Long siteId);

	List<MCountry> findByProjectIdAndSiteId(Long projectId,Long siteId);

}
