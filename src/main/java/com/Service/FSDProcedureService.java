package com.Service;

import com.entities.FSDProcedure;
import com.repositories.FSDProcedureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by karima on 04/12/2016.
 */
@Service
public class FSDProcedureService {

    @Autowired
    FSDProcedureRepository fsdProcedureRepository;

    public void save(FSDProcedure fsdProcedure){fsdProcedureRepository.save(fsdProcedure);}

}
