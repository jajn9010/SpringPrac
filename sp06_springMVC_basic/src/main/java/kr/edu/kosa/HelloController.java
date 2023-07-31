package kr.edu.kosa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info("Welcome hello.jsp page move");
		
		//1.
		ModelAndView mav = new ModelAndView();
		mav.addObject("nickname","데이터저장");
		mav.setViewName("hello");
		
		return mav;
	}

}
