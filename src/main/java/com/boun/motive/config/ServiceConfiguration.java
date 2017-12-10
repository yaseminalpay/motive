package com.boun.motive.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.boun.motive.service.ICommentService;
import com.boun.motive.service.IContentService;
import com.boun.motive.service.IInterestService;
import com.boun.motive.service.INotificationService;
import com.boun.motive.service.IUserService;
import com.boun.motive.service.impl.CommentServiceMongoImpl;
import com.boun.motive.service.impl.ContentServiceMongoImpl;
import com.boun.motive.service.impl.InterestServiceMongoImpl;
import com.boun.motive.service.impl.NotificationServiceMongoImpl;
import com.boun.motive.service.impl.UserServiceMongoImpl;

//TODO: get which DB impl to initialize from a config or properties file
@Configuration
public class ServiceConfiguration {

	@Bean
	public IUserService getUserService() {
		return new UserServiceMongoImpl();
	}

	@Bean
	public ICommentService getCommentService() {
		return new CommentServiceMongoImpl();
	}

	@Bean
	public IContentService getContentService() {
		return new ContentServiceMongoImpl();
	}

	@Bean
	public IInterestService getInterestService() {
		return new InterestServiceMongoImpl();
	}

	@Bean
	public INotificationService getNotificationService() {
		return new NotificationServiceMongoImpl();
	}
}
