package com.bb.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bb.controller.helper.MenuHelper;
import com.bb.controller.helper.WizardView;
import com.bb.primary.model.Broadband;
import com.bb.primary.model.MCity;
import com.bb.primary.model.MCountry;
import com.bb.primary.model.MDomain;
import com.bb.primary.model.Menu;
import com.bb.primary.model.NewWizard;
import com.bb.primary.model.NewWizarditem;
import com.bb.primary.model.Pages;
import com.bb.primary.model.Provider;
import com.bb.primary.model.Route;
import com.bb.primary.repository.BroadbandRepository;
import com.bb.primary.repository.DomainRepository;
import com.bb.primary.repository.MCityRepository;
import com.bb.primary.repository.MCountryRepository;
import com.bb.primary.repository.MenuRepository;
import com.bb.primary.repository.NewWizardRepository;
import com.bb.primary.repository.NewWizarditemRepository;
import com.bb.primary.repository.PageRepository;
import com.bb.primary.repository.ProviderRepository;
import com.bb.primary.repository.RouteRepository;
import com.bb.util.Utility;

import jakarta.annotation.PostConstruct;

@Service
public class CacheObject {

	@Autowired
	MCountryRepository mCountryRepository;
	@Autowired
	MenuRepository menuRepository;
	@Autowired
	MCityRepository cityRepository;
	@Autowired
	ProviderRepository providerRepository;
	@Autowired
	RouteRepository routeRepository;
	@Autowired
	PageRepository pageRepository;
	@Autowired
	DomainRepository domainRepository;
	@Autowired
	NewWizarditemRepository wizarditemRepository;
	@Autowired
	NewWizardRepository wizardRepository;
	@Autowired
	BroadbandRepository broadbandRepository;

	public static Map<Long, List<MenuHelper>> menuHelperList = new HashMap<Long, List<MenuHelper>>();
	public static Map<Integer,List<MCity>> cityList = new HashMap<Integer,List< MCity>>();
	public static Map<Long, Map<String, MCity>> cityMap = new HashMap<Long, Map<String, MCity>>();
	public static Map<Long, Map<String, MCountry>> countryIdMap = new HashMap<Long, Map<String, MCountry>>();
	public static Map<Long, Map<String, Provider>> busProviderMap = new HashMap<Long, Map<String, Provider>>();
	public static Map<Long, Map<String, Provider>> railProviderMap = new HashMap<Long, Map<String, Provider>>();
	public static Map<Long, Map<String, Route>> routeMap = new HashMap<Long, Map<String, Route>>();
	public static Map<Long, MDomain> domainMap = new HashMap<Long, MDomain>();
	public static Map<Integer,List<MDomain>> doaminList = new HashMap<Integer,List<MDomain>>();
	public static Map<Long, Map<String, Pages>> pageMap = new HashMap<Long, Map<String, Pages>>();
	public static Map<Long, Map<String, List<WizardView>>> wizardMap = new HashMap<Long, Map<String, List<WizardView>>>();
	public static Map<Long, Map<Long, Broadband>> broadbandMasterMap;
	public static Map<Long, Map<String, Broadband>> broadbandSeoNameMap;
	@PostConstruct
	public void init() {
		cacheDomainData();
	}

	public String cacheDomainData() {
		Map<Integer,List<MDomain>> doaminList = new HashMap<Integer,List<MDomain>>();
		List<MDomain> list = domainRepository.findAll();
		Map<Long, MDomain> domainMap = new HashMap<Long, MDomain>();
		for (MDomain domain : list) {
			domainMap.put(Long.parseLong("" + domain.getId()), domain);
			cacheMenu(Long.parseLong("" + domain.getId()), 1);
			List<MDomain> lists=doaminList.get(domain.getProjectId());
			if(lists==null)
				lists=new ArrayList<MDomain>();
			lists.add(domain);
			doaminList.put(domain.getProjectId(), lists);
			
				
		}
		CacheObject.domainMap = domainMap;
		CacheObject.doaminList = doaminList;
		fetchAllBroadBand();
		cityList=new HashMap<Integer,List< MCity>>();
		return "done";

	}

