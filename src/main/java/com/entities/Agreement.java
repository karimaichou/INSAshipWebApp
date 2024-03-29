package com.entities;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by karima on 20/11/2016.
 */

@Entity
@Table(name = "agreement")
public class Agreement {

    @Id
    @GeneratedValue
    private long id;

    private boolean state;

    @OneToOne(optional = false)
    @Cascade(CascadeType.DELETE)
    private Application application;

    @OneToOne
    private Document agreementDoc;

    boolean signedByInsa;
    boolean isSignedByStudent;
    boolean signedByCompany;


    public boolean isSignedByInsa() {
        return signedByInsa;
    }

    public void setSignedByInsa(boolean signedByInsa) {
        this.signedByInsa = signedByInsa;
    }

    public boolean isSignedByStudent() {
        return isSignedByStudent;
    }

    public void setSignedByStudent(boolean signedByStudent) {
        isSignedByStudent = signedByStudent;
    }

    public boolean isSignedByCompany() {
        return signedByCompany;
    }

    public void setSignedByCompany(boolean signedByCompany) {
        this.signedByCompany = signedByCompany;
    }

    public Document getAgreementDoc() {
        return agreementDoc;
    }

    public void setAgreementDoc(Document agreementDoc) {
        this.agreementDoc = agreementDoc;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }
}
