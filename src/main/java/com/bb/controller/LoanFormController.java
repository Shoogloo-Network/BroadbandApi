package com.bb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bb.controller.helper.Response;
import com.bb.secondary.model.User;
import com.bb.secondary.repository.LoanFormRepository;


@RestController
@RequestMapping("/api/")
public class LoanFormController {
	@Autowired
	LoanFormRepository loanFormRepository;

	@PostMapping("save")
	@CrossOrigin
	public Response saveLoanForm(@RequestBody User loanForm) {
		loanFormRepository.save(loanForm);
		Response res  = new Response();
		res.setPayload(loanFormRepository.save(loanForm));
		res.setMessage("successfull");
		res.setStatusCode(200);
		return res;
	}
	
	
}
