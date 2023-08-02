package edu.kosa.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.kosa.model.DeptDAO;

@Controller
public class ListController {
	
	@Autowired
	private DeptDAO deptDAO; //DB연결 관련
	
	@RequestMapping("list.do")
	public String list(Model model) {
		
		List list = deptDAO.listDept();
		
		model.addAttribute("list", list);
		return "list";
	}
	
	@RequestMapping("/hello.do")
	public ModelAndView hello() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("greeting", getGreeting());
		mav.setViewName("hello");
		
		return mav;
	}

	private Object getGreeting() {
		
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		
		if(hour >= 6 && hour <= 11) return "좋은 아침입니다.";
		else if (hour >= 12 && hour <= 15) return "점심 입니다. 밥 먹고 준열이 졸아요";
		else if (hour >=18 && hour <= 20) return "준열이 술먹는 시간이에요";
		
		return "Hello World";
	}
}
