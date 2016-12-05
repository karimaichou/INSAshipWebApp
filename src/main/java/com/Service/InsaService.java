package com.Service;

import com.entities.Application;
import com.entities.INSA;
import com.repositories.INSARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by karima on 04/12/2016.
 */
@Service
public class InsaService {

    @Autowired
    INSARepository insaRepository;

    List<INSA> findByYear(int year)
    {
        return insaRepository.findByYear(year);
    }

    //responsable d'une candidature
    INSA findByApplications(Application application)
    {
        return insaRepository.findByApplications(application);
    }

    List<INSA> findAll()
    {
        return insaRepository.findAll(new Sort(Sort.Direction.ASC, "year"));
    }

}
