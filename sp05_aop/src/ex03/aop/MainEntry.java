package ex03.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEntry {
	public static void main(String[] args) {
		String config = "classpath:ex03/aop/appCtx.xml";
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
		
		ICalc proxy = ctx.getBean("proxy", ICalc.class);
		
		// proxy를 통해서 실행
		System.out.println(proxy.add(1, 2));
		System.out.println(proxy.add(10, 20));
		System.out.println();
		System.out.println(proxy.mul(5, 7));
		System.out.println();
		System.out.println(proxy.sub(10, 20, 30));
		
		/*
		System.out.println(c.add(1, 2));
		System.out.println(c.add(10, 20));
		System.out.println();
		System.out.println(c.mul(5, 7));
		*/
	}
}
