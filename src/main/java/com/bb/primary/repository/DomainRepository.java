package com.bb.primary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bb.primary.model.MDomain;

public interface DomainRepository extends JpaRepository<MDomain, Integer> {

	List<MDomain> findByProjectId(Integer id);

}
 