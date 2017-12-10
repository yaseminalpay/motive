package com.boun.motive.service;

import com.boun.motive.model.Notification;

import java.util.List;

public interface INotificationService {
    Notification createNotification(Notification notification);
    List<Notification> deactivateNotifications(List<Notification> notifications);
    List<Notification> getNotificationsByUserId(String userId);
    List<Notification> getActiveNotificationsByUserId(String userId);
}
