package com.bb.primary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.bb.primary.model.CityBroadbandRel;

public interface CityBroadbandRelRepository extends JpaRepository<CityBroadbandRel, Long> {


List<Object[]>	findByCityIdQuery(Long cityId);
List<Long>	findByCitySeoNameQuery(String cityName,Integer siteId);
List<Object[]>	findByBroadbandIdQuery(Long providerId);

List<CityBroadbandRel> findByBroadbandId(Long id);


List<CityBroadbandRel> findByCityId(Long id);
List<Object[]> findBroadbandByCityIdQuery(Long cityId);

List<Object[]> findCityBroadbandPlans(Integer siteId);
CityBroadbandRel findByCityIdAndBroadbandId(Long cityId, Long broadbandId);

}
