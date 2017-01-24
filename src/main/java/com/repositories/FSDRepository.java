package com.repositories;

import com.entities.FSD;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by karima on 04/12/2016.
 */
public interface FSDRepository extends JpaRepository<FSD,Integer>{
    List<FSD> findAll();

    FSD findById(int id);
}
