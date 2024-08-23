package com.bb.primary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bb.primary.model.NewWizard;
public interface NewWizardRepository  extends JpaRepository<NewWizard, Long> {

	
	List<NewWizard> findBySiteIdAndMenuIdAndEntityId(Long siteId, Long entity, Long id);

	List<NewWizard> findBySiteId(Long siteId);


	List<NewWizard> findBySiteIdAndEntityNameAndEntityId(Long siteId, String entityName, Long id);

	List<NewWizard> findBySiteIdAndEntityNameAndEntityIdAndStatus(Long siteId, String entityName, Long id, int i);

}
