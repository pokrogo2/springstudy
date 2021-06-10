package ex10_component;

import org.springframework.stereotype.Component;

@Component("bk")
public class Book {
	public void info() {
		System.out.println("나 책");
	}
}
