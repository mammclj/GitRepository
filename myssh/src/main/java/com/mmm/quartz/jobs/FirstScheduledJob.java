package com.mmm.quartz.jobs;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.mmm.service.UserService;

public class FirstScheduledJob extends QuartzJobBean {

	private static Logger logger = Logger.getLogger(FirstScheduledJob.class);

	private UserService userService;
	//此类因为没有用spring管理，所以userService需要用setter方法注入
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		//TODO 要实现的代码逻辑
//		logger.info("-----------在这写定时执行代码逻辑----------------");
//		User user = this.userService.getUserById("1");
	}

}