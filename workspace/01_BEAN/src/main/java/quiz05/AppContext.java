package quiz05;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@ImportResource("quiz05.xml")

@Configuration
public class AppContext {
	@Bean
	public Person person3() {
		return new Person("남2","남");
	}
	@Bean
	public Person person4() {
		return new Person("여2","여");
	}
	@Bean
	public HoneyMoon honeymoon2() {
		return new HoneyMoon("방콕",person3(),person4());
				
	}
}
