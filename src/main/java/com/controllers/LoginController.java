package com.controllers;

import com.Service.StudentService;
import com.Service.UserService;
import com.View.ConfirmationForm;
import com.View.StudentLoginForm;
import com.View.StudentRegisterForm;
import com.entities.*;
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
import java.util.List;

/**
 * Created by karima on 04/12/2016.
 */

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    StudentService studentService;



    @RequestMapping(value = "/confirmation-compte")
    public String confirmationCompte(){
        return "confirmation-compte";
    }

    @RequestMapping(value="/register",method = RequestMethod.POST)
    public String registerStudent(@ModelAttribute("student") Student student)
    {
        studentService.save(student);
        return "confirmation-compte";
    }

    @RequestMapping(value="/confirmation-compte",method = RequestMethod.POST)
    public String registerconfirmation(@ModelAttribute("confirmation") ConfirmationForm confirmation)
    {

        return "sign-in";
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

        if (logged instanceof Company) return "redirect:/company/index";
        if (logged instanceof INSA) return "redirect:/insa/offers"; //redirect to you controller methon in your controller
        if (logged instanceof FSD) return "redirect:/fsd/something"; //redirect to you controller methon in your controller
        return "redirect:/offers";
    }

}
