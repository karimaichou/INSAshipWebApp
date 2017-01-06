package com.repositories;

import com.entities.Application;
import com.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by karima on 04/12/2016.
 */
public interface StudentRepository extends JpaRepository<Student,Integer> {

    Student findByEmailAndPassword(String email, String password);


    List<Student> findByScholarYearOrderByScholarYearAsc(int year);

    List<Student> findByApplications(Application application);





}
