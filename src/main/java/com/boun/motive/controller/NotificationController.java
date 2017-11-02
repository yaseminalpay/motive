package com.boun.motive.controller;

import com.boun.motive.dao.INotificationDAO;
import com.boun.motive.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/notifications")
public class NotificationController {

    @Autowired
    INotificationDAO notificationDAO;

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity<Notification> create(@RequestBody @Valid Notification notification) {
        notificationDAO.createNotification(notification);
        return new ResponseEntity<Notification>(notification, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/deactivate/{userId}")
    public void deactivateNotificationsOfUser(@PathVariable("userId") String userId) {
        List<Notification> notifications = notificationDAO.getActiveNotificationsByUserId(userId);
        notificationDAO.deactivateNotifications(notifications);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{userId}")
    public List<Notification> getNotificationsByUserId(@PathVariable("userId") String userId) {
        return notificationDAO.getNotificationsByUserId(userId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/active/{userId}")
    public List<Notification> getActiveNotificationsByUserId(@PathVariable("userId") String userId) {
        return notificationDAO.getActiveNotificationsByUserId(userId);
    }
}
