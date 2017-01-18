package com.Service;

import com.entities.Company;
import com.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by karima on 04/12/2016.
 */
@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public Company findById(int id)
    {
        return companyRepository.findById(id);
    }
}
