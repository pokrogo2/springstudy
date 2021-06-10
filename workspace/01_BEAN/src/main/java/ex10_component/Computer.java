package ex10_component;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("com") // bean id =com class = Computer
@Scope("prototype")
public class Computer {
	public void info() {
		System.out.println("나는 컴");
	}
}
