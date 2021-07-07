package com.koreait.myproject01.config;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.koreait.myproject01.command.EmailAuthCommand;
import com.koreait.myproject01.command.FindIdCommand;
import com.koreait.myproject01.command.FindPwCommand;
import com.koreait.myproject01.command.IdCheckCommand;
import com.koreait.myproject01.command.JoinCommand;
import com.koreait.myproject01.command.LeaveCommand;
import com.koreait.myproject01.command.LoginCommand;
import com.koreait.myproject01.command.LogoutCommand;
import com.koreait.myproject01.fcommand.DeleteFBoardCommand;
import com.koreait.myproject01.fcommand.DeleteFReplyCommand;
import com.koreait.myproject01.fcommand.InsertFBoardCommand;
import com.koreait.myproject01.fcommand.InsertFReplyCommand;
import com.koreait.myproject01.fcommand.SelectFBoardListCommand;
import com.koreait.myproject01.fcommand.SelectFBoardViewCommand;
import com.koreait.myproject01.fcommand.UpdateFBoardCommand;
import com.koreait.myproject01.fcommand.UpdateFBoardPage;
import com.koreait.myproject01.gcommand.DeleteBoardCommand;
import com.koreait.myproject01.gcommand.DeleteReplyCommand;
import com.koreait.myproject01.gcommand.InsertBoardCommand;
import com.koreait.myproject01.gcommand.InsertReplyCommand;
import com.koreait.myproject01.gcommand.SelectBoardListCommand;
import com.koreait.myproject01.gcommand.SelectBoardViewCommand;

import com.koreait.myproject01.gcommand.UpdateBoardCommand;
import com.koreait.myproject01.gcommand.UpdateBoardPage;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
@Configuration
public class BeanConfiguration {

	@Bean
	public HikariConfig hikariConfig() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("oracle.jdbc.OracleDriver");
		hikariConfig.setJdbcUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
		hikariConfig.setUsername("spring");
		hikariConfig.setPassword("1111");
		return hikariConfig;
	}
	
	@Bean(destroyMethod="close")
	public HikariDataSource hikariDataSource() {
		return new HikariDataSource(hikariConfig());
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(hikariDataSource());
		sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/koreait/myproject01/dao/*.xml"));
		return sqlSessionFactory.getObject();
	}
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setDefaultEncoding("utf-8");
		multipartResolver.setMaxUploadSize(1024 * 1024 * 10);  // 바이트 단위(10MB)
		return multipartResolver;
	}
	@Bean
	public SqlSessionTemplate sqlSession() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory());
	}
	@Bean
	public IdCheckCommand idCheckCommand() {
		return new IdCheckCommand();
	}
	@Bean
	public EmailAuthCommand emailAuthCommand() {
		return new EmailAuthCommand();
	}
	@Bean
	public JoinCommand joinCommand() {
		return new JoinCommand();
	}
	@Bean
	public LoginCommand loginCommand() {
		return new LoginCommand();
	}
	@Bean
	public LogoutCommand logoutCommand() {
		return new LogoutCommand();
	}
	@Bean
	public LeaveCommand leaveCommand() {
		return new LeaveCommand();
	}
	@Bean
	public FindIdCommand findIdCommand() {
		return new FindIdCommand();
	}
	@Bean
	public FindPwCommand findPwCommand() {
		return new FindPwCommand();
	}
	@Bean
	public InsertBoardCommand insertBoardCommand() {
		return new InsertBoardCommand();
	}
	@Bean
	public SelectBoardListCommand selectBoardListCommand() {
		return new SelectBoardListCommand();
	}
	@Bean
	public SelectBoardViewCommand selectBoardViewCommand() {
		return new SelectBoardViewCommand();
	}
	@Bean
	public DeleteBoardCommand deleteBoardCommand() {
		return new DeleteBoardCommand();
	}
	@Bean
	public UpdateBoardCommand updateBoardCommand() {
		return new UpdateBoardCommand();
	}
	@Bean
	public InsertReplyCommand insertReplyCommand() {
		return new InsertReplyCommand();
	}
	@Bean
	public UpdateBoardPage updateBoardPage() {
		return new UpdateBoardPage();
	}
	@Bean
	public DeleteReplyCommand deleteReplyCommand() {
		return new DeleteReplyCommand();
	}
	@Bean
	public InsertFBoardCommand insertFBoardCommand() {
		return new InsertFBoardCommand();
	}
	@Bean
	public SelectFBoardListCommand selectFBoardListCommand() {
		return new SelectFBoardListCommand();
	}
	@Bean
	public SelectFBoardViewCommand selectFBoardViewCommand() {
		return new SelectFBoardViewCommand();
	}
	@Bean
	public DeleteFBoardCommand deleteFBoardCommand() {
		return new DeleteFBoardCommand();
	}
	@Bean
	public UpdateFBoardCommand updateFBoardCommand() {
		return new UpdateFBoardCommand();
	}
	@Bean
	public InsertFReplyCommand insertFReplyCommand() {
		return new InsertFReplyCommand();
	}
	@Bean
	public UpdateFBoardPage updateFBoardPage() {
		return new UpdateFBoardPage();
	}
	@Bean
	public DeleteFReplyCommand deleteFReplyCommand() {
		return new DeleteFReplyCommand();
	}
}
