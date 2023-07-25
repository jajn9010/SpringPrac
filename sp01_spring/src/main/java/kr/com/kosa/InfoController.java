package kr.com.kosa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InfoController {

	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String info(Model model) {
		//이름, 주소, 핸드폰 번호
		String name = "이재진";
		String addr = "서울 금천구";
		
		model.addAttribute("name", name);
		model.addAttribute("addr", addr);
		model.addAttribute("tel", "010-1111-2222");
		
		return "info";
	}
}
