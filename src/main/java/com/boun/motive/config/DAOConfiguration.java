package com.boun.motive.config;

import com.boun.motive.dao.*;
import com.boun.motive.dao.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//TODO: get which DB impl to initialize from a config or properties file
@Configuration
public class DAOConfiguration {

    IAnnotationDAO annotationDAO;
    ICommentDAO commentDAO;
    IContentDAO contentDAO;
    IInterestDAO interestDAO;
    INotificationDAO notificationDAO;
    IUserDAO userDAO;

    @Bean
    public IUserDAO getUserDAO() {
        return new UserDAOMongoImpl();
    }

    @Bean
    public IAnnotationDAO getAnnotationDAO() {
        return new AnnotationDAOMongoImpl();
    }

    @Bean
    public ICommentDAO getCommentDAO() { return new CommentDAOMongoImpl(); }

    @Bean
    public IContentDAO getContentDAO() {
        return new ContentDAOMongoDAOImpl();
    }

    @Bean
    public IInterestDAO getInterestDAO() {
        return new InterestDAOMongoImpl();
    }

    @Bean
    public INotificationDAO getNotificationDAO() {
        return new NotificationDAOMongoImpl();
    }
}
