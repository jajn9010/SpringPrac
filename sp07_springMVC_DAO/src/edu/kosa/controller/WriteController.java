package edu.kosa.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.kosa.model.DeptDAO;
import edu.kosa.model.DeptDTO;

@Controller
public class WriteController {
	
	@Autowired
	private DeptDAO deptDao;
	
	@RequestMapping("/write.do")
	public String write(Model model, HttpServletRequest request) {
		
		int deptNo = Integer.parseInt(request.getParameter("deptno"));
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		
		System.out.println(deptNo + "\t" + dname + "\t" + loc);
		
		DeptDTO dto = new DeptDTO();
		dto.setDeptno(deptNo);
		dto.setDname(dname);
		dto.setLoc(loc);
		
		deptDao.insertDept(dto);
		
		return "redirect:list.do";
	}
}
