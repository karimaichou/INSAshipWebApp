package com.Service;

import com.entities.Document;
import com.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by karima on 05/12/2016.
 */
@Service
public class DocumentService {

    @Autowired
    DocumentRepository documentRepository;

    public void save(Document document)
    {
        documentRepository.save(document);
    }
}
