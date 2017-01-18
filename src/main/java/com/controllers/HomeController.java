package com.controllers;

import com.Service.StudentService;
import com.Service.UserService;
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

/**
 * Created by borik on 11/18/2016.
 */
@Controller
public class HomeController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private UserService userService;

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
        model.addAttribute("studentlastname",((Student) logged).getLastName());
        model.addAttribute("studentFirstName",((Student) logged).getFirstName());
        model.addAttribute("studentSex",((Student) logged).getFirstName());
        model.addAttribute("studentAdress",((Student) logged).getAddress());
        model.addAttribute("studenttelephone",((Student) logged).getTelephone());
        model.addAttribute("studentEmail",((Student) logged).getEmail());
        model.addAttribute("studentDateofbirth",((Student) logged).getDateOfBirth());
        model.addAttribute("studentDateInscription",((Student) logged).getDateInscription());
        model.addAttribute("studentDescription",((Student) logged).getDescription());
        model.addAttribute("studentScolarYear",((Student) logged).getScholarYear());
        return "indexStudent";
    }



}
