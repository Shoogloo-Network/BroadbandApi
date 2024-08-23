package com.bb.primary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bb.primary.model.BroadbandAttributeValue;

public interface BroadbandAttributeValueRepository extends JpaRepository<BroadbandAttributeValue, Long> {

	List<BroadbandAttributeValue> findByBroadbandAttributeId(Long id);




}
