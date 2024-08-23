package com.bb.controller;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections4.map.PassiveExpiringMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bb.cache.CacheObject;
import com.bb.controller.helper.BroadBandView;
import com.bb.controller.helper.Response;
import com.bb.primary.model.Provider;

@RestController
@RequestMapping("admin/cache")
public class CacheController {
	@Autowired
	CacheObject cacheObject;

	@CrossOrigin
	@GetMapping("/cacheClean")
	public Response viewHomePage(Model model) {
		Response res = new Response();
		res.setPayload(""+cacheObject.cacheDomainData());
		AdminController.staticProjectData.clear();
		AdminController.staticProjectDataList.clear();
		cacheObject.fetchAllBroadBand();
		ProviderController.map = new HashMap<String, List<Provider>>();
		BroadbandController.cacheResponseMap=new HashMap<String, Response>();
		BroadbandController.cacheMap=new HashMap<String, List<BroadBandView>>();
		res.setMessage("sucessful");
		return res;
	}

}
