package quiz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEntry {
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("quiz/appCtx.xml");
		
		IMessageKorImpl helloKor = (IMessageKorImpl) context.getBean("messageKor");
		IMessageEngImpl helloEng = (IMessageEngImpl) context.getBean("messageEng");
		
		helloKor.sayHello();
		helloEng.sayHello();
	}
}
