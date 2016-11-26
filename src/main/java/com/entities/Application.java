package com.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by borik on 11/24/2016.
 */
@Entity
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

    private boolean FSDProcedure;

    private Integer offer_id;

    public Integer getOffer_id() {
        return offer_id;
    }

    public void setOffer_id(Integer offer_id) {
        this.offer_id = offer_id;
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
        return FSDProcedure;
    }

    public void setFSDProcedure(boolean FSDProcedure) {
        this.FSDProcedure = FSDProcedure;
    }

    @ManyToOne(optional = false)
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @ManyToOne(optional = false)
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @ManyToOne(optional = false)
    private INSA insa;

    public INSA getInsa() {
        return insa;
    }

    public void setInsa(INSA insa) {
        this.insa = insa;
    }

    @OneToOne(mappedBy = "application")
    private FSDProcedure fsdProcedure;

    public com.entities.FSDProcedure getFsdProcedure() {
        return fsdProcedure;
    }

    public void setFsdProcedure(com.entities.FSDProcedure fsdProcedure) {
        this.fsdProcedure = fsdProcedure;
    }

    @OneToOne(mappedBy = "application")
    private Agreement agreement;

    public Agreement getAgreement() {
        return agreement;
    }

    public void setAgreement(Agreement agreement) {
        this.agreement = agreement;
    }

    @OneToMany(mappedBy = "application")
    private Collection<Document> documents;

    public Collection<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Collection<Document> documents) {
        this.documents = documents;
    }

    @OneToMany(mappedBy = "application")
    private Collection<Notification> notifications;

    public Collection<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(Collection<Notification> notifications) {
        this.notifications = notifications;
    }
}
