package ex05.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainEntry {
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("ex05/aop/appCtx.xml");
		
		ICalc proxy = ctx.getBean("proxy", ICalc.class);
		
		System.out.println(proxy.add(2, 5));
		System.out.println(proxy.mul(3, 5));
		System.out.println(proxy.sub(40, 20, 10));
	}
}
