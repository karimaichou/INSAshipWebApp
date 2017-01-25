package com.Service;

import com.entities.Agreement;
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

    public Agreement save(Agreement agreement)
    {
        return agreementRepository.save(agreement);
    }

    public Agreement findById(long id)
    {
        return agreementRepository.findById(id);
    }
}
