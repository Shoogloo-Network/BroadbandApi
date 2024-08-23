package com.bb.primary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bb.primary.model.CityProviderRel;

public interface CityProviderRelRepository extends JpaRepository<CityProviderRel, Long> {


List<Object[]>	findByCityIdQuery(Long cityId);
List<Long>	findByCitySeoNameQuery(String cityName,Integer siteId);
List<Object[]>	findByProviderIdQuery(Long providerId);
List<CityProviderRel> findByProviderId(Long id);
CityProviderRel findByCityIdAndProviderId(Long cityId, Long providerId);
List<CityProviderRel> findByCityId(Long cityId);

}
