package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springConfig.Client;

public class MainEntry {
	public static void main(String[] args) {
		//AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		ApplicationContext ctx = new GenericXmlApplicationContext("config/appCtx.xml");
		
		Client c = ctx.getBean("client", Client.class);
		c.setHost("서버야");
		c.send();
		
		Client c2 = ctx.getBean("client", Client.class);
		c2.setHost("서버야");
		c2.send();
		
		// spring은 singleTon Pattern
		System.out.println(c.hashCode());
		System.out.println(c2.hashCode());
		
		((AbstractApplicationContext) ctx).close();
	}
}
