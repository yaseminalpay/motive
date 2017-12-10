package com.boun.motive.controller;

import com.boun.motive.model.Notification;
import com.boun.motive.service.INotificationService;

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
    INotificationService notificationService;

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity<Notification> create(@RequestBody @Valid Notification notification) {
        notificationService.createNotification(notification);
        return new ResponseEntity<>(notification, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/deactivate")
    public ResponseEntity<List<Notification>> deactivateNotificationsOfUser(@RequestParam("userId") String userId) {
        List<Notification> notifications = notificationService.getActiveNotificationsByUserId(userId);
        return new ResponseEntity<>(notificationService.deactivateNotifications(notifications), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Notification>> getNotificationsByUserId(@RequestParam("userId") String userId) {
        return new ResponseEntity<>(notificationService.getNotificationsByUserId(userId), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/active")
    public ResponseEntity<List<Notification>> getActiveNotificationsByUserId(@RequestParam("userId") String userId) {
        return new ResponseEntity<>(notificationService.getActiveNotificationsByUserId(userId), HttpStatus.OK);
    }
}
