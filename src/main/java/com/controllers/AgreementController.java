package com.controllers;

import com.Service.*;
import com.View.SignAgreementForm;
import com.entities.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.restful.Offer;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.List;

/**
 * Created by karima on 15/01/2017.
 */

@Controller
public class AgreementController {

    @Autowired
    OfferService offerService;

    @Autowired
    NotificationService notificationService;

    @Autowired
    DocumentService documentService;

    @Autowired
    AgreementService agreementService;

    @Autowired
    ApplicationService applicationService;

    @RequestMapping(value="/agreementByInsa")
    public String generateAgreementByInsa(ModelMap model, HttpServletRequest request,@ModelAttribute("application") Application application)
    {
        try
        {
            generateCommunAgreement(model,request,application);

        }catch(Exception e)
        {
            e.printStackTrace();
            model.addAttribute("error","there has been an error while generating the application agreement, please try again");
        }

        model.addAttribute("success","Congratulations! the application has been safely approved and the internship agreement has been generated");
        //model.addAttribute("application",application);

        return "insa/offers";

    }

    public void generateCommunAgreement(ModelMap model, HttpServletRequest request,Application application) throws Exception
    {
        Student student=application.getStudent();
        Company company=application.getCompany();
        INSA insa=application.getInsa();
        Offer offer=offerService.findById(application.getOffer_id(),company.getId());
        Document document = new Document();

            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("c:/insaship/"+application.getId()+"agreement.pdf"));
            document.open();
            Image image1 = Image.getInstance("c:/insaship/header.jpg");
            image1.scaleAbsolute(585, 200);
            //Add to document
            document.add(image1);
            document.add(new Paragraph("\tcompany\n"+
                    "name: "+company.getUsername()+
                    "\n"+"adress: "+company.getAddress()+"\n telephone: "+company.getTelephone()));
            document.add(new Paragraph("----------------------"));
            document.add(new Paragraph("\tStudent\n"+
                    "name: "+student.getLastName()+" "+student.getFirstName()+"\n"+
                    "adress: "+student.getAddress()+"\n Telephone: "+student.getTelephone()+"\nEmail: "+student.getEmail()+
                    "\n Scolar Year: "+student.getScholarYear()+"\n"));
            document.add(new Paragraph("----------------------"));
            document.add(new Paragraph("\tInternship details:"+
                    "\n adress: "+company.getAddress()+"\nStarting day"+offer.getStartDate()+"\nDescription:"+offer.getDescription()));
            document.add(new Paragraph("----------------------"));
            document.add(new Paragraph("\tInsa supervisor\n"+
                    "Name: "+insa.getUsername()+"\nTelephone:"+insa.getTelephone()+"\nEmail: "+insa.getEmail()));

            document.addTitle("Internship agreement of "+student.getLastName()+" "+student.getFirstName());
            document.add(new Paragraph("Signatures:\n"));
            document.close();
            writer.close();

            //presistence of the agreement
            com.entities.Document agreementDoc=new com.entities.Document();
            agreementDoc.setFileUrl("c:/insaship/"+application.getId()+"agreement.pdf");
            agreementDoc.setFileType("agreement");
            agreementDoc.setName("Internship agreement");
            agreementDoc.setCreationDate(new Date(System.currentTimeMillis()));

            documentService.save(agreementDoc);

            Agreement agreement=new Agreement();
            agreement.setApplication(application);
            agreement.setAgreementDoc(agreementDoc);
            agreement.setState(false);
            agreementService.save(agreement);


            application.setAgreement(agreement);
            application.setState(ApplicationState.UnderAgreement);
            applicationService.save(application);

            //send notifications
            Notification notification = new Notification();
            notification.setApplication(application);
            notification.setEventDate(new Date(System.currentTimeMillis()));
            notification.setMessage("the Internship agreement has been generated");
            notification.setUser(application.getStudent());
            notification.setVisualized(false);
            notificationService.save(notification);