	public void cacheMenu(Long siteId, Integer status) {
	
		List<Menu> menuList = menuRepository.findBySiteIdAndStatusOrderBySortOrderAsc(siteId, status);
		System.out.println("menuList=" + menuList);
		List<MCity> cityList = cityRepository.findBySiteIdOrderBySortingOrder(Integer.parseInt(""+siteId));
		List<MCountry> countryList = mCountryRepository.findBySiteId(siteId);
		List<Provider> railProviderList = providerRepository.findBySiteIdAndCategoryId(siteId, 2);
		List<Provider> busProviderList = providerRepository.findBySiteIdAndCategoryId(siteId, 3);
		List<Route> routeList = routeRepository.findBySiteId(siteId); 
		List<Pages> pagesList = pageRepository.findBySiteId(siteId);

		List<MenuHelper> menuHelperList = new ArrayList<MenuHelper>();
		Map<String, List<WizardView>> wizardMap = new HashMap<String, List<WizardView>>();
		Map<String, MCity> cityMap = new HashMap<String, MCity>();
		Map<String, MCountry> countryIdMap = new HashMap<String, MCountry>();
		Map<String, Provider> busProviderMap = new HashMap<String, Provider>();
		Map<String, Provider> railProviderMap = new HashMap<String, Provider>();
		Map<String, Route> routeMap = new HashMap<String, Route>();
		Map<String, Pages> pageMap = new HashMap<String, Pages>();
		List<NewWizard> wizardListTemp = wizardRepository.findBySiteId(siteId);
		Map<String,List<NewWizard>>wizardMapTemp=new HashMap<String,List<NewWizard>>();
		
		for(NewWizard newWizard:wizardListTemp)
		{
			String key=newWizard.getMenuId()+"#"+newWizard.getEntityId();
			List<NewWizard>ll=wizardMapTemp.get(key);
			if(ll==null)
				ll=new ArrayList<NewWizard>();
			ll.add(newWizard);
			wizardMapTemp.put(key,ll);
		}
		

		for (Menu menu : menuList) {
			List<WizardView> listView = new ArrayList<WizardView>();
			List<NewWizard> wizardList = wizardMapTemp.get( menu.getId()+"#"+ 0l);
			if(wizardList!=null)
			for (NewWizard wizard : wizardList) {
				List<NewWizarditem> list = wizarditemRepository.findByWizardId(wizard.getId());
				WizardView item = new WizardView();
				item.setWizard(wizard);
				item.setWizardItem(list);
				listView.add(item);
			}
			wizardMap.put("page" + menu.getUrl(), listView);
			MenuHelper menuHelper = new MenuHelper();
			menuHelper.setDisplayName(menu.getDisplayName());
			menuHelper.setGroupName(menu.getGroupName());
			menuHelper.setId(menu.getId());
			menuHelper.setName(menu.getName());
			menuHelper.setSortOrder(menu.getSortOrder());
			menuHelper.setUrl(menu.getUrl());
			if (menu.getName().equals("Cities")) {
				List<WizardView> listView2 = new ArrayList<WizardView>();
				List<MenuHelper> menuCityList = new ArrayList<MenuHelper>();
				for (MCity city : cityList) {
					if (city.getMenu() == 1) {
						MenuHelper menuCity = new MenuHelper();
						menuCity.setDisplayName(city.getDisplayName());
						menuCity.setGroupName(menu.getName());
						menuCity.setId(city.getId());
						menuCity.setName(city.getName());
						menuCity.setSortOrder(city.getSortingOrder());
						menuCity.setUrl(city.getSeoName());
						menuCityList.add(menuCity);
					}

					List<NewWizard> wizardList2 =
					 wizardMapTemp.get( menu.getId()+"#"+ city.getId());
				if(	wizardList2!=null)
					for (NewWizard wizard : wizardList2) {
						List<NewWizarditem> list = wizarditemRepository.findByWizardId(wizard.getId());
						WizardView item = new WizardView();
						item.setWizard(wizard);
						item.setWizardItem(list);
						listView2.add(item);
					}
					wizardMap.put("city" + city.getSeoName(), listView2);
				
				}
				menuHelper.setChild(menuCityList);

			}
			if (menu.getName().equals("Routes")) {
				List<WizardView> listView2 = new ArrayList<WizardView>();
				List<MenuHelper> menuCityList = new ArrayList<MenuHelper>();
				for (Route city : routeList) {
					if (city.getMenu() == 1) {
						MenuHelper menuCity = new MenuHelper();
						menuCity.setDisplayName(city.getDisplayName());
						menuCity.setGroupName(menu.getName());
						menuCity.setId(city.getId());
						menuCity.setName(city.getName());
						menuCity.setSortOrder(city.getSortingOrder());
						menuCity.setUrl(city.getSeoName());
						menuCityList.add(menuCity);

					}
					List<NewWizard> wizardList2 =  wizardMapTemp.get( menu.getId()+"#"+ city.getId());
					if(	wizardList2!=null)
					for (NewWizard wizard : wizardList2) {
						List<NewWizarditem> list = wizarditemRepository.findByWizardId(wizard.getId());
						WizardView item = new WizardView();
						item.setWizard(wizard);
						item.setWizardItem(list);
						listView2.add(item);
					}
					wizardMap.put("route" + city.getSeoName(), listView2);
					routeMap.put(city.getSeoName(), city);
				}
				menuHelper.setChild(menuCityList);
			}
			if (menu.getId()==9) {
				List<WizardView> listView2 = new ArrayList<WizardView>();
				List<MenuHelper> menuCityList = new ArrayList<MenuHelper>();
				for (Provider provider : railProviderList) {
					if (provider.getMenu() == 1) {
						MenuHelper menuCity = new MenuHelper();
						menuCity.setDisplayName(provider.getName());
						menuCity.setGroupName(menu.getName());
						menuCity.setId(provider.getId());
						menuCity.setName(provider.getName());
						menuCity.setSortOrder(provider.getSortingOrder());
						menuCity.setUrl(provider.getSeoName());
						menuCityList.add(menuCity);
					}
					List<NewWizard> wizardList2 =  wizardMapTemp.get( menu.getId()+"#"+ provider.getId());
					if(	wizardList2!=null)
					for (NewWizard wizard : wizardList2) {
						List<NewWizarditem> list = wizarditemRepository.findByWizardId(wizard.getId());
						WizardView item = new WizardView();
						item.setWizard(wizard);
						item.setWizardItem(list);
						listView2.add(item);
					}
					wizardMap.put("railProvider" + provider.getSeoName(), listView2);
					railProviderMap.put(provider.getSeoName(), provider);
				}
				menuHelper.setChild(menuCityList);

			}
			if (menu.getName().equals("Bus Providers")) {
				List<WizardView> listView2 = new ArrayList<WizardView>();
				List<MenuHelper> menuCityList = new ArrayList<MenuHelper>();
				for (Provider city : busProviderList) {
					if (city.getMenu() == 1) {
						MenuHelper menuCity = new MenuHelper();
						menuCity.setDisplayName(city.getName());
						menuCity.setGroupName(menu.getName());
						menuCity.setId(city.getId());
						menuCity.setName(city.getName());
						menuCity.setSortOrder(city.getSortingOrder());
						menuCity.setUrl(city.getSeoName());
						menuCityList.add(menuCity);
					}
					List<NewWizard> wizardList2 =  wizardMapTemp.get( menu.getId()+"#"+ city.getId());
					if(	wizardList2!=null)
					for (NewWizard wizard : wizardList2) {
						List<NewWizarditem> list = wizarditemRepository.findByWizardId(wizard.getId());
						WizardView item = new WizardView();
						item.setWizard(wizard);
						item.setWizardItem(list);
						listView2.add(item);
					}
					wizardMap.put("busProvider" + city.getSeoName(), listView2);
					busProviderMap.put(city.getSeoName(), city);
				}
				menuHelper.setChild(menuCityList);
			}
			if (menu.getName().equals("Countries")) {
				List<WizardView> listView2 = new ArrayList<WizardView>();
				List<MenuHelper> menuCityList = new ArrayList<MenuHelper>();
				for (MCountry country : countryList) {
					if (country.getMenu() == 1) {
						MenuHelper menuCity = new MenuHelper();
						menuCity.setDisplayName(country.getName());
						menuCity.setGroupName(menu.getName());
						menuCity.setId(country.getId());
						menuCity.setName(country.getName());
						menuCity.setSortOrder(country.getSortingOrder());
						menuCity.setUrl(country.getSeoName());
						menuCityList.add(menuCity);
					}
					countryIdMap.put("" + country.getId(), country);
					countryIdMap.put("" + country.getName().toLowerCase(), country);
					List<NewWizard> wizardList2 = wizardMapTemp.get( menu.getId()+"#"+ country.getId());;
					if(	wizardList2!=null)
					for (NewWizard wizard : wizardList2) {
						List<NewWizarditem> list = wizarditemRepository.findByWizardId(wizard.getId());
						WizardView item = new WizardView();
						item.setWizard(wizard);
						item.setWizardItem(list);
						listView2.add(item);
					}
					wizardMap.put("country" + country.getSeoName(), listView2);
				}
				menuHelper.setChild(menuCityList);
			}
	
			menuHelperList.add(menuHelper);

		}
		for (Pages page : pagesList) {
			pageMap.put(page.getSeoName(), page);
		}
		for (MCity city : cityList) {
			if(city.getSeoName()==null ||city.getSeoName().equals(""))
			{
		
			city.setSeoName(Utility.getSeoName(city.getName()));
			}
			else
				cityMap.put(city.getSeoName(), city);
			cityMap.put(city.getName().toLowerCase(), city);
		}
	
		CacheObject.menuHelperList.put(siteId, menuHelperList);
		CacheObject.cityMap.put(siteId, cityMap);
		CacheObject.busProviderMap.put(siteId, busProviderMap);
		CacheObject.railProviderMap.put(siteId, railProviderMap);
		CacheObject.routeMap.put(siteId, routeMap);
		CacheObject.pageMap.put(siteId, pageMap);
		CacheObject.wizardMap.put(siteId, wizardMap);
		CacheObject.countryIdMap.put(siteId, countryIdMap);
	
	}

