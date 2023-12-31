package ex05.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEntry {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ex05/di/memberCtx.xml");
		
		//MemberDAO dao = context.getBean("dao", MemberDAO.class);
		MemberDAO dao = context.getBean("xyz", MemberDAO.class);
		
		dao.insert();
	}
}
