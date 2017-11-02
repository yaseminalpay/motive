package com.boun.motive.dao;

import com.boun.motive.model.Notification;
import org.springframework.data.mongodb.core.aggregation.BooleanOperators;

import java.util.List;

public interface INotificationDAO {
    Notification createNotification(Notification notification);
    List<Notification> deactivateNotifications(List<Notification> notifications);
    List<Notification> getNotificationsByUserId(String userId);
    List<Notification> getActiveNotificationsByUserId(String userId);
}
