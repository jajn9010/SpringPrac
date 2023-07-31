package kr.edu.kosa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class WriteController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("user", "글쓴이는 나야");
		mav.addObject("content", "여기는 내용이 들어갑니다.");
		mav.addObject("title", "writeController Title이에요");
		
		mav.setViewName("write");
		
		return mav;
	}

}
