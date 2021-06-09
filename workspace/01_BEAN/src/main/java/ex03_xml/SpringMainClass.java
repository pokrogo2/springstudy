package ex03_xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String resourceLocation1="app-context3-1.xml";
			String resourceLocation2="app-context3-2.xml";
			String resourceLocation3="app-context3-3.xml";
			AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocation1);
			
			ListBean listBean = ctx.getBean("listBean",ListBean.class);
			listBean.info();
			
			MapBean mapBean = ctx.getBean("mapBean",MapBean.class);
			mapBean.info();
			
			
			ctx.close();
	}

}
