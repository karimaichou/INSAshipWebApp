package com.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by karima on 20/11/2016.
 */
@Entity
public class FSDProcedure {

    @Id
    @GeneratedValue
    private Integer id;

    private boolean result;

    @OneToOne(optional = false)
    private Application application;

    @ManyToOne(optional = false)
    private FSD fsd;

    @OneToMany
    private List<Document> documents;

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public FSDProcedure(){}

    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public FSD getFsd() {
        return fsd;
    }

    public void setFsd(FSD fsd) {
        this.fsd = fsd;
    }
}
