package com.controllers;

import com.Service.ApplicationService;
import com.Service.NotificationService;
import com.Service.UserService;
import com.entities.Notification;
import com.entities.Student;
import com.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

/**
 * Created by admin on 21/01/2017.
 */
@Controller
public class NotificationsStudentController {


    @Autowired
    private NotificationService notificationService;

    @Autowired
    private UserService userService;

    @RequestMapping("/notifications")
    public String showNotifications(Model model, Principal principal, HttpServletRequest req){

        User logged=userService.findByEmail(principal.getName());
        req.getSession().setAttribute("loggedUser",logged);
        List<Notification> notifications= notificationService.findByUser(logged);
        model.addAttribute("notifdetails",notifications);

        for(int i=0;i<notifications.size();i++){

            Notification notif =  notifications.get(i);
            notif.setVisualized(true);
            notificationService.save(notif);
        }

        return "notifications";
    }
}
