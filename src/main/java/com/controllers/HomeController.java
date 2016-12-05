package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by borik on 11/18/2016.
 */
@Controller
public class HomeController {

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

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(){
        return "register";
    }
}
