package quiz04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {
	@Bean(name="lecture2")
	public Lecture l2() {
		return new Lecture("웹디자인","교수2");
	}
	@Bean(name="student2")
	public Student s2() {
		return new Student("학생2",l2());
	}
}
