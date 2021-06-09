package quiz01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String resourceLocations = "classpath:quiz01.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocations);
		Person p = ctx.getBean("person",Person.class);
		p.info();
		ctx.close();
	}

}
