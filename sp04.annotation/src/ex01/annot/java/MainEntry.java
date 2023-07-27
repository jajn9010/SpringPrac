package ex01.annot.java;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainEntry {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		
		Cats catsInfo = ctx.getBean("catsInfo", Cats.class);
		catsInfo.getMyCatsInfo();
		
		MyCats cats = ctx.getBean("cat2", MyCats.class);
		catsInfo.setMyCatsInfo(cats);
		catsInfo.getMyCatsInfo();
		
		ctx.close();
	}
}
