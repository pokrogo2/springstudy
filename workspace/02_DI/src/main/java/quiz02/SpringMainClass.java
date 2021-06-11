package quiz02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;


public class SpringMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		TV tv = ctx.getBean("tv",TV.class);
		tv.chDown();
		tv.chUp();
		tv.volDown();
		tv.volUp();
	}

}
