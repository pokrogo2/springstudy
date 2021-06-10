package ex10_component;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import org.springframework.context.support.GenericXmlApplicationContext;



public class SpringMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("app-context10.xml");
		
		Person p =ctx.getBean("person",Person.class);
		Book b = ctx.getBean("bk",Book.class);
		p.info();
		b.info();
		ctx.close();
		AbstractApplicationContext ctx2 = new AnnotationConfigApplicationContext(AppContext.class);
		Person p2 = ctx2.getBean("person",Person.class);
		p2.info();
		Book b2 = ctx2.getBean("bk",Book.class);
		b2.info();
		Computer com1 = ctx2.getBean("com",Computer.class);
		Computer com2 = ctx2.getBean("com",Computer.class);
		com1.info();
		System.out.println(com1==com2);
		ctx2.close();
		
	}

}
