package com.controllers;

import com.Service.ApplicationService;
import com.Service.NotificationService;
import com.Service.OfferService;
import com.entities.*;
import com.restful.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by karima on 13/01/2017.
 */
@Controller
@Secured("ROLE_INSA")
@RequestMapping(value="/insa")
public class InsaController {

    @Autowired
    ApplicationService applicationService;

    @Autowired
    OfferService offerService;

    @Autowired
    NotificationService notificationService;

    @RequestMapping(value="/home")
    public String getIndex()
    {
        return "insa/home";
    }

    @RequestMapping(value="/offers")//pending offers to be accepted
    public String getOffers(ModelMap model, HttpServletRequest request)
    {
        try
        {
            INSA teacher=(INSA) request.getSession().getAttribute("loggedUser");
            int year=teacher.getYear();
            List<Application> applications=applicationService.findApplicationByYear(year);
            request.getSession().setAttribute("applications",applications);
            model.addAttribute("notifications",request.getSession().getAttribute("notifications"));

            model.addAttribute("applications",applications);
            if(applications==null || applications.size()==0 )
                model.addAttribute("emptyApp","You have no assigned applications for the moment.");

        }catch(Exception e)
        {
            model.addAttribute("error","an error occured while retrieving offer's list. please try again");
        }

        return "insa/offers";
    }

    @RequestMapping(value="/details")
    public String getDetails(ModelMap model, HttpServletRequest request, @ModelAttribute("id") int id)
    {
        try{
            List<Application> applications=(List<Application>)request.getSession().getAttribute("applications");

            //show info about the student and offer
            Application foundApp=new Application();
            foundApp.setId(id);
            Application application=applications.get(applications.indexOf(foundApp));
            Student student=application.getStudent();
            Company company=application.getCompany();
            Offer offer=offerService.findById(application.getOffer_id(),company.getId());
            boolean fsdRequired=application.isFSDProcedure();
            model.addAttribute("notifications",request.getSession().getAttribute("notifications"));

            model.addAttribute("student",student);
            model.addAttribute("company",company);
            model.addAttribute("offer",offer);// get the corresponding offer to the application and return its details
            model.addAttribute("fsd",fsdRequired);
            model.addAttribute("application",application);

        }catch (Exception e)
        {
            e.printStackTrace();
            model.addAttribute("error","an error occured while retrieving offer's details. please try again");
        }

        return "insa/details";
    }

    @RequestMapping(value="/refuse")
    public String refuseOffer(ModelMap model, HttpServletRequest request, @ModelAttribute("id") int id)
    {
        try {
            List<Application> applications = (List<Application>) request.getSession().getAttribute("applications");
            INSA teacher = (INSA) request.getSession().getAttribute("loggedUser");
            Application foundApp = new Application();
            foundApp.setId(id);
            Application application = applications.get(applications.indexOf(foundApp));
            application.setInsa(teacher);
            application.setState(ApplicationState.Rejected);
            applicationService.save(application);
            applications.remove(application);

            //send notifications
            Notification notification = new Notification();
            notification.setApplication(application);
            notification.setEventDate(new Date(System.currentTimeMillis()));
            notification.setMessage("the application has been updated: an INSA's member refused the application");
            notification.setUser(application.getStudent());
            notification.setVisualized(false);
            notificationService.save(notification);

            Notification notification2 = new Notification();
            notification2.setApplication(application);
            notification2.setEventDate(new Date(System.currentTimeMillis()));
            notification2.setMessage("the application has been updated: an INSA's member refused the application");
            notification2.setUser(application.getCompany());
            notification2.setVisualized(false);
            notificationService.save(notification2);
            model.addAttribute("success", "the Application has been successfully refused");

        }catch (Exception e)
        {
            model.addAttribute("error","an error occured while trying to refuse the application. please try again");
        }
        return "insa/offers";
    }

