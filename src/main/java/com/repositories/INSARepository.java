package com.repositories;

import com.entities.Application;
import com.entities.INSA;
import com.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by karima on 04/12/2016.
 */
public interface INSARepository extends JpaRepository<INSA,Integer> {


    List<INSA> findByYear(int year);

    INSA findByApplications(Application application);

}
