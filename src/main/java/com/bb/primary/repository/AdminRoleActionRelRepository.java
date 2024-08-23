package com.bb.primary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bb.primary.model.AdminRoleActionRel;

public interface AdminRoleActionRelRepository extends JpaRepository<AdminRoleActionRel, Long> {
	//findByUserId(Integer userId);
}
 