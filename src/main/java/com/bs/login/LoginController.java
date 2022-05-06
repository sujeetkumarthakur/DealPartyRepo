package com.bs.login;

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

import com.bs.deal.DealController;

@Controller
public class LoginController {
	@Autowired
	private LoginServiceI service;
	@Autowired
	private DealController dealController;
	
	@GetMapping("/")
	public ModelAndView loadForm() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("logindetails", new LoginDetails());
		mav.setViewName("LoginPage");
		return mav;
	}
	
	@GetMapping("/dash")
	public ModelAndView dash() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("deals", dealController.getDealById(159));
		mav.setViewName("DashBoard");
		return mav;
	}
	
	@PostMapping("/isLogined")
	public  ModelAndView isLogined(@ModelAttribute LoginDetails logins) {
		ModelAndView mav=new ModelAndView();
		if (service.isLogined(logins)) {
			mav.addObject("deals", dealController.getDealById(159));
			mav.setViewName("DashBoard");
			return mav;
		} else
			mav.setViewName("Error");
			return mav;
	}
	@PostMapping("/createLogin")
	public @ResponseBody  LoginDetails createLogin(@RequestBody LoginDetails logins) {
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