            Notification notification2 = new Notification();
            notification2.setApplication(application);
            notification2.setEventDate(new Date(System.currentTimeMillis()));
            notification2.setMessage("the internship's has been generated");
            notification2.setUser(application.getCompany());
            notification2.setVisualized(false);
            notificationService.save(notification2);


    }
    @RequestMapping(value="/generateAgreement")
    public String generateAgreement(ModelMap model, HttpServletRequest request,@ModelAttribute("application") Application application)
    {
        //do same things as if we were going to generate by insa
        try{
            generateCommunAgreement(model,request,application);

            //send notification to insa also
            Notification notification2 = new Notification();
            notification2.setApplication(application);
            notification2.setEventDate(new Date(System.currentTimeMillis()));
            notification2.setMessage("the internship's agreement has been generated");
            notification2.setUser(application.getInsa());
            notification2.setVisualized(false);
            notificationService.save(notification2);
        }
        catch(Exception e)
        {
            model.addAttribute("error","there has been an error while generating the application agreement, please try again");
        }

        model.addAttribute("success","Congratulations! the application has been safely approved.");


        return "fsd/index";
    }


    @RequestMapping(value = "signAgreement",method = RequestMethod.POST)
    public String signAgreement(ModelMap model,HttpServletRequest request,@ModelAttribute("SigningForm")SignAgreementForm form)
    {
        String returnPage = "index";
        try {

            Agreement agreement = agreementService.findById(form.getAgreement());
            Application application = agreement.getApplication();

            User logged = (User) request.getSession().getAttribute("loggedUser");

            if (form.getUsername().equals(logged.getUsername()))
            {
                if (logged instanceof Company)
                {
                    request.getSession().setAttribute("success","You have successfully signed agreement");
                    agreement.setSignedByCompany(true);
                    returnPage = "redirect:/company/detailAccepted?id=" + application.getId();

                }
                else if (logged instanceof INSA)
                {
                    agreement.setSignedByInsa(true);
                    List<Application> applications = (List<Application>) request.getSession().getAttribute("suppervisedApplications");
                    applications.set(applications.indexOf(application), application);
                    Student student=application.getStudent();
                    Company company=application.getCompany();
                    model.addAttribute("student",student);
                    model.addAttribute("company",company);
                    model.addAttribute("application",application);
                    returnPage="insa/suppervisedDetails";
                }
                else if (logged instanceof Student) {
                    request.getSession().setAttribute("success","You have successfully signed agreement");
                    agreement.setSignedByStudent(true);
                    returnPage = "redirect:/detail?id=" + application.getId();
                }

                if (agreement.isSignedByCompany() && agreement.isSignedByInsa() && agreement.isSignedByStudent()) {
                    application.setState(ApplicationState.Done);
                    applicationService.save(application);
                }
                agreementService.save(agreement);

            } else {
                model.addAttribute("error", "your username is wrong, please try again to sign the agreement");
                model.addAttribute("agreement", agreement.getId());
                return "signing";
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        //je retourne sur la page index de tout le monde
        model.addAttribute("signed","the agreement has been signed successfully");
        return returnPage;

    }

    @RequestMapping(value="signAgreement",method = RequestMethod.GET)
    public String signAgreement(ModelMap model, HttpServletRequest request, @ModelAttribute("id") int applicationId)
    {
        Application application=applicationService.findById(applicationId);
        Agreement agreement=application.getAgreement();
        model.addAttribute("agreement",agreement.getId());
        return "signing";
    }


    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void getFile(HttpServletResponse response, @ModelAttribute("id") int id) {
        try {

            Application app=applicationService.findById(id);
            DefaultResourceLoader loader = new DefaultResourceLoader();
            String url=app.getAgreement().getAgreementDoc().getFileUrl();
            InputStream is =new FileInputStream(url);
            String name=url.substring(url.lastIndexOf('/'),url.lastIndexOf('.'));
            IOUtils.copy(is, response.getOutputStream());
            response.setHeader("Content-Disposition", "attachment; filename="+name+".pdf");
            response.flushBuffer();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
