package com.kosa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UpdateController {
	
	@RequestMapping(value = "/update.bo", method = RequestMethod.GET)
	public ModelAndView update() {
		String name = "김연아";
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", name);
		mav.addObject("update", "Update Page 3333입니다.");
		
		mav.setViewName("update");
		
		return mav;
	}
	
	/*
	@RequestMapping(value = "/update.bo", method = RequestMethod.GET)
	public String update(Model model) {
		String name = "김연아";
		model.addAttribute("name", name);
		model.addAttribute("update", "Update Page 입니다.");
		
		return "update";
	}
	*/
}
