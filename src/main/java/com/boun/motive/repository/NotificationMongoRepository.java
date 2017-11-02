package com.boun.motive.repository;

import com.boun.motive.model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationMongoRepository extends MongoRepository<Notification, String> {

    List<Notification> findNotificationByUserId(String userId);

    @Query("{'$and':[ {'userId':?0}, {'notificationStatus': 'NOT_SEEN'} ]}")
    List<Notification> findActiveNotificationByUserId(String userId);
}
