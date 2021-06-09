package ex01_xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//spring bean configuration file 에 정의된 <bean>을 생성하는 클래스
		//GenericXmlApplicationContext
		
		//AbstractApplicationContext 는 GenericXmlApplicationContext의 super클래스
		
		String resourceLocations="classpath:app-context1.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocations);
		//이미 스플이은 appcontext1.xml에 정의된 bean을 모두 생성해서 가지고있음
		//개발자는 필요한 bean을 getBean메소드를 이용해서 가져다 사용
		
		//기존 : 개발자가 직접 bean생성
		//스프링 : 스프링이 미리 Bean생성
		//IoC : Inversion of Control,제어의 역전
		//<bean id = "engineerCalculator1" class="ex01_xml.engineerCalculator">
		EngineerCalculator e1 = ctx.getBean("engineerCalculator1",EngineerCalculator.class);
		e1.add();
		e1.subtract();
		e1.multiply();
		e1.divide();
		EngineerCalculator e2 = ctx.getBean("engineerCalculator2",EngineerCalculator.class);
		e2.add();
		e2.subtract();
		e2.multiply();
		e2.divide();
		
		ctx.close();
	}

}
