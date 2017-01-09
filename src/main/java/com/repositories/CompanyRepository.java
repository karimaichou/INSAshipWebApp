package com.repositories;

import com.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by karima on 04/12/2016.
 */
public interface CompanyRepository extends JpaRepository<Company,Integer> {


}
