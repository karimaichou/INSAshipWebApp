package com.controllers;

import com.Service.StudentService;
import com.View.StudentLoginForm;
import com.View.StudentRegisterForm;
import com.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by karima on 04/12/2016.
 */

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value="/register",method = RequestMethod.POST)
    public String registerStudent(@ModelAttribute("StudentRegisterForm")StudentRegisterForm form, ModelMap model)
    {
        Student student=new Student();
        studentService.save(student);
        return "index";
    }


    @RequestMapping(value = "/sign-in",method = RequestMethod.POST)
    public String loginStudent(@ModelAttribute("StudentForm")StudentLoginForm form,ModelMap model, HttpServletRequest request, HttpServletResponse resp)
    {
        Student student=studentService.findByEmailAndPassword(form.getUsername(),form.getPassword());
        if(student==null)
        {
            model.addAttribute("errorLogin","Error! Your email or password is wrong !");
            return "sign-in";
        }

        else
        {
            request.getSession().setAttribute("currentUser",student);
            if(form.isRemember())
            {
                Cookie mailCookie=new Cookie("username",form.getUsername());
                Cookie passCookie=new Cookie("password",form.getPassword());
                mailCookie.setMaxAge(Integer.MAX_VALUE);
                passCookie.setMaxAge(Integer.MAX_VALUE);
                resp.addCookie(mailCookie);
                resp.addCookie(passCookie);
            }

        }
            return "index";
    }
}