	public void fetchAllBroadBand() {
		List<Broadband> boradbandList = broadbandRepository.findByStatus("1");
		Map<Long, Map<Long, Broadband>> broadbandMasterMap = new HashMap<Long, Map<Long, Broadband>>();
		Map<Long, Map<String, Broadband>> broadbandSeoNameMap = new HashMap<Long, Map<String, Broadband>>();
		for (Broadband broadBand : boradbandList) {
			Integer siteId = broadBand.getSiteId();
			Map<Long, Broadband> map = broadbandMasterMap.get(Long.parseLong(""+siteId));
			if (map == null)
				map = new HashMap<Long, Broadband>();
			map.put(broadBand.getId(), broadBand);
			broadbandMasterMap.put(Long.parseLong(""+siteId), map);
			
		Map<String,Broadband>seoMap=	broadbandSeoNameMap.get(Long.parseLong(""+siteId));
		if(seoMap==null)
			seoMap=new HashMap<String, Broadband>();
		seoMap.put(Utility.getSeoName(broadBand.getName()), broadBand);
		seoMap.put(broadBand.getSeoName(), broadBand);
		broadbandSeoNameMap.put(Long.parseLong(""+siteId), seoMap);

		}
		CacheObject.broadbandMasterMap=broadbandMasterMap;
		CacheObject.broadbandSeoNameMap=broadbandSeoNameMap;
	
	}
}
