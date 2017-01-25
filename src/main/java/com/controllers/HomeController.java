package com.controllers;

import com.Service.NotificationService;
import com.Service.StudentService;
import com.Service.UserService;
import com.entities.Notification;
import com.entities.Student;
import com.entities.User;
import com.restful.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;
import java.util.List;

/**
 * Created by borik on 11/18/2016.
 */
@Controller
public class HomeController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private UserService userService;
    @Autowired
    private NotificationService notificationService;

    @ModelAttribute("studentupdate")
    public Student construct(){
        return new Student();
    }

    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/example")
    public String example(){
        return "example";
    }


    @RequestMapping(value = "/sign-in",method = RequestMethod.GET)
    public String signIn(HttpServletRequest request, ModelMap model) {
        Cookie cookies[] = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username"))
                model.addAttribute("username", cookie.getValue());
            else if (cookie.getName().equals("password"))
                model.addAttribute("password", cookie.getValue());
        }

        return "sign-in";
    }


    @RequestMapping(value = "/indexStudent")
    public String indexStudent(ModelMap model, Principal principal, HttpServletRequest req){

        User logged=userService.findByEmail(principal.getName());
        req.getSession().setAttribute("loggedUser",(Student)logged);
        model.addAttribute("notifications",req.getSession().getAttribute("notifications"));
        model.addAttribute("studentlastname",((Student) logged).getLastName());
        model.addAttribute("studentFirstName",((Student) logged).getFirstName());
        model.addAttribute("studentSex",((Student) logged).getSex());
        model.addAttribute("studentAdress",((Student) logged).getAddress());
        model.addAttribute("studenttelephone",((Student) logged).getTelephone());
        model.addAttribute("studentEmail",((Student) logged).getEmail());
        model.addAttribute("studentDateofbirth",((Student) logged).getDateOfBirth());
        model.addAttribute("studentDateInscription",((Student) logged).getDateInscription());
        model.addAttribute("studentDescription",((Student) logged).getDescription());
        model.addAttribute("studentScolarYear",((Student) logged).getScholarYear());
        return "indexStudent";
    }

    @RequestMapping(value="/manage",method=RequestMethod.POST)
    public String updateProfile(@ModelAttribute("studentupdate") Student student,ModelMap model,Principal principal,HttpServletRequest request)
    {

        User student1=userService.findByEmail(principal.getName());
        request.getSession().setAttribute("loggedUser",(Student)student1);
        User logged=userService.findByEmail(principal.getName());
        request.getSession().setAttribute("loggedUser",(Student)logged);
        model.addAttribute("notifications",request.getSession().getAttribute("notifications"));


        ((Student )student1).setLastName(student.getLastName());
        ((Student )student1).setFirstName(student.getFirstName());
        ((Student )student1).setDateOfBirth(student.getDateOfBirth());
        ((Student )student1).setAddress(student.getAddress());
        ((Student )student1).setTelephone(student.getTelephone());
        ((Student )student1).setEmail(student.getEmail());
        ((Student )student1).setScholarYear(student.getScholarYear());
        studentService.update(((Student )student1));
        return "sign-in";
    }


    @RequestMapping(value = "/manage")
    public String showProfilUpdate(ModelMap model, Principal principal, HttpServletRequest req){


        User logged=userService.findByEmail(principal.getName());
        req.getSession().setAttribute("loggedUser",(Student)logged);
        model.addAttribute("notifications",req.getSession().getAttribute("notifications"));

        model.addAttribute("stlastname",((Student) logged).getLastName());
        model.addAttribute("stFirstName",((Student) logged).getFirstName());
        model.addAttribute("stAdress",((Student) logged).getAddress());
        model.addAttribute("sttelephone",((Student) logged).getTelephone());
        model.addAttribute("stEmail",((Student) logged).getEmail());
        model.addAttribute("stDateofbirth",((Student) logged).getDateOfBirth());
        model.addAttribute("stDescription",((Student) logged).getDescription());
        model.addAttribute("stScolarYear",((Student) logged).getScholarYear());
        return "manage";
    }




}
