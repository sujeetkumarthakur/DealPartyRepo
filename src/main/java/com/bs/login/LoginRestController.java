package com.bs.login;

import java.util.LinkedHashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bs.deal.Deal;
import com.bs.deal.DealController;

@RestController
@RequestMapping("/rest")
public class LoginRestController {
	@Autowired
	private LoginServiceI service;
	@Autowired
	private DealController dealController;

	@GetMapping("/getLogindetail")
	public LoginDetails get() {
		return new LoginDetails(12, "user11", "password", null, new Deal(15, "product1", "12/12/2022", "12/12/2022", "account",
				"MH", "12/12/2022", "de", new LinkedHashSet<>()));
		 
	}

	@PostMapping("/isLogined")
	public ModelAndView isLogined(@ModelAttribute LoginDetails logins) {
		ModelAndView mav = new ModelAndView();
		if (service.isLogined(logins)) {
			mav.addObject("deals", dealController.getDealById(logins.getDeal().getDealId()));
			mav.setViewName("DashBoard");
			return mav;
		} else
			mav.setViewName("Error");
		return mav;
	}

	@PostMapping("/createLogin")
	public @ResponseBody LoginDetails createLogin(@RequestBody LoginDetails logins) {
		return service.createLoginDetails(logins);
	}

	@PutMapping("/updateLogin")
	public @ResponseBody LoginDetails updateLogin(@RequestBody LoginDetails logins) {
		return service.updateLoginDetails(logins);
	}

	@GetMapping("/getToken/{id}")
	public @ResponseBody LoginDetails getToken(@PathVariable("id") int loginId) {
		return service.getToken(loginId);
	}
}
