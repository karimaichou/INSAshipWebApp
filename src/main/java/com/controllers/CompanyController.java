package com.controllers;

import com.Service.*;
import com.entities.*;
import com.restful.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by borik on 1/13/2017.
 */
@Controller
@RequestMapping(value = "/company")
public class CompanyController {

    @Autowired
    OfferService offerService;
    @Autowired
    CompanyService companyService;
    @Autowired
    ApplicationService applicationService;
    @Autowired
    FSDService fsdService;
    @Autowired
    FSDProcedureService fsdProcedureService;
    @Autowired
    NotificationService notificationService;

    @RequestMapping(value = "/index")
    public String index(ModelMap model,HttpServletRequest request){
        model.addAttribute("notifications",request.getSession().getAttribute("notifications"));
        return "company/index";
    }

    @RequestMapping(value = "/offers",method = RequestMethod.GET)
    public String offers(HttpServletRequest request, ModelMap model){
        try {
            Company company = (Company) request.getSession().getAttribute("loggedUser");
            model.addAttribute("notifications",request.getSession().getAttribute("notifications"));

            List<Offer> offers = offerService.findByCompanyId(company.getId());
            if (offers == null || offers.isEmpty()) {
                model.addAttribute("noOffer", "You don't offer any internship at the moment");
            } else {
                model.addAttribute("offers", offers);
                request.getSession().setAttribute("offers", offers);
            }
        }catch (Exception e){}
        return "company/offers";
    }

    @RequestMapping(value = "/applications",method = RequestMethod.GET)
    public String applications(HttpServletRequest request,ModelMap model, @RequestParam(value="id", required=true) int id ){
        try{
            Company company = (Company)request.getSession().getAttribute("loggedUser");
            model.addAttribute("notifications",request.getSession().getAttribute("notifications"));

            List<Application> applications = applicationService.findByCompanyAndOfferIdAndStateNot(company,id, ApplicationState.Rejected);
            if(applications==null || applications.isEmpty()) {
                model.addAttribute("noApplication", "There are no applications for your offer at the moment");
            }
            else {
                model.addAttribute("applications", applications);
            }
        }catch(Exception e){
            model.addAttribute("errorDetails","Error occured while trying to show the applications, please try again later");
        }
        return "company/applications";
    }

    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public String detail (HttpServletRequest request,ModelMap model, @RequestParam(value="id", required=true) int id ){
        try{
            //get application and offer and save application to session
            Company company = (Company) request.getSession().getAttribute("loggedUser");
            Application application = applicationService.findById(id);
            Offer offer = offerService.findById(application.getOffer_id(),company.getId());
            request.getSession().setAttribute("application",application);
            model.addAttribute("notifications",request.getSession().getAttribute("notifications"));

            //save application and offer to model
            model.addAttribute("application",application);
            model.addAttribute("offer",offer);
            //if needed add FSDs to dropdown form
            if (application.getState() == ApplicationState.Sent) {
                LinkedHashMap<Integer, String> mapFSDs = new LinkedHashMap<Integer, String>();
                List<FSD> fsds = fsdService.findAll();
                mapFSDs.put(-1, "Select");
                mapFSDs.put(0, "No security procedure");
                for (FSD fsd : fsds) {
                    mapFSDs.put(fsd.getId(), fsd.getUsername());
                }
                model.addAttribute("mapFSDs", mapFSDs);
            }
            model.addAttribute("success",request.getSession().getAttribute("success"));
            request.getSession().setAttribute("success",null);
            model.addAttribute("select",request.getSession().getAttribute("select"));
            request.getSession().setAttribute("select",0);
        }
        catch (Exception e){}
        model.addAttribute("fsd",new FSD());
        return "company/detail";
    }

