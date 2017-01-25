package com.repositories;

import com.entities.Application;
import com.entities.Notification;
import com.entities.Student;
import com.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by karima on 05/12/2016.
 */
public interface NotificationRepository extends JpaRepository<Notification,Integer> {

    Notification findByApplicationAndUserOrderByEventDateDesc(Application application, User user);
    List<Notification> findByUser(User user);
    List<Notification> findByUserAndVisualized(User user, boolean visualized);
    List<Notification> findByApplicationAndUserAndVisualizedOrderByEventDateDesc(Application application, User user, boolean visualized);
    List<Notification> findTop15ByUserOrderByEventDateDesc(User user);
}
