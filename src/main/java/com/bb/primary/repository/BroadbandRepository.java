package com.bb.primary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bb.controller.helper.BroadBandView;
import com.bb.primary.model.Broadband;

public interface BroadbandRepository extends JpaRepository<Broadband, Long> {

	List<Broadband> findBySiteId(int id);

	List<Broadband> findBySiteIdAndProviderId(Integer siteId, Long providerId);

	List<Broadband> findBySiteIdAndStatus(Integer siteId, String status);

	List<Broadband> findByStatus(String string);

	Broadband getBySiteIdAndSeoNameAndStatus(Long siteId, String seoName, String i);

	List<Broadband> findBySiteIdAndSpeedGreaterThanEqual(Integer siteId, int parseInt);

	List<Broadband> findBySiteIdAndStatusAndSpeedGreaterThanEqual(Integer siteId, String status, int parseInt);

	List<Broadband> findBySiteIdAndCostLessThanEqual(Integer siteId, int parseInt);

	List<Broadband> findBySiteIdAndStatusAndCostLessThanEqual(Integer siteId, String status, int parseInt);

	List<Broadband> findBySiteIdAndStatusAndSpeedScale(Integer siteId, String status, String string);

	Broadband getBySiteIdAndNameAndStatus(Long siteId, String seoName, String string);

	List<Broadband> findBySiteIdAndStatusOrderBySortingOrder(Integer siteId, String status);

	List<Broadband> findBySiteIdAndSpeedGreaterThanEqualOrderBySortingOrder(Integer siteId, int parseInt);

	List<Broadband> findBySiteIdAndCostLessThanEqualOrderBySortingOrder(Integer siteId, int parseInt);

	List<Broadband> findBySiteIdAndStatusAndSpeedScaleOrderBySortingOrder(Integer siteId, String status, String string);

	List<Broadband> findBySiteIdAndStatusAndSpeedGreaterThanEqualOrderBySortingOrder(Integer siteId, String status, int parseInt);

	List<Broadband> findBySiteIdAndStatusAndCostLessThanEqualOrderBySortingOrder(Integer siteId, String status, int parseInt);

}
