package com.bb.primary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bb.primary.model.ReportAbuse;

public interface ReportAbuseRepository extends JpaRepository<ReportAbuse, Long> {

	List<ReportAbuse> findBySiteId(int id);

	



}
