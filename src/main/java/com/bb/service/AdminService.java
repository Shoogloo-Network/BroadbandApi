package com.bb.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bb.controller.helper.BroadBandView;
import com.bb.controller.helper.BroadBandViewNew;
import com.bb.primary.model.Broadband;
import com.bb.primary.model.Provider;
import com.bb.primary.repository.BroadBandArttibuteRelRepository;
import com.bb.primary.repository.BroadbandRepository;
import com.bb.primary.repository.ProviderRepository;
import com.bb.util.Utility;

@Service
public class AdminService {
	@Autowired
	ProviderRepository providerRepository;
	@Autowired
	BroadbandRepository broadbandRepository;
	@Autowired
	BroadBandArttibuteRelRepository boradBandArttibuteRelRepository;

	// @Autowired BroadbandAttributeMasterRepository
	// broadbandAttributeMasterRepository;
	public void cacheBoradBandObjects() {
		/*
		 * List<Broadband> broadbandList = broadbandRepository.findAll(); Map<Integer,
		 * Map<Long, BroadBandViewNew>> broadbandMap = new HashMap<Integer, Map<Long,
		 * BroadBandViewNew>>(); Map<Integer, Map<String, List<Long>>>
		 * broadbandSearchMap = new HashMap<Integer, Map<String, List<Long>>>(); for
		 * (Broadband broadband : broadbandList) { Map<Long, BroadBandViewNew> broad1 =
		 * broadbandMap.get(broadband.getSiteId()); if (broad1 == null) broad1 = new
		 * HashMap<Long, BroadBandViewNew>();
		 * 
		 * BroadBandViewNew broadBandViewNew = convert(broadband);
		 * broad1.put(broadband.getId(), broadBandViewNew);
		 * broadbandMap.put(broadband.getSiteId(), broad1);
		 * 
		 * } Map<Integer, Map<String, Provider>> providerMap = new HashMap<Integer,
		 * Map<String, Provider>>(); List<Provider> providerList =
		 * providerRepository.findAll(); for (Provider provider : providerList) {
		 * Map<String, Provider> broad1 = providerMap.get(provider.getSiteId()); if
		 * (broad1 == null) broad1 = new HashMap<String, Provider>(); broad1.put("" +
		 * provider.getId(), provider); providerMap.put(provider.getSiteId(), broad1); }
		 * CacheObject.broadbandIdMap = broadbandMap;
		 * System.out.println("CacheObject.broadbandIdMap==" +
		 * CacheObject.broadbandIdMap);
		 */}

