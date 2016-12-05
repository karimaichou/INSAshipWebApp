package com.repositories;

import com.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by karima on 04/12/2016.
 */
public interface ApplicationRepository extends JpaRepository<Application,Integer> {

    List<Application> findByStudentOrderByCreationDateAsc(Student student);

   // List<Application> findByOffer_idOrderByCreationDateAsc(int offer_id);

   // List<Application> findByOffer_idAndStateOrderByCreationDateAsc(int offer_id,String state);

    List<Application> findByCompanyOrderByCreationDateAsc(Company company);

    List<Application> findByCompanyAndStateOrderByCreationDateAsc(Company company,String state);

    List<Application> findByInsaOrderByCreationDateAsc(INSA insa);

    List<Application> findByInsaAndStateOrderByCreationDateAsc(INSA insa,String state);

    List<Application> findByStudentAndStateOrderByCreationDateAsc(Student student, String state);

    //List<Application> findByStudentAndFSDProcedureOrderByCreationDateAsc(Student student,boolean fsd);

    //Application findByStudentAndOffer_idAndFSDProcedureOrderByCreationDateAsc(Student student,int offer_id,boolean fsd);

    List<Application> findByStudentAndMeetingRequestOrderByCreationDateAsc(Student student,boolean meeting);

    //Application findByStudentAndOffer_idAndMeetingRequestOrderByCreationDateAsc(Student student,int offer_id,boolean meeting);
}
