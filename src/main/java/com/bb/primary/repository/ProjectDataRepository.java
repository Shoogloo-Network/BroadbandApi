package com.bb.primary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bb.primary.model.ProjectData;

public interface ProjectDataRepository extends JpaRepository<ProjectData, Integer> {

	ProjectData findByProjectIdAndKeyName(Integer siteId,String id);

	List<ProjectData> findByProjectId(Integer id);

	ProjectData findByKeyName(String keyName);

	ProjectData findBySiteIdAndKeyName(Integer siteId, String key);

	


}
