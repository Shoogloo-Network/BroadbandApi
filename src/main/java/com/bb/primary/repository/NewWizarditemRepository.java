package com.bb.primary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bb.primary.model.NewWizarditem;
public interface NewWizarditemRepository  extends JpaRepository<NewWizarditem, Long> {

	List<NewWizarditem> findByWizardId(Long id);

	List<NewWizarditem> findByWizardIdAndStatus(Long id, int i);



}
