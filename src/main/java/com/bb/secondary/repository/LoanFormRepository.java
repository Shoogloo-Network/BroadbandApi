package com.bb.secondary.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bb.secondary.model.User;

public interface LoanFormRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);

	List<User> findByCreatedAtBetween(Date date1, Date date2);

	List<User> findByCreatedAtBetweenOrderByIdDesc(Date date1, Date date2);

}
