package com.boun.motive.dao.impl;

import com.boun.motive.dao.INotificationDAO;
import com.boun.motive.model.Notification;
import com.boun.motive.repository.NotificationMongoRepository;
import com.boun.motive.util.constant.NotificationStatus;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NotificationDAOMongoImpl implements INotificationDAO {

    @Autowired
    NotificationMongoRepository notificationMongoRepository;

    @Override
    public Notification createNotification(Notification notification) {
        notificationMongoRepository.save(notification);
        return notification;
    }

    @Override
    public List<Notification> deactivateNotifications(List<Notification> notifications) {
        for (Notification notification: notifications) {
            notification.setNotificationStatus(NotificationStatus.SEEN);
        }
        notificationMongoRepository.save(notifications);
        return notifications;
    }

    @Override
    public List<Notification> getNotificationsByUserId(String userId) {
        return notificationMongoRepository.findNotificationByUserId(userId);
    }

    @Override
    public List<Notification> getActiveNotificationsByUserId(String userId) {
        return notificationMongoRepository.findActiveNotificationByUserId(userId);
    }
}
