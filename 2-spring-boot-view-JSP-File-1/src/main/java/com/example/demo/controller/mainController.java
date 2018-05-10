package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Personel;

@RestController
public class mainController {

	
	
	@RequestMapping("/personels")
	public ModelAndView hello() {
		
		Personel p1=new Personel(1l,"celal","aygar");
		Personel p2=new Personel(2l,"fatih","terim");
		Personel p3=new Personel(3l,"ilhan","cavcav");
		Personel p4=new Personel(4l,"şenol","güneş");
		Personel p5=new Personel(5l,"kahraman","gün");
		Personel p6=new Personel(6l,"fatih sultan","mehmet");
		Personel p7=new Personel(7l,"yıldırım","beyazit");
		Personel p8=new Personel(8l,"kanuni sultan","süleyman");
		List<Personel> personels=new ArrayList<>();
		personels.add(p1);
		personels.add(p2);
		personels.add(p3);
		personels.add(p4);
		personels.add(p5);
		personels.add(p6);
		personels.add(p7);
		personels.add(p8);
		ModelAndView mav=new ModelAndView();
		mav.addObject("personels", personels);
		mav.setViewName("personels");
		return mav;
	}
	
	
}
