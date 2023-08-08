package com.kosa.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kosa.service.ShaEncoder;
import com.kosa.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	ShaEncoder shaEncoder;
	
	@Inject
	UserService userService;
	
	@RequestMapping("/user/login.do")
	public String login() {
		return "user/login";
	}
	
	@RequestMapping("/user/join.do")
	public String join() {
		return "user/join";
	}
	
	@RequestMapping("/user/insertUser.do")
	public String insertUser(@RequestParam String userid,
							 @RequestParam String pwd) {
		
		String dbpwd = shaEncoder.saltEncoding(pwd, userid);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("pwd", dbpwd);
		userService.insertUser(map);
		
		return "user/login";
	}
	
	@RequestMapping("/user/home.do")
	public String home() {
		return "user/home";
	}
	
	@RequestMapping("/user/updateForm.do")
	public String updateForm(Model model, @RequestParam String userid) {
		model.addAttribute(userid);
		return "user/update";
	}
	
	@RequestMapping("/user/update.do")
	public String update(@RequestParam String userid,
						 @RequestParam String passwd,
						 @RequestParam String changePwd,
						 @RequestParam String changeCheckPwd) {
		
		Map<String, Object> map = userService.selectUser(userid);
		
		
		String userPw = (String) map.get("PASSWORD");
		String checkPw = shaEncoder.saltEncoding(passwd, userid);
		String changePw = shaEncoder.saltEncoding(changePwd, userid);
		
		if(userPw.equals(checkPw)) {
			if(changePwd.equals(changeCheckPwd)) {
				Map<String, Object> map2 = new HashMap<String, Object>();
				map2.put("userid", userid);
				map2.put("pwd", changePw);
				userService.update(map2);
				return "user/login";
			} else {
				return "user/error";
			}
		} else {
			return "user/error";
		}
	}
}
