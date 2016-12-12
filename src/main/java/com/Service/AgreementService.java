package com.Service;

import com.entities.Document;
import com.repositories.AgreementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by karima on 07/12/2016.
 */
@Service
public class AgreementService {

    @Autowired
    private AgreementRepository agreementRepository;

    public Document findAgreementDocument(long id)
    {
        return agreementRepository.findAgreementDocument(id);
    }
}
