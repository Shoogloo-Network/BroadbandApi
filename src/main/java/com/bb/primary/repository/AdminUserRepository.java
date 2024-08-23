package com.bb.primary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bb.primary.model.AdminUser;

public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {

	AdminUser findByEmailAndProjectId(String email, Integer id);

	AdminUser findByUseridAndPasswordAndStatusAndProjectId(String userId, String password, Integer status, Integer id);

	List<AdminUser> findByProjectId(Integer id);

}
