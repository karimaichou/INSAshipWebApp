package com.controllers;

import com.Service.*;
import com.View.ApplicationForm;
import com.View.OfferForm;
import com.View.SearchForm;
import com.View.StudentLoginForm;
import com.entities.*;
import com.restful.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Created by karima on 11/12/2016.
 */
@Controller
public class OfferController {

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

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/offers",method = RequestMethod.GET)
    public String offers(ModelMap model, HttpServletRequest req, Principal principal){

        User logged=userService.findByEmail(principal.getName());
        req.getSession().setAttribute("loggedUser",(Student)logged);
        model.addAttribute("notifications",req.getSession().getAttribute("notifications"));

        model.addAttribute("username",req.getSession().getAttribute("username"));
        List<Offer> offerList = offerService.findAll();
        req.getSession().setAttribute("offers",offerList);
        if(offerList==null)
            model.addAttribute("noOffer","there is no available internship offer for the moment");
        model.addAttribute("offers",offerList);
        return "offers";
    }

    @RequestMapping(value = "/search-offers",method = RequestMethod.POST)
    public String getOffers(@ModelAttribute("SearchForm")SearchForm form, HttpServletRequest req, ModelMap model, Principal principal)
    {
        User logged=userService.findByEmail(principal.getName());
        req.getSession().setAttribute("loggedUser",(Student)logged);
        model.addAttribute("notifications",req.getSession().getAttribute("notifications"));


        //filter part
        List<Offer> offerList = offerService.findByKeyword(form.getKeyword());
        req.getSession().setAttribute("offers",offerList);
        if(offerList==null)
            model.addAttribute("noOffer","there is no available internship offer for the moment");
        model.addAttribute("offers",offerList);
        return "offers";
    }

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public String getDetails(HttpServletRequest request,ModelMap model, @RequestParam(value="id", required=true) int id , @RequestParam(value="company", required=true) int company)
    {
        try{
            List<Offer> offerList =(List<Offer>)request.getSession().getAttribute("offers");
            Offer offer=offerList.get(offerList.indexOf(new Offer(id, company)));
            model.addAttribute("offer",offer);
        }catch(Exception e){
            model.addAttribute("errorDetails","Error occured while trying to show the offer, please try again later");
    }

        return "offerDetails";
    }


    @Secured("ROLE_STUDENT")
    @RequestMapping(value="/apply",method = RequestMethod.GET)
    public  String ApplyOffer(HttpServletRequest request,ModelMap model,@RequestParam(value="id", required=true) int id , @RequestParam(value="company", required=true) int company)
    {
        List<Offer> offerList =(List<Offer>)request.getSession().getAttribute("offers");
        Offer offer=offerList.get(offerList.indexOf(new Offer(id, company)));
        System.out.println(offer.getTitle());
        Student candidate=(Student) request.getSession().getAttribute("loggedUser");
        model.addAttribute("prenom",candidate.getFirstName());
        model.addAttribute("nom",candidate.getLastName());
        model.addAttribute("email",candidate.getEmail());
        model.addAttribute("offer",offer);
        return "apply";
    }


    @Secured("ROLE_STUDENT")
    @RequestMapping(value="/apply",method = RequestMethod.POST)
    public  String Apply(@ModelAttribute("ApplicationForm")ApplicationForm form, HttpServletRequest request, ModelMap model)
    {
       try {

           List<Offer> offerList =(List<Offer>)request.getSession().getAttribute("offers");
           Offer offer=offerList.get(offerList.indexOf(new Offer(form.getId(), form.getCompany())));
           System.out.println(offer.getTitle());
           Company company=companyService.findById(offer.getCompany_id());

           System.out.println(company.getUsername());
           Student student=(Student)request.getSession().getAttribute("loggedUser");

           System.out.println(student.getFirstName()+company.getUsername()+offer.getTitle());

           //test if the student has already applied
           List<Application> old = applicationService.findByStudentAndCompanyAndOfferIdAndStateNot(student,company,offer.getId(),ApplicationState.Rejected);
           if (!(old == null || old.size() == 0) ) {
               model.addAttribute("Error", "You are already applied to that internship offer.");
           }else {

               MultipartFile resume = form.getFiles().get(0);
               MultipartFile cover = form.getFiles().get(1);
               Document file1 = new Document();
               Document file2 = new Document();
               file1.setFileType("resume");
               file2.setFileType("coverLetter");
               file1.setCreationDate(new Date(System.currentTimeMillis()));
               file2.setCreationDate(new Date(System.currentTimeMillis()));
               file1.setName("resume");
               file2.setName("Cover Letter");
               List<Document> files = new ArrayList<Document>();
               files.add(file1);
               files.add(file2);

               Application application = new Application();
               application.setStudent(student);
               application.setCompany(company);
               application.setCreationDate(new Date(System.currentTimeMillis()));
               application.setOffer_id(offer.getId());
               application.setDocuments(files);
               application.setFSDProcedure(false);
               application.setState(ApplicationState.Sent);
               application = applicationService.save(application);

               Notification notification = new Notification();
               notification.setApplication(application);
               notification.setEventDate(new Date(System.currentTimeMillis()));
               notification.setMessage("New application to the offer :" + offer.getTitle() + " on :" + notification.getEventDate() + "from : " +
                       student.getFirstName() + " " + student.getLastName() + "./n a confirmation was also sent to your mail.");
               notification.setMessage("Student " + student.getFirstName() + " " + student.getLastName() + " has applied to your offer: "
                       + offer.getTitle() + ".");


               System.out.println(notification.getMessage());
               notification.setUser(company);
               notification.setVisualized(false);
               notificationService.save(notification);


               file1.setFileUrl(request.getServletContext().getRealPath("/") + "resources\\" + application.getId() + "Resume");
               file2.setFileUrl(request.getServletContext().getRealPath("/") + "resources\\" + application.getId() + "Cover");
               documentService.save(file1);
               documentService.save(file2);
               resume.transferTo(new File(request.getServletContext().getRealPath("/") + "resources\\" + application.getId() + "Resume"));
               cover.transferTo(new File(request.getServletContext().getRealPath("/") + "resources\\" + application.getId() + "Cover"));

               // and last but not least : add Franck's service to send an email to student + company

               model.addAttribute("success", "Your application was sent successfully, you will soon receive a confirmation email.");
           }
       }catch(Exception e)
       {
           e.printStackTrace();
           model.addAttribute("Error", "There was an error with you application, please try again later");
       }
        return "offers";
    }
}
