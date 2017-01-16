package com.Service;

import com.entities.*;
import com.repositories.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by karima on 04/12/2016.
 */

@Service
public class ApplicationService {

    @Autowired
    ApplicationRepository applicationRepository;


    public Application save(Application application)
    {
        return applicationRepository.save(application);
    }

    List<Application> findByStudentOrderByCreationDateAsc(Student student)
    {
        return applicationRepository.findByStudentOrderByCreationDateAsc(student);
    }

    List<Application> findByOfferIdOrderByCreationDateAsc(int offer_id)
    {
        return applicationRepository.findByOfferIdOrderByCreationDateAsc(offer_id);
    }

    List<Application> findByOfferIdAndStateOrderByCreationDateAsc(int offer_id,String state)
    {
        return applicationRepository.findByOfferIdAndStateOrderByCreationDateAsc(offer_id,state);
    }

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

    List<Application> findByStudentAndIsFsdOrderByCreationDateAsc(Student student,boolean fsd)
    {
        return applicationRepository.findByStudentAndIsFsdOrderByCreationDateAsc(student,fsd);
    }


    List<Application> findByStudentAndMeetingRequestOrderByCreationDateAsc(Student student,boolean meeting)
    {
        return applicationRepository.findByStudentAndMeetingRequestOrderByCreationDateAsc(student,meeting);
    }

    Application findByStudentAndOfferIdAndMeetingRequestOrderByCreationDateAsc(Student student,int offer_id,boolean meeting)
    {
        return applicationRepository.findByStudentAndOfferIdAndMeetingRequestOrderByCreationDateAsc(student,offer_id,meeting);
    }
    Application findByStudentAndOfferIdAndIsFsdOrderByCreationDateAsc(Student student,int offer_id,boolean fsd)
    {
        return applicationRepository.findByStudentAndOfferIdAndIsFsdOrderByCreationDateAsc(student,offer_id,fsd);
    }

    List<Document> findDocumentById(int id)
    {
        return applicationRepository.findDocumentById(id);
    }

    public List<Application> findApplicationByYear(int year)
    {
        return applicationRepository.findApplicationByYear(year);

    }
}
