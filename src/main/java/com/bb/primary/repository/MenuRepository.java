package com.bb.primary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bb.primary.model.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {

	List<Menu> findByProjectId(Long id);

	List<Menu> findByProjectIdAndSiteIdOrderBySortOrder(Long id, Long siteId);

	List<Menu> findBySiteIdAndStatusOrderBySortOrderAsc(Long siteId, int i);

	List<Menu> findBySiteId(Long siteId);

	

}
 