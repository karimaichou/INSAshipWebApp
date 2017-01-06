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
    public String registerStudent(@ModelAttribute("StudentRegisterForm")StudentRegisterForm form, ModelMap model)
    {
        Student student=new Student();
        
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
    public String loginSuccess(ModelMap model, Principal principal,HttpServletRequest req)
    {
        return "offers";
    }


    /*@RequestMapping(value = "/sign-in",method = RequestMethod.POST)
    public String loginStudent(@ModelAttribute("StudentForm")StudentLoginForm form,ModelMap model, HttpServletRequest request, HttpServletResponse resp)
    {
        User user=userService.findByEmailAndPassword(form.getUsername(),form.getPassword());
        if(user==null)
        {
            model.addAttribute("errorLogin","Error! Your email or password is wrong !");
            return "sign-in";
        }

        else
        {
            request.getSession().setAttribute("currentUser",user);
            if(form.isRemember())
            {
                Cookie mailCookie=new Cookie("username",form.getUsername());
                Cookie passCookie=new Cookie("password",form.getPassword());
                mailCookie.setMaxAge(Integer.MAX_VALUE);
                passCookie.setMaxAge(Integer.MAX_VALUE);
                resp.addCookie(mailCookie);
                resp.addCookie(passCookie);
            }
            //si c un etudiant aller a la page des offres dirrectement sinon aller dans la page home
            if(user.getRoles().contains("ROLE_STUDENT"))
                return "offers";


        }
            return "index";
    }*/
}
