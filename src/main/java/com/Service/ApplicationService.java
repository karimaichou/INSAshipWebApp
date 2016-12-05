package com.Service;

import com.entities.Application;
import com.entities.Company;
import com.entities.INSA;
import com.entities.Student;
import com.repositories.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by karima on 04/12/2016.
 */
public class ApplicationService {

    @Autowired
    ApplicationRepository applicationRepository;

    List<Application> findByStudentOrderByCreationDateAsc(Student student)
    {
        return applicationRepository.findByStudentOrderByCreationDateAsc(student);
    }

   /* List<Application> findByOffer_idOrderByCreationDateAsc(int offer_id)
    {
        return applicationRepository.findByOffer_idOrderByCreationDateAsc(offer_id);
    }

    List<Application> findByOffer_idAndStateOrderByCreationDateAsc(int offer_id,String state)
    {
        return applicationRepository.findByOffer_idAndStateOrderByCreationDateAsc(offer_id,state);
    }*/

    List<Application> findByCompanyOrderByCreationDateAsc(Company company)
    {
        return applicationRepository.findByCompanyOrderByCreationDateAsc(company);
    }

    List<Application> findByCompanyAndStateOrderByCreationDateAsc(Company company,String state)
    {
        return applicationRepository.findByCompanyAndStateOrderByCreationDateAsc(company,state);
    }

    List<Application> findByInsaOrderByCreationDateAsc(INSA insa)
    {
        return applicationRepository.findByInsaOrderByCreationDateAsc(insa);
    }

    List<Application> findByInsaAndStateOrderByCreationDateAsc(INSA insa,String state)
    {
        return applicationRepository.findByInsaAndStateOrderByCreationDateAsc(insa,state);
    }

    List<Application> findByStudentAndStateOrderByCreationDateAsc(Student student, String state)
    {
        return applicationRepository.findByStudentAndStateOrderByCreationDateAsc(student,state);
    }

    /*List<Application> findByStudentAndFSDProcedureOrderByCreationDateAsc(Student student,boolean fsd)
    {
        return applicationRepository.findByStudentAndFSDProcedureOrderByCreationDateAsc(student,fsd);
    }*/



    List<Application> findByStudentAndMeetingRequestOrderByCreationDateAsc(Student student,boolean meeting)
    {
        return applicationRepository.findByStudentAndMeetingRequestOrderByCreationDateAsc(student,meeting);
    }

    /*Application findByStudentAndOffer_idAndMeetingRequestOrderByCreationDateAsc(Student student,int offer_id,boolean meeting)
    {
        return applicationRepository.findByStudentAndOffer_idAndMeetingRequestOrderByCreationDateAsc(student,offer_id,meeting);
    }
    Application findByStudentAndOffer_idAndFSDProcedureOrderByCreationDateAsc(Student student,int offer_id,boolean fsd)
    {
        return applicationRepository.findByStudentAndOffer_idAndFSDProcedureOrderByCreationDateAsc(student,offer_id,fsd);
    }*/
}
