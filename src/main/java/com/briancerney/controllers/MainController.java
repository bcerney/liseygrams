package com.briancerney.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.briancerney.models.Liseygram;
import com.briancerney.models.LiseygramDAO;

@Controller
@SessionAttributes("currentGram")
public class MainController {
	
	@Autowired
	private LiseygramDAO liseygramDao;
	
	@RequestMapping(path={"/","/home"}, method=RequestMethod.GET)
	public String showHomePage(ModelMap map) {
		Liseygram gram = (Liseygram) map.get("currentGram");
		
		if (gram == null) {
			gram = liseygramDao.getGramById(5);
			gram.setUpGram();
			map.put("currentGram", gram);
		}
		return "home";
	}
	
	@RequestMapping(path={"/"}, method=RequestMethod.POST)
	public String postLetterChange(HttpServletRequest request, 
									@RequestParam String from, 
									@RequestParam String to,
									ModelMap map) {
		Liseygram gram = (Liseygram) map.get("currentGram");
		gram.guessLetter(from, to);
		return "redirect:/home";
	}

}
