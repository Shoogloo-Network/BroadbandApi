package com.bb.primary.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bb.primary.model.BroadBandArttibuteRel;

public interface BroadBandArttibuteRelRepository extends JpaRepository<BroadBandArttibuteRel, Long> {

	List<BroadBandArttibuteRel> findByBroadBandId(Long boradBandId);

	List<BroadBandArttibuteRel> findByBroadBandIdAndStatus(Long id, int i);

	List<BroadBandArttibuteRel> findByBroadBandIdAndStatusAndSiteId(Long id, int i, int j);
	List<Map<String,Object>>	findByBroadbandId(Long boradBandbandId);
	List<Map<String,Object>>	findByBroadbandIds(List<Long> boradBandId);


}
