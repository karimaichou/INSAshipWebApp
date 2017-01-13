package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by borik on 1/13/2017.
 */
@Controller
@RequestMapping(value = "/company")
public class CompanyController {

    @RequestMapping(value = "/index")
    public String index(){
        return "company/index";
    }
}
