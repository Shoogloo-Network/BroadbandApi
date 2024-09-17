package com.bb.secondary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bb.secondary.model.User;

public interface LoanFormRepository extends JpaRepository<User, Long> {

}
