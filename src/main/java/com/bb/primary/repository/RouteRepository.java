package com.bb.primary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bb.primary.model.Route;

public interface RouteRepository extends JpaRepository<Route, Long> {

	List<Route> findBySiteId(Integer siteId);

	List<Route> findBySiteIdAndMenu(Long siteId, int i);

	List<Route> findBySiteId(Long siteId);

}
