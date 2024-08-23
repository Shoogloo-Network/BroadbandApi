package com.bb.primary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bb.primary.model.CityCityRel;

public interface CityCityRelRepository extends JpaRepository<CityCityRel, Long> {

	List<Object[]> findByCityIdQuery(Long id);

	List<Object[]> findByCityName(String seoName);

	List<CityCityRel> findBySourceCityId(Long sourceCityId);

}
