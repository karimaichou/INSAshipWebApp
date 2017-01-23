package com.controllers;

import com.Service.*;
import com.entities.Application;
import com.entities.ApplicationState;
import com.restful.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Aymene on 13/01/2017.
 */
@Controller
@RequestMapping(value = "/fsd")
public class FSDController {

    @Autowired
    OfferService offerService;

    @Autowired
    DocumentService documentService;

    @Autowired
    ApplicationService applicationService;

    @Autowired
    CompanyService companyService;

    @Autowired
    NotificationService notificationService;

    @RequestMapping(value = "/index")
    public String index(ModelMap model, HttpServletRequest req){
       /* model.addAttribute("username",req.getSession().getAttribute("username"));

        List<Application> studentApplicationList = applicationService.findByIsFsdAndStateOrderByCreationDateAsc(true, ApplicationState.ValidatedByStudent);
        List<Application> insaApplicationList = applicationService.findByIsFsdAndStateOrderByCreationDateAsc(true, ApplicationState.ValidatedByINSA);

        List<Application> applicationList = new ArrayList<Application>();
        applicationList.addAll(studentApplicationList);
        applicationList.addAll(insaApplicationList);
        Collections.sort(applicationList, new Comparator<Application>() {
            public int compare(Application o1, Application o2) {
                if (o1.getCreationDate() == null || o2.getCreationDate() == null)
                    return 0;
                return o1.getCreationDate().compareTo(o2.getCreationDate());
            }
        });

        req.getSession().setAttribute("applications",applicationList);
        if(applicationList.isEmpty())
            model.addAttribute("noApplication","there is no available internship application for the moment");
        model.addAttribute("applications",applicationList);*/
        return "fsd/index";
    }

    @RequestMapping(value = "/valider", method = RequestMethod.POST)
    public String valider(ModelMap model, HttpServletRequest req){
      /*  String choix = req.getParameter("choix");
        String id = req.getParameter("id");

        Application app = (Application) applicationService.findByOfferIdOrderByCreationDateAsc(Integer.valueOf(id));

        if(choix.equals("accepter")){
            app.getFsdProcedure().setResult(true);
            if(app.getState()== ApplicationState.ValidatedByINSA){
                // Karima's Code
            }
        }else if(choix.equals("rejeter")){
            app.getFsdProcedure().setResult(false);

        }
*/
        return "fsd/index";
    }
}
