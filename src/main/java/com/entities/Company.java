package com.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.List;

/**
 * Created by karima on 20/11/2016.
 */
@Entity
public class Company extends User {


    private String address;

    @OneToMany(mappedBy = "company")
    private Collection<Application> applications;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public Collection<Application> getApplications() {
        return applications;
    }

    public void setApplications(Collection<Application> applications) {
        this.applications = applications;
    }
}
