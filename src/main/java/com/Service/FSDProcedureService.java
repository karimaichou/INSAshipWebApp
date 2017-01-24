package com.Service;

import com.entities.FSDProcedure;
import com.repositories.FSDProcedureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by karima on 04/12/2016.
 */
@Service
@Transactional
public class FSDProcedureService {
    @Autowired
    FSDProcedureRepository fsdProcedureRepository;

    public FSDProcedure save(FSDProcedure fsdProcedure) {
        return fsdProcedureRepository.save(fsdProcedure);
    }
}