    @RequestMapping(value="/approve")
    public String approveOffer(ModelMap model, HttpServletRequest request, @ModelAttribute("id") int id,RedirectAttributes redirectAttributes)
    {
        // here you have to set applicatoin's insa attribute and send a notification to the student and company and delete current application from applications
       try {
           List<Application> applications = (List<Application>) request.getSession().getAttribute("applications");
           INSA teacher = (INSA) request.getSession().getAttribute("loggedUser");
           Application foundApp = new Application();
           foundApp.setId(id);
           Application application = applications.get(applications.indexOf(foundApp));
           application.setInsa(teacher);
           application.setState(ApplicationState.AcceptedByINSA);
           applicationService.save(application);
           applications.remove(application);

           //send notifications
           Notification notification = new Notification();
           notification.setApplication(application);
           notification.setEventDate(new Date(System.currentTimeMillis()));
           notification.setMessage("the application has been updated: an INSA's member approved the application");
           notification.setUser(application.getStudent());
           notification.setVisualized(false);
           notificationService.save(notification);

           Notification notification2 = new Notification();
           notification2.setApplication(application);
           notification2.setEventDate(new Date(System.currentTimeMillis()));
           notification2.setMessage("the application has been updated: an INSA's member approved the application");
           notification2.setUser(application.getCompany());
           notification2.setVisualized(false);
           notificationService.save(notification2);

           System.out.println("semtu");
           //model.addAttribute("success","the Application has been successfully approved");

           if(!application.isFSDProcedure() || (application.getFsdProcedure().isResult() != null && application.getFsdProcedure().isResult()) )
           {
               redirectAttributes.addFlashAttribute("application", application);
               return "redirect:/agreementByInsa";
           }

       }catch(Exception e)
       {
           e.printStackTrace();
           model.addAttribute("error","an error occured while trying to approve the application. please try again");
       }
        return "insa/offers";
    }

    //get application which agreement still on false
    @RequestMapping(value="/applications")
    public String getApplications(ModelMap model, HttpServletRequest request)
    {
        try
        {
            INSA teacher=(INSA) request.getSession().getAttribute("loggedUser");
            int year=teacher.getYear();
            List<Application> applications=applicationService.findByStatesAndInsa(teacher.getId());
            request.getSession().setAttribute("suppervisedApplications",applications);
            model.addAttribute("applications",applications);
            if(applications==null || applications.size()==0 )
                model.addAttribute("emptyApp","You have no assigned applications for the moment.Enjoy");

        }catch(Exception e)
        {
            model.addAttribute("error","an error occured while retrieving applications list. please try again");
        }

        return "insa/applications";//suppervisedApplications
    }


    @RequestMapping(value="/suppervisedDetails")
    public String getSuppervisedDetails(ModelMap model, HttpServletRequest request, @ModelAttribute("id") int id)
    {
        try{
            List<Application> applications=(List<Application>)request.getSession().getAttribute("suppervisedApplications");

            //show info about the student and offer
            Application foundApp=new Application();
            foundApp.setId(id);
            Application application=applications.get(applications.indexOf(foundApp));
            Student student=application.getStudent();
            Company company=application.getCompany();
            model.addAttribute("student",student);
            model.addAttribute("company",company);
            model.addAttribute("application",application);

        }catch (Exception e)
        {
            model.addAttribute("error","an error occured while retrieving offer's details. please try again");
        }

        return "insa/suppervisedDetails";
    }

    @RequestMapping(value="/viewAgreement")
    public String agreementDetails(ModelMap model, HttpServletRequest request, @ModelAttribute("id") int id) {
        try
        {
            List<Application> applications=(List<Application>)request.getSession().getAttribute("suppervisedApplications");

            //show info about the student and offer
            Application foundApp=new Application();
            foundApp.setId(id);
            Application application=applications.get(applications.indexOf(foundApp));
            Agreement agreement=application.getAgreement();
            Document agreementDoc=agreement.getAgreementDoc();

            //then open it and view its content
            model.addAttribute("agreementName",agreementDoc.getName());

        } catch (Exception e) {
            model.addAttribute("error","an error occured while retrieving agreement document. please try again");
        }

        return "agreementView";
    }

    @RequestMapping(value="signAgreement")
    public String signAgreement(ModelMap model, HttpServletRequest request, @ModelAttribute("id") int id)
    {
        try
        {
            List<Application> applications = (List<Application>) request.getSession().getAttribute("suppervisedApplications");
            Application foundApp = new Application();
            foundApp.setId(id);
            Application application = applications.get(applications.indexOf(foundApp));
            model.addAttribute("agreement",application.getAgreement().getId());

        }catch (Exception e)
        {
            model.addAttribute("error","an error occured while retrieving agreement document. please try again");
        }

        return "signing";
    }

}
