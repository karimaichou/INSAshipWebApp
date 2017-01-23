package com.entities;



import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by borik on 11/24/2016.
 */
@Entity
@Table(name = "application")
public class Application {
    @Id
    @GeneratedValue
    private Integer id;

    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Enumerated(EnumType.STRING)
    private ApplicationState state;

    private String message;

    private boolean meetingRequest;

    @Column(columnDefinition="tinyint(1) default 0")
    private boolean isFsd;

    private Integer offerId;

    @ManyToOne(optional = false)
    private Student student;

    @ManyToOne(optional = false,cascade=CascadeType.ALL)
    private Company company;

    @OneToMany(cascade={CascadeType.PERSIST,CascadeType.REMOVE})
    private Collection<Document> documents;

    @OneToOne(mappedBy = "application",cascade = CascadeType.REMOVE,optional = true)
    private FSDProcedure fsdProcedure;

    @OneToOne(mappedBy = "application")
    private Agreement agreement;

    @OneToMany(mappedBy = "application")
    private Collection<Notification> notifications;

    @ManyToOne(optional = true)
    private INSA insa;



    public INSA getInsa() {
        return insa;
    }

    public void setInsa(INSA insa) {
        this.insa = insa;
    }

    public Integer getOffer_id() {
        return offerId;
    }

    public void setOffer_id(Integer offer_id) {
        this.offerId = offer_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public ApplicationState getState() {
        return state;
    }

    public void setState(ApplicationState state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isMeetingRequest() {
        return meetingRequest;
    }

    public void setMeetingRequest(boolean meetingRequest) {
        this.meetingRequest = meetingRequest;
    }

    public boolean isFSDProcedure() {
        return isFsd;
    }

    public void setFSDProcedure(boolean FSDProcedure) {
        this.isFsd = FSDProcedure;
    }



    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }



    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


    public com.entities.FSDProcedure getFsdProcedure() {
        return fsdProcedure;
    }

    public void setFsdProcedure(com.entities.FSDProcedure fsdProcedure) {
        this.fsdProcedure = fsdProcedure;
    }



    public Agreement getAgreement() {
        return agreement;
    }

    public void setAgreement(Agreement agreement) {
        this.agreement = agreement;
    }


    public Collection<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Collection<Document> documents) {
        this.documents = documents;
    }


    public Collection<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(Collection<Notification> notifications) {
        this.notifications = notifications;
    }

    @Override
    public  boolean equals( Object  application)
    {
        if (this == application) return true;
        if (!(application instanceof Application)) return false;
        Application book = (Application) application;
        return getId().equals(((Application) application).getId());
    }
}
