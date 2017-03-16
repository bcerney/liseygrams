package com.briancerney.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.briancerney.models.Liseygram;
import com.briancerney.models.LiseygramDAO;

@Controller
@SessionAttributes("currentGram")
public class MainController {
	
	@Autowired
	private LiseygramDAO liseygramDao;
	
	@RequestMapping(path={"/"}, method=RequestMethod.GET)
	public String showHomePage(ModelMap map) {
		Liseygram gram = liseygramDao.getGramById(1);
		map.addAttribute("currentGram", gram);
		return "home";
	}

}
