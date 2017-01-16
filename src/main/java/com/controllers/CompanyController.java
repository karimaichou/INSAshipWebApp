package com.controllers;

import com.Service.ApplicationService;
import com.Service.CompanyService;
import com.Service.OfferService;
import com.entities.Application;
import com.entities.ApplicationState;
import com.entities.Company;
import com.restful.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping(value = "/index")
    public String index(){
        return "company/index";
    }

    @RequestMapping(value = "/offers",method = RequestMethod.GET)
    public String offers(HttpServletRequest request, ModelMap model){
        Company company = (Company)request.getSession().getAttribute("loggedUser");
        List<Offer> offers = offerService.findByCompanyId(company.getId());

        if(offers==null || offers.isEmpty()) {
            model.addAttribute("noOffer", "You don't offer any internship at the moment");
        }
        else {
            model.addAttribute("offers", offers);
        }
        return "company/offers";
    }

    @RequestMapping(value = "/applications",method = RequestMethod.GET)
    public String applications(HttpServletRequest request,ModelMap model, @RequestParam(value="id", required=true) int id ){
        try{
            Company company = (Company)request.getSession().getAttribute("loggedUser");
            List<Application> applications = applicationService.findByCompanyAndOfferIdAndStateNot(company,id, ApplicationState.Rejected);
            if(applications==null || applications.isEmpty()) {
                model.addAttribute("noApplication", "There are no applications at the moment");
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
        Application application = applicationService.findById(id);
        request.getSession().setAttribute("application",application);
        model.addAttribute("application",application);
        return "company/detail";
    }

    @RequestMapping(value = "/meeting",method = RequestMethod.GET)
    public String meeting(HttpServletRequest request){
        try {
            Application application = (Application) request.getSession().getAttribute("application");
            application.setMeetingRequest(true);
            System.out.println("jojo");
            applicationService.save(application);
        }
        catch (Exception e){}
        return "redirect:/company/offers";
    }
    @RequestMapping(value = "/accept",method = RequestMethod.GET)
    public String accept(HttpServletRequest request){
        try {
            Application application = (Application) request.getSession().getAttribute("application");
            application.setState(ApplicationState.AcceptedByCompany);
            applicationService.save(application);
            System.out.println("jaja");
        }
        catch (Exception e){}
        return "redirect:/company/offers";
    }
    @RequestMapping(value = "/reject",method = RequestMethod.GET)
    public String reject(HttpServletRequest request){
        try {
            Application application = (Application) request.getSession().getAttribute("application");
            application.setState(ApplicationState.Rejected);
            System.out.println("nene");
            applicationService.save(application);
        }
        catch (Exception e){}
        return "redirect:/company/offers";
    }
}
