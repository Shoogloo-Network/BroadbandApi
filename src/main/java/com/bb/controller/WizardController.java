package com.bb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bb.controller.helper.Response;
import com.bb.controller.helper.WizardView;
import com.bb.primary.model.NewWizard;
import com.bb.primary.model.NewWizarditem;
import com.bb.primary.repository.NewWizardRepository;
import com.bb.primary.repository.NewWizarditemRepository;

@RestController
@RequestMapping("admin/wizard")
public class WizardController {
	@Autowired
	NewWizarditemRepository wizarditemRepository;
	@Autowired
	NewWizardRepository wizardRepository;

	@CrossOrigin
	@PostMapping("/saveWizard")
	public Response saveWizard(@RequestHeader(value = "projectId", required = false) Integer projectId,
			@RequestHeader(value = "siteId", required = false) Long siteId, @RequestBody NewWizard country) {
		System.out.println("country=" + country);
	//	country.setSiteId(siteId);
		
		NewWizard country2 = wizardRepository.save(country);
		Response res = new Response();
		res.setPayload(country2);
		res.setMessage("sucessful");
		return res;
	}
	@CrossOrigin
	@PostMapping("/saveWizardItem")
	public Response saveWizardItem(@RequestHeader(value = "projectId", required = false) String projectId,
			@RequestHeader(value = "siteId", required = false) String siteId, @RequestBody NewWizarditem country) {
		System.out.println("country=" + country);
		NewWizarditem country2 = wizarditemRepository.save(country);
		Response res = new Response();
		res.setPayload(country2);
		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@GetMapping("/list")
	public Response updateForm(@RequestHeader(value = "projectId", required = false) Integer projectId,
			@RequestHeader(value = "siteId", required = false) Long siteId) {

		List<NewWizard> country = wizardRepository.findBySiteId(siteId);

		Response res = new Response();
		res.setPayload(country);

		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@GetMapping("/findWizard/{id}")
	public Response updateForm(@RequestHeader(value = "projectId", required = false) Integer projectId,
			@RequestHeader(value = "siteId", required = false) Long siteId, @PathVariable(value = "id") Long id) {
		System.out.println("id=" + id);
		NewWizard country = wizardRepository.getReferenceById(id);

		Response res = new Response();
		res.setPayload(country);

		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@GetMapping("/findWizardAndItems/{id}")
	public Response findWizardAndItem(@RequestHeader(value = "projectId", required = false) Integer projectId,
			@RequestHeader(value = "siteId", required = false) Long siteId, @PathVariable(value = "id") Long id) {
		System.out.println("id=" + id);
		NewWizard wi = wizardRepository.getReferenceById(id);
		List<NewWizarditem> country = wizarditemRepository.findByWizardId(id);
		WizardView item = new WizardView();
		item.setWizard(wi);
		item.setWizardItem(country);
		Response res = new Response();
		res.setPayload(item);

		res.setMessage("sucessful");
		return res;
	}
	@CrossOrigin
	@GetMapping("/findWizardItems/{id}")
	public Response findWizardItem(@RequestHeader(value = "projectId", required = false) Integer projectId,
			@RequestHeader(value = "siteId", required = false) Long siteId, @PathVariable(value = "id") Long id) {
	
		List<NewWizarditem> country = wizarditemRepository.findByWizardId(id);
	
		Response res = new Response();
		res.setPayload(country);

		res.setMessage("sucessful");
		return res;
	}

	@CrossOrigin
	@GetMapping("/listWizard/entityName/{entity}/{id}")
	public Response listWizard(@RequestHeader(value = "projectId", required = false) Integer projectId,
			@RequestHeader(value = "siteId", required = false) Long siteId, @PathVariable(value = "id") Long id,
			@PathVariable(value = "entity") Long entity) {
		List<WizardView> listView = new ArrayList<WizardView>();
		System.out.println("id=" + siteId);
		List<NewWizard> country = wizardRepository.findBySiteIdAndMenuIdAndEntityId(siteId, entity, id);
		for (NewWizard wizard : country) {
			List<NewWizarditem> list = wizarditemRepository.findByWizardId(wizard.getId());
			WizardView item = new WizardView();
			item.setWizard(wizard);
			item.setWizardItem(list);
			listView.add(item);
		}
		Response res = new Response();
		res.setPayload(listView);

		res.setMessage("sucessful");
		return res;
	}
	@CrossOrigin
	@GetMapping("/wizard/entityName/{entityName}/{id}")
	public Response wizard(@RequestHeader(value = "projectId", required = false) Integer projectId,
			@RequestHeader(value = "siteId", required = false) Long siteId, @PathVariable(value = "id") Long id,
			@PathVariable(value = "entityName") String entityName ,  @RequestParam(value = "status", required = false) Integer status) {
		List<WizardView> listView = new ArrayList<WizardView>();
		System.out.println("status=" + status);
		
		if(status==null || status==0)
		{
		List<NewWizard> country = wizardRepository.findBySiteIdAndEntityNameAndEntityId(siteId, entityName, id);
		for (NewWizard wizard : country) {
			List<NewWizarditem> list = wizarditemRepository.findByWizardId(wizard.getId());
			WizardView item = new WizardView();
			item.setWizard(wizard);
			item.setWizardItem(list);
			listView.add(item);
		}}
		else
		{
			List<NewWizard> country = wizardRepository.findBySiteIdAndEntityNameAndEntityIdAndStatus(siteId, entityName, id,1);
			for (NewWizard wizard : country) {
				List<NewWizarditem> list = wizarditemRepository.findByWizardIdAndStatus(wizard.getId(),1);
				WizardView item = new WizardView();
				item.setWizard(wizard);
				item.setWizardItem(list);
				listView.add(item);
			}
		}
		Response res = new Response();
		res.setPayload(listView);

		res.setMessage("sucessful");
		return res;
	}
	
}
