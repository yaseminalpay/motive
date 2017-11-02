package com.boun.motive.dao;

import com.boun.motive.model.Notification;

import java.util.List;

public interface INotificationDAO {
    public void createNotification(Notification notification);
    public void deactivateNotifications(List<Notification> notifications);
    public List<Notification> getNotificationsByUserId(String userId);
    public List<Notification> getActiveNotificationsByUserId(String userId);
}
