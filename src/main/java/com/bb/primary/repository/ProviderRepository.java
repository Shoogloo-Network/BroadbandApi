package com.bb.primary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bb.primary.model.Provider;

public interface ProviderRepository extends JpaRepository<Provider, Long> {

	List<Provider> findBySiteId(Integer siteId);

	List<Provider> findBySiteIdAndStatus(Integer siteId,Integer status);


	

	List<Provider> findBySiteIdAndCategoryId(Integer siteId, Integer categoryId);
//	List<Provider> findBySiteIdAndCategoryIdAndStatus(Integer siteId, Integer categoryId,Integer status);



	List<Provider> findBySiteIdAndMenuAndCategoryId(Long siteId, int i, int j);

	List<Provider> findBySiteIdAndStatusOrderBySortingOrder(Integer siteId, Integer status);

	List<Provider> findBySiteIdOrderBySortingOrder(Integer siteId);

	List<Provider> findBySiteIdAndCategoryIdOrderBySortingOrder(Integer siteId, Integer categoryId);




	List<Provider> findBySiteIdAndStatusAndCategoryIdOrderBySortingOrder(Integer siteId, Integer status,
			Integer categoryId);

	List<Provider> findBySiteIdAndCategoryId(Long siteId, int categoryId);

	Provider findBySeoName(String seoName);



}
