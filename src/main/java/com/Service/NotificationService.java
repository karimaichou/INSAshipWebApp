package com.Service;

import com.entities.Application;
import com.entities.Notification;
import com.entities.User;
import com.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by karima on 05/12/2016.
 */
@Service
public class NotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    Notification findByApplicationAndUserOrderByEventDateDesc(Application application, User user)
    {
        return notificationRepository.findByApplicationAndUserOrderByEventDateDesc(application,user);
    }
    List<Notification> findByApplicationAndUserAndVisualizedOrderByEventDateDesc(Application application, User user, boolean visualized)
    {
        return notificationRepository.findByApplicationAndUserAndVisualizedOrderByEventDateDesc(application,user,visualized);
    }
    public List<Notification> findByUser(User user){
        return notificationRepository.findByUser(user);

    }
    public void save(Notification notification)
    {
         notificationRepository.save(notification);
    }

    public List<Notification> findByUserAndVisualized(User user, boolean visualized){

        return notificationRepository.findByUserAndVisualized(user,visualized);
    }
}
