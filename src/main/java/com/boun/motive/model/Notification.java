package com.boun.motive.model;

import com.boun.motive.util.constant.NotificationStatus;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class Notification implements Serializable {

    @Id
    private String id;

    @NotNull
    private NotificationStatus notificationStatus;

    @NotNull
    private String userId;

    public Notification(){

    }

    public Notification(String id, NotificationStatus notificationStatus, String userId) {
        this.id = id;
        this.notificationStatus = notificationStatus;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public NotificationStatus getNotificationStatus() {
        return notificationStatus;
    }

    public void setNotificationStatus(NotificationStatus notificationStatus) {
        this.notificationStatus = notificationStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
