package com.bb.template;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bb.primary.model.MCountry;
import com.bb.primary.repository.MCountryRepository;

@Controller

public class MCountryControllerT {
	@Autowired
	MCountryRepository mCountryRepository ;
	@GetMapping("/admin/country")
    public String viewHomePage(Model model) {
		List<String>fieldList=new ArrayList<String>();
		fieldList.add("AAA");
		fieldList.add("BBB");
		 model.addAttribute("fieldList", fieldList);
        model.addAttribute("allList", mCountryRepository.findAll());
        return "country/index";
    }
 
    @GetMapping("/admin/countryaddnew")
    public String addNewCountry(Model model) {
    	MCountry country =new MCountry();
    	System.out.println("country="+country);
        model.addAttribute("ob", country);
        return "country/add";
    }
    @GetMapping("/admin/countryEdit")
    public String editCountry(@PathVariable(value = "id") Long id, Model model) {
    	MCountry country = mCountryRepository.getReferenceById(id);
    	System.out.println("country="+country);
        model.addAttribute("ob", country);
        return "country/add";
    }
 
    @PostMapping("/admin/countrysave")
    public String saveCountry(@ModelAttribute("country") MCountry country) {
    	country=	mCountryRepository.save(country);
        return "redirect:/admin/countryEdit/"+country.getId();
    }
 
    @GetMapping("/admin/countryfind/{id}")
    public String updateForm(@PathVariable(value = "id") Long id, Model model) {
    	MCountry country = mCountryRepository.getReferenceById(id);
    	System.out.println("country="+country);
        model.addAttribute("ob", country);
        return "detail";
    }
 
    @GetMapping("/admin/countrydelete/{id}")
    public String deleteThroughId(@PathVariable(value = "id") int id) {
    	//mCountryRepository.deleteById(id);
        return "redirect:/";
 
    }
}

