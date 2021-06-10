package ex04_xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("app-context4.xml");
		Member m  = ctx.getBean("member",Member.class);
		m.info();
		ctx.close();
	}

}
