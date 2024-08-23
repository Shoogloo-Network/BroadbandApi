package com.bb.primary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bb.primary.model.MCity;

public interface MCityRepository extends JpaRepository<MCity, Long> {

	List<MCity> findBySiteId(Integer siteId);

	List<MCity> findBySiteIdAndMenu(Long siteId, int i);

	List<MCity>  findBySiteIdAndStatus(Integer siteId, String status);

	List<MCity> findBySiteIdAndSeoName(Long siteId, String seoName);

	List<MCity> findBySiteId(Long siteId);

	 MCity findBySeoName(String seoName);

	List<MCity> findBySiteIdAndStatusOrderBySortingOrder(Integer siteId, String status);

	List<MCity> findBySiteIdOrderBySortingOrder(Integer siteId);

	List<MCity> findBySiteIdAndCountryIdAndStatusOrderBySortingOrder(Integer siteId, Long countryId, String status);

}
