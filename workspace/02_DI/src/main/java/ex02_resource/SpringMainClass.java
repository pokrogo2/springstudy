package ex02_resource;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import ex01_inject.SelectListCommand;

public class SpringMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
AbstractApplicationContext ctx = new GenericXmlApplicationContext("app-context2.xml");
	ex02_resource.SelectListCommand s = ctx.getBean("selectListCommand",ex02_resource.SelectListCommand.class);
	s.execute();
	ctx.close();
	}

}
