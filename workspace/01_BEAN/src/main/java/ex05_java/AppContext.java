package ex05_java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
 * @Configuration
 * bean을 만들어주는 java 클래스
 * 
 * */
@Configuration
public class AppContext {

	//Bean을 만드는 메소드를 하나씩 만듬
	//메소드 =>bean생성
	
	
	@Bean //나는 bean만드는 메소드
	//반환타입이 Song <bean class="Song">
	//메소드명 : song <bean id ="song">
	public Song song() {
		Song s = new Song();
		s.setTitle("hello"); //property name="title"
		s.setGenre("balad");// property name="genre"
		return s;
		
	}
	@Bean(name="singer") //<bean id ="singer">
	public Singer xyz() {
		//메소드이름은 중요하지않음 
		return new Singer("adele",song());
	}
	
	
	
}
