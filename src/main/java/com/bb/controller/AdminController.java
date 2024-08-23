package com.bb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bb.cache.CacheObject;
import com.bb.controller.helper.Response;
import com.bb.primary.model.ProjectData;
import com.bb.primary.repository.ProjectDataRepository;

@RestController
@RequestMapping("admin/admin")
public class AdminController {
	@Autowired
	ProjectDataRepository projectDataRepository;
static 	Map<String,ProjectData>staticProjectData=new HashMap<String,ProjectData>();
static 	Map<String,List<ProjectData>>staticProjectDataList=new HashMap<String,List<ProjectData>>();
	@CrossOrigin
	@GetMapping("/cache")
	public Response viewHomePage(Model model) {
		Response res = new Response();
		res.setPayload(projectDataRepository.findAll());
		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@GetMapping("/cacheByprojectId/{projectId}/key/{key}")
	public Response viewHome(@PathVariable(value = "projectId") Integer id, @PathVariable(value = "key") String key,
			@RequestHeader(value = "projectId", required = false) Integer projectId,
			@RequestHeader(value = "siteId", required = false) Integer siteId , @RequestParam(value="cache" , required= false) Integer cache) {
		Response res = new Response();
		if(staticProjectData.containsKey(siteId+","+ key)) {
			res.setPayload(staticProjectData.get(siteId+","+ key));
		}else {
		
			staticProjectData.put(siteId+","+ key,projectDataRepository.findBySiteIdAndKeyName(siteId, key));
		res.setPayload(staticProjectData.get(siteId+","+ key));
		}
		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@GetMapping("/cacheByprojectId/{key}")
	public Response byKey(@PathVariable(value = "key") String key,
			@RequestHeader(value = "projectId", required = false) Integer projectId,
			@RequestHeader(value = "siteId", required = false) Integer siteId) {
		Response res = new Response();

		if(staticProjectData.containsKey(siteId+","+ key)) {
			res.setPayload(staticProjectData.get(siteId+","+ key));
		}else {
		
			staticProjectData.put(siteId+","+ key,projectDataRepository.findBySiteIdAndKeyName(siteId, key));
		res.setPayload(staticProjectData.get(siteId+","+ key));
		}
		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@GetMapping("/cacheByprojectId/{projectId}")
	public Response viewHomse(@PathVariable(value = "projectId") Integer id) {
		Response res = new Response();
		
		if(staticProjectDataList.containsKey(""+id)) {
			res.setPayload(staticProjectDataList.get(""+id));
		}else {
		
			staticProjectDataList.put(""+id,projectDataRepository.findByProjectId(id));
		res.setPayload(staticProjectDataList.get(""+id));
		}
		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@PostMapping("/save")
	public Response saveEmployee(@RequestHeader(value = "projectId", required = false) Integer projectId,
			@RequestHeader(value = "siteId", required = false) Integer siteId, @RequestBody ProjectData country) {
		// public Response search(@ModelAttribute("country") MCountry country ) {
		System.out.println("country=" + country);
		country.setSiteId(siteId);
		country.setProjectId(projectId);
		ProjectData pr = projectDataRepository.findBySiteIdAndKeyName(country.getSiteId(), country.getKeyName());
		if (pr == null)
			pr = new ProjectData();
		pr.setValue(country.getValue());
		pr.setKeyName(country.getKeyName());
		pr.setProjectId(country.getProjectId());
		pr.setSiteId(country.getSiteId());
		ProjectData country2 = projectDataRepository.save(pr);
		Response res = new Response();
		res.setPayload(country2);
		res.setMessage("sucessful");
		return res;
	}

}
