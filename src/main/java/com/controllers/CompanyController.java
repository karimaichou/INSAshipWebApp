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
import java.util.ArrayList;
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

    @RequestMapping(value = "/index")
    public String index(){

        return "company/index";
    }

    @RequestMapping(value = "/offers",method = RequestMethod.GET)
    public String offers(HttpServletRequest request, ModelMap model){
        try {
            Company company = (Company) request.getSession().getAttribute("loggedUser");
            List<Offer> offers = offerService.findByCompanyId(company.getId());
            if (offers == null || offers.isEmpty()) {
                model.addAttribute("noOffer", "You don't offer any internship at the moment");
            } else {
                model.addAttribute("offers", offers);
                request.getSession().setAttribute("offers", offers);
            }
        }catch (Exception e){}
        request.getSession().setAttribute("error",0);
        return "company/offers";
    }

    @RequestMapping(value = "/applications",method = RequestMethod.GET)
    public String applications(HttpServletRequest request,ModelMap model, @RequestParam(value="id", required=true) int id ){
        try{
            Company company = (Company)request.getSession().getAttribute("loggedUser");
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
        request.getSession().setAttribute("error",0);
        return "company/applications";
    }

    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public String detail (HttpServletRequest request,ModelMap model, @RequestParam(value="id", required=true) int id ){
        try{
            //get application and offer and save application to session
            Application application = applicationService.findById(id);
            Offer offer = filterOffers((List<Offer>) request.getSession().getAttribute("offers"),application.getOffer_id());
            request.getSession().setAttribute("application",application);
            //save application and offer to model
            model.addAttribute("application",application);
            model.addAttribute("offer",offer);
            //Add FSDs to dropdown form
            LinkedHashMap<Integer, String> mapFSDs = new LinkedHashMap<Integer, String>();
            List<FSD> fsds = fsdService.findAll();
            mapFSDs.put(-1,"Select");
            mapFSDs.put(0,"No security procedure");
            for (FSD fsd:fsds){
                mapFSDs.put(fsd.getId(),fsd.getUsername());
            }
            model.addAttribute("mapFSDs",mapFSDs);
            //handle verification
            Integer error = (Integer) request.getSession().getAttribute("error");
            if (error != null)
            {
                if (error == 1) {
                    request.getSession().setAttribute("error", 0);
                    model.addAttribute("error",1);
                }
                else model.addAttribute("error",0);
            }else model.addAttribute(("error"),0);
        }
        catch (Exception e){}
        model.addAttribute("fsd",new FSD());
        return "company/detail";
    }

    @RequestMapping(value = "/accept",method = RequestMethod.POST)
    public String accept(HttpServletRequest request,@ModelAttribute("fsd") FSD fsdFromForm,ModelMap model) {
        System.out.println(fsdFromForm.getId());
        if(fsdFromForm.getId() == -1){
            try {
                Application application = (Application)request.getSession().getAttribute("application");
                request.getSession().setAttribute("error",1);
                return "redirect:/company/detail?id=" + application.getId();
            }catch (Exception e){return "redirect:/company/index";}
        }
        else {
            try {
                Application application = (Application) request.getSession().getAttribute("application");
                application.setState(ApplicationState.AcceptedByCompany);
                if (fsdFromForm.getId() > 0){
                    FSD fsd = fsdService.findById(fsdFromForm.getId());
                    FSDProcedure fsdProcedure = new FSDProcedure();
                    fsdProcedure.setFsd(fsd);
                    fsdProcedure.setApplication(application);
                    fsdProcedure.setResult(false);
                    application.setFSDProcedure(true);
                    fsdProcedureService.save(fsdProcedure);
                }
                applicationService.save(application);
                model.addAttribute("application",null);
                model.addAttribute("message","You have accepted application:");
                model.addAttribute("result","Success");
            }
            catch (Exception e){
                model.addAttribute("message","An error occurred during acceptation, please try again later.");
                model.addAttribute("result","Error");
                return "company/result";
            }
        }
        return "company/result";
    }

    @RequestMapping(value = "/meeting",method = RequestMethod.GET)
    public String meeting(HttpServletRequest request){
        try {
            Application application = (Application) request.getSession().getAttribute("application");
            application.setMeetingRequest(true);
            applicationService.save(application);
        }
        catch (Exception e){}
        return "redirect:/company/offers";
    }

    @RequestMapping(value = "/reject",method = RequestMethod.GET)
    public String reject(HttpServletRequest request,ModelMap model){
        try {
            Application application = (Application) request.getSession().getAttribute("application");
            application.setState(ApplicationState.Rejected);
            model.addAttribute("message","You have rejected application:");
            model.addAttribute("result","Success");
            applicationService.save(application);
        }
        catch (Exception e){}
        return "company/result";
    }

    @RequestMapping(value = "/accepted",method = RequestMethod.GET)
    public String accepted(ModelMap model,HttpServletRequest request){
        try {
            Company company = (Company) request.getSession().getAttribute("loggedUser");
            List<Application> applications = applicationService.findByCompany(company);
            applications = filterApplications(applications);
            model.addAttribute("applications",applications);
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
            //save application and offer to model
            model.addAttribute("application", application);
            model.addAttribute("offer", offer);
        }catch (Exception e){}
        return "company/detailAccepted";
    }

    private Offer filterOffers(List<Offer> offers,Integer id)
    {
        Offer selected = null;
        for (Offer offer:offers)
        {

            if (offer.getId() == id){
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
