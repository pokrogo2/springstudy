package com.koreait.integration.batch;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SchedulerListener;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Application Lifecycle Listener implementation class BoardListener
 *
 */
@WebListener
public class BoardListener implements ServletContextListener {
		//Scheduler , SchedulerFactory : quartz
	private Scheduler scheduler;
	private SchedulerFactory factory;
	public BoardListener() {
        //boardListener 가 동작하면 factory와 scheduler 생성
		try {
		factory = new StdSchedulerFactory();
		scheduler = factory.getScheduler();
		}catch(Exception e) {
			e.printStackTrace();
		}
    }

	public void contextInitialized(ServletContextEvent sce)  { 
		// TODO Auto-generated method stub
		System.out.println("--integrationProject 시작");
		
		
		//job : 무슨 일을 
		//trigger : 언제 하겠다.
		try {
		JobDetail job = JobBuilder.newJob(BoardJob.class)
				.withIdentity("myBoardJob" , "myGroup").build();
		CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("myBoardJob" , "myGroup").withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * 1/1 * ? *")).build();
		scheduler.start();
		scheduler.scheduleJob(job,trigger);
	}catch(SchedulerException e) {
		e.printStackTrace();
	}
	}
	

    public void contextDestroyed(ServletContextEvent sce)  { 
         System.out.println("--integrationProject 종료");
         try {
        	 scheduler.shutdown();
        	 
         }catch(SchedulerException e) {
        	 e.printStackTrace();
         }
    }

}
