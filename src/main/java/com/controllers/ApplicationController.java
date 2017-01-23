package com.controllers;

import com.Service.ApplicationService;
import com.Service.UserService;
import com.entities.Student;
import com.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * Created by admin on 20/01/2017.
 */
@Controller
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private UserService userService;

    @RequestMapping("/showApplications")
    public String showApplications(Model model, Principal principal, HttpServletRequest req){

        User logged=userService.findByEmail(principal.getName());
        req.getSession().setAttribute("loggedUser",logged);

        model.addAttribute("applications",applicationService.findByStudentOrderByCreationDateAsc((Student)logged));
        return "showApplications";
    }
}