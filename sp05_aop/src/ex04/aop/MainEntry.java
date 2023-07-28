package ex04.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEntry {
	public static void main(String[] args) {
		String config = "classpath:ex04/aop/appCtx.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
		
		IMessageBean msg = ctx.getBean("messageBeanImpl", IMessageBean.class);
		msg.sayHello();
		System.out.println("-------------------------");
		msg.engHello();
		
		System.out.println("===================================");
		IBookBean book = ctx.getBean("bookBeanImpl", IBookBean.class);
		book.testHello("잘 나오는지 확인");
		System.out.println("-------------------------");
		book.korHello();
	}
}
