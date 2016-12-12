package com.repositories;

import com.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by karima on 04/12/2016.
 */
public interface ApplicationRepository extends JpaRepository<Application,Integer> {

    @Query("SELECT c FROM Application o INNER JOIN o.documents c WHERE o.id = ?1")
    List<Document> findDocumentById(int id);

    @Query("SELECT c FROM Application o INNER JOIN o.agreement c WHERE o.id = ?1")
    Agreement findAgreement(int id);

    List<Application> findByStudentOrderByCreationDateAsc(Student student);

    List<Application> findByOfferIdOrderByCreationDateAsc(int offer_id);

    List<Application> findByOfferIdAndStateOrderByCreationDateAsc(int offer_id,String state);

    List<Application> findByCompanyOrderByCreationDateAsc(Company company);

    List<Application> findByCompanyAndStateOrderByCreationDateAsc(Company company,String state);

    List<Application> findByInsaOrderByCreationDateAsc(INSA insa);

    List<Application> findByInsaAndStateOrderByCreationDateAsc(INSA insa,String state);

    List<Application> findByStudentAndStateOrderByCreationDateAsc(Student student, String state);

    List<Application> findByStudentAndIsFsdOrderByCreationDateAsc(Student student,boolean fsd);

    Application findByStudentAndOfferIdAndIsFsdOrderByCreationDateAsc(Student student,int offer_id,boolean fsd);

    List<Application> findByStudentAndMeetingRequestOrderByCreationDateAsc(Student student,boolean meeting);

    Application findByStudentAndOfferIdAndMeetingRequestOrderByCreationDateAsc(Student student,int offer_id,boolean meeting);
}
