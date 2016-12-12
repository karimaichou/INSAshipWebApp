package com.repositories;

import com.entities.Agreement;
import com.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by karima on 07/12/2016.
 */
public interface AgreementRepository extends JpaRepository<Agreement,Long> {

    @Query("SELECT c FROM Agreement o INNER JOIN o.agreementDoc c WHERE o.id = ?1")
    public Document findAgreementDocument(long id);
}
