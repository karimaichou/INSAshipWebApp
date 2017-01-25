package com.controllers;

import com.Service.*;
import com.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 20/01/2017.
 */
@Controller
public class ApplicationController {

    @ModelAttribute("studentAcceptedCompany")
    public Application constructApp(){
        return new Application();
    }

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;
    @Autowired
    private OfferService offerService;
    @Autowired
    private NotificationService notificationService;

    @RequestMapping("/showApplications")
    public String showApplications(Model model, Principal principal, HttpServletRequest req){
        User logged=userService.findByEmail(principal.getName());
        req.getSession().setAttribute("loggedUser",(Student)logged);
        model.addAttribute("notifications",req.getSession().getAttribute("notifications"));

        model.addAttribute("applications",applicationService.findByStudentOrderByCreationDateAsc((Student)logged));
        return "showApplications";
    }

    @RequestMapping(value = "/appliAcceCompany",method = RequestMethod.GET)
    public String applications(HttpServletRequest req,ModelMap model,Principal principal){
        try{
            User logged=userService.findByEmail(principal.getName());
            req.getSession().setAttribute("loggedUser",(Student)logged);
            model.addAttribute("notifications",req.getSession().getAttribute("notifications"));

            List<Application> applications = applicationService.findByStudentAndStateOrderByCreationDate((Student)logged,ApplicationState.AcceptedByCompany);

            if(applications==null || applications.isEmpty()) {
                model.addAttribute("noApplication", "There are no applications at the moment");
            }
            else {
                model.addAttribute("applications", applications);
            }
        }catch(Exception e){
            model.addAttribute("errorDetails","Error occured while trying to show the applications, please try again later");
        }
        return "appliAcceCompany";
    }
    @RequestMapping(value = "/validatedBystudent",method = RequestMethod.GET)
    public String applicationsvalidated(HttpServletRequest req,ModelMap model,Principal principal){
        try{
            User logged=userService.findByEmail(principal.getName());
            req.getSession().setAttribute("loggedUser",(Student)logged);
            model.addAttribute("notifications",req.getSession().getAttribute("notifications"));

            List<Application> applications = applicationService.findByStudentAndStateOrderByCreationDate((Student)logged,ApplicationState.AcceptedByStudent);

            if(applications==null || applications.isEmpty()) {
                model.addAttribute("noApplication", "There are no applications at the moment");
            }
            else {
                model.addAttribute("applications", applications);
            }
        }catch(Exception e){
            model.addAttribute("errorDetails","Error occured while trying to show the applications, please try again later");
        }
        return "validatedBystudent";
    }
    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public String detail (HttpServletRequest request,ModelMap model, @RequestParam(value="id", required=true) int id,Principal principal ){
        User logged=userService.findByEmail(principal.getName());
        request.getSession().setAttribute("loggedUser",(Student)logged);
        model.addAttribute("notifications",request.getSession().getAttribute("notifications"));

        Application application = applicationService.findById(id);
        request.getSession().setAttribute("application",application);
        model.addAttribute("application",application);
        return "detail";
    }

    @RequestMapping("/appliAcceInsa")
    public String showApplicationsAcceptedInsa(Model model, Principal principal, HttpServletRequest req){

        User logged=userService.findByEmail(principal.getName());
        req.getSession().setAttribute("loggedUser",(Student)logged);
        model.addAttribute("notifications",req.getSession().getAttribute("notifications"));

        model.addAttribute("applicationsAccepted",applicationService.findByStudentAndStateOrderByCreationDate((Student)logged,ApplicationState.AcceptedByINSA));
        return "appliAcceInsa";
    }
    @RequestMapping(value = "/accept",method = RequestMethod.GET)
    public String accept(HttpServletRequest req,Principal principal){
        try {

            Date date=new Date();
            User logged=userService.findByEmail(principal.getName());
            req.getSession().setAttribute("loggedUser",logged);
            Application application = (Application) req.getSession().getAttribute("application");
            application.setState(ApplicationState.AcceptedByStudent);
            applicationService.save(application);
            Notification notification=new Notification();
            notification.setApplication(application);
            notification.setUser(application.getCompany());
            Student student = (Student) logged;
            notification.setMessage(student.getFirstName()+""+student.getLastName()+"has validated his application");
            notification.setVisualized(false);
            notification.setEventDate(date);

            Notification notification2=new Notification();
            notification2.setApplication(application);
            Student student2 = (Student) logged;
            notification2.setUser(student2);
            notification2.setMessage("you validate an application");
            notification2.setVisualized(false);
            notification2.setEventDate(date);
            notificationService.save(notification);
            notificationService.save(notification2);

        }
        catch (Exception e){}
        return "redirect:/indexStudent";
    }

    @RequestMapping(value = "/detail")
    public String detail (){
        return "detail";
    }

}
