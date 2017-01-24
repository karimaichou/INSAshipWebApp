package com.Service;

import com.entities.FSD;
import com.repositories.FSDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by karima on 04/12/2016.
 */
@Service
public class FSDService {
    @Autowired
    FSDRepository fsdRepository;

    public List<FSD> findAll(){
        return fsdRepository.findAll();
    }

    public FSD findById(int id) {
        return fsdRepository.findById(id);
    }
}
