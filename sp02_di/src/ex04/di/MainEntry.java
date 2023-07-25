package ex04.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEntry {
	public static void main(String[] args) {
		
		//ApplicationContext context = new ClassPathXmlApplicationContext("ex04/di/appCtx.xml");
		//ApplicationContext context = new ClassPathXmlApplicationContext("appCtx.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"ex04/di/appCtx.xml", "ex04/di/test.xml"});
		
		IRecordViewImpl view = context.getBean("view", IRecordViewImpl.class);
		//IRecordViewImpl view = (IRecordViewImpl) context.getBean("view");
		
		view.print();
		
		/*
		IRecordImpl record = new IRecordImpl();
		
		IRecordViewImpl view = new IRecordViewImpl();
		
		view.setRecord(record);
		view.input();
		view.print();
		*/
	}
}
