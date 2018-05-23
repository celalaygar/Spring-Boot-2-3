package com.javaegitimleri.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.javaegitimleri.app.service.AppService;

@Controller
public class MainController {

	@Autowired
	private AppService appservice;
	
	
	@RequestMapping("/personels")
	public ModelAndView getPersonel() {
		ModelAndView mav=new ModelAndView();
		
		
		mav.addObject("personels", appservice.findPersonels());
		mav.setViewName("personels");
		
		return mav;
	}
	@RequestMapping("/")
	public String mainPage() {
		
		return "main";
	}
	@RequestMapping("/welcome")
	public String welcome() {
		
		return "welcome";
	}
	
	
	
}
