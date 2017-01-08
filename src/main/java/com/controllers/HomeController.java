package com.controllers;

import com.Service.StudentService;
import com.entities.Student;
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

/**
 * Created by borik on 11/18/2016.
 */
@Controller
public class HomeController {


    @Autowired
    private StudentService studentService;

    @ModelAttribute("student")
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
    public String signIn(HttpServletRequest request, ModelMap model){
        Cookie cookies[]=request.getCookies();
        for(Cookie cookie:cookies)
        {
            if(cookie.getName().equals("username"))
                model.addAttribute("username",cookie.getValue());
            else if(cookie.getName().equals("password"))
                model.addAttribute("password",cookie.getValue());
        }

        return "sign-in";
    }

    @RequestMapping(value = "/register")
    public String register(){
        return "register";
    }
   /* @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String doRegistration(@ModelAttribute("student") Student student){
        studentService.save(student);
        return "confirm-registration";
    }*/

    @RequestMapping(value = "/indexStudent")
    public String indexStudent(){
        return "indexStudent";
    }



}
