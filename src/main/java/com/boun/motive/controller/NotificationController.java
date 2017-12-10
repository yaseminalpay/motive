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
        return new ResponseEntity<>(notification, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/deactivate")
    public ResponseEntity<List<Notification>> deactivateNotificationsOfUser(@RequestParam("userId") String userId) {
        List<Notification> notifications = notificationDAO.getActiveNotificationsByUserId(userId);
        return new ResponseEntity<>(notificationDAO.deactivateNotifications(notifications), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Notification>> getNotificationsByUserId(@RequestParam("userId") String userId) {
        return new ResponseEntity<>(notificationDAO.getNotificationsByUserId(userId), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/active")
    public ResponseEntity<List<Notification>> getActiveNotificationsByUserId(@RequestParam("userId") String userId) {
        return new ResponseEntity<>(notificationDAO.getActiveNotificationsByUserId(userId), HttpStatus.OK);
    }
}