    @RequestMapping(value = "/accept",method = RequestMethod.POST)
    public String accept(HttpServletRequest request,@ModelAttribute("fsd") FSD fsdFromForm,ModelMap model) {
        System.out.println(fsdFromForm.getId());
        Application application = (Application)request.getSession().getAttribute("application");
        if(fsdFromForm.getId() == -1){
            try {
                request.getSession().setAttribute("select",1);
            }catch (Exception e){return "redirect:/company/index";}
        }
        else {
            try {
                application.setState(ApplicationState.AcceptedByCompany);
                if (fsdFromForm.getId() > 0){
                    FSD fsd = fsdService.findById(fsdFromForm.getId());
                    FSDProcedure fsdProcedure = new FSDProcedure();
                    fsdProcedure.setFsd(fsd);
                    fsdProcedure.setApplication(application);
                    fsdProcedure.setResult(null);
                    application.setFSDProcedure(true);
                    fsdProcedureService.save(fsdProcedure);

                }
                applicationService.save(application);
                request.getSession().setAttribute("success","You have successfully accepted application:");

                Notification notification = new Notification();
                notification.setEventDate(new Date(System.currentTimeMillis()));
                notification.setUser(application.getStudent());
                notification.setApplication(application);
                notification.setVisualized(false);
                notification.setMessage("Company " + application.getCompany().getUsername() + " has accepted your application.");
                notificationService.save(notification);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return "redirect:/company/detail?id=" + application.getId();
    }

    @RequestMapping(value = "/meeting",method = RequestMethod.GET)
    public String meeting(HttpServletRequest request,ModelMap model){
        Application application = (Application) request.getSession().getAttribute("application");
        try {
            application.setMeetingRequest(true);
            applicationService.save(application);

            Notification notification = new Notification();
            notification.setEventDate(new Date(System.currentTimeMillis()));
            notification.setUser(application.getStudent());
            notification.setApplication(application);
            notification.setVisualized(false);
            notification.setMessage("Company " + application.getCompany().getUsername() + " has requested a meeting for your application.");
            notificationService.save(notification);

            request.getSession().setAttribute("success","You have successfully sent meeting.");
        }
        catch (Exception e){

        }
        return "redirect:/company/detail?id=" + application.getId();
    }

    @RequestMapping(value = "/reject",method = RequestMethod.GET)
    public String reject(HttpServletRequest request,ModelMap model){
        Application application = (Application) request.getSession().getAttribute("application");
        try {
            application.setState(ApplicationState.Rejected);
            request.getSession().setAttribute("success","You have successfully rejected application:");
            applicationService.save(application);

            Notification notification = new Notification();
            notification.setEventDate(new Date(System.currentTimeMillis()));
            notification.setUser(application.getStudent());
            notification.setApplication(application);
            notification.setVisualized(false);
            notification.setMessage("Company " + application.getCompany().getUsername() + " has refused your application.");
            notificationService.save(notification);
        }
        catch (Exception e){}
        return "redirect:/company/detail?id=" + application.getId();
    }

    @RequestMapping(value = "/accepted",method = RequestMethod.GET)
    public String accepted(ModelMap model,HttpServletRequest request){
        try {
            Company company = (Company) request.getSession().getAttribute("loggedUser");
            List<Application> applications = applicationService.findByCompany(company);
            applications = filterApplications(applications);
            model.addAttribute("applications",applications);
            model.addAttribute("notifications",request.getSession().getAttribute("notifications"));
        }
        catch (Exception e){}
        return "company/accepted";
    }

    @RequestMapping(value = "/detailAccepted",method = RequestMethod.GET)
    public String detailAccepted (HttpServletRequest request,ModelMap model, @RequestParam(value="id", required=true) int id ) {
        try {
            //get application and offer and save application to session
            Company company = (Company)request.getSession().getAttribute("loggedUser");
            Application application = applicationService.findById(id);
            Offer offer = offerService.findById(application.getOffer_id(),company.getId());
            request.getSession().setAttribute("application", application);
            model.addAttribute("notifications",request.getSession().getAttribute("notifications"));

            //save application and offer to model
            model.addAttribute("application", application);
            model.addAttribute("offer", offer);
        }catch (Exception e){}
        return "company/detailAccepted";
    }

    @RequestMapping(value="signAgreement")
    public String signAgreement(ModelMap model, HttpServletRequest request, @ModelAttribute("id") int id)
    {
        try
        {

            Application application = applicationService.findById(id);
            model.addAttribute("agreement",application.getAgreement().getId());

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return "signing";
    }



    private Offer filterOffers(List<Offer> offers,Integer id,Integer cmpid)
    {
        Offer selected = null;
        for (Offer offer:offers)
        {

            if (offer.getId() == id &&offer.getCompany() == cmpid){
                selected = offer;
                break;
            }
        }
        return selected;
    }

    private List<Application> filterApplications(List<Application> applications)
    {
        List<Application> filtered = new ArrayList<Application>();
        for(Application application:applications)
        {
            if (application.getState() != ApplicationState.Rejected && application.getState() != ApplicationState.Sent)
            {
                filtered.add(application);
            }
        }
        return filtered;
    }
}
