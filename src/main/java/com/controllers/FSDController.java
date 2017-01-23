package com.controllers;

import com.Service.*;
import com.entities.*;
import com.restful.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by Aymene on 13/01/2017.
 */
@Controller
@RequestMapping(value = "/fsd")
public class FSDController {

    @Autowired
    OfferService offerService;

    @Autowired
    FSDProcedureService FSDProcedureService;

    @Autowired
    DocumentService documentService;

    @Autowired
    ApplicationService applicationService;

    @Autowired
    CompanyService companyService;

    @Autowired
    InsaService insaService;

    @Autowired
    NotificationService notificationService;

    @RequestMapping(value = "/index")
    public String index(ModelMap model, HttpServletRequest req){
        model.addAttribute("username",req.getSession().getAttribute("username"));

        List<Application> studentApplicationList = applicationService.findByIsFsdAndFsdProcedure_ResultAndStateOrderByCreationDateAsc(true,null, ApplicationState.ValidatedByStudent);
        List<Application> insaApplicationList = applicationService.findByIsFsdAndFsdProcedure_ResultAndStateOrderByCreationDateAsc(true,null, ApplicationState.ValidatedByINSA);

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
        model.addAttribute("applications",applicationList);
        return "fsd/index";
    }

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public String getDetails(HttpServletRequest request, ModelMap model, @RequestParam(value="id", required=true) int id ,@RequestParam(value="offer_id", required=true) int offer_id, @RequestParam(value="company", required=true) int company)
    {
        try{
            Offer offer = offerService.findById(offer_id,company);
            model.addAttribute("offer",offer);
            request.getSession().setAttribute("application",applicationService.findById(id));
            model.addAttribute("application", applicationService.findById(id));
        }catch(Exception e){
            model.addAttribute("errorDetails","Error occured while trying to show the offer, please try again later");
        }

        return "fsd/details";
    }

    @RequestMapping(value = "/valider", method = RequestMethod.GET)
    public String valider(ModelMap model, HttpServletRequest req, HttpServletResponse res){
        String choix = req.getParameter("choix");
        //String id = req.getParameter("id");

//        Application app = applicationService.findById(Integer.valueOf(id));
        Application app = (Application) req.getSession().getAttribute("application");
        Company company= app.getCompany();
        INSA insa = app.getInsa();
        Student student = app.getStudent();

        Notification notificationComp=new Notification();
        Notification notificationStud=new Notification();
        Notification notificationInsa = new Notification();

        notificationComp.setApplication(app);
        notificationComp.setEventDate(new Date(System.currentTimeMillis()));
        notificationComp.setVisualized(false);
        notificationComp.setUser(company);

        notificationStud.setApplication(app);
        notificationStud.setEventDate(new Date(System.currentTimeMillis()));
        notificationStud.setVisualized(false);
        notificationStud.setUser(student);

        if(app.getInsa() != null) {
            notificationInsa.setApplication(app);
            notificationInsa.setEventDate(new Date(System.currentTimeMillis()));
            notificationInsa.setVisualized(false);
            notificationInsa.setUser(insa);
        }

        if(choix.equals("accepter")){
            app.getFsdProcedure().setResult(true);
            if(app.getState()== ApplicationState.ValidatedByINSA){
                // Karima's Code
            }
        }else if(choix.equals("rejeter")){
            app.getFsdProcedure().setResult(false);

        }

        return "fsd/index";
    }
}
