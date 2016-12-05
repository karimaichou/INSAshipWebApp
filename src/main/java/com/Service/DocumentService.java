package com.Service;

import com.entities.Document;
import com.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by karima on 05/12/2016.
 */
public class DocumentService {

    @Autowired
    DocumentRepository documentRepository;

    public void insert(Document document)
    {
        documentRepository.save(document);
    }
}
