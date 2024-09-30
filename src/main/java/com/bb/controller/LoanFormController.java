package com.bb.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bb.controller.helper.LoanDto;
import com.bb.controller.helper.Response;
import com.bb.secondary.model.User;
import com.bb.secondary.repository.LoanFormRepository;


@RestController
@RequestMapping("admin/")
public class LoanFormController {
	@Autowired
	LoanFormRepository loanFormRepository;

	@PostMapping("home-loan/save")
	@CrossOrigin
	public Response saveLoanForm(@RequestBody User loanForm) {
		Response res = new Response();
//	Optional<User> user = loanFormRepository.findByEmail(loanForm.getEmail());
//		if(user.isPresent()) {
//			res.setMessage("Already Exist");
//			res.setPayload(user);
//			res.setStatusCode(403);
//			return res;
//		}
//		else {
		loanFormRepository.save(loanForm);
		
		res.setPayload(loanFormRepository.save(loanForm));
		res.setMessage("successfull");
		res.setStatusCode(200);
		return res;
		}
//	}
	@GetMapping("loanlist")
	@CrossOrigin
	public Response LoanData(@RequestParam(value="date1" , required= true)@DateTimeFormat(pattern = "yyyy-MM-dd")Date date1,
			@RequestParam(value="date2" , required= true)@DateTimeFormat(pattern = "yyyy-MM-dd") Date date2) {
		List<User> list = loanFormRepository.findByCreatedAtBetweenOrderByIdDesc(date1,date2);
		List<LoanDto> dto = new ArrayList<>();
		 for (User user : list) {
			 LoanDto userDTO = new LoanDto();
			 userDTO.setId(user.getId());
			 userDTO.setEmail(user.getEmail());
			 userDTO.setName(user.getName());
			 userDTO.setLastname(user.getLastname());
			 userDTO.setLoanamount(user.getLoanamount());
			 userDTO.setMobile(user.getMobile());
			 userDTO.setProperty_city(user.getProperty_city());
			 userDTO.setCreatedAt(user.getCreatedAt());
			 userDTO.setLoantype(user.getLoantype());
	         dto.add(userDTO);
	        }
		Response res = new Response();
		res.setPayload(dto);
		res.setMessage("successfull");
		res.setStatusCode(200);
		return res;
	}
}
