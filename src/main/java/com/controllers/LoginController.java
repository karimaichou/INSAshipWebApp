package com.controllers;

import com.Service.StudentService;
import com.Service.UserService;
import com.View.StudentLoginForm;
import com.View.StudentRegisterForm;
import com.entities.Student;
import com.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

/**
 * Created by karima on 04/12/2016.
 */

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    StudentService studentService;

    @RequestMapping(value="/register",method = RequestMethod.POST)
    public String registerStudent(@ModelAttribute("student") Student student)
    {
        studentService.save(student);
        return "index";
    }



    @RequestMapping(value="loginError")

    public String loginError(ModelMap model)
    {
        model.addAttribute("errorLogin","Error! Your email or password is wrong !");
        return "sign-in";
    }

    @RequestMapping(value="welcomePage")
    public String loginSuccess(ModelMap model, Principal principal, HttpServletRequest req)
    {

        User logged=userService.findByEmail(principal.getName());
        req.getSession().setAttribute("loggedUser",logged);
        return "redirect:/offers";
    }

}