	public List<BroadBandViewNew> findProviderCache(List<Broadband> countryList) {
		System.out.println("countryList=" + countryList);
		List<BroadBandViewNew> broadbandViewList = new ArrayList<BroadBandViewNew>();
		List<Long> ids = new ArrayList<Long>();

		for (Broadband broad : countryList) {
			ids.add(broad.getId());
		}
		List<Provider> providerList = providerRepository.findAllById(ids);
		List<Map<String, Object>> attrList = boradBandArttibuteRelRepository.findByBroadbandIds(ids);
		Map<Long, Provider> providerMap = new HashMap<Long, Provider>();
		for (Provider pro : providerList) {
			providerMap.put(pro.getId(), pro);
		}
		Map<Long, List<Map<String, Object>>> AttrMap = new HashMap<Long, List<Map<String, Object>>>();
		for (Map<String, Object> pro : attrList) {
			List<Map<String, Object>> li = AttrMap.get(Long.parseLong("" + pro.get("boradBandbandId")));
			if (li == null)
				li = new ArrayList<Map<String, Object>>();
			li.add(pro);
			AttrMap.put(Long.parseLong("" + pro.get("boradBandbandId")), li);
		}
		for (Broadband broad : countryList) {
			try {
				BroadBandViewNew broadBandView = convert(broad, providerMap.get(broad.getProviderId()),
						AttrMap.get(broad.getId()));
				broadbandViewList.add(broadBandView);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return broadbandViewList;

	}

	public BroadBandViewNew convert(Broadband broad, Provider provider, List<Map<String, Object>> attrList) {
		System.out.println("broad.getProviderId()=" + broad.getProviderId());
		// Provider opt = providerRepository.getReferenceById(broad.getProviderId());

		BroadBandViewNew broadBandView = new BroadBandViewNew();
		broadBandView.setId(broad.getId());
		broadBandView.setProjectId(broad.getProjectId());
		broadBandView.setProviderId(broad.getProviderId());
		broadBandView.setSiteId(broad.getSiteId());
		broadBandView.setName(broad.getName());
		broadBandView.setCurrency(broad.getCurrency());
		broadBandView.setCost(broad.getCost());
		broadBandView.setCostDurationScale(broad.getCostDurationScale());
		broadBandView.setSpeed(broad.getSpeed());
		broadBandView.setSpeedScale(broad.getSpeedScale());
		broadBandView.setBandwidth(broad.getBandwidth());
		broadBandView.setBandwidthSpeedScale(broad.getBandwidthSpeedScale());
		broadBandView.setBandwidthDurationScale(broad.getBandwidthDurationScale());
		broadBandView.setContractLength(broad.getContractLength());
		broadBandView.setContractLengthDuration(broad.getContractLengthDuration());
		broadBandView.setDealUrl(broad.getDealUrl());
		broadBandView.setMeta_title(broad.getMeta_title());
		broadBandView.setMeta_keyword(broad.getMeta_keyword());
		broadBandView.setStatus(broad.getStatus());
		broadBandView.setSortingOrder(broad.getSortingOrder());
		broadBandView.setImageUrl(broad.getImageUrl());
		broadBandView.setLink(broad.getLink());
		broadBandView.setMeta_description(broad.getMeta_description());
		broadBandView.setPlanExpiry(broad.getPlanExpiry());
		broadBandView.setRating(broad.getRating());
		broadBandView.setBasePrice(broad.getBasePrice());
		broadBandView.setSetupCost(broad.getSetupCost());
		broadBandView.setInstallation(broad.getInstallation());
		broadBandView.setTaxes(broad.getTaxes());
		broadBandView.setOthers(broad.getOthers());
	
		broadBandView.setSponsored(broad.getSponsored());
		broadBandView.setProviderImage(provider.getImage());
		broadBandView.setProviderLogo(provider.getLogo());
		broadBandView.setProviderName(provider.getName());
		broadBandView.setProviderLink(provider.getLink());

		broadBandView.setBroadbandAttribute(attrList);
		return broadBandView;
	}

	public List<BroadBandView> findProvider(List<Broadband> countryList, String ott, String value,String status) {
		List<BroadBandView> broadbandViewList = new ArrayList<BroadBandView>();
		List<Long> providerIds = new ArrayList<Long>();
		List<Long> broadBandIds = new ArrayList<Long>();
		for (Broadband broad : countryList) {
		
			if (!providerIds.contains(broad.getProviderId())) {
				providerIds.add(broad.getProviderId());
			
			}
			if (!broadBandIds.contains(broad.getId())) {
				broadBandIds.add(broad.getId());
			
			}
			if(broad.getSeoName()==null ||broad.getSeoName().equals(""))
			broad.setSeoName(Utility.getSeoName(broad.getName()));
		}

		List<Provider> providerList = providerRepository.findAllById(providerIds);
		
		List<Map<String, Object>> attrList = boradBandArttibuteRelRepository.findByBroadbandIds(broadBandIds);
		Map<Long, Provider> providerMap = new HashMap<Long, Provider>();
		for (Provider pro : providerList) {
			providerMap.put(pro.getId(), pro);
		
		}
		Map<Long, List<Map<String, Object>>> AttrMap = new HashMap<Long, List<Map<String, Object>>>();
		for (Map<String, Object> pro : attrList) {
		
			if(pro.get("broadBandId")==null && status!=null && status.equals("1"))
			{
			
				continue;
			}List<Map<String, Object>> li = AttrMap.get(Long.parseLong("" + pro.get("broadBandId")));
			if (li == null)
				li = new ArrayList<Map<String, Object>>();
			li.add(pro);
			AttrMap.put(Long.parseLong("" + pro.get("broadBandId")), li);
		}
		for (Broadband broad : countryList) {
			if ((status!=null && status.equals("1")) &&(broad.getProviderId() == null|| broad.getStatus().equals("0"))) 
				continue;
			BroadBandView broadView = findProvider(broad, ott, value, providerMap.get(broad.getProviderId()),
					AttrMap.get(broad.getId()));
			if (broadView.getBroadBand() != null)
				broadbandViewList.add(broadView);
		}

		return broadbandViewList;
	}

	public BroadBandView findProvider(Broadband broad, String ott, String value, Provider provider,
			List<Map<String, Object>> attrList) {
		BroadBandView broadBandView = new BroadBandView();

		try {
			int count = 0;
			if(attrList!=null)
			for (Map<String, Object> map : attrList) {
				if (map.get("type").equals("ott"))
					count = count + 1;
			}
			// List<Map<String, Object>> attrList =
			// boradBandArttibuteRelRepository.findByBroadbandId(broad.getId());
			if (ott != null) {
				if (ott.equals("ott")) {
					Integer intVal = Integer.parseInt(value);

					if (intVal != null && intVal <= count) {
						broadBandView.setBroadBand(broad);
						broadBandView.setProvider(provider);
						broadBandView.setCountOTT(count);
						broadBandView.setBroadbandAttribute(attrList);
					}
				} else if (ott != null && ott.equals("speed")) {
					Integer intVal = Integer.parseInt(value);
					if ((broad.getSpeed() <= intVal && broad.getSpeedScale().equals("mbps"))
							|| broad.getSpeedScale().equals("gbps")) {
						broadBandView.setBroadBand(broad);
						broadBandView.setProvider(provider);
						broadBandView.setBroadbandAttribute(attrList);
					}
				} else if (ott != null && ott.equals("cost")) {
					Double intVal = Double.parseDouble(value);
					if (broad.getCost() <= intVal && broad.getCostDurationScale().equals("month")) {
						broadBandView.setBroadBand(broad);
						broadBandView.setProvider(provider);
						broadBandView.setBroadbandAttribute(attrList);
					}
				}
			} else {
				broadBandView.setBroadBand(broad);
				broadBandView.setProvider(provider);
				broadBandView.setBroadbandAttribute(attrList);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return broadBandView;
	}

}
