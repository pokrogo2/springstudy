package ex09_scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import ex05_java.AppContext;

public class SpringMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("app-context9.xml");
		Person p1 = ctx.getBean("person1",Person.class);
		Person p2 = ctx.getBean("person1",Person.class);
		System.out.println(p1==p2);
		AbstractApplicationContext ctx2 = new AnnotationConfigApplicationContext(ex09_scope.AppContext.class);
		Person p3 = ctx2.getBean("person2",Person.class);
		Person p4 = ctx2.getBean("person2",Person.class);
		System.out.println(p3==p4);
		ctx.close();
		ctx2.close();
	}

}
