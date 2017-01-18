package com.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

/**
 * Created by karima on 20/11/2016.
 */
@Entity
@Table(name = "insa")
public class INSA extends User {

    private Integer year;

    @OneToMany(mappedBy = "insa")
    private Collection<Application> applications;

    public Collection<Application> getApplications() {
        return applications;
    }

    public void setApplications(Collection<Application> applications) {
        this.applications = applications;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
