package ex10_component;

import org.springframework.stereotype.Component;

/*
 * @Component
 * bean으로 만들 클래스를  직접 bean으로 생성
 * XML이나 JAVA를 따로만들지 않아도됨
 * ComponentScan을통해 Component를 찾는 방식
 * */



@Component // id="person" class="Person"으로 자동으로 만들어짐 클래스의 첫글자 자동소문자화
public class Person {
	public void info() {
		System.out.println("사람");
	}
}
