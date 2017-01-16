package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by karima on 15/01/2017.
 */

@Controller
public class AgreementController {

    @RequestMapping(value="/agreement")
    public String approveOffer(ModelMap model, HttpServletRequest request)
    {
        if(request.getAttribute("application")!=null)
            System.out.println("application passed");
        return null;
    }
}
