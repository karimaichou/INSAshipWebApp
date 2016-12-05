package com.repositories;

import com.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by karima on 05/12/2016.
 */
public interface DocumentRepository extends JpaRepository<Document,Integer> {

    /*@Query("SELECT c FROM Application o INNER JOIN o.documents c WHERE o.id =: id")
    List<Document> findDocumentByApplication(int id);*/

}
