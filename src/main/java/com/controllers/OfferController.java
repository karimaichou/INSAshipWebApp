package com.controllers;

import com.Service.OfferService;
import com.View.ApplicationForm;
import com.View.OfferForm;
import com.View.StudentLoginForm;
import com.entities.Student;
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
import java.util.List;

/**
 * Created by karima on 11/12/2016.
 */
@Controller
public class OfferController {

    @Autowired
    OfferService offerService;

    @RequestMapping(value = "/offers",method = RequestMethod.GET)
    public String offers(ModelMap model, HttpServletRequest req){
        model.addAttribute("username",req.getSession().getAttribute("username"));
        List<Offer> offerList = offerService.findAll();
        req.getSession().setAttribute("offers",offerList);
        if(offerList==null)
            model.addAttribute("noOffer","there is no available internship offer for the moment");
        model.addAttribute("offers",offerList);
        return "offers";
    }

    @RequestMapping(value = "/search-offers",method = RequestMethod.POST)
    public String getOffers(@ModelAttribute("OfferForm")OfferForm form)
    {
        //filter part

        return "offers";
    }

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public String getDetails(HttpServletRequest request,ModelMap model, @RequestParam(value="id", required=true) int id )
    {
        try{
            List<Offer> offerList =(List<Offer>)request.getSession().getAttribute("offers");
            Offer offer=offerList.get(offerList.indexOf(new Offer(id)));
            model.addAttribute("offer",offer);
        }catch(Exception e){
            model.addAttribute("errorDetails","Error occured while trying to show the offer, please try again later");
    }

        return "offerDetails";
    }


    @Secured("ROLE_STUDENT")
    @RequestMapping(value="/apply",method = RequestMethod.GET)
    public  String ApplyOffer(HttpServletRequest request,ModelMap model,@RequestParam(value="id", required=true) int id)
    {
        List<Offer> offerList =(List<Offer>)request.getSession().getAttribute("offers");
        Offer offer=offerList.get(offerList.indexOf(new Offer(id)));
        Student candidate=(Student) request.getSession().getAttribute("loggedUser");
        ModelAndView view= new ModelAndView("ApplicationForm", "apply", new ApplicationForm());
        model.addAttribute("prenom",candidate.getFirstName());
        model.addAttribute("nom",candidate.getLastName());
        model.addAttribute("email",candidate.getEmail());
        model.addAttribute("offer",offer);
        return "apply";
    }


    @Secured("ROLE_STUDENT")
    @RequestMapping(value="/apply",method = RequestMethod.POST)
    public  String Apply(@ModelAttribute("ApplyForm")ApplicationForm form, HttpServletRequest request, ModelMap model)
    {
        System.out.println("email : "+form.getEmail());
        MultipartFile resume = form.getResume();
        MultipartFile cover = form.getResume();

        System.out.println(resume.getOriginalFilename());

        model.addAttribute("success","your application was sent successfully, you'll receive a confirmation email sooner");
        return "offers";
    }
}
